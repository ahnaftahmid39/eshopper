package com.bazlur.eshoppers.repository;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import com.bazlur.eshoppers.domain.User;

public class UserRepositoryImpl implements UserRepository {
  private static final Set<User> USERS = new CopyOnWriteArraySet<>();

  @Override
  public void save(User user) {
    USERS.add(user);
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return USERS.stream()
        .filter(user -> user.getUsername().equals(username))
        .findFirst();
  }

}
