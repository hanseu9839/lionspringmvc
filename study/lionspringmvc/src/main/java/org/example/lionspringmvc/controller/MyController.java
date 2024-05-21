package org.example.lionspringmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @GetMapping("/home")
    public String name() {
        return "home";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @ResponseBody
    @GetMapping("rest")
    public String rest() {
        return "restbody test";
    }

//    @GetMapping("greeting")
//    public String greet(String name, int age, HttpServletRequest request){
//        //http://localhost:8888/greeting?name=jae&age=29
//        System.out.println(name);
//        System.out.println(age);
//
//        System.out.println("request:::" + request.getParameter("name"));
//        System.out.println("request:::" + request.getParameter("age"));
//        return "greeting";
//    }

//@GetMapping("greeting")
    public String greet(String name,@RequestParam(name="age", required = false, defaultValue = "10") int age, Model model) {
            //http://localhost:8888/greeting?name=jae&age=29
            System.out.println(name);
            System.out.println(age);

            model.addAttribute("name", name);
            model.addAttribute("age", age);
            return "greeting";
    }

    @GetMapping("greeting")
    public ModelAndView mvGreet(@RequestParam String name, @RequestParam int age,ModelAndView mv){
        System.out.println(name);

        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("greeting");

        return mv;
    }


}
