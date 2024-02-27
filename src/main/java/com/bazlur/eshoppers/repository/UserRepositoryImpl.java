package com.bazlur.eshoppers.repository;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import com.bazlur.eshoppers.domain.User;

public class UserRepositoryImpl implements UserRepository {
  private static final Set<User> USERS = new CopyOnWriteArraySet<>();

  @Override
  public void save(User user) {
    USERS.add(user);
  }
  
  
}