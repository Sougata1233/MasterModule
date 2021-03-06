package com.example.master.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.dto.UserDTO;
import com.example.master.entity.User;
import com.example.master.repository.UserRepository;

/*
 * DAO class for USER_DETAILS table
 */

@Component
public class UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository userRepository;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<User> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return userRepository.findAll();
    }
    
    @Transactional
    public List<User> findAllOrdered() throws Exception{
    	return userRepository.findAllOrderByUserName();
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUserName(String userName) {
    	System.out.println(LOGGER.isTraceEnabled());
    	return userRepository.findByUserNameReturnStream(userName).findFirst();
    }

    @Transactional(readOnly = true)
    public User findUserById(Long id) {
    	return userRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<User> findByUserNameStream(String userName) {
    	return userRepository.findByUserNameCustom(userName);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUser(User user) {
		userRepository.save(user);
		LOGGER.info("User added successfully " + user.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(Long userId) {
		userRepository.delete(userId);
		LOGGER.info("User with id " + userId + " deleted successfully ");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user) {
		userRepository.save(userRepository.findOne(user.getId()));
		LOGGER.info("User added successfully " + user.toString());
    }
    
    @Transactional(readOnly = true)
    public int findCountOfUserName(String userName) {
    	return (userRepository.findByUserName(userName).size());
    }
    
    @Transactional
    public void save(User user) {
    	userRepository.save(user);
    }
    
    @Transactional
    public void saveEntity(User user) {
    	userRepository.save(user);
    }
    
    @Transactional
    public void storedProc(Long inUserId, Long inLocationId) {
    	entityManager.createNativeQuery("BEGIN USER_CREATE_PROC(:IN_USER_ID, :IN_LOCATION_ID); END;")
		.setParameter("IN_USER_ID", inUserId)
		.setParameter("IN_LOCATION_ID", inLocationId)
		.executeUpdate();
    }
}
