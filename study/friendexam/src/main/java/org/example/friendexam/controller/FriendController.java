package org.example.friendexam.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.service.FriendService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Iterator;
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {
    public final FriendService friendService;

    @GetMapping
    public String friends(Model model, @RequestParam(defaultValue = "1")int page,
                          @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page -1 , size);

        Page<Friend> friends =  friendService.findAllFriends(pageable);

        model.addAttribute("friends", friends);
        model.addAttribute("currentPage",page);
        return "friends/list";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("friend", new Friend());
        return "friends/form";
    }

    @PostMapping("/add")
    public String registrationFriend(@ModelAttribute Friend friend, RedirectAttributes redirectAttributes){
        // 친구저장
        friendService.saveFriend(friend);

        redirectAttributes.addAttribute("message", "친구 등록 성공!!");
        return "redirect:/friends";
    }

    // 친구상세페이지
    // localhost/friends/1
    @GetMapping("/{id}")
    public String detailsFriend(@PathVariable(value="id") Long id, Model model){
        Friend friend  = friendService.findFriendById(id);

        model.addAttribute("friend", friend);
        return "friends/details";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        friendService.delete(id);

        return "redirect:/friends";
    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        Friend friend = friendService.findFriendById(id);
        model.addAttribute("friend", friend);
        return "friends/edit";
    }


    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute Friend friend) {
        friendService.update(friend);

        return "redirect:/friends/"+id;
    }


}
