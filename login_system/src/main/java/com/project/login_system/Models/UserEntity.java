package com.project.login_system.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    @Column(length = 50, nullable = true)
    private String nama;

    @Column(length = 50, nullable = true)
    private String email;

    @Column(length = 50, nullable = true)
    private String alamat;

    @Column(length = 20, nullable = true)
    private String password;

}
