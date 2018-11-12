package com.example.master.services.serviceImpl;

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

import com.example.master.component.LocationMasterDao;
import com.example.master.component.OrganizationDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.DepartmentDTO;
import com.example.master.dto.OrganizationDTO;
import com.example.master.entity.Department;
import com.example.master.entity.LocationMaster;
import com.example.master.entity.Organization;
import com.example.master.services.OrganizationService;

/*
 * Service Class For Organization Entity
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationDao organizationDao;
    
    @Autowired
    LocationMasterDao locationDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(OrganizationServiceImpl.class);

    /*
     * Preparing DTO For Organization Entity
     */
    private OrganizationDTO prepareOrganizationDTO(Organization organizationEntity) {
    	OrganizationDTO organizationDTO = new OrganizationDTO();
    	organizationDTO.setorgName(organizationEntity.getorgName().toUpperCase());
    	organizationDTO.setHierarchyId(organizationEntity.getHierarchyId());
    	organizationDTO.setmodby(organizationEntity.getmodby());
    	organizationDTO.setmodifiedOn(organizationEntity.getmodifiedOn());
    	organizationDTO.setshortCode(organizationEntity.getshortCode());
    	organizationDTO.setorgTyp(organizationEntity.getorgTyp());
    	organizationDTO.setId(organizationEntity.getId());
    	
    	LocationMaster location = locationDao.findLocationMasterById(organizationEntity.getLocationId());

    	organizationDTO.setLocation(location.getlocationArea());
    	organizationDTO.setLocationId(organizationEntity.getLocationId());
    	
        List<DepartmentDTO> departmentDtoList=new ArrayList<DepartmentDTO>();
    	
        for (Department dpt: organizationEntity.getDepartment()) {
        	DepartmentDTO dptDto = new DepartmentDTO();
        	dptDto.setorgId(dpt.getorgId());
        	dptDto.setdepartmentName(dpt.getdepartmentName());
        	dptDto.setmodby(dpt.getmodby());
        	dptDto.setmodifiedOn(dpt.getmodifiedOn());
        	dptDto.setId(dpt.getId());
        	departmentDtoList.add(dptDto);
        	
        	/*List<EmployeeDTO> employeeDtoList=new ArrayList<EmployeeDTO>();
        	
            for (Employee emp: dpt.getEmployee()) {
            	EmployeeDTO empDto = new EmployeeDTO();
            	empDto.setId(emp.getId());
            	empDto.setdeptId(emp.getdeptId());
            	empDto.setempName(emp.getempName());
            	employeeDtoList.add(empDto);
            }
            
            dptDto.setEmployee(employeeDtoList);*/
        	
        	
        }
        organizationDTO.setDepartment(departmentDtoList);
	
        return organizationDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.OrganizationService#persistUser(com.example.master.dto.OrganizationDTO)
     * 
     * Save Service For Organization Entity
     * 
     * @Param
     * 
     * OrganizationDTO
     * 
     */
    @Override
    public ResponseEntity<OrganizationDTO> persistUser(OrganizationDTO organizationDTO) {

	
    	Organization organizationEntity = new Organization();
    	organizationEntity.setorgName(organizationDTO.getorgName());
    	organizationEntity.setHierarchyId(organizationDTO.getHierarchyId());
    	organizationEntity.setmodby(organizationDTO.getmodby());
    	organizationEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
    	organizationEntity.setshortCode(organizationDTO.getshortCode());
    	organizationEntity.setorgTyp(organizationDTO.getorgTyp());
    	organizationEntity.setLocationId(organizationDTO.getLocationId());

    	organizationDao.addOrganization(organizationEntity);
	
    	return new ResponseEntity<OrganizationDTO>(organizationDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.OrganizationService#updateOrganization(com.example.master.dto.OrganizationDTO)
     * 
     * Update Service For Organization Entity
     * 
     * @Param
     * 
     * OrganizationDTO
     * 
     */
    @Override
    public ResponseEntity<OrganizationDTO> updateOrganization(OrganizationDTO organizationDTO) {
    	Organization organizationEntity = new Organization();
    	
    	organizationEntity.setorgName(organizationDTO.getorgName());
    	organizationEntity.setHierarchyId(organizationDTO.getHierarchyId());
    	organizationEntity.setmodby(organizationDTO.getmodby());
    	organizationEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
    	organizationEntity.setshortCode(organizationDTO.getshortCode());
    	organizationEntity.setorgTyp(organizationDTO.getorgTyp());
    	organizationEntity.setLocationId(organizationDTO.getLocationId());
    	organizationEntity.setId(organizationDTO.getId());


    	organizationDao.updateOrganization(organizationEntity);
	
    	return new ResponseEntity<OrganizationDTO>(organizationDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.OrganizationService#populateOrganizationList()
     * 
     * Fetching All Organization Entity
     * 
     */
    @Override
    public List<OrganizationDTO> populateOrganizationList() {
		List<OrganizationDTO> organizationDTOList=new ArrayList<OrganizationDTO>();
		try {
		    List<Organization> organizationEntityList=organizationDao.findAll();
		    
		    organizationEntityList.forEach(organizationEntity->{
		    	organizationDTOList.add(prepareOrganizationDTO(organizationEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return organizationDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.OrganizationService#populateOneOrganizationDetails(java.lang.Long)
     */
    @Override
    public OrganizationDTO populateOneOrganizationDetails(Long Id) {
    	Organization organizationEntity = organizationDao.findOrganizationById(Id);
	
    	return prepareOrganizationDTO(organizationEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.OrganizationService#destroyOrganization(java.lang.Long)
     * 
     * Delete Service For Organization Entity
     * 
     * @Param
     * 
     * Long ID
     * 
     */
    @Override
    public DeleteDTO destroyOrganization(Long Id) {

    	Organization org = organizationDao.findOrganizationById(Id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	
    	if(org.getDepartment().isEmpty()) {
    		organizationDao.deleteOrganization(Id);
        	
        	deleteDTO.setstatus(1);
        	deleteDTO.setstatusCode(2000);
        	deleteDTO.setmsg("Deleted successfully.");
    	}else {
    		deleteDTO.setstatus(1);
        	deleteDTO.setstatusCode(2000);
        	deleteDTO.setmsg("Can not Delete. Department Present Against Organization");
    	}
    	
    	return deleteDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.OrganizationService#getAllHeadOrganization()
     * 
     * Fetching All Organization
     * 
     */
	@Override
	public List<OrganizationDTO> getAllHeadOrganization() {
		
		List<Organization> organization = organizationDao.getAllHeadOrganizations()
															.stream()
															.sorted(Comparator.comparing(Organization::getorgName))
															.collect(Collectors.toList());
		List<OrganizationDTO> organizationDTO = new ArrayList<>();
		
		organization.forEach(org->{
			organizationDTO.add(prepareOrganizationDTO(org));
		});
		
		return organizationDTO;
	}
}
