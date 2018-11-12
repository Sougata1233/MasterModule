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

import com.example.master.component.CityDao;
import com.example.master.dto.CityDTO;
import com.example.master.dto.CountryDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.dto.StateDTO;
import com.example.master.entity.City;
import com.example.master.services.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;

   
    
    private static final Logger LOGGER=LoggerFactory.getLogger(CityServiceImpl.class);

   
    private CityDTO prepareCityDTO(City cityEntity) {
    	CityDTO cityDTO = new CityDTO();
    	
	
    	cityDTO.setcityName(cityEntity.getcityName());
    	
    	cityDTO.setstateId(cityEntity.getstateId());
	
    	try {
    		StateDTO stateDTO = new StateDTO();

    		stateDTO.setstateName(cityEntity.getState().getstateName());
    		stateDTO.setId(cityEntity.getState().getId());
    		stateDTO.setcountryId(cityEntity.getState().getcountryId());
    		
    		CountryDTO countryDTO = new CountryDTO();
    		
    		countryDTO.setId(cityEntity.getState().getCountry().getId());
    		countryDTO.setcountryName(cityEntity.getState().getCountry().getcountryName());
    	    stateDTO.setCountry(countryDTO);

    		cityDTO.setState(stateDTO);
    	} catch (Exception e) {
    	    LOGGER.error("error in getting designation of user {} {}",  e.getMessage());
    	}
	
    	cityDTO.setId(cityEntity.getId());

	    return cityDTO;
    }
    
    

    @Override
    public ResponseEntity<CityDTO> persistCity(CityDTO cityDTO) {
    	City cityEntity = new City();

    	cityEntity.setcityName(cityDTO.getcityName());
    	cityEntity.setstateId(cityDTO.getstateId());

    	cityDao.addCity(cityEntity);
	return new ResponseEntity<CityDTO>(cityDTO, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<CityDTO> updateCity(CityDTO cityDTO) {
    	City cityEntity = new City();
        
    	cityEntity.setcityName(cityDTO.getcityName());
    	cityEntity.setstateId(cityDTO.getstateId());
		cityEntity.setId(cityDTO.getId());

		cityDao.updateCity(cityEntity);
		return new ResponseEntity<CityDTO>(cityDTO, HttpStatus.CREATED);
    }
    

    @Override
    public List<CityDTO> populateCityList() {
		List<CityDTO> cityDTOList=new ArrayList<CityDTO>();
		try {
		    List<City> cityEntityList=cityDao.findAll()
		    							.stream()
		    							.sorted(Comparator.comparing(City::getcityName))
		    							.collect(Collectors.toList());
		    cityEntityList.forEach(cityEntity->{
		    	cityDTOList.add(prepareCityDTO(cityEntity));
		    });
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return cityDTOList;
    }

    @Override
    public CityDTO populateOneCityDetails(int Id) {
    	City cityEntity = cityDao.findCityById(Id);
	return prepareCityDTO(cityEntity);
    }

    @Override
    public DeleteDTO destroyCity(int Id) {
    	cityDao.deleteCity(Id);
    	
    	DeleteDTO deleteDTO = new DeleteDTO();
    	deleteDTO.setstatus(1);
    	deleteDTO.setstatusCode(2000);
    	deleteDTO.setmsg("Deleted successfully.");
    	
    	return deleteDTO;
    }



	@Override
	public List<CityDTO> getCityByState(long stateId) {
		List<CityDTO> cityDTOs = new ArrayList<>();
		try {
			List<City> cities = cityDao.getCityByState(stateId)
					.stream()
					.sorted(Comparator.comparing(City::getcityName))
					.collect(Collectors.toList());
			cities.forEach(city->{
				cityDTOs.add(prepareCityDTO(city));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cityDTOs;
	}

   
    

    
}
