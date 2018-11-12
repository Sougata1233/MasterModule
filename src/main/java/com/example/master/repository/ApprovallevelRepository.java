package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.Country;

public interface ApprovallevelRepository extends JpaRepository<Country, Long> {

}
