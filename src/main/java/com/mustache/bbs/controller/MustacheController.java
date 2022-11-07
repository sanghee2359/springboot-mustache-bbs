package com.mustache.bbs.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class MustacheController {
    @GetMapping(value = "/hi/{id}")
    public String mustacheCon2(@PathVariable String id, Model model) {
        model.addAttribute("username", "rok");// view에 값을 넘기겠
        model.addAttribute("id", id);// view에 값을 넘기겠
        return "greetings"; // greetings라는 이름의의 view를 리턴
    }
}
