package org.example.lionspringmvc.controller;

import org.example.lionspringmvc.domain.Item;
import org.example.lionspringmvc.domain.Product;
import org.example.lionspringmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ExamController {
    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("welcomeMsg", "saisai washoui hanguran hansounggutn");

        List<Item> items = Arrays.asList(
                new Item("pen", 3000),
                new Item("notebook", 50000000),
                new Item("cup", 2550)
        );

        model.addAttribute("items", items);

        return "welcom";
    }



    // url = /products
    @GetMapping("/products")
    public String product(Model model){
        List<Product> products = Arrays.asList(
                new Product("banana", 1.25),
                new Product("apple", 0.75),
                new Product("Cherry", 2.05)

        );
        model.addAttribute("products", products);

        return "product";
    }

    @GetMapping("/example")
    public String showExam(Model model){
        model.addAttribute("username", "han");
        model.addAttribute("isAdmin", true);
        model.addAttribute("languages", new String[]{"English, Spanish","German"});

        return "exam";
    }

    // http://localhost:users 사용자 목록을 출력하세요.
    // 사용자 목록에서 사용자, 관리자 여부
    // -- 이 값을 메시지 프로퍼티를 이용해서 출력하도록 완성
    @GetMapping("/users")
    public String users(Model model){
        List<User> users = Arrays.asList(
                new User("한승균", 20),
                new User("강은화", 19),
                new User("강경미", 22),
                new User("김채민", 21)
        );

        model.addAttribute("users", users);
        model.addAttribute("isAdmin", true);
        return "users";
    }
}
