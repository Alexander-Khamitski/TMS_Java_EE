package com.tms.lesson44.hw.controller;

import com.tms.lesson44.hw.dao.StudentDao;
import com.tms.lesson44.hw.model.Student;
import com.tms.lesson44.hw.validator.Validator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private Validator validator;

    @GetMapping()
    public ModelAndView showStudents() {
        ModelAndView modelAndView = new ModelAndView("getStudents");
        modelAndView.addObject("students", this.studentDao.getAllStudents());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getStudentInfo(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("getStudent");
        modelAndView.addObject("student", this.studentDao.getStudent(id));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateStudentPage(@ModelAttribute Student student) {
        return new ModelAndView("createStudent");
    }

    @PostMapping
    public ModelAndView createStudent(@Valid @ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("createStudent", "student", student);
            return modelAndView;
        } else {
            studentDao.addStudent(student);
            return new ModelAndView("createdStudent", "student", student);
        }
    }

    @GetMapping("/delete")
    public ModelAndView showDeleteStudentPage() {
        return new ModelAndView("deleteStudent");
    }

    @PostMapping("/delete")
    public ModelAndView deleteStudent(@RequestParam int id) {
        if (this.validator.isIdValid(id)) {
            this.studentDao.deleteStudent(id);
            return new ModelAndView("deletedStudent").addObject("id", id);
        } else {
            return new ModelAndView("deleteStudent").addObject("message", "id " + id + " is not found");
        }
    }
}
