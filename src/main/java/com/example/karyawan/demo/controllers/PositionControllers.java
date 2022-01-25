package com.example.karyawan.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/position/")
public class PositionControllers {
    @GetMapping(value = "index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("position/index");
        return view;
    }

}
