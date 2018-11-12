package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findById(long i);
    List<Country> findByStatesId(long stateId);

}
