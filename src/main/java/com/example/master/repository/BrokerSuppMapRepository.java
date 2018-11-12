package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.master.entity.BrokerSuppMap;

public interface BrokerSuppMapRepository extends JpaRepository<BrokerSuppMap, Long> {
	
	@Query(value = "SELECT BROKER_SUPP_MAP_SEQ.nextval FROM dual", nativeQuery =true)
	long seqVal();
	
	@Query("select b from BrokerSuppMap b where b.suppCode = :suppCode")
	public List<BrokerSuppMap> findBySuppCode(@Param("suppCode") String suppCode);
	
	@Query("select b from BrokerSuppMap b where b.brokerId = :brokerId")
	public List<BrokerSuppMap> findByBrokerId(@Param("brokerId") long brokerId);
	
	@Query("select b from BrokerSuppMap b where b.brokerId = :brokerId and b.suppCode = :suppCode")
	public BrokerSuppMap findByBrokerIdAndSuppCode(@Param("brokerId") long brokerId, @Param("suppCode") String suppCode);

}
