package com.arman.trueidentity.unit_test.role;


import com.arman.trueidentity.role.Role;
import com.arman.trueidentity.role.RoleRepo;
import com.arman.trueidentity.role.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

  @Mock
  RoleRepo roleRepo;

  @InjectMocks
  RoleService roleService;

  @Test
  public void createNewRole() {
    when(roleRepo.save(any(Role.class))).then(
        (invocationOnMock) -> {
          Role role = invocationOnMock.getArgument(0);
          role.setId(1L);
          return role;
        }
    );

    String name = "default_role";
    String displayName = "Default Role";

    Role role = roleService.createRole(
        name,
        displayName
    );

    assertEquals(name, role.getName());
    assertEquals(displayName, role.getDisplayName());
    assertNotNull(role.getUuid());
  }

}
