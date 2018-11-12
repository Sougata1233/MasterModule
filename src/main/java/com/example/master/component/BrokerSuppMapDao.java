package com.example.master.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.master.entity.BrokerSuppMap;
import com.example.master.repository.BrokerSuppMapRepository;

@Component
public class BrokerSuppMapDao {
	
	@Autowired
	BrokerSuppMapRepository brokersuppRepository;
	
	@Transactional
	public long getNextVal() {
		return brokersuppRepository.seqVal();
	}
	
	@Transactional
	public BrokerSuppMap save(BrokerSuppMap brokersupp) {
		return brokersuppRepository.save(brokersupp);
	}

	@Transactional
	public List<BrokerSuppMap> getByMapId(long mapId) {
		return (List<BrokerSuppMap>) brokersuppRepository.findOne(mapId);
	}
	
	@Transactional
	public void delete(long mapId) {
		 brokersuppRepository.delete(mapId);
	}
	
	@Transactional
	public List<BrokerSuppMap> getBySuppCode(String suppCode) {
		return brokersuppRepository.findBySuppCode(suppCode);
	}
	
	@Transactional
	public List<BrokerSuppMap> getByBrokerId(long brokerId) {
		return brokersuppRepository.findByBrokerId(brokerId);
	}
	
	@Transactional
	public BrokerSuppMap getByBrokerIdAndSuppCode(long brokerId, String suppCode) {
		return brokersuppRepository.findByBrokerIdAndSuppCode(brokerId, suppCode);
	}
	
	@Transactional
	public List<BrokerSuppMap> getAll() {
		return brokersuppRepository.findAll();
	}
	
}
