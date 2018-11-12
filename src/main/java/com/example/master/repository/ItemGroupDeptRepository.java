package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.master.entity.ItemGroupDept;


public interface ItemGroupDeptRepository extends JpaRepository<ItemGroupDept, Long> {
	
	List<ItemGroupDept> findByDeptId(long deptId);
	
	@Query("select i from ItemGroupDept i where i.itemGrp = :itemGrp")
	List<ItemGroupDept> findByItemGrp(@Param("itemGrp") String itemGrp);
	
	@Query("select i from ItemGroupDept i where i.itemGrp = :itemGrp")
	ItemGroupDept findByItemGrpEntity(@Param("itemGrp") String itemGrp);
	
	@Query("select i from ItemGroupDept i where i.itemGrp = :itemGrp and i.deptId = :deptId")
	ItemGroupDept findByItemGrpAndDeptId(@Param("itemGrp") String itemGrp , @Param("deptId") long deptId);
	
	@Query("select i from ItemGroupDept i where i.itemGrp = :itemGrp and i.isMapped = :isMapped")
	List<ItemGroupDept> findByItemGrpAndIsMapped(@Param("itemGrp") String itemGrp , @Param("isMapped") String isMapped);
	
	@Query(value = "SELECT ITEM_GRP_DEPT_MAP_SEQ.nextval FROM dual", nativeQuery =true)
	long seqVal();

}
