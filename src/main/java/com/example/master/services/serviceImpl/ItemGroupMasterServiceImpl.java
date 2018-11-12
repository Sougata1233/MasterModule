package com.example.master.services.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.master.component.DepartmentDao;
import com.example.master.component.ItemGroupDeptDao;
import com.example.master.component.ItemGroupMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.DepartmentMapDTO;
import com.example.master.dto.ItemGroupMasterDTO;
import com.example.master.dto.ItemMasterDTO;
import com.example.master.entity.Department;
import com.example.master.entity.ItemGroupDept;
import com.example.master.entity.ItemGroupMaster;
import com.example.master.services.ItemGroupMasterService;

/*
 * Service implementation class for itrmgroup_master table
 */
@Service
public class ItemGroupMasterServiceImpl implements ItemGroupMasterService {

	@Autowired
	ItemGroupMasterDao itemgroupmasterDao;
   
   @Autowired
   DepartmentDao departmentDao;
   
   @Autowired
   ItemGroupDeptDao itemgroupdeptDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(ItemGroupMasterServiceImpl.class);

    
    /*
     * preparing item group master DTO 
     */
    private ItemGroupMasterDTO prepareItemGroupMasterDTO(ItemGroupMaster itemgrpmasterEntity) throws Exception {
    	
    	ItemGroupMasterDTO itemgrpmasterdt = new ItemGroupMasterDTO();
    	
    	itemgrpmasterdt.setgrpDsc(itemgrpmasterEntity.getgrpDsc());
		itemgrpmasterdt.setactiveFlag(itemgrpmasterEntity.getactiveFlag());
		itemgrpmasterdt.setpurchaseCode(itemgrpmasterEntity.getpurchaseCode());
		itemgrpmasterdt.setinactiveTag(itemgrpmasterEntity.getinactiveTag());
		itemgrpmasterdt.setmodBy(itemgrpmasterEntity.getmodBy());
		itemgrpmasterdt.setmodOn(itemgrpmasterEntity.getmodOn());
		itemgrpmasterdt.setId(itemgrpmasterEntity.getId());
        
		
		/*
		 * getting the department for itemgroup_dept mapping table
		 */
		List<ItemMasterDTO> itemmasterDtoList=new ArrayList<ItemMasterDTO>();
    	
		List<DepartmentMapDTO> itemgroudeptEmp = new ArrayList<>();
		List<Department> department = departmentDao.findAll();
		long size = department.size();
		List<ItemGroupDept> itemgroupmapList = itemgroupdeptDao.getMapByItemGroup(itemgrpmasterEntity.getId());
		List<Long> deptids = new ArrayList<>();
		long deptid;
		for(int k = 0 ; k < itemgroupmapList.size() ; k++) {
			deptid = itemgroupmapList.get(k).getDeptId();
			deptids.add(deptid);
		}
		
		long start = Calendar.getInstance().getTimeInMillis();
		for(int i = 0 ; i < size; i ++) {
			DepartmentMapDTO itemmap = new DepartmentMapDTO();
			
			String isMapped = "false";
			if(deptids.contains(department.get(i).getId())) {
				isMapped = "true";
			}else {
				isMapped = "false";
			}
			
			itemmap.setIsMapped(isMapped);
			itemmap.setId(department.get(i).getId());
			itemmap.setDeptName(department.get(i).getdepartmentName());
			itemgroudeptEmp.add(prepareItemmasterDeptDTO(itemmap));
		}
		
		long end = Calendar.getInstance().getTimeInMillis();
    	System.out.println("start "+start+" end "+end);
    	System.out.println((end-start));

		itemgrpmasterdt.setDepartment(itemgroudeptEmp);
	    return itemgrpmasterdt;
    }
    
    
    /*
     * populating DTO for department item group mapping 
     */
   private DepartmentMapDTO prepareItemmasterDeptDTO(DepartmentMapDTO itemmap) {
		DepartmentMapDTO deptmap = new DepartmentMapDTO();
		
		deptmap.setId(itemmap.getId());
		deptmap.setDeptName(itemmap.getDeptName());
		deptmap.setIsMapped(itemmap.getIsMapped());
		
		return deptmap;
	}

