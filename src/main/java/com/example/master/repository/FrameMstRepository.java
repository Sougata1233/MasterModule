package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.FrameMst;

public interface FrameMstRepository extends JpaRepository<FrameMst, Long> {

    List<FrameMst> findById(Long i);

}
