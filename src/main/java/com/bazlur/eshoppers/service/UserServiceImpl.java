package com.bazlur.eshoppers.service;

import com.bazlur.eshoppers.domain.User;
import com.bazlur.eshoppers.dto.UserDTO;
import com.bazlur.eshoppers.repository.UserRepository;

public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void saveUser(UserDTO userDTO) {
    String encrypted = encryptPassword(userDTO.getPassword());
    User user = new User();
    user.setFirstName(userDTO.getFirstName());
    user.setLastName(userDTO.getLastName());
    user.setEmail(userDTO.getEmail());
    user.setPassword(encrypted);
    user.setUsername(userDTO.getUsername());

    userRepository.save(user);
  }

  public boolean isNotUniqueUsername(UserDTO user) {
    return userRepository.findByUsername(user.getUsername()).isPresent();
  }

  private String encryptPassword(String password) {
    return password;
  }
}
