package com.arman.trueidentity.unit_test.user;

import com.arman.trueidentity.user.User;
import com.arman.trueidentity.user.UserRepo;
import com.arman.trueidentity.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @Mock
  UserRepo userRepo;

  @InjectMocks
  UserService userService;

  @Test
  public void createNewUser() {
    when(userRepo.save(any())).then(
        (invocationOnMock) -> {
          User user = invocationOnMock.getArgument(0);
          user.setId(1L);
          return user;
        }
    );

    Instant mockInstant = Instant.ofEpochSecond(1716491786);
    try (MockedStatic<Instant> mockedStatic = mockStatic(Instant.class, Mockito.CALLS_REAL_METHODS)) {
      mockedStatic.when(Instant::now).thenReturn(mockInstant);

      String username = "username";
      String password = "pass";

      User user = userService.createNewUser(
          username,
          password
      );

      assertNotNull(user.getUuid());
      assertEquals(username, user.getUsername());
      assertEquals(password, user.getPassword());
      assertEquals(mockInstant, user.getCreationDate());
      assertNull(user.getLastUpdateDate());
    }
  }
}
