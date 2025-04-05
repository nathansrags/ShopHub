package com.shophub.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {

    @RequestMapping("/")
    String redirect(){
        return "redirect:swagger-ui/index.html";
    }
}
