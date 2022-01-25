package com.example.karyawan.demo.repositories;

import com.example.karyawan.demo.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface positionRepo extends JpaRepository<Position, Long> {
    @Query("FROM Position WHERE lower (positionName) LIKE lower (concat('%',?1,'%'))")
    List<Position> SearchPosition(String keyword);
}
