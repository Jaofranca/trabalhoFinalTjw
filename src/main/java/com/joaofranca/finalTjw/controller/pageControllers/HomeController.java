package com.joaofranca.finalTjw.controller.pageControllers;

import com.joaofranca.finalTjw.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

//    @GetMapping(value= "/")
//    public String index(){
//        return "home/index";
//    }
    @GetMapping("/")
    public ModelAndView index(Model model){
        model.addAttribute("nome","Danilo");
        return new ModelAndView("index");
    }

//    @PostMapping("/create")
//    public void create(Student student){
////        Sysout
//
//    }

}
