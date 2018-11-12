package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.master.entity.MukamJute;


@Repository
public interface MukamJuteRepository extends JpaRepository<MukamJute, Long> {
	
	
	List<MukamJute> findByMukamId(long mukamid);
	List<MukamJute> save(List<MukamJute> mukamjute);
	
	@Query("select m from MukamJute m where m.mukamId = :mukamId and m.ItemJuteCode = :ItemJuteCode")
	MukamJute findByMukamIdAndItemJuteCode(@Param("mukamId") long mukamId, @Param("ItemJuteCode") String ItemJuteCode);
	
	@Query(value = "SELECT MUKAM_JUTE_MAP_SEQ.nextval FROM dual", nativeQuery =true)
	long seqVal();

}
