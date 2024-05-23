package com.arman.trueidentity.user;

import com.arman.trueidentity.role.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false, length = 100)
  private String uuid;

  @Column(unique = true, nullable = false, length = 100)
  private String username;

  @Column(unique = true, nullable = false, length = 100)
  private String password;

  @Column
  private Instant creationDate;

  @Column
  private Instant lastUpdateDate;

  @ManyToMany
  private final List<Role> roles = new ArrayList<>();

}
