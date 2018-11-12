package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.JuteQualityPriceMaster;

public interface JuteQualityPriceMasterRepository extends JpaRepository<JuteQualityPriceMaster, Long> {

    List<JuteQualityPriceMaster> findById(Long i);

}
