package com.bazlur.eshoppers.annotations;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.bazlur.eshoppers.util.PasswordEqualValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordEqualValidator.class)
public @interface PasswordEqual {
  String message() default "Password and confirm password must be equal";
  String first();
  String second();
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
