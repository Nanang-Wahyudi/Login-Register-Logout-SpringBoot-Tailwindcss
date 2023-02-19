package com.project.login_system.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.login_system.Models.UserEntity;
import com.project.login_system.Repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository UserRepo;

    // Create User (Register)
    @Override
    public UserEntity createUser(UserEntity userEnt) {
        return UserRepo.save(userEnt);
    }

    // Dibuat Setelah Berhasil Create User Kedatabase
    @Override
    public boolean checkEmail(String email) {
        return UserRepo.existsByEmail(email);
    }

}
