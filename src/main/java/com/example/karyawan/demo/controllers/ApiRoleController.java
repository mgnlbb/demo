package com.example.karyawan.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.karyawan.demo.models.Role;
import com.example.karyawan.demo.repositories.roleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiRoleController {
    @Autowired
    private roleRepo roleRepo;


    @GetMapping("/role")
    public ResponseEntity<List<Role>> GetAllPosition() {
        try {
            List<Role> roles = this.roleRepo.findAll();
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping("/rolemapped")
    public ResponseEntity<Map<String, Object>> GetAllPage(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "0" ) int size) {
        try {
            List<Role> role = new ArrayList<>();
            org.springframework.data.domain.Pageable pagingSort = PageRequest.of(page, size);

            Page<Role> pageTuts = roleRepo.findAll(pagingSort);

            role = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("role", role);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/role")
    public ResponseEntity<Object> savePosition(@RequestBody Role role){
        Role roleData = this.roleRepo.save(role);
        if (roleData.equals(role)){
            return new ResponseEntity<>("success", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }
}
