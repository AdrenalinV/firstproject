package ru.geekbrains.firstproject.model.dtos;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String username;
    private String password;
}
