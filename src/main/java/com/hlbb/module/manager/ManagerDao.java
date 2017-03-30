package com.hlbb.module.manager;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public interface ManagerDao extends Repository<Manager,Long>{
	Manager findById(Long mngId);
	Manager findByLoginNameAndPassword(String loginName,String password);
	Manager findByLoginName(String loginName);
}
