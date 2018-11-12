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

import com.example.master.component.StateDao;
import com.example.master.dto.CountryDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.StateDTO;
import com.example.master.entity.State;
import com.example.master.services.StateService;

/*
 * Service Class For State
 */
@Service
public class StateServiceImpl implements StateService {

    @Autowired
    StateDao stateDao;
    private static final Logger LOGGER=LoggerFactory.getLogger(StateServiceImpl.class);
   
    /*
     * Prepare DTO For State Entity
     */
    private StateDTO prepareStateDTO(State stateEntity) {
    	StateDTO stateDTO = new StateDTO();
    	stateDTO.setcountryId(stateEntity.getcountryId());
    	stateDTO.setstateName(stateEntity.getstateName());
    	try {
    		CountryDTO countryDTO = new CountryDTO();

    		countryDTO.setcountryName(stateEntity.getCountry().getcountryName());
    		countryDTO.setId(stateEntity.getCountry().getId());
    		stateDTO.setCountry(countryDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
    	stateDTO.setId(stateEntity.getId());

    	return stateDTO;
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.StateService#persistState(com.example.master.dto.StateDTO)
     * 
     * Save Service For State
     * 
     */
    @Override
    public ResponseEntity<StateDTO> persistState(StateDTO stateDTO) {
    	State stateEntity = new State();
    	stateEntity.setcountryId(stateDTO.getcountryId());
    	stateEntity.setstateName(stateDTO.getstateName());

    	stateDao.addState(stateEntity);

    	return new ResponseEntity<StateDTO>(stateDTO, HttpStatus.CREATED);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.StateService#updateState(com.example.master.dto.StateDTO)
     * 
     * Update Service For State
     * 
     * @Param
     * 
     * StateDTO
     * 
     */
    @Override
    public ResponseEntity<StateDTO> updateState(StateDTO stateDTO) {
    	State stateEntity = new State();

    	stateEntity.setcountryId(stateDTO.getcountryId());
    	stateEntity.setstateName(stateDTO.getstateName());
		stateEntity.setId(stateDTO.getId());
	
		stateDao.updateState(stateEntity);
	
		return new ResponseEntity<StateDTO>(stateDTO, HttpStatus.CREATED);
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.StateService#populateStateList()
     * 
     * Fetching All State
     * 
     */
    @Override
    public List<StateDTO> populateStateList() {
		List<StateDTO> stateDTOList=new ArrayList<StateDTO>();
		try {
		    List<State> stateEntityList=stateDao.findAll()
		    									.stream()
		    									.sorted(Comparator.comparing(State::getstateName))
		    									.collect(Collectors.toList());
		    
		    stateEntityList.forEach(stateEntity->{
		    	stateDTOList.add(prepareStateDTO(stateEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return stateDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.StateService#populateOneStateDetails(long)
     * 
     * Fetching State By stateId
     * 
     * @Param
     * 
     * Long Id
     * 
     */
    @Override
    public StateDTO populateOneStateDetails(long Id) {
    	State stateEntity = stateDao.findStateById(Id);
	
    	return prepareStateDTO(stateEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.StateService#destroyState(long)
     * 
     * Delete Service For State
     * 
     * @Param
     * 
     * Long ID
     * 
     */
    @Override
    public DeleteDTO destroyState(long stateId) {

    	State state = stateDao.findStateById(stateId);
    	DeleteDTO deleteDTO = new DeleteDTO();
    	
    	if(state.getCity().isEmpty()) {
    		stateDao.deleteState(stateId);
    		
    		deleteDTO.setstatus(1);
        	deleteDTO.setstatusCode(2000);
        	deleteDTO.setmsg("Deleted successfully.");
    	}else {
    		deleteDTO.setstatus(1);
        	deleteDTO.setstatusCode(208);
        	deleteDTO.setmsg("Can not Delete. City Present Against State");
    	}
    
    	return deleteDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.StateService#getAllStateByCountry(long)
     * 
     * Fetching State By Country
     * 
     * @Param
     * 
     * Long countryId
     * 
     */
	@Override
	public List<StateDTO> getAllStateByCountry(long countryId) {
		List<StateDTO> stateDTOs = new ArrayList<>();
		
		try {
			List<State> states = stateDao.getStateByCountry(countryId)
											.stream()
											.sorted(Comparator.comparing(State::getstateName))
											.collect(Collectors.toList());
			states.forEach(state->{
				stateDTOs.add(prepareStateDTO(state));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return stateDTOs;
	}
}
