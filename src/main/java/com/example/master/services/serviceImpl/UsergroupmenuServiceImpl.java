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

import com.example.master.component.UsergroupmenuDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.UsergroupmenuDTO;
import com.example.master.entity.Usergroupmenu;
import com.example.master.services.UsergroupmenuService;

/*
 * Service Class For Usergroupmenu Entity
 */
@Service
public class UsergroupmenuServiceImpl implements UsergroupmenuService {

    @Autowired
    UsergroupmenuDao usergroupmenuDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(UsergroupmenuServiceImpl.class);

   /*
    * Preparing DTO For Usergroupmenu Entity
    */
    private UsergroupmenuDTO prepareUsergroupmenuDTO(Usergroupmenu usergroupmenuEntity) {
    	UsergroupmenuDTO usergroupmenuDTO = new UsergroupmenuDTO();
    	
    	usergroupmenuDTO.setUsergrpid(usergroupmenuEntity.getUsergrpid());
    	usergroupmenuDTO.setmenuId(usergroupmenuEntity.getmenuId());
		usergroupmenuDTO.setfromDate(usergroupmenuEntity.getfromDate());
    	usergroupmenuDTO.setendDate(usergroupmenuEntity.getendDate());
    	usergroupmenuDTO.setmodby(usergroupmenuEntity.getmodby());
    	usergroupmenuDTO.setmodifiedOn(usergroupmenuEntity.getmodifiedOn());
    	usergroupmenuDTO.setIsenable(usergroupmenuEntity.getIsenable());
    	usergroupmenuDTO.setId(usergroupmenuEntity.getId());
	
    	return usergroupmenuDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UsergroupmenuService#persistUsergroupmenu(com.example.master.dto.UsergroupmenuDTO)
     * 
     * Save Service For Usergroupmenu Entity
     * 
     * @Param
     * 
     * UsergroupmenuDTO
     * 
     */
    @Override
    public ResponseEntity<UsergroupmenuDTO> persistUsergroupmenu(UsergroupmenuDTO usergroupmenuDTO) {

		Usergroupmenu usergroupmenuEntity = new Usergroupmenu();
		
		usergroupmenuEntity.setUsergrpid(usergroupmenuDTO.getUsergrpid());
		usergroupmenuEntity.setmenuId(usergroupmenuDTO.getmenuId());
		usergroupmenuEntity.setfromDate(usergroupmenuDTO.getfromDate());
		usergroupmenuEntity.setendDate(usergroupmenuDTO.getendDate());
		usergroupmenuEntity.setmodby(usergroupmenuDTO.getmodby());
		usergroupmenuEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
		usergroupmenuEntity.setIsenable(usergroupmenuDTO.getIsenable());
		
		usergroupmenuDao.addUsergroupmenu(usergroupmenuEntity);
		
		return new ResponseEntity<UsergroupmenuDTO>(usergroupmenuDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UsergroupmenuService#updateUsergroupmenu(com.example.master.dto.UsergroupmenuDTO)
     * 
     * Update Service For Usergroupmenu Entity
     * 
     * @Param
     * 
     * UsergroupmenuDTO
     * 
     */
    @Override
    public ResponseEntity<UsergroupmenuDTO> updateUsergroupmenu(UsergroupmenuDTO usergroupmenuDTO) {
		Usergroupmenu usergroupmenuEntity = new Usergroupmenu();
	
		usergroupmenuEntity.setUsergrpid(usergroupmenuDTO.getUsergrpid());
		usergroupmenuEntity.setmenuId(usergroupmenuDTO.getmenuId());
		usergroupmenuEntity.setfromDate(usergroupmenuDTO.getfromDate());
		usergroupmenuEntity.setendDate(usergroupmenuDTO.getendDate());
		usergroupmenuEntity.setmodby(usergroupmenuDTO.getmodby());
		usergroupmenuEntity.setmodifiedOn(Date.valueOf(LocalDate.now()));
		usergroupmenuEntity.setIsenable(usergroupmenuDTO.getIsenable());
		usergroupmenuEntity.setId(usergroupmenuDTO.getId());
	
		usergroupmenuDao.updateUsergroupmenu(usergroupmenuEntity);
		
		return new ResponseEntity<UsergroupmenuDTO>(usergroupmenuDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UsergroupmenuService#populateUsergroupmenuList()
     * 
     * Fetching All Usergroupmenu
     * 
     */
    @Override
    public List<UsergroupmenuDTO> populateUsergroupmenuList() {
		List<UsergroupmenuDTO> usergroupmenuDTOList=new ArrayList<UsergroupmenuDTO>();
		try {
		    List<Usergroupmenu> usergroupmenuEntityList=usergroupmenuDao.findAll()
		    															.stream()
		    															.sorted(Comparator
		    																	.comparing(Usergroupmenu::getUsergrpid))
		    															.collect(Collectors.toList());
		    
		    usergroupmenuEntityList.forEach(usergroupmenuEntity->{
		    	usergroupmenuDTOList.add(prepareUsergroupmenuDTO(usergroupmenuEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return usergroupmenuDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UsergroupmenuService#populateOneUsergroupmenuDetails(java.lang.Long)
     * 
     * Fetching Usergroupmenu by id
     * 
     * @Param
     * 
     * Long id
     * 
     */
    @Override
    public UsergroupmenuDTO populateOneUsergroupmenuDetails(Long id) {
    	Usergroupmenu usergroupmenuEntity = usergroupmenuDao.findUsergroupmenuById(id);
	
    	return prepareUsergroupmenuDTO(usergroupmenuEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.UsergroupmenuService#destroyUsergroupmenu(java.lang.Long)
     */
    @Override
    public DeleteDTO destroyUsergroupmenu(Long userId) {

    	usergroupmenuDao.deleteUsergroupmenu(userId);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
