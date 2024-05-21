package org.example.lionspringmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitController {

    @GetMapping("/visit")
    public String showVisit(
            @CookieValue(name = "lastVisit", defaultValue="N/A") String lastVisit,
            HttpServletResponse response, Model model
    ){
        Cookie cookie = new Cookie("lastVisit", "carami");
        cookie.setMaxAge(2*60*60);
        response.addCookie(cookie);

        model.addAttribute("lastVisit", lastVisit);
        return "visit";
    }
}
