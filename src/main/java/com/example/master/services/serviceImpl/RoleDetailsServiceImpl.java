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

import com.example.master.component.RoleDetailsDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.RoleDetailsDTO;
import com.example.master.entity.RoleDetails;
import com.example.master.services.RoleDetailsService;

/*
 * Service For RoleDetails Entity
 */
@Service
public class RoleDetailsServiceImpl implements RoleDetailsService {

    @Autowired
    RoleDetailsDao roledetailsDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(RoleDetailsServiceImpl.class);

   /*
    * Preparing DTO For RoleDetails Entity
    */
    private RoleDetailsDTO prepareRoleDetailsDTO(RoleDetails roledetailsEntity) {
    	RoleDetailsDTO roledetailsDTO = new RoleDetailsDTO();
    	
    	roledetailsDTO.setrole(roledetailsEntity.getrole());
    	roledetailsDTO.setisEnable(roledetailsEntity.getisEnable());
    	roledetailsDTO.setfromDate(roledetailsEntity.getfromDate());
    	roledetailsDTO.settoDate(roledetailsEntity.gettoDate());
    	roledetailsDTO.setmodby(roledetailsEntity.getmodby());
    	roledetailsDTO.setmodifiedOn(roledetailsEntity.getmodifiedOn());
		roledetailsDTO.setId(roledetailsEntity.getId());

	    return roledetailsDTO;
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.RoleDetailsService#persistRoleDetails(com.example.master.dto.RoleDetailsDTO)
     * 
     * Save Service For RoleDetails Entity
     * 
     * @Param 
     * 
     * RoleDetailsDTO
     * 
     */
    @Override
    public ResponseEntity<RoleDetailsDTO> persistRoleDetails(RoleDetailsDTO roledetailsDTO) {
    	RoleDetails roledetailsEntity = new RoleDetails();
    	
    	roledetailsEntity.setrole(roledetailsDTO.getrole());
    	roledetailsEntity.setisEnable(roledetailsDTO.getisEnable());
    	roledetailsEntity.setfromDate(roledetailsDTO.getfromDate());
    	roledetailsEntity.settoDate(roledetailsDTO.gettoDate());
    	roledetailsEntity.setmodby(roledetailsDTO.getmodby());
    	roledetailsEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));

    	roledetailsDao.addRoleDetails(roledetailsEntity);
	
    	return new ResponseEntity<RoleDetailsDTO>(roledetailsDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.RoleDetailsService#updateRoleDetails(com.example.master.dto.RoleDetailsDTO)
     * 
     * Update Service For RoleDetails Entity
     * 
     * @Param
     * 
     * RoledetailsDTO
     * 
     */
    @Override
    public ResponseEntity<RoleDetailsDTO> updateRoleDetails(RoleDetailsDTO roledetailsDTO) {
    	RoleDetails roledetailsEntity = new RoleDetails();

    	roledetailsEntity.setrole(roledetailsDTO.getrole());
    	roledetailsEntity.setisEnable(roledetailsDTO.getisEnable());
    	roledetailsEntity.setfromDate(roledetailsDTO.getfromDate());
    	roledetailsEntity.settoDate(roledetailsDTO.gettoDate());
    	roledetailsEntity.setmodby(roledetailsDTO.getmodby());
    	roledetailsEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
		roledetailsEntity.setId(roledetailsDTO.getId());
    	
		roledetailsDao.updateRoleDetails(roledetailsEntity);
	
		return new ResponseEntity<RoleDetailsDTO>(roledetailsDTO, HttpStatus.CREATED);
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.RoleDetailsService#populateRoleDetailsList()
     * 
     * Fetching All RoleDetails Entity
     * 
     */
    @Override
    public List<RoleDetailsDTO> populateRoleDetailsList() {
		List<RoleDetailsDTO> roledetailsDTOList=new ArrayList<RoleDetailsDTO>();
		try {
		    List<RoleDetails> roledetailsEntityList=roledetailsDao.findAll()
		    														.stream()
		    														.sorted(Comparator.comparing(RoleDetails::getrole))
		    														.collect(Collectors.toList());
		    
		    roledetailsEntityList.forEach(approvermasterEntity->{
		    	roledetailsDTOList.add(prepareRoleDetailsDTO(approvermasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return roledetailsDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.RoleDetailsService#populateOneRoleDetailsDetails(java.lang.Long)
     * 
     * Fetching RoleDetails By RoleId
     * 
     * @Param
     * 
     * Long Id
     * 
     */
    @Override
    public RoleDetailsDTO populateOneRoleDetailsDetails(Long Id) {
    	RoleDetails roledetailsEntity = roledetailsDao.findRoleDetailsById(Id);
	
    	return prepareRoleDetailsDTO(roledetailsEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.RoleDetailsService#destroyRoleDetails(java.lang.Long)
     * 
     * Delete Service For RoleDetails
     * 
     * @Param
     * 
     * Long id
     * 
     */
    @Override
    public DeleteDTO destroyRoleDetails(Long Id) {

    	roledetailsDao.deleteRoleDetails(Id);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
