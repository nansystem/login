package com.example.login.presentation.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static java.util.stream.Collectors.joining;

@Controller
public class IndexController {

    @GetMapping
    public String index() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("[authorities]");
        System.out.println("  " + auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(joining("\n  ")));

        WebAuthenticationDetails details = (WebAuthenticationDetails) auth.getDetails();
        System.out.println("[details]");
        System.out.println("  IP Address : " + details.getRemoteAddress());
        System.out.println("  Session ID : " + details.getSessionId());

        UserDetails principal = (UserDetails) auth.getPrincipal();
        System.out.println("[principal]");
        System.out.println("  username : " + principal.getUsername());
        System.out.println("  password : " + principal.getPassword());

        System.out.println("[credentials]");
        System.out.println("  " + auth.getCredentials());
        return "index.html";
    }
}
