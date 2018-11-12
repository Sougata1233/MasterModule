package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.Broker;

public interface BrokerRepository extends JpaRepository<Broker, Long> {
	
	List<Broker> findByBrokerName(String brokerName);

}
