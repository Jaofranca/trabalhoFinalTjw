package com.joaofranca.finalTjw.controller.pageControllers;

import com.joaofranca.finalTjw.dto.response.ClassroomResponseDTO;
import com.joaofranca.finalTjw.dto.response.StudentResponseDTO;
import com.joaofranca.finalTjw.dto.response.TeacherResponseDTO;
import com.joaofranca.finalTjw.entity.Classroom;
import com.joaofranca.finalTjw.entity.Student;
import com.joaofranca.finalTjw.service.ClassroomService;
import com.joaofranca.finalTjw.service.StudentService;
import com.joaofranca.finalTjw.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

//    @GetMapping(value= "/")
//    public String index(){
//        return "home/index";
//    }
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassroomService classroomService;
    @GetMapping("/")
    public ModelAndView index(Model model){
        List<StudentResponseDTO> studentsList = studentService.findAll();
        List<TeacherResponseDTO> teachersList = teacherService.findAll();
        List<ClassroomResponseDTO> classroomsList = classroomService.findAll();
        model.addAttribute("StudentsList",studentsList);
        model.addAttribute("TeachersList",teachersList);
        model.addAttribute("ClassroomsList",classroomsList);

        return new ModelAndView("index");
    }

//    @PostMapping("/create")
//    public void create(Student student){
////        Sysout
//
//    }

}
