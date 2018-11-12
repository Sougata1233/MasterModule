package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.Codemaster;

public interface CodemasterRepository extends JpaRepository<Codemaster, String> {

    List<Codemaster> findBycode(String code);
    List<Codemaster> findByCodeType(String codeType);
    
}
