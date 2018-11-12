package com.example.master.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.example.master.dto.BrokerSuppMukamDTO;

@Component
public class BrokerSuplpierMukamDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	public List<BrokerSuppMukamDTO> getAllBrokerSuppMukam(){
		String hql = "select s.suppName, s.id, s.address1 from SupplierMaster s where s.suppTyp = 'J'"
				+ " union select b.brokerName , to_char(b.brokerId), b.address from Broker b";
		return (List<BrokerSuppMukamDTO>)entityManager.createQuery(hql);
	}
	
}
