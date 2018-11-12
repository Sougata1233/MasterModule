package com.example.master.services.serviceImpl;

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

import com.example.master.component.MachineMasterDao;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.MachineMasterDTO;
import com.example.master.entity.MachineMaster;
import com.example.master.services.MachineMasterService;

/*
 * Service Class For MachineMaster Entity
 */
@Service
public class MachineMasterServiceImpl implements MachineMasterService {

    @Autowired
    MachineMasterDao machinemasterDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(MachineMasterServiceImpl.class);

    /*
     * Preparing DTO For MachineMaster Entity 
     * 
     * @Param
     * 
     * MachineMaster
     * 
     */
    private MachineMasterDTO prepareMachineMasterDTO(MachineMaster machinemasterEntity) {
    	MachineMasterDTO machinemasterDTO = new MachineMasterDTO();
    	machinemasterDTO.setmachineDsc(machinemasterEntity.getmachineDsc());
   	    machinemasterDTO.setmillFact(machinemasterEntity.getmillFact());
   	    machinemasterDTO.setuser1(machinemasterEntity.getuser1());
   	    machinemasterDTO.setdate1(machinemasterEntity.getdate1());
   	    machinemasterDTO.setuser2(machinemasterEntity.getuser2());
   	    machinemasterDTO.setdate2(machinemasterEntity.getdate2());
   	    machinemasterDTO.setuser3(machinemasterEntity.getuser3());
   	    machinemasterDTO.setdate3(machinemasterEntity.getdate3());
   	    machinemasterDTO.setuser4(machinemasterEntity.getuser4());
   	    machinemasterDTO.setdate4(machinemasterEntity.getdate4());
   	    machinemasterDTO.setactiveFlag(machinemasterEntity.getactiveFlag());
   	    machinemasterDTO.setdept(machinemasterEntity.getdept());
   	    machinemasterDTO.setId(machinemasterEntity.getId());
	
	    return machinemasterDTO;
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.MachineMasterService#persistMachineMaster(com.example.master.dto.MachineMasterDTO)
     * 
     * Save Service For MachineMaster Entity
     * 
     * @Param
     * 
     * MachineMasterDTO
     * 
     */
    @Override
    public ResponseEntity<MachineMasterDTO> persistMachineMaster(MachineMasterDTO machinemasterDTO) {
    	MachineMaster machinemasterEntity = new MachineMaster();

    	machinemasterEntity.setmachineDsc(machinemasterDTO.getmachineDsc());
   	    machinemasterEntity.setmillFact(machinemasterDTO.getmillFact());
   	    machinemasterEntity.setuser1(machinemasterDTO.getuser1());
   	    machinemasterEntity.setdate1(machinemasterDTO.getdate1());
   	    machinemasterEntity.setuser2(machinemasterDTO.getuser2());
   	    machinemasterEntity.setdate2(machinemasterDTO.getdate2());
   	    machinemasterEntity.setuser3(machinemasterDTO.getuser3());
   	    machinemasterEntity.setdate3(machinemasterDTO.getdate3());
   	    machinemasterEntity.setuser4(machinemasterDTO.getuser4());
   	    machinemasterEntity.setdate4(machinemasterDTO.getdate4());
   	    machinemasterEntity.setactiveFlag(machinemasterDTO.getactiveFlag());
   	    machinemasterEntity.setdept(machinemasterDTO.getdept());
   	    machinemasterEntity.setId(machinemasterDTO.getId());
	
   	    machinemasterDao.addMachineMaster(machinemasterEntity);
	
   	    return new ResponseEntity<MachineMasterDTO>(machinemasterDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.MachineMasterService#updateMachineMaster(com.example.master.dto.MachineMasterDTO)
     * 
     * Update Service For MachineMaster
     * 
     * @Param
     * 
     * MachineMasterDTO
     * 
     */
    @Override
    public ResponseEntity<MachineMasterDTO> updateMachineMaster(MachineMasterDTO machinemasterDTO) {
    	MachineMaster machinemasterEntity = new MachineMaster();

    	machinemasterEntity.setmachineDsc(machinemasterDTO.getmachineDsc());
   	    machinemasterEntity.setmillFact(machinemasterDTO.getmillFact());
   	    machinemasterEntity.setuser1(machinemasterDTO.getuser1());
   	    machinemasterEntity.setdate1(machinemasterDTO.getdate1());
   	    machinemasterEntity.setuser2(machinemasterDTO.getuser2());
   	    machinemasterEntity.setdate2(machinemasterDTO.getdate2());
   	    machinemasterEntity.setuser3(machinemasterDTO.getuser3());
   	    machinemasterEntity.setdate3(machinemasterDTO.getdate3());
   	    machinemasterEntity.setuser4(machinemasterDTO.getuser4());
   	    machinemasterEntity.setdate4(machinemasterDTO.getdate4());
   	    machinemasterEntity.setactiveFlag(machinemasterDTO.getactiveFlag());
   	    machinemasterEntity.setdept(machinemasterDTO.getdept());
   	    machinemasterEntity.setId(machinemasterDTO.getId());
	
   	    machinemasterDao.updateMachineMaster(machinemasterEntity);
	
   	    return new ResponseEntity<MachineMasterDTO>(machinemasterDTO, HttpStatus.CREATED);
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.MachineMasterService#populateMachineMasterList()
     * 
     * Fetching All MachineMaster Entity Service
     * 
     */
    @Override
    public List<MachineMasterDTO> populateMachineMasterList() {
		List<MachineMasterDTO> machinemasterDTOList=new ArrayList<MachineMasterDTO>();
		try {
		    List<MachineMaster> machinemasterEntityList=machinemasterDao.findAll()
		    															.stream()
		    															.sorted(Comparator.comparing(
		    																	MachineMaster::getmachineDsc))
		    															.collect(Collectors.toList());
		    
		    machinemasterEntityList.forEach(machinemasterEntity->{
		    	machinemasterDTOList.add(prepareMachineMasterDTO(machinemasterEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return machinemasterDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.MachineMasterService#populateOneMachineMasterDetails(java.lang.String)
     * 
     * Fetching MachineMaster By nachineId
     * 
     * @Param
     * 
     * String machineId
     * 
     */
    @Override
    public MachineMasterDTO populateOneMachineMasterDetails(String machineId) {
    	MachineMaster machinemasterEntity = machinemasterDao.findMachineMasterById(machineId);
	
    	return prepareMachineMasterDTO(machinemasterEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.MachineMasterService#destroyMachineMaster(java.lang.String)
     * 
     * Delete Service For MachineMaster
     * 
     * @Param
     * 
     * String Id
     * 
     */
    @Override
    public DeleteDTO destroyMachineMaster(String Id) {

    	machinemasterDao.deleteMachineMaster(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }
}
