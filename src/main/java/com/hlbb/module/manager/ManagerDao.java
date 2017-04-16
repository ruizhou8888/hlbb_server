package com.hlbb.module.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ManagerDao extends JpaRepository<Manager,Long>{
	Manager findByLoginNameAndPassword(String loginName,String password);
	Manager findByLoginName(String loginName);
}
