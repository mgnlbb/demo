package com.example.karyawan.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/role/")
public class RoleController {
    @GetMapping(value = "index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("role/index");
        return view;
    }
}
