package com.project.login_system.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.login_system.Models.UserEntity;
import com.project.login_system.Services.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String Home() {
        return "index";
    }

    @GetMapping("/register")
    public String Register() {
        return "register";
    }

    @PostMapping("/createUser")
    public String createUSer(@ModelAttribute UserEntity user, RedirectAttributes rAttributes) {

        // System.out.println(user);

        // Dibuat Setelah Berhasil Create User Kedatabase
        boolean f = userService.checkEmail(user.getEmail());

        // note : cek pesan sysout diterminal, sebelum msg dibuat
        if (f) {
            // System.out.println("Email ID Already Exist!!");
            rAttributes.addFlashAttribute("msg", "Email id already exist!!");

        } else {
            UserEntity userEntity = userService.createUser(user);
            if (userEntity != null) {
                // System.out.println("Register Sucessfully!!");
                rAttributes.addFlashAttribute("msg", "Register Sucessfully!!");

            } else {
                // System.out.println("Something Error In Server!!");
                rAttributes.addFlashAttribute("msg", "Something error in server!!");
            }
        }

        // Pindah Ke Dalam Else
        // Untuk Mengecek Apakah Create User(Register) Berhasil

        // UserEntity userEntity = userService.createUser(user);
        // if (userEntity != null) {
        // System.out.println("Register Sucessfully!!");
        // } else {
        // System.out.println("Something Error In Server!!");
        // }

        return "redirect:/register";
    }

}
