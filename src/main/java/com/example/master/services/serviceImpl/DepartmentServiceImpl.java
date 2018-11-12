package com.example.master.services.serviceImpl;

import static com.example.master.constant.MasterManagementConstant.USER_HOST_SERVER;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.master.component.DepartmentDao;
import com.example.master.component.ItemGroupDeptDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.DepartmentDTO;
import com.example.master.dto.OrganizationDTO;
import com.example.master.entity.Department;
import com.example.master.entity.ItemGroupDept;
import com.example.master.services.DepartmentService;

/*
 * Service Class For Department Entity
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    ItemGroupDeptDao itemgroupdeptDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(DepartmentServiceImpl.class);

    /*
     * Preparing DTO for Department Entity
     */
    private DepartmentDTO prepareDepartmentDTO(Department departmentEntity) {
    	DepartmentDTO departmentDTO = new DepartmentDTO();
    
    	departmentDTO.setorgId(departmentEntity.getorgId());
    	departmentDTO.setdepartmentName(departmentEntity.getdepartmentName().toUpperCase());
		departmentDTO.setmodby(departmentEntity.getmodby());
    	departmentDTO.setmodifiedOn(departmentEntity.getmodifiedOn());
		departmentDTO.setId(departmentEntity.getId());
		
		/*
		 *Fetching Organization 
		 */
		try {
    		OrganizationDTO organizationDTO = new OrganizationDTO();
    		
    		organizationDTO.setorgName(departmentEntity.getOrganization().getorgName());
    		organizationDTO.setHierarchyId(departmentEntity.getOrganization().getHierarchyId());
    		organizationDTO.setmodby(departmentEntity.getOrganization().getmodby());
    		organizationDTO.setmodifiedOn(departmentEntity.getOrganization().getmodifiedOn());
    		organizationDTO.setshortCode(departmentEntity.getOrganization().getshortCode());
    		organizationDTO.setorgTyp(departmentEntity.getOrganization().getorgTyp());
    		organizationDTO.setId(departmentEntity.getOrganization().getId());

    		departmentDTO.setOrganization(organizationDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
    	
    	    return departmentDTO;
    }
  
    /*
     * (non-Javadoc)
     * @see com.example.master.services.DepartmentService#persistDepartment(com.example.master.dto.DepartmentDTO)
     * 
     * Saving Service For Department Entity
     * 
     * @Param
     * 
     * DepartmentDTO
     * 
     */
    @Override
    public ResponseEntity<DepartmentDTO> persistDepartment(DepartmentDTO departmentDTO) {
    	
    	Department departmentEntity = new Department();
		
    	departmentEntity.setorgId(departmentDTO.getorgId());
		departmentEntity.setdepartmentName(departmentDTO.getdepartmentName().toUpperCase());
		departmentEntity.setmodby(departmentDTO.getmodby());
		departmentEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
	
//		List<Department> department = departmentDao.findByDepartmentName(departmentDTO.getdepartmentName());
		
		/*if(department == null) {
			System.out.println("inside if condition "+ department.contains(department));
			departmentDao.addDepartment(departmentEntity);
			return new ResponseEntity<DepartmentDTO>(departmentDTO, HttpStatus.CREATED);
		}else {
			System.out.println("inside else condition "+ department.contains(department));
			return new ResponseEntity<DepartmentDTO>(departmentDTO, HttpStatus.CONFLICT);
		}*/
		departmentDao.addDepartment(departmentEntity);
		
		return new ResponseEntity<DepartmentDTO>(departmentDTO, HttpStatus.CREATED);
	}

    /*
     * (non-Javadoc)
     * @see com.example.master.services.DepartmentService#updateDepartment(com.example.master.dto.DepartmentDTO)
     * 
     * Update Service For Department Entity
     * 
     * @Param
     * 
     * DepartmentDTO
     * 
     */
    @Override
    public ResponseEntity<DepartmentDTO> updateDepartment(DepartmentDTO departmentDTO) {
    	Department departmentEntity = new Department();
		
    	departmentEntity.setorgId(departmentDTO.getorgId());
		departmentEntity.setdepartmentName(departmentDTO.getdepartmentName().toUpperCase());
		departmentEntity.setmodby(departmentDTO.getmodby());
		departmentEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
		departmentEntity.setId(departmentDTO.getId());
	
		departmentDao.updateDepartment(departmentEntity);
		return new ResponseEntity<DepartmentDTO>(departmentDTO, HttpStatus.CREATED);
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.DepartmentService#populateDepartmentList()
     * 
     * Fetching All Service For Department Entity
     * 
     */
    @Override
    public List<DepartmentDTO> populateDepartmentList() {
		List<DepartmentDTO> departmentDTOList=new ArrayList<DepartmentDTO>();
		try {
		    List<Department> departmentEntityList=departmentDao.findAll()
		    										.stream()
		    										.sorted(Comparator.comparing(Department::getdepartmentName))
		    										.collect(Collectors.toList());
		    
		    departmentEntityList.forEach(departmentEntity->{
		    	departmentDTOList.add(prepareDepartmentDTO(departmentEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return departmentDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.DepartmentService#populateOneDepartmentDetails(java.lang.Long)
     * 
     * Fetching Deprtment By id Serviec
     * 
     */
    @Override
    public DepartmentDTO populateOneDepartmentDetails(Long departmentId) {
    	Department departmentEntity = departmentDao.findDepartmentById(departmentId);
	
    	return prepareDepartmentDTO(departmentEntity);
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.DepartmentService#destroyDepartment(java.lang.Long)
     * 
     * Delete Service For Department Entity
     * 
     */
    @Override
    public DeleteDTO destroyDepartment(Long Id) {

    	List<ItemGroupDept> itemgroupdept = itemgroupdeptDao.getMapByDeptId(Id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	
    	if(itemgroupdept.isEmpty()) {
    		departmentDao.deleteDepartment(Id);
        	
        	deleteDTO.setstatus(1);
        	deleteDTO.setstatusCode(2000);
        	deleteDTO.setmsg("Deleted successfully.");
    	}else {
    		deleteDTO.setstatus(1);
        	deleteDTO.setstatusCode(2000);
        	deleteDTO.setmsg("Can not Delete. Item Group Present Against Department.");
    	}
    	
    	return deleteDTO;
    	
    }
}
