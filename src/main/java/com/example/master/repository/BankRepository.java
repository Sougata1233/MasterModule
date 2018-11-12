package com.example.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{

}
