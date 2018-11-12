package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.master.dto.SupplierMasterDTO;
import com.example.master.dto.DeleteDTO;


public interface SupplierMasterService {

    //public ResponseEntity<ActivityDTO> getUser(String username);

    public ResponseEntity<SupplierMasterDTO> persistSupplierMaster(SupplierMasterDTO suppliermaster);

     public SupplierMasterDTO populateOneSupplierMasterDetails(String Id);
    public List<SupplierMasterDTO> populateSupplierMasterList() throws Exception;

    

    public DeleteDTO destroySupplierMaster(String Id);

   

    //public void persistActivity(ActivityDTO loggedUser, boolean changePassword);

    
    List<SupplierMasterDTO> getOtherTypeSupplierMaster(String supPType);

    ResponseEntity<SupplierMasterDTO> updateSupplierMaster(SupplierMasterDTO suppliermasterDTO);

    
    

}
