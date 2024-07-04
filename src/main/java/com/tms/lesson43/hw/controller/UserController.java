package com.tms.lesson43.hw.controller;

import com.tms.lesson43.hw.model.User;
import com.tms.lesson43.hw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/create")
    public ModelAndView fillCreateUserForm() {
        return new ModelAndView("create/createUserForm", "user", new User());
    }

    @PostMapping(value = "/create")
    public ModelAndView createUser(@ModelAttribute User user, Model model) {
        if (user.getId() != 0 && !user.getPassport_number().isEmpty()) {
            UserService.createUser(user);
            String message = String.format("User with '%s' id has been created successfully!", user.getId());
            model.addAttribute("message", message);
            return new ModelAndView("create/createUser", "user", new User());
        }
        String message = "Please, fill in all required data.";
        model.addAttribute("message", message);
        return new ModelAndView("create/createUserForm", "user", new User());
    }

    @GetMapping(value = "/update")
    public ModelAndView fillUpdateUserForm() {
        return new ModelAndView("update/updateUserForm", "user", new User());
    }

    @PostMapping(value = "/update")
    public ModelAndView updateUser(@ModelAttribute User user, Model model) {
        if (user.getId() != 0) {
            UserService.updateUser(user);
            String message = String.format("User with '%s' id has been updated successfully!", user.getId());
            model.addAttribute("message", message);
            return new ModelAndView("update/updateUser", "user", new User());
        }
        String message = "Please, fill in all required data.";
        model.addAttribute("message", message);
        return new ModelAndView("update/updateUserForm", "user", new User());
    }

    @GetMapping(value = "/delete")
    public ModelAndView fillDeleteUserForm() {
        return new ModelAndView("delete/deleteUserForm", "user", new User());
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteUser(@ModelAttribute User user, Model model) {
        if (user.getId() != 0) {
            UserService.deleteUser(user);
            String message = String.format("User with '%s' id has been deleted successfully!", user.getId());
            model.addAttribute("message", message);
            return new ModelAndView("delete/deleteUser", "user", new User());
        }
        String message = "Please, fill in all required data.";
        model.addAttribute("message", message);
        return new ModelAndView("delete/deleteUserForm", "user", new User());
    }

    @GetMapping(value = "/get")
    public ModelAndView fillGetUserForm() {
        return new ModelAndView("get/getUserForm", "user", new User());
    }

    @PostMapping(value = "/get")
    public ModelAndView getUser(@ModelAttribute User user, Model model) {
        if (user.getId() != 0) {
            user = UserService.getUserInfo(user);
            System.out.println("!!!!!!!!!!!hello");
            System.out.println(user);
            if (user != null) {
                model.addAttribute("isUserExist", true);
                model.addAttribute("id", user.getId());
                model.addAttribute("name", user.getName());
                model.addAttribute("surname", user.getSurname());
                model.addAttribute("age", user.getAge());
                model.addAttribute("passport_number", user.getPassport_number());
                return new ModelAndView("get/getUser", "user", new User());
            }
        }
        model.addAttribute("isUserExist", false);
        model.addAttribute("message", "User with '" + user.getId() + "' ID doesn't exist.");
        return new ModelAndView("get/getUserForm", "user", new User());
    }
}
