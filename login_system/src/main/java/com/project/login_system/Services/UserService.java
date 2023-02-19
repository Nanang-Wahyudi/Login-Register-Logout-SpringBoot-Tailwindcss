package com.project.login_system.Services;

import com.project.login_system.Models.UserEntity;

public interface UserService {

    // Create User (Register)
    public UserEntity createUser(UserEntity userEnt);

    // Dibuat Setelah Berhasil Create User Kedatabase
    public boolean checkEmail(String email);
}
