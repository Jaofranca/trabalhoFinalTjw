package com.joaofranca.finalTjw.controller.pageControllers;

import com.joaofranca.finalTjw.dto.request.StudentRequestDTO;
import com.joaofranca.finalTjw.dto.response.StudentResponseDTO;
import com.joaofranca.finalTjw.entity.Student;
import com.joaofranca.finalTjw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/table")
    public ModelAndView index(Model model){
        List<StudentResponseDTO> studentsList = studentService.findAll();
        model.addAttribute("StudentsList",studentsList);
        return new ModelAndView("tables/student");
    }
    @GetMapping("/student/form")
    public ModelAndView studentForm(){
        return new ModelAndView("register/student");
    }

    @PostMapping("/student/register")
    public String studentRegister(StudentRequestDTO student){
        studentService.register(student);
        return "redirect:/student/table";
    }
    @GetMapping("/student/{id}")
    public ModelAndView studentFind(@PathVariable long id,Model model){
        List<StudentResponseDTO> studentsList = studentService.findAll();
        List<String> studentsCpf = studentsList.stream()
                .map(StudentResponseDTO::getCpf)
                .collect(Collectors.toList());
        model.addAttribute("studentsCpf",studentsCpf);
        model.addAttribute("student",studentService.findById(id));
        return new ModelAndView("/edit/student");
    }

    @PostMapping("/student/{id}/update")
    public String studentUpdate(@PathVariable long id,StudentRequestDTO student){
        studentService.update(id,student);
        return "redirect:/student/table";
    }

    @GetMapping("/student/{id}/delete")
    public String studentDelete(@PathVariable long id){
        studentService.delete(id);
        return "redirect:/student/table";
    }




}
