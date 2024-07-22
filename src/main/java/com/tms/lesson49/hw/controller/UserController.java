package com.tms.lesson49.hw.controller;

import java.util.Objects;

import com.tms.lesson49.hw.model.Person;
import com.tms.lesson49.hw.model.User;
import com.tms.lesson49.hw.service.HibernateUtil;
import com.tms.lesson49.hw.service.PersonService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    private PersonService personService;

    private String errorMessage = "Please, fill in valid data.";

    @GetMapping(value = "/create")
    public ModelAndView fillCreateUserForm() {
        return new ModelAndView("create/createPersonForm", "person", new Person());
    }

    @PostMapping(value = "/create")
    public ModelAndView createUser(@ModelAttribute Person person, Model model) {
//        if (isPersonNull(person.getId()) &&
//                person.getId() != 0 &&
//                !person.getName().isEmpty() &&
//                !person.getSurname().isEmpty() &&
//                person.getAge() != 0 &&
//                !person.getPassportNumber().isEmpty()) {
//        if (isPersonNull(person.getId())) {

            personService.createUser(person);
            System.out.println("hello blyat'");
            String message = String.format("User with '%s' id has been created successfully!", person.getId());
            model.addAttribute("message", message);
            return new ModelAndView("create/createPerson", "person", new Person());
//        }
//        model.addAttribute("message", errorMessage);
//        return new ModelAndView("create/createUserForm", "user", new User());
    }



    @GetMapping(value = "/get")
    public ModelAndView getPerson(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null && !isPersonNull(id) && id != 0) {
            Person requestedPerson = personService.getPersonInfo(id);
            model.addAttribute("person", requestedPerson);
            return new ModelAndView("get/getPerson");
        }
        model.addAttribute("message", errorMessage);
        return new ModelAndView("get/getPersonForm", "person", new Person());
    }

    @GetMapping(value = "/update")
    public ModelAndView fillUpdateUserForm() {
        return new ModelAndView("update/updateUserForm", "user", new User());
    }

//    @PostMapping(value = "/update")
//    public ModelAndView updateUser(@ModelAttribute User user, Model model) {
//        if (!isPersonNull(user.getId()) && user.getId() != 0) {
//            personService.updateUser(user);
//            String message = String.format("User with '%s' id has been updated successfully!", user.getId());
//            model.addAttribute("message", message);
//            return new ModelAndView("update/updateUser", "user", new User());
//        }
//        model.addAttribute("message", errorMessage);
//        return new ModelAndView("update/updateUserForm", "user", new User());
//    }

//    @PostMapping(value = "/update")
//    public ModelAndView updateUser(@ModelAttribute User user, Model model) {
//        if (!isPersonNull(user.getId()) && user.getId() != 0) {
//            personService.updatePerson(user);
//            String message = String.format("User with '%s' id has been updated successfully!", user.getId());
//            model.addAttribute("message", message);
//            return new ModelAndView("update/updateUser", "user", new User());
//        }
//        model.addAttribute("message", errorMessage);
//        return new ModelAndView("update/updateUserForm", "user", new User());
//    }

    @GetMapping(value = "/delete")
    public ModelAndView fillDeleteUserForm() {
        return new ModelAndView("delete/deletePersonForm", "person", new Person());
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteUser(@RequestParam("id") int id, Model model) {
        if (!isPersonNull(id) && id != 0) {
            personService.deleteUser(id);
            String message = String.format("Person with '%s' id has been deleted successfully!", id);
            model.addAttribute("message", message);
            return new ModelAndView("delete/deletePerson", "person", new Person());
        }
        model.addAttribute("message", errorMessage);
        return new ModelAndView("delete/deletePersonForm", "person", new Person());
    }

    private boolean isPersonNull(int id) {
        return Objects.isNull(personService.getPersonInfo(id));
    }
}
