package com.grupo5.grupo5.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null && Integer.valueOf(status.toString()) == HttpStatus.NOT_FOUND.value()) {
            return "errors/404";
        }
        if (status != null && Integer.valueOf(status.toString()) == HttpStatus.FORBIDDEN.value()) {
            return "errors/403";
        }
        return "error";
    }

}
