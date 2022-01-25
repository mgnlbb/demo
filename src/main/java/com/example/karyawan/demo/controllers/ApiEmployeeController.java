package com.example.karyawan.demo.controllers;

import com.example.karyawan.demo.models.Employee;
import com.example.karyawan.demo.repositories.employeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiEmployeeController {
    @Autowired
    private  employeeRepo employeeRepo;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> GetAllEmployee() {
        try {
            List<Employee> employee = this.employeeRepo.findAll();
            return new ResponseEntity<>(employee, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        }
    }


    @PostMapping("/employee")
    public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {
        try {
            this.employeeRepo.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(employee, HttpStatus.NO_CONTENT);
        }
    }



    @DeleteMapping("employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) {
        Optional<Employee> employeeData = this.employeeRepo.findById(id);

        if (employeeData.isPresent()){
            this.employeeRepo.deleteById(id);

            ResponseEntity rest = new ResponseEntity<>("success", HttpStatus.OK);
            return rest;
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
