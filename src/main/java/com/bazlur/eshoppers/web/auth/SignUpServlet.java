package com.bazlur.eshoppers.web.auth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bazlur.eshoppers.dto.UserDTO;
import com.bazlur.eshoppers.repository.UserRepositoryImpl;
import com.bazlur.eshoppers.service.UserService;
import com.bazlur.eshoppers.service.UserServiceImpl;
import com.bazlur.eshoppers.util.ValidationUtil;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
  private final static Logger LOGGER = LoggerFactory.getLogger(SignUpServlet.class);

  private UserService userService = new UserServiceImpl(new UserRepositoryImpl());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    LOGGER.info("GET /signup");
    req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    LOGGER.info("POST /signup");
    UserDTO userDTO = copyParametersTo(req);
    ValidationUtil validationUtil = ValidationUtil.getInstance();
    Map<String, String> errors = validationUtil.validate(userDTO);
                                         
    if (errors.isEmpty()) {
      LOGGER.info("user is valid, creating a new with: {}", userDTO);
      userService.saveUser(userDTO);
      resp.sendRedirect("/cart/home");
    } else if (userService.isNotUniqueUsername(userDTO)) {
      LOGGER.info("This username {} already exists", userDTO.getUsername());
      errors.put("username", "Username is already taken");
      req.setAttribute("userDTO", userDTO);
      req.setAttribute("errors", errors);
      req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
    }    
    else {
      LOGGER.info("user is not valid, redirecting back to signup page");
      req.setAttribute("errors", errors);
      req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
    }
  }

  private UserDTO copyParametersTo(HttpServletRequest req) {
    // log the parameters
    LOGGER.info("firstName: {}", req.getParameter("firstName"));
    LOGGER.info("lastName: {}", req.getParameter("lastName"));
    LOGGER.info("email: {}", req.getParameter("email"));
    LOGGER.info("password: {}", req.getParameter("password"));
    LOGGER.info("passwordConfirmed: {}", req.getParameter("passwordConfirmed"));
    LOGGER.info("username: {}", req.getParameter("username"));

    UserDTO userDTO = new UserDTO();
    userDTO.setFirstName(req.getParameter("firstName"));
    userDTO.setLastName(req.getParameter("lastName"));
    userDTO.setEmail(req.getParameter("email"));
    userDTO.setPassword(req.getParameter("password"));
    userDTO.setConfirmPassword(req.getParameter("passwordConfirmed"));
    userDTO.setUsername(req.getParameter("username"));
    return userDTO;
  }

  // private Map<String, String> validate(UserDTO userDTO) {
  // var validatorFactory = Validation.buildDefaultValidatorFactory();
  // var validator = validatorFactory.getValidator();

  // Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
  // Map<String, String> errors = new HashMap<>();
  // for (ConstraintViolation<UserDTO> violation : violations) {
  // String path = violation.getPropertyPath().toString();
  // if (errors.containsKey(path)) {
  // String errorMsg = errors.get(path);
  // errors.put(path, errorMsg + " <br/> " + violation.getMessage());
  // } else {
  // errors.put(path, violation.getMessage());
  // }
  // }
  // return errors;
  // }
}
