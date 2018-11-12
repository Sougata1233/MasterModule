package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByStateId(long stateId);
}
