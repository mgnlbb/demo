package com.example.karyawan.demo.controllers;

import com.example.karyawan.demo.models.Position;
import com.example.karyawan.demo.repositories.positionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiPositionController {
    @Autowired
    private positionRepo positionRepo;

    //get all data
    @GetMapping("/position")
    public ResponseEntity<List<Position>> GetAllPosition() {
        try {
            List<Position> positions = this.positionRepo.findAll();
            return new ResponseEntity<>(positions, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping("/positionmapped")
    public ResponseEntity<Map<String, Object>> GetAllPage(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "0" ) int size) {
        try {
            List<Position> position = new ArrayList<>();
            org.springframework.data.domain.Pageable pagingSort = PageRequest.of(page, size);

            Page<Position> pageTuts = positionRepo.findAll(pagingSort);

            position = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("position", position);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/searchposition/{keyword}")
    public ResponseEntity<List<Position>> SearchPositionName(@PathVariable("keyword") String keyword) {
        if(keyword != null) {
            List<Position> position = this.positionRepo.SearchPosition(keyword);
            return new ResponseEntity<>(position, HttpStatus.OK);
        } else {
            List<Position> position = this.positionRepo.findAll();
            return new ResponseEntity<>(position, HttpStatus.OK);
        }
    }

    @PostMapping("/position")
    public ResponseEntity<Object> savePosition(@RequestBody Position position){
        Position positionData = this.positionRepo.save(position);
        if (positionData.equals(position)){
            return new ResponseEntity<>("success", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/position/{id}")
    public ResponseEntity<Position> GetPositionById(@PathVariable("id") Long id){
        try {
            Optional<Position> position = this.positionRepo.findById(id);
            if (position.isPresent()){
                ResponseEntity rest = new ResponseEntity<>(position, HttpStatus.OK);
                return rest;
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/position/{id}")
    public ResponseEntity<Object> UpdatePosition(@RequestBody Position position, @PathVariable("id") Long id){
        Optional<Position> positionData = this.positionRepo.findById(id);

        if (positionData.isPresent()){
            position.setId(id);
            this.positionRepo.save(position);

            ResponseEntity rest = new ResponseEntity<>("success", HttpStatus.OK);
            return rest;
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("position/{id}")
    public ResponseEntity<Object> DeletePosition(@PathVariable("id") Long id) {
        Optional<Position> positionData = this.positionRepo.findById(id);

        if (positionData.isPresent()){
            this.positionRepo.deleteById(id);

            ResponseEntity rest = new ResponseEntity<>("success", HttpStatus.OK);
            return rest;
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
