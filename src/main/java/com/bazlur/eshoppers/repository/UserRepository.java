package com.bazlur.eshoppers.repository;

import java.util.Optional;

import com.bazlur.eshoppers.domain.User;

public interface UserRepository {
  void save(User user);
  Optional<User> findByUsername(String username);
}
