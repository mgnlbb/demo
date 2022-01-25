package com.example.karyawan.demo.repositories;

import com.example.karyawan.demo.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface roleRepo extends JpaRepository<Role, Long>{
    
}
