package com.arman.trueidentity.right;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "right")
@Data
public class Right {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String uuid;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(nullable = false)
  private String displayName;
}
