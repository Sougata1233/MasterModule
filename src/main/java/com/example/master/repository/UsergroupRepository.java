package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.Usergroup;

public interface UsergroupRepository extends JpaRepository<Usergroup, Long> {

    List<Usergroup> findById(Long i);

}
