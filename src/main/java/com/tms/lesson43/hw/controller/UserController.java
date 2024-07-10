package com.tms.lesson43.hw.controller;

import java.util.Objects;

import com.tms.lesson43.hw.model.User;
import com.tms.lesson43.hw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private String errorMessage = "Please, fill in valid data.";

    @GetMapping(value = "/create")
    public ModelAndView fillCreateUserForm() {
        return new ModelAndView("create/createUserForm", "user", new User());
    }

    @PostMapping(value = "/create")
    public ModelAndView createUser(@ModelAttribute User user, Model model) {
        if (isUserNull(user.getId()) &&
                user.getId() != 0 &&
                !user.getName().isEmpty() &&
                !user.getSurname().isEmpty() &&
                user.getAge() != 0 &&
                !user.getPassportNumber().isEmpty()) {
            userService.createUser(user);
            String message = String.format("User with '%s' id has been created successfully!", user.getId());
            model.addAttribute("message", message);
            return new ModelAndView("create/createUser", "user", new User());
        }
        model.addAttribute("message", errorMessage);
        return new ModelAndView("create/createUserForm", "user", new User());
    }

    @GetMapping(value = "/get")
    public ModelAndView getUser(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null && !isUserNull(id) && id != 0) {
            User requestedUser = userService.getUserInfo(id);
            model.addAttribute("user", requestedUser);
            return new ModelAndView("get/getUser");
        }
        model.addAttribute("message", errorMessage);
        return new ModelAndView("get/getUserForm", "user", new User());
    }

//    @GetMapping(value = "/get")
//    public ModelAndView fillGetUserForm() {
//        return new ModelAndView("get/getUserForm", "user", new User());
//    }
//
//    @GetMapping(value = "/get")
//    public ModelAndView getUser(@RequestParam("id") int id, Model model) {
//        if (!isUserNull(id) && id != 0) {
//            User requestedUser = userService.getUserInfo(id);
//            model.addAttribute("user", requestedUser);
//            return new ModelAndView("get/getUser");
//
//        }
//        model.addAttribute("message", errorMessage);
//        return new ModelAndView("get/getUserForm", "user", new User());
//    }

    @GetMapping(value = "/update")
    public ModelAndView fillUpdateUserForm() {
        return new ModelAndView("update/updateUserForm", "user", new User());
    }

    @PostMapping(value = "/update")
    public ModelAndView updateUser(@ModelAttribute User user, Model model) {
        if (!isUserNull(user.getId()) && user.getId() != 0) {
            userService.updateUser(user);
            String message = String.format("User with '%s' id has been updated successfully!", user.getId());
            model.addAttribute("message", message);
            return new ModelAndView("update/updateUser", "user", new User());
        }
        model.addAttribute("message", errorMessage);
        return new ModelAndView("update/updateUserForm", "user", new User());
    }

    @GetMapping(value = "/delete")
    public ModelAndView fillDeleteUserForm() {
        return new ModelAndView("delete/deleteUserForm", "user", new User());
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteUser(@RequestParam("id") int id, Model model) {
        if (!isUserNull(id) && id != 0) {
            userService.deleteUser(id);
            String message = String.format("User with '%s' id has been deleted successfully!", id);
            model.addAttribute("message", message);
            return new ModelAndView("delete/deleteUser", "user", new User());
        }
        model.addAttribute("message", errorMessage);
        return new ModelAndView("delete/deleteUserForm", "user", new User());
    }

    private boolean isUserNull(int id) {
        return Objects.isNull(userService.getUserInfo(id));
    }
}
