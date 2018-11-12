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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.master.component.UsergroupDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.UsergroupDTO;
import com.example.master.entity.Usergroup;
import com.example.master.services.UsergroupService;

/*
 * Service Class For Usergroup Entity
 */
@Service
public class UsergroupServiceImpl implements UsergroupService {

    @Autowired
    UsergroupDao usergroupDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(UsergroupServiceImpl.class);

    /*
     * Preparing DTO For Usergroup Entity
     */
    private UsergroupDTO prepareUsergroupDTO(Usergroup usergroupEntity) {
    	UsergroupDTO usergroupDTO = new UsergroupDTO();
    
    	usergroupDTO.setUsrgrpName(usergroupEntity.getUsrgrpName());
    	usergroupDTO.setIsenable(usergroupEntity.getIsenable());
		usergroupDTO.setfromDate(usergroupEntity.getfromDate());
    	usergroupDTO.settoDate(usergroupEntity.gettoDate());
    	usergroupDTO.setmodby(usergroupEntity.getmodby());
    	usergroupDTO.setmodifiedOn(usergroupEntity.getmodifiedOn());
		usergroupDTO.setId(usergroupEntity.getId());
	
	    return usergroupDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UsergroupService#persistUsergroup(com.example.master.dto.UsergroupDTO)
     * 
     * Save Service For Usergroup Entity
     * 
     * @Param
     * 
     * UsergroupDTO
     * 
     */
    @Override
    public ResponseEntity<UsergroupDTO> persistUsergroup(UsergroupDTO usergroupDTO) {
    	Usergroup usergroupEntity = new Usergroup();
		
		usergroupEntity.setUsrgrpName(usergroupDTO.getUsrgrpName());
		usergroupEntity.setIsenable(usergroupDTO.getIsenable());
		usergroupEntity.setfromDate(usergroupDTO.getfromDate());
		usergroupEntity.settoDate(usergroupDTO.gettoDate());
		usergroupEntity.setmodby(usergroupDTO.getmodby());
		usergroupEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
		
		usergroupDao.addUsergroup(usergroupEntity);
		
		return new ResponseEntity<UsergroupDTO>(usergroupDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UsergroupService#updateUsergroup(com.example.master.dto.UsergroupDTO)
     * 
     * Update Service For Usergroup Entity
     * 
     * @Param
     * 
     * UsergroupDTO
     * 
     */
    @Override
    public ResponseEntity<UsergroupDTO> updateUsergroup(UsergroupDTO usergroupDTO) {
		Usergroup usergroupEntity = new Usergroup();

		usergroupEntity.setUsrgrpName(usergroupDTO.getUsrgrpName());
		usergroupEntity.setIsenable(usergroupDTO.getIsenable());
		usergroupEntity.setfromDate(usergroupDTO.getfromDate());
		usergroupEntity.settoDate(usergroupDTO.gettoDate());
		usergroupEntity.setmodby(usergroupDTO.getmodby());
		usergroupEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
		usergroupEntity.setId(usergroupDTO.getId());
	
		usergroupDao.updateUsergroup(usergroupEntity);
		
		return new ResponseEntity<UsergroupDTO>(usergroupDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UsergroupService#populateUsergroupList()
     * 
     * Fetching All Usergroup Entity
     * 
     */
    @Override
    public List<UsergroupDTO> populateUsergroupList() {
		List<UsergroupDTO> usergroupDTOList=new ArrayList<UsergroupDTO>();
		try {
		    List<Usergroup> usergroupEntityList=usergroupDao.findAll()
		    												.stream()
		    												.sorted(Comparator.comparing(Usergroup::getUsrgrpName))
		    												.collect(Collectors.toList());
		    
		    usergroupEntityList.forEach(usergroupEntity->{
		    	usergroupDTOList.add(prepareUsergroupDTO(usergroupEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return usergroupDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UsergroupService#populateOneUsergroupDetails(java.lang.Long)
     * 
     * Fetching Usergroup By Id
     * 
     * @Param
     * 
     * Long id
     * 
     */
    @Override
    public UsergroupDTO populateOneUsergroupDetails(Long id) {
    	Usergroup usergroupEntity = usergroupDao.findUsergroupById(id);
	
    	return prepareUsergroupDTO(usergroupEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UsergroupService#destroyUsergroup(java.lang.Long)
     * 
     * Delete Service For Usergroup Entity
     * 
     * @Param
     * 
     * Long id
     * 
     */
    @Override
    public DeleteDTO destroyUsergroup(Long id) {

    	usergroupDao.deleteUsergroup(id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
