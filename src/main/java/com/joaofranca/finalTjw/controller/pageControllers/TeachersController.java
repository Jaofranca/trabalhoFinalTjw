package com.joaofranca.finalTjw.controller.pageControllers;

import com.joaofranca.finalTjw.dto.request.StudentRequestDTO;
import com.joaofranca.finalTjw.dto.request.TeacherRequestDTO;
import com.joaofranca.finalTjw.dto.response.TeacherResponseDTO;
import com.joaofranca.finalTjw.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TeachersController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher/table")
    public ModelAndView index(Model model){
        List<TeacherResponseDTO> teachersList = teacherService.findAll();
        model.addAttribute("TeachersList",teachersList);
        return new ModelAndView("tables/teachers");
    }
    @GetMapping("/teacher/form")
    public ModelAndView teacherForm(){
        return new ModelAndView("register/teacher");
    }

    @PostMapping("/teacher/register")
    public String teacherRegister(TeacherRequestDTO teacher){
        teacherService.register(teacher);
        return "redirect:/teacher/table";
    }
    @GetMapping("/teacher/{id}")
    public String teacherFind(@PathVariable long id,Model model){
        model.addAttribute("teacher",teacherService.findById(id));
        return "/edit/teacher";
    }

    @PostMapping("/teacher/{id}/update")
    public String teacherUpdate(@PathVariable long id, TeacherRequestDTO teacher){
        teacherService.update(id,teacher);
        return "redirect:/teacher/table";
    }

    @GetMapping("/teacher/{id}/delete")
    public String teacherDelete(@PathVariable int id){
        teacherService.delete(id);
        return "redirect:/teacher/table";
    }



}
