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
import org.springframework.web.bind.annotation.PathVariable;

import com.example.master.component.BankDao;
import com.example.master.dto.BankDTO;
import com.example.master.dto.DeleteDTO;
import com.example.master.entity.Bank;
import com.example.master.services.BankService;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    BankDao bankDao;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(BankServiceImpl.class);

    /*
     * preparing DTO for fetching details of bank
     */
    private BankDTO prepareBankDTO(Bank bankEntity) {
    	BankDTO bankDTO = new BankDTO();
    	bankDTO.setId(bankEntity.getId());
    	bankDTO.setBname(bankEntity.getBname());
	
    	bankDTO.setLocation(bankEntity.getLocation());
    	bankDTO.setAdd(bankEntity.getAdd());
    	bankDTO.setModBy(bankEntity.getModBy());
    	bankDTO.setModOn(bankEntity.getModOn());
    	
    	

	    return bankDTO;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.BankService#persistBank(com.example.master.dto.BankDTO)
     * saving data to the bank master table
     */
    @Override
    public ResponseEntity<BankDTO> persistBank(BankDTO bankDTO) {

    	Bank bankEntity = new Bank();
    	bankEntity.setBname(bankDTO.getBname());
    	bankEntity.setLocation(bankDTO.getLocation());
    	bankEntity.setAdd(bankDTO.getAdd());
    	bankEntity.setModBy(bankDTO.getModBy());
    	bankEntity.setModOn(Date.valueOf(LocalDate.now()));
    	
    	bankDao.addBank(bankEntity);
	return new ResponseEntity<BankDTO>(bankDTO, HttpStatus.CREATED);

    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.BankService#updateBank(com.example.master.dto.BankDTO)
     * updating bank master table
     */
    @Override
    public ResponseEntity<BankDTO> updateBank(BankDTO bankDTO) {

    	Bank bankEntity = new Bank();
    	bankEntity.setBname(bankDTO.getBname());
    	bankEntity.setLocation(bankDTO.getLocation());
    	bankEntity.setAdd(bankDTO.getAdd());
    	bankEntity.setModBy(bankDTO.getModBy());
    	bankEntity.setModOn(Date.valueOf(LocalDate.now()));
    	bankEntity.setId(bankDTO.getId());

	System.out.println("bank Entity to send to dao is " + bankEntity);
	bankDao.updateBank(bankEntity);
	return new ResponseEntity<BankDTO>(bankDTO, HttpStatus.CREATED);

    }

    
    /*
     * (non-Javadoc)
     * @see com.example.master.services.BankService#populateBankList()
     * fetching all the details from bank master table
     */
    @Override
    public List<BankDTO> populateBankList() {
	List<BankDTO> bankDTOList=new ArrayList<BankDTO>();
	try {
	    List<Bank> bankEntityList=bankDao.findAll()
	    							.stream()
	    							.sorted(Comparator.comparing(Bank::getBname))
	    							.collect(Collectors.toList());
	    
	    bankEntityList.forEach(bankEntity->{
	    	bankDTOList.add(prepareBankDTO(bankEntity));
	    });
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return bankDTOList;
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.BankService#populateOneBankDetails(java.lang.Long)
     * fetching data from bank master table by it's id
     */
    @Override
    public BankDTO populateOneBankDetails(Long Id) {
    	Bank bankEntity = bankDao.findBankById(Id);
	return prepareBankDTO(bankEntity);
    }

    /*
     * (non-Javadoc)
     * @see com.example.master.services.BankService#destroyBank(java.lang.Long)
     * deleting data from bank master table by it's id
     */
    @Override
    public DeleteDTO destroyBank(@PathVariable("Id") Long Id) {

	bankDao.deleteBank(Id);
	
	DeleteDTO deleteDTO = new DeleteDTO();
	deleteDTO.setstatus(1);
	deleteDTO.setstatusCode(2000);
	deleteDTO.setmsg("Deleted successfully.");
	
	
	return deleteDTO;
	
    }

   
    

    
}
