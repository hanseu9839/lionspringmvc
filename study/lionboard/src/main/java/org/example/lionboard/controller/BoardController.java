package org.example.lionboard.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lionboard.domain.Board;
import org.example.lionboard.domain.BoardDeleteRequest;
import org.example.lionboard.domain.BoardWriteRequest;
import org.example.lionboard.service.BoardService;
import org.example.lionboard.util.CryptoUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("list")
    public String list(Model model, @RequestParam(defaultValue="1")int page, @RequestParam(defaultValue="10")int size) {
        Pageable pageable = PageRequest.of(page-1, size);

        Page<Board> boards = boardService.boardAll(pageable);

        model.addAttribute("boards", boards);
        model.addAttribute("currentPage", page);

        return "board/list";
    }

    @GetMapping("/writeform")
    public String addForm(Model model) {
        model.addAttribute("board", new BoardWriteRequest());
        return "board/writeform";
    }

    @PostMapping("/writeform")
    public String write(@Validated @ModelAttribute("board")  BoardWriteRequest form, BindingResult bindingResult){
        // 실패 로직
        if(bindingResult.hasErrors()){
            log.info("errors={}", bindingResult);
            return "board/writeform";
        }

        Board board = Board.builder()
                .title(form.getTitle())
                .name(form.getName())
                .content(form.getContent())
                .password(CryptoUtil.encrypt(form.getPassword()))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        boardService.save(board);

        return "redirect:list";
    }

    @GetMapping("/view/{id}")
    public String details(@PathVariable Long id, Model model){
       Board board = boardService.findById(id);

       model.addAttribute("board", board);
       return "board/view";

    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id, Model model){
        BoardDeleteRequest request =  BoardDeleteRequest.builder()
                .id(id)
                .build();
        model.addAttribute("board", request);

        return "board/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, @ModelAttribute("board") BoardDeleteRequest request,BindingResult bindingResult){
        Board board = boardService.findById(id);

        if(!board.getPassword().equals(request.getPassword())){
            bindingResult.reject("passwordError", null);
            return "board/delete";
        }

        boardService.delete(board);

        return "redirect:list";
    }


    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        Board board = boardService.findById(id);

        model.addAttribute("board", board);
        return "board/update";
    }
}
