package com.project.login_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.login_system.Models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // Dibuat Setelah Berhasil Create User Kedatabase
    public boolean existsByEmail(String email);
}
