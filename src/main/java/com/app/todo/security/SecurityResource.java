package com.app.todo.security;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SecurityResource {

    @GetMapping("/csrf_token")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest) {
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

}
