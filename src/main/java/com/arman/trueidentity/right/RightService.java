package com.arman.trueidentity.right;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RightService {

  @Autowired
  RightRepo rightRepo;


  public Right createRole(String name, String displayName) {
    Right right = new Right();
    right.setUuid(UUID.randomUUID().toString());
    right.setName(name);
    right.setDisplayName(displayName);
    return rightRepo.save(right);
  }
}
