package ru.geekbrains.firstproject.controllers;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.firstproject.configs.JWT.JWTProvider;
import ru.geekbrains.firstproject.model.dtos.AuthRequestDto;
import ru.geekbrains.firstproject.model.dtos.AuthResponseDto;
import ru.geekbrains.firstproject.model.dtos.SignUpRequestDto;
import ru.geekbrains.firstproject.model.entities.Role;
import ru.geekbrains.firstproject.model.entities.User;
import ru.geekbrains.firstproject.services.UserService;

import java.util.ArrayList;

@Log
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTProvider jwtProvider;

    @PostMapping("/signup")
    public String registerUser(@RequestBody SignUpRequestDto signUpRequestDto){
        User user=new User();
        user.setRoles(new ArrayList<Role>());
        user.setPassword(signUpRequestDto.getPassword());
        user.setUserName(signUpRequestDto.getUsername());
        userService.saveUser(user);
        return "Ok";
    }
    @PostMapping("/login")
public AuthResponseDto auth(@RequestBody AuthRequestDto authRequestDto){
        System.out.println("login "+ authRequestDto.getUsername());
        System.out.println("pas "+ authRequestDto.getPassword());
        User user= userService.findByUsernameAndPassword(authRequestDto.getUsername(), authRequestDto.getPassword());
        String token=jwtProvider.generateToken(user.getUserName());
        return new AuthResponseDto(token);
    }
}
