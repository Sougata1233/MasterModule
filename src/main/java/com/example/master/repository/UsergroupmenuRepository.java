package com.example.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.master.entity.Usergroupmenu;

public interface UsergroupmenuRepository extends JpaRepository<Usergroupmenu, Long> {

    List<Usergroupmenu> findById(Long i);

}
