package ru.geekbrains.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.firstproject.model.entities.User;
import ru.geekbrains.firstproject.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/score")
@RequiredArgsConstructor
public class ScoreController {
    private final UserService userService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/inc")
    public void incScore(Principal principal) throws RuntimeException {
        User user = userService.findUserByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        user.setScore(user.getScore() + 1);
        userService.updateUser(user);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/dec")
    public void decScore(Principal principal) {
        User user = userService.findUserByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        if (user.getScore() > 0) {
            user.setScore(user.getScore() - 1);
            userService.updateUser(user);
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/get/current")
    public String getScore(Principal principal) {
        User user = userService.findUserByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return String.format("User: %s \t score: %d", user.getUserName(), user.getScore());
//            return user;
    }

    @GetMapping("/get/{id}")
    public String getScore(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return String.format("User: %s \t score: %d", user.getUserName(), user.getScore());
//      return user;
    }

}
