package com.arman.trueidentity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

  @Autowired
  final UserRepo userRepo;

  public User createNewUser(String username, String password) {
    User user = new User();
    user.setUuid(UUID.randomUUID().toString());
    user.setUsername(username);
    user.setPassword(password);
    user.setCreationDate(Instant.now());
    return userRepo.save(user);
  }
}
