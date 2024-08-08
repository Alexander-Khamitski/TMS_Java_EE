package com.teachmeskills.lesson54;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = "/all")
    public String showAll() {
        return "all";
    }

    @GetMapping(value = "/user")
    public String showUser() {
        return "user";
    }

    @GetMapping(value = "/admin")
    public String showAdmin() {
        return "admin";
    }
}
