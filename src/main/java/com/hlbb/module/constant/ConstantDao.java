package com.hlbb.module.constant;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ConstantDao extends JpaRepository<Constant,Long>{
	Page<Constant> findByTypeNo(String typeNo,Pageable pb);
	void deleteByTypeNo(String typeNo);
	List<Constant> findByTypeNoAndValue(String typeNo,String value);
}
