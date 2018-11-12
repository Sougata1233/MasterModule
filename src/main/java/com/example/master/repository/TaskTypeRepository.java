package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.TaskType;

public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {

    List<TaskType> findById(Long i);

}
