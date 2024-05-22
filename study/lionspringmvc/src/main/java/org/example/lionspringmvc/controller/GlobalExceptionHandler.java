package org.example.lionspringmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e, Model model){
        log.info("error :: ");
        log.error("Server Error {}",e.getMessage());

        model.addAttribute("errorMessage", e.getMessage());

        return "error";
    }
}
