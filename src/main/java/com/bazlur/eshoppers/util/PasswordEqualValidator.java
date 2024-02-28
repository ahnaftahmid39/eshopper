package com.bazlur.eshoppers.util;

import java.lang.reflect.Field;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bazlur.eshoppers.annotations.PasswordEqual;

public class PasswordEqualValidator implements ConstraintValidator<PasswordEqual, Object> {

  private String firstFieldName;
  private String secondFieldName;
  private String message;

  public void initialize(PasswordEqual constraintAnnotation) {
    this.firstFieldName = constraintAnnotation.first();
    this.secondFieldName = constraintAnnotation.second();
    this.message = constraintAnnotation.message();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    boolean valid = true;
    try {
      final Object firstObj = getValue(value, firstFieldName);
      final Object secondObj = getValue(value, secondFieldName);
      valid = Objects.equals(firstObj, secondObj);

    } catch (final Exception e) {
      System.out.println(e.getClass());
    }

    if (!valid) {
      context.buildConstraintViolationWithTemplate(message)
          .addPropertyNode(firstFieldName)
          .addConstraintViolation()
          .disableDefaultConstraintViolation();
    }
    return valid;
  }

  private Object getValue(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
    Field field = object.getClass().getDeclaredField(fieldName);
    field.setAccessible(true);
    return field.get(object);
  }

}
