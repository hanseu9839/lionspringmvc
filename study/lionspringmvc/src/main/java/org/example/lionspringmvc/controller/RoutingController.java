package org.example.lionspringmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {
    @GetMapping("/start")
    public String startProcess(Model model){
        model.addAttribute("forwardTest", "doungdoung");
        return "forward:/forward";
    }

    @GetMapping("/forward")
    public String forward(Model model, HttpServletRequest request){
        System.out.println("forwardTest::::::"+model.getAttribute("forwardTest"));
        System.out.println(request.getAttribute("forwardTest"));
        return "forwardPage"; // forwardPage는 뷰이름.
    }

    @GetMapping("/redirect")
    public String redirect(Model model){
        model.addAttribute("forwardTest", "doungdoung");

        return "redirect:/finalDestination";
    }

    @GetMapping("/finalDestination")
    public String finalDestination(){

        return "redirectPage";
    }
}