   /*
    * (non-Javadoc)
    * @see com.example.master.services.ItemGroupMasterService#persistItemGroupMaster(com.example.master.dto.ItemGroupMasterDTO)
    * saving data to itemgroup_master table as well as itemgroup_dept table
    */
	@Override
    public ResponseEntity<ItemGroupMasterDTO> persistItemGroupMaster(ItemGroupMasterDTO itemgroupmasterDTO) {

    	ItemGroupMaster itemgroupmasterEntity = new ItemGroupMaster();
    	if(itemgroupmasterDTO.getgrpDsc()!=null) {
    		itemgroupmasterEntity.setgrpDsc(itemgroupmasterDTO.getgrpDsc().toUpperCase());
    	}
    	itemgroupmasterEntity.setactiveFlag(itemgroupmasterDTO.getactiveFlag());
    	itemgroupmasterEntity.setpurchaseCode(itemgroupmasterDTO.getpurchaseCode());
    	itemgroupmasterEntity.setinactiveTag(itemgroupmasterDTO.getinactiveTag());
    	itemgroupmasterEntity.setmodBy(itemgroupmasterDTO.getmodBy());
    	itemgroupmasterEntity.setmodOn(Date.valueOf(LocalDate.now()));
    	itemgroupmasterEntity.setId(itemgroupmasterDTO.getId().toUpperCase());
    	System.out.println(itemgroupmasterDTO);
    	itemgroupmasterDao.addItemGroupMaster(itemgroupmasterEntity);
    	
    	List<DepartmentMapDTO> deptmapDTOList = itemgroupmasterDTO.getDepartment();
    	List<ItemGroupDept> itemgrpddeptEntityList = new ArrayList<>();
    	ItemGroupDept itemgroupdeptEntity = new ItemGroupDept();
    	
    	for(int i = 0 ; i < deptmapDTOList.size(); i++) {
    		long nexval = itemgroupdeptDao.getNextVal();
    		itemgroupdeptEntity.setMapId(nexval);
    		itemgroupdeptEntity.setDeptId(deptmapDTOList.get(i).getId());
    		itemgroupdeptEntity.setItemGrp(itemgroupmasterEntity.getId());
    		itemgroupdeptEntity.setIsMapped("true");
    		itemgrpddeptEntityList.add(itemgroupdeptDao.saveMap(itemgroupdeptEntity));
    	}
    	
	return new ResponseEntity<ItemGroupMasterDTO>(itemgroupmasterDTO, HttpStatus.CREATED);

    }

