package com.joaofranca.finalTjw.controller.pageControllers;

import com.joaofranca.finalTjw.dto.request.ClassroomRequestDTO;
import com.joaofranca.finalTjw.dto.request.TeacherRequestDTO;
import com.joaofranca.finalTjw.dto.response.ClassroomResponseDTO;
import com.joaofranca.finalTjw.dto.response.StudentResponseDTO;
import com.joaofranca.finalTjw.dto.response.TeacherResponseDTO;
import com.joaofranca.finalTjw.entity.Teacher;
import com.joaofranca.finalTjw.service.ClassroomService;
import com.joaofranca.finalTjw.service.StudentService;
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
public class ClassroomsController {
    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/classroom/table")
    public ModelAndView index(Model model){
        List<ClassroomResponseDTO> ClassroomsList = classroomService.findAll();
        model.addAttribute("ClassroomsList",ClassroomsList);
        return new ModelAndView("tables/classrooms");
    }

    @GetMapping("/classroom/form")
    public ModelAndView classroomForm(Model teacherModel){
        List<TeacherResponseDTO> teachersList = teacherService.findAll();
        List<StudentResponseDTO> studentsList = studentService.findAll();
        teacherModel.addAttribute("TeachersList",teachersList);
        teacherModel.addAttribute("StudentsList",studentsList);
        return new ModelAndView("register/classroom");
    }

    @PostMapping("/classroom/register")
    public String classroomRegister(ClassroomRequestDTO classroom){
        classroomService.register(classroom);
        return "redirect:/classroom/table";
    }
    @GetMapping("/classroom/{id}")
    public String classroomFind(@PathVariable long id,Model model,Model teacherModel){
        List<TeacherResponseDTO> teachersList = teacherService.findAll();
        teacherModel.addAttribute("TeachersList",teachersList);
        model.addAttribute("classroom",classroomService.findById(id));
        return "/edit/classroom";
    }

    @PostMapping("/classroom/{id}/update")
    public String classroomUpdate(@PathVariable long id, ClassroomRequestDTO classroom){
        classroomService.update(id,classroom);
        return "redirect:/classroom/table";
    }

    @GetMapping("/classroom/{id}/delete")
    public String classroomDelete(@PathVariable int id){
        classroomService.delete(id);
        return "redirect:/classroom/table";
    }


}
