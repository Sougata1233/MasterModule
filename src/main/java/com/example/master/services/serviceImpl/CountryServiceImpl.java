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

import com.example.master.component.CountryDao;
import com.example.master.dto.CityDTO;
import com.example.master.dto.CountryDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.StateDTO;
import com.example.master.entity.City;
import com.example.master.entity.Country;
import com.example.master.entity.State;
import com.example.master.services.CountryService;

/*
 * Service Class for Cousntry Table
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryDao countryDao;

    private static final Logger LOGGER=LoggerFactory.getLogger(CountryServiceImpl.class);

    /*
     * Preparing DTO for Country Table GET Methods
     */
    private CountryDTO prepareCountryDTO(Country countryEntity) {
    	CountryDTO countryDTO = new CountryDTO();
    	List<StateDTO> stDTOList=new ArrayList<StateDTO>();
    	
    	countryDTO.setcountryName(countryEntity.getcountryName());
    	
	    	for (State st: countryEntity.getState()) {
	    		StateDTO stDTO = new StateDTO();
	    		stDTO.setId(st.getId());
	    		stDTO.setcountryId(st.getcountryId());
	    	    stDTO.setstateName(st.getstateName());
	        
	    	    /*
	    	     * Preparing DTO for City under Country Entity
	    	     */
	            List<CityDTO> ctDTOList=new ArrayList<CityDTO>();
	            for (City ct: st.getCity()) {
	            	CityDTO ctDTO = new CityDTO();
	            	ctDTO.setId(ct.getId());
	            	ctDTO.setstateId(ct.getstateId());
	            	ctDTO.setcityName(ct.getcityName()); 
	               
	            	ctDTOList.add(ctDTO);
	            	stDTO.setCity(ctDTOList);
	            }
	            stDTOList.add(stDTO);
	        }
    	countryDTO.setState(stDTOList);
    	countryDTO.setId(countryEntity.getId());
	
    	return countryDTO;
    }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.CountryService#persistCountry(com.example.master.dto.CountryDTO)
     * 
     * Saving Country Entity to The Database
     * 
     * @Param
     * 
     * CountryDTO
     * 
     */
    @Override
    public ResponseEntity<CountryDTO> persistCountry(CountryDTO countryDTO) {
    	Country countryEntity = new Country();
    	
    	countryEntity.setcountryName(countryDTO.getcountryName());
    	
    	countryDao.addCountry(countryEntity);
    	return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.CREATED);

    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.CountryService#updateCountry(com.example.master.dto.CountryDTO)
     * 
     * Update Service For Country Entity
     * 
     * @Param
     * 
     * CountryDTO
     * 
     */
    @Override
    public ResponseEntity<CountryDTO> updateCountry(CountryDTO countryDTO) {
    	Country countryEntity = new Country();
    	
    	countryEntity.setcountryName(countryDTO.getcountryName());
	   	countryEntity.setId(countryDTO.getId());

	   	countryDao.updateCountry(countryEntity);
	   	return new ResponseEntity<CountryDTO>(countryDTO, HttpStatus.CREATED);
   }
    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.CountryService#populateCountryList()
     * 
     * Fetching All Service For Country Entity
     * 
     */
    @Override
    public List<CountryDTO> populateCountryList() {
		List<CountryDTO> countryDTOList=new ArrayList<CountryDTO>();
		try {
		    List<Country> countryEntityList=countryDao.findAll()
		    								.stream()
		    								.sorted(Comparator.comparing(Country::getcountryName))
		    								.collect(Collectors.toList());
		    
		    countryEntityList.forEach(countryEntity->{
		    	countryDTOList.add(prepareCountryDTO(countryEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return countryDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.CountryService#populateOneCountryDetails(long)
     * 
     * Fetching By Country_Id service For Country Entity
     * 
     * @Param
     * 
     * Long CountryId
     * 
     */
    @Override
    public CountryDTO populateOneCountryDetails(long countryId) {
    	Country countryEntity = countryDao.findCountryById(countryId);
	return prepareCountryDTO(countryEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.CountryService#destroyCountry(long)
     * 
     * Delete Service For Country
     * 
     * @Param
     * 
     * long id
     * 
     */
    @Override
    public DeleteDTO destroyCountry(long Id) {

    	Country country = countryDao.findCountryById(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	if(country.getState().isEmpty()) {
    		countryDao.deleteCountry(Id);
        	
        	deleteDTO.setstatus(1);
        	deleteDTO.setstatusCode(2000);
        	deleteDTO.setmsg("Deleted successfully.");
    	}else {
    		deleteDTO.setstatus(1);
        	deleteDTO.setstatusCode(2000);
        	deleteDTO.setmsg("Can not Delete. State Present Against Country");
    	}
    	
    	return deleteDTO;
 }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.CountryService#getCountryByState(long)
     * 
     * Fetching Country By StateId Service
     * 
     * @Param
     * 
     * Long stateId
     * 
     */
	@Override
	public List<CountryDTO> getCountryByState(long stateId) {
		List<CountryDTO> countryDTOs = new ArrayList<>();
		
		List<Country> countries = countryDao.getCountryByState(stateId)
									.stream()
									.sorted(Comparator.comparing(Country::getcountryName))
									.collect(Collectors.toList());
		countries.forEach(country->{
			countryDTOs.add(prepareCountryDTO(country));
		});
		
		return countryDTOs;
	}
}