	/*
	 * (non-Javadoc)
	 * @see com.example.master.services.ItemGroupMasterService#updateItemGroupMaster(com.example.master.dto.ItemGroupMasterDTO)
	 * updating itemgroup_master table
	 */
    @Override
    public ResponseEntity<ItemGroupMasterDTO> updateItemGroupMaster(ItemGroupMasterDTO itemgroupmasterDTO) {
//    	ItemGroupMaster itemgroupmasterEntity = new ItemGroupMaster();
    	ItemGroupMaster itemgroupmasterEntity = itemgroupmasterDao.findItemGroupMasterById(itemgroupmasterDTO.getId());
    	if(itemgroupmasterDTO.getgrpDsc()!=null) {
    		itemgroupmasterEntity.setgrpDsc(itemgroupmasterDTO.getgrpDsc().toUpperCase());
    	}
    	itemgroupmasterEntity.setactiveFlag(itemgroupmasterDTO.getactiveFlag());
    	itemgroupmasterEntity.setpurchaseCode(itemgroupmasterDTO.getpurchaseCode());
    	itemgroupmasterEntity.setinactiveTag(itemgroupmasterDTO.getinactiveTag());
    	itemgroupmasterEntity.setmodBy(itemgroupmasterDTO.getmodBy());
    	itemgroupmasterEntity.setmodOn(Date.valueOf(LocalDate.now()));
    	itemgroupmasterEntity.setId(itemgroupmasterDTO.getId());

		System.out.println("ItemMaster Entity to send to dao is " + itemgroupmasterEntity);
		itemgroupmasterDao.updateItemGroupMaster(itemgroupmasterEntity);
	
		/*
		 * if isMapped field of the DTO is true and the respective entity is not present in the table then add to the mapping table,
		 * else if the DTO is true and the respective entity is also present in the table then update the entity, else if
		 * the DTO is false and the respective entity is present in the table then delete it, else do nothing
		 */
		List<ItemGroupDept> itemgroupmapList = itemgroupdeptDao.getMapByItemGroup(itemgroupmasterEntity.getId());
		long mapid;
		
		List<DepartmentMapDTO> deptList = itemgroupmasterDTO.getDepartment();
		List<ItemGroupDept> gropdeptList = new ArrayList<>();
		
		for(int j = 0 ; j < deptList.size() ; j++) {
			long deptid = deptList.get(j).getId();
			System.out.println(deptid);
//			ItemGroupDept groupdept = itemgroupdeptDao.getMapByItemGroupAndDeptId(itemgroupmasterEntity.getId(),deptid);
			ItemGroupDept groupdept = 
					itemgroupdeptDao.getMapByItemGroupAndDeptId(itemgroupmasterDTO.getId(),
							itemgroupmasterDTO.getDepartment().get(j).getId());
			System.out.println(groupdept);
			
			if(itemgroupmasterDTO.getDepartment().get(j).getIsMapped().equalsIgnoreCase("true") && groupdept == null) {
			ItemGroupDept groypdeptEntity = new ItemGroupDept();
			String isMapped = itemgroupmasterDTO.getDepartment().get(j).getIsMapped();
			groypdeptEntity.setDeptId(deptid);
			groypdeptEntity.setIsMapped(itemgroupmasterDTO.getDepartment().get(j).getIsMapped());
			groypdeptEntity.setItemGrp(itemgroupmasterEntity.getId());
			
			gropdeptList.add(itemgroupdeptDao.save(groypdeptEntity));
			}else if(itemgroupmasterDTO.getDepartment().get(j).getIsMapped().equalsIgnoreCase("true") && groupdept != null) {
				System.out.println("item group entity "+groupdept);
				groupdept.setDeptId(deptid);
				groupdept.setIsMapped(itemgroupmasterDTO.getDepartment().get(j).getIsMapped());
				groupdept.setItemGrp(itemgroupmasterEntity.getId());
				System.out.println("item group entity after add "+groupdept);
				gropdeptList.add(itemgroupdeptDao.save(groupdept));
			}else if(itemgroupmasterDTO.getDepartment().get(j).getIsMapped().equalsIgnoreCase("false") && groupdept != null) {
				itemgroupdeptDao.deleteMap(groupdept.getMapId());
			}
		}
	
		return new ResponseEntity<ItemGroupMasterDTO>(itemgroupmasterDTO, HttpStatus.CREATED);

    }
    

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ItemGroupMasterService#populateItemGroupMasterList()
     * fetching the datas from itemgroup_master table as well the item group dept mapping table
     */
    @Override
    public List<ItemGroupMasterDTO> populateItemGroupMasterList(){
	List<ItemGroupMasterDTO> itemgroupmasterDTOList=new ArrayList<ItemGroupMasterDTO>();
	try {
	    List<ItemGroupMaster> itemgroupmasterEntityList=itemgroupmasterDao.findAll()
	    												.stream()
	    												.sorted(Comparator.comparing(ItemGroupMaster::getgrpDsc))
	    												.collect(Collectors.toList());
	    
	    itemgroupmasterEntityList.forEach(itemgroupmasterEntity->{
	    	try {
				itemgroupmasterDTOList.add(prepareItemGroupMasterDTO(itemgroupmasterEntity));
			} catch (Exception e) {
				e.printStackTrace();
			}
	    });
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return itemgroupmasterDTOList;
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.ItemGroupMasterService#populateOneItemGroupMasterDetails(java.lang.String)
     * fetching a single entity from the itemgroup_master table as well as the mapping table
     */
    @Override
    public ItemGroupMasterDTO populateOneItemGroupMasterDetails(@PathVariable("userId") String userId) {
    	ItemGroupMaster itemgroupmasterEntity = itemgroupmasterDao.findItemGroupMasterById(userId);
    	ItemGroupMasterDTO itemgroup = new ItemGroupMasterDTO();
		try {
			itemgroup = prepareItemGroupMasterDTO(itemgroupmasterEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return itemgroup;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ItemGroupMasterService#destroyItemGroupMaster(java.lang.String)
     * deleting itemgroup_master entity by its id as well as respective mapping table datas
     */
    @Override
    public DeleteDTO destroyItemGroupMaster(@PathVariable("Id") String Id) {

    	List<ItemGroupDept> itemGroupDepts = itemgroupdeptDao.getMapByItemGroup(Id);
    	ItemGroupMaster itemgroup = itemgroupmasterDao.findItemGroupMasterById(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	if(itemgroup.getItemMaster().isEmpty()) {
    		itemgroupmasterDao.deleteItemGroupMaster(Id);
        	
    		for(int k = 0 ; k < itemGroupDepts.size(); k++) {
        		itemgroupdeptDao.deleteMap(itemGroupDepts.get(k).getMapId());
        	}
    		
        	deleteDTO.setstatus(1);
        	deleteDTO.setstatusCode(2000);
        	deleteDTO.setmsg("Deleted Successfully.");
    	}else {
    		deleteDTO.setstatus(1);
        	deleteDTO.setstatusCode(2000);
        	deleteDTO.setmsg("Can not Delete. Item Present Against Item Group");
    	}
		
    	return deleteDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.ItemGroupMasterService#populateItemGroupMasterFiletered()
     * fetching all itemgroup_master entities of jute type
     */
	@Override
	public List<ItemGroupMasterDTO> populateItemGroupMasterFiletered() {
		
		List<ItemGroupMaster> itemGroupFiltered = itemgroupmasterDao.findItemGroupFiltered();
		List<ItemGroupMasterDTO> itemgorupmasterDTOList = new ArrayList<>();
		
		itemGroupFiltered.forEach(itemgroup->{
			try {
				itemgorupmasterDTOList.add(prepareItemGroupMasterDTO(itemgroup));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		return itemgorupmasterDTOList;
	}
}
