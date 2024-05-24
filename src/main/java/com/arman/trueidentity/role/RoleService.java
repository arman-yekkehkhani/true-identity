package com.arman.trueidentity.role;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class RoleService {

  @Autowired
  final RoleRepo roleRepo;


  public Role createRole(String name, String displayName) {
    Role role = new Role();
    role.setUuid(UUID.randomUUID().toString());
    role.setName(name);
    role.setDisplayName(displayName);
    return roleRepo.save(role);
  }
}
