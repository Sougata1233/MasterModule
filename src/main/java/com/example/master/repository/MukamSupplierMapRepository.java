package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.master.entity.MukamSupplier;

public interface MukamSupplierMapRepository extends JpaRepository<MukamSupplier, Long>{
	
	@Query(value = "SELECT MUKAM_SUPP_MAP_SEQ.nextval FROM dual", nativeQuery = true)
    Long getNextSeriesId();
	
	@Query(value = "SELECT MUKAM_SUPP_MAP_SEQ FROM dual", nativeQuery = true)
    Long getPresentSeq();
	
	MukamSupplier findById(long id);
	
	@Query("select s from MukamSupplier s where s.supplierName = :supplierName order by mukamId")
	List<MukamSupplier> findBySupplierName(@Param("supplierName") String supplierName);

	MukamSupplier findBySupplierNameAndMukamId(String suppcode, long mukamid);
	List<MukamSupplier> findByMukamId(long mukamid);
}
