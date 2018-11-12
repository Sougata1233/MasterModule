package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.master.entity.State;

public interface StateRepository extends JpaRepository<State, Long> {

    State findById(long i);
    
    @Query("delete from State s where s.id = :id")
    void deleteState1(@Param("id") long id);
    
    List<State> findByCountryId(long countryId);

}
