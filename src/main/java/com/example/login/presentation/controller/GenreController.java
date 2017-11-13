package com.example.login.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/genre")
public class GenreController {

    @GetMapping
    public String genre() {
        return "genre/index";
    }
}
