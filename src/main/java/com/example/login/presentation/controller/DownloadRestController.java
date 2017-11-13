package com.example.login.presentation.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/download/")
public class DownloadRestController {

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public String download() {
        return "<a><b>content</b></a>";
    }
}
