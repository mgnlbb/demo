package com.example.karyawan.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/employee/")
public class EmployeeController {
    @GetMapping(value="index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("employee/index");
        return view;
    }

    @GetMapping(value= "/new")
    public ModelAndView newEmployee() {
        ModelAndView view = new ModelAndView("employee/newData");
        return view;
    }

    @GetMapping(value="edit/{id}")
    public ModelAndView editEmployee() {
        ModelAndView view = new ModelAndView("employee/editData");
        return view;
    }
}
