package com.arman.trueidentity.unit_test.right;

import com.arman.trueidentity.right.Right;
import com.arman.trueidentity.right.RightRepo;
import com.arman.trueidentity.right.RightService;
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
public class RightServiceTest {

  @Mock
  RightRepo rightRepo;

  @InjectMocks
  RightService rightService;

  @Test
  public void createRight() {
    when(rightRepo.save(any(Right.class))).then(
        invocationOnMock -> {
          Right right = invocationOnMock.getArgument(0);
          right.setId(1L);
          return right;
        }
    );
    String name = "basic_right";
    String displayName = "basic right";

    Right right = rightService.createRole(
        name,
        displayName
    );

    assertEquals(name, right.getName());
    assertEquals(displayName, right.getDisplayName());
    assertNotNull(right.getUuid());
  }
}
