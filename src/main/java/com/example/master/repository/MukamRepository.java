package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.master.entity.Mukam;

public interface MukamRepository extends JpaRepository<Mukam, Long> {

    List<Mukam> findById(Long i);
    
    @Query("select m from Mukam m where m.mukamName = :mukamName")
    Mukam findByMukamNameEntity(@Param("mukamName") long mukamName);
    
    Mukam findByMukamName(String mukamname);
    
    @Query("select m from Mukam m where m.id = :id")
    Mukam findByIdEntity(@Param("id") long id);
    
    @Query("Select m.id, m.mukamName from Mukam m")
    List<Mukam> findALL();

}
