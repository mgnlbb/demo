package com.example.karyawan.demo.repositories;

import com.example.karyawan.demo.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface employeeRepo extends JpaRepository<Employee, Long>{
    // @Query("FROM Employee WHERE PositionId = ?1")
    // List<Employee> FindByPositionId(Long positionID);
}
