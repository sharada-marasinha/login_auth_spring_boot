package com.auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CustomerController {
    @GetMapping("/get-data")
    public String getData() {
        return "Hello";
    }
    @GetMapping("/auth")
    public String getAuth(HttpServletRequest request) {
        return STR."Request : \{request.getSession().getId()}";
    }
    @GetMapping("/csrf")
    public CsrfToken getCsrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
