package com.mycompany.kitabonline.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String email;

}
