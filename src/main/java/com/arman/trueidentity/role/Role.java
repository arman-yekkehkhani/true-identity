package com.arman.trueidentity.role;

import com.arman.trueidentity.right.Right;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String uuid;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(nullable = false)
  private String displayName;

  @ManyToMany
  private final List<Right> rights = new ArrayList<>();

}
