package com.example.master.component;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.master.entity.TaskType;
import com.example.master.repository.TaskTypeRepository;

@Component
public class TaskTypeDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskTypeDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    TaskTypeRepository tasktypeRepository;

    @Transactional(readOnly = true)
    public List<TaskType> findAll() throws Exception {
		LOGGER.info("DATASOURCE = " + dataSource);
		return tasktypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TaskType findTaskTypeById(Long id) {
    	return tasktypeRepository.findOne(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addTaskType(TaskType tasktype) {
    	tasktypeRepository.save(tasktype);
    	LOGGER.info("TaskType added successfully " + tasktype.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteTaskType(Long userId) {
    	tasktypeRepository.delete(userId);
    	LOGGER.info("TaskType with id " + userId + " deleted successfully ");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateTaskType(TaskType tasktype) {
    	tasktypeRepository.save(tasktype);
    	LOGGER.info("Activity added successfully " + tasktype.toString());
    }
}
