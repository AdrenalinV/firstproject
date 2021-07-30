package ru.geekbrains.firstproject.model.dtos;

import lombok.Data;

@Data
public class SignUpRequestDto {
    private String username;
    private String password;
}
