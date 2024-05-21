package org.example.lionspringmvc.controller;

import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.example.lionspringmvc.domain.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("userForm", new UserForm());
        return "form";
    }



    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result){

        if(result.hasErrors()){
            return "form"; // 유효성 검사에서 에러가 발견되었다면 form.html 뷰로 리턴
        }

        System.out.println(userForm.getUsername() + ":: " + userForm.getPassword());
        return "result"; // 성공했다면, result.html 이 응답.
    }


}
