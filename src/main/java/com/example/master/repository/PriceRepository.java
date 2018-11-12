package com.example.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.master.entity.Price;


@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

}
