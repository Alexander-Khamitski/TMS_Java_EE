package com.tms.lesson52.hw.controller;

import java.util.List;

import com.tms.lesson52.hw.model.Student;
import com.tms.lesson52.hw.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/create")
    public ModelAndView fillCreateStudentForm() {
        return new ModelAndView("create/createStudentForm", "student", new Student());
    }

    @PostMapping(value = "/create")
    public ModelAndView createStudent(@ModelAttribute Student student, Model model) {
        if (!student.getName().isEmpty() &&
                !student.getSurname().isEmpty() &&
                student.getGroupId() != 0) {
            studentRepository.save(student);
            String message = String.format("Student with '%s' id has been created successfully!", student.getId());
            model.addAttribute("message", message);
            return new ModelAndView("create/createStudent", "student", new Student());
        }
        model.addAttribute("message", "Please, fill in valid data.");
        return new ModelAndView("create/createStudentForm", "student", new Student());
    }

    @GetMapping(value = "/get")
    public ModelAndView getStudent(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null && studentRepository.existsById(id)) {
            Student requestedStudent = studentRepository.findById(id).orElse(null);
            model.addAttribute("student", requestedStudent);
            return new ModelAndView("get/getStudent");
        }
        return new ModelAndView("get/getStudentForm", "student", new Student());
    }

    @GetMapping(value = "/getStudentBySurname")
    public ModelAndView getStudentBySurname(@RequestParam(value = "surname", required = false) String surname, Model model) {
        if (surname != null) {
            Student requestedStudent = studentRepository.findStudentBySurname(surname);
            model.addAttribute("student", requestedStudent);
            return new ModelAndView("get/getStudent");
        }
        return new ModelAndView("get/getStudentBySurnameForm", "student", new Student());
    }

    @GetMapping(value = "/getStudentByName")
    public ModelAndView getStudentByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            Student requestedStudent = studentRepository.findStudentByName(name);
            model.addAttribute("student", requestedStudent);
            return new ModelAndView("get/getStudent");
        }
        return new ModelAndView("get/getStudentByNameForm", "student", new Student());
    }

    @GetMapping(value = "/getStudentsByGroupId")
    public ModelAndView getStudentsByGroupId(@RequestParam(value = "groupId", required = false) Integer groupId, ModelMap model) {
        if (groupId != null) {
            List<Student> requestedStudents = studentRepository.findStudentsByGroupId(groupId);
            model.put("students", requestedStudents);
            return new ModelAndView("get/getStudentsByGroupId");
        }
        return new ModelAndView("get/getStudentsByGroupIdForm", "students", new Student());
    }

    @GetMapping(value = "/getStudentsByPayment")
    public ModelAndView getStudentsByPayment(@RequestParam(value = "ispaid", required = false) Boolean isPaid, ModelMap model) {
        if (isPaid != null) {
            List<Student> requestedStudents = studentRepository.findStudentsByPayment(isPaid);
            System.out.println(requestedStudents);
            model.put("students", requestedStudents);
            return new ModelAndView("get/getStudentsByPayment");
        }
        return new ModelAndView("get/getStudentsByPaymentForm", "student", new Student());
    }

    @GetMapping(value = "/update")
    public ModelAndView fillUpdateStudentForm() {
        return new ModelAndView("update/updateStudentForm", "student", new Student());
    }

    @PostMapping(value = "/update")
    public ModelAndView updateStudent(@ModelAttribute Student student, Model model) {
        if (studentRepository.existsById(student.getId())) {
            studentRepository.save(student);
            String message = String.format("Student with '%s' id has been updated successfully!", student.getId());
            model.addAttribute("message", message);
            return new ModelAndView("update/updateStudent", "student", new Student());
        }
        return new ModelAndView("update/updateStudentForm", "student", new Student());
    }

    @GetMapping(value = "/updateStudentGroup")
    public ModelAndView fillUpdateStudentGroupForm() {
        return new ModelAndView("update/updateStudentGroupForm", "student", new Student());
    }

    @PostMapping(value = "/updateStudentGroup")
    public ModelAndView updateStudentGroup(@ModelAttribute Student student, Model model) {
        int id = student.getId();
        int groupId = student.getGroupId();
        if (studentRepository.existsById(id)) {
            student = studentRepository.findById(id).orElse(null);
            student.setGroupId(groupId);
            studentRepository.save(student);
            String message = String.format("Student with '%s' id has been updated successfully!", student.getId());
            model.addAttribute("message", message);
            return new ModelAndView("update/updateStudent", "student", new Student());
        }
        return new ModelAndView("update/updateStudentGroupForm", "student", new Student());
    }

    @GetMapping(value = "/delete")
    public ModelAndView fillDeleteStudentForm() {
        return new ModelAndView("delete/deleteStudentForm", "student", new Student());
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteStudent(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            String message = String.format("Student with '%s' id has been deleted successfully!", id);
            model.addAttribute("message", message);
            return new ModelAndView("create/createStudent", "student", new Student());
        }
        model.addAttribute("message", "Please, fill in valid data.");
        return new ModelAndView("delete/deleteStudentForm", "student", new Student());
    }
}
