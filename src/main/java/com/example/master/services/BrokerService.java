package com.example.master.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.master.dto.BrokerDTO;
import com.example.master.dto.BrokerSuppMukamDTO;
import com.example.master.dto.BrokerWithMukamDTO;
import com.example.master.dto.DeleteDTO;

public interface BrokerService {

	public ResponseEntity<BrokerDTO> persistBroker(BrokerDTO brokerDTO);
	public BrokerDTO populateOneBrokerDetails(long id);
	public List<BrokerDTO> populateBrokerList();
	public DeleteDTO deleteBroker(long id);
	ResponseEntity<BrokerDTO> updateBroker(BrokerDTO broker);
	BrokerWithMukamDTO getBrokerSupplierMukamByBrokerId(long brokerId);
//	BrokerSupplierMukamDTO getBrokerMukamSupplier(String id);
	List<BrokerSuppMukamDTO> getBrokerMukamSupplier();
	BrokerSuppMukamDTO getBrokerMukamSupplierById(String id);
}
