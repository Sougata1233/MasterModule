package com.example.master.component;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.Activity;
import com.example.master.repository.ActivityRepository;


@Component
public class ActivityDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ActivityRepository activityRepository;

    @Transactional(readOnly = true)
    public List<Activity> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return activityRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Activity findActivityById(Long id) {
    	return activityRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addActivity(Activity activity) {
    	activityRepository.save(activity);
    	LOGGER.info("Activity added successfully " + activity.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteActivity(Long userId) {
    	activityRepository.delete(userId);
    	LOGGER.info("Activity with id " + userId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateActivity(Activity activity) {
    	activityRepository.save(activity);
    	LOGGER.info("Activity added successfully " + activity.toString());
    }
}
