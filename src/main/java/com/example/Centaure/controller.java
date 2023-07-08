package com.example.Centaure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @RequestMapping(path = {"/Home"})
    public String Home(){
        return "Tela inicial";
    }
}

