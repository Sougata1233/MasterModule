package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.master.dto.SupplierMasterDTO;
import com.example.master.entity.SupplierMaster;

@Repository
public interface SupplierMasterRepository extends JpaRepository<SupplierMaster, String>{

    SupplierMaster findById(String i);
    
    @Query(value = "SELECT SUPPLIER_SEQ.nextval FROM dual", nativeQuery = true)
     Long getNextSeriesId();
    
    @Query(value = "SELECT SUPPLIER_SEQ FROM dual", nativeQuery = true)
    Long getPresentSeq();
    
    @Query("select s from SupplierMaster s")
    List<SupplierMasterDTO> getAll();
    
    @Query("select s from SupplierMaster s where s.id = :id and s.suppTyp = :suppTyp")
    SupplierMaster findBySuppCodeAndSuppType(@Param("id") String id, @Param("suppTyp") String suppTyp);
    
    List<SupplierMaster> findBySuppTyp(String suppType);
    
    List<SupplierMaster> findBySuppName(String suppName);

   // List<Activity> findByUserName(String userName);

    // custom query example and return a stream
   // @Query("select u from User u where u.userName = :userName")
   // Stream<Activity> findByUserNameReturnStream(@Param("userName") String userName);

}
