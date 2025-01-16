package com.AxelSolutions.first_spring_app;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWordController{
    public string helloWord () {
        return "Ola Mundo";
    }
}