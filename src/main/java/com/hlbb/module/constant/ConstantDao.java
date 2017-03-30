package com.hlbb.module.constant;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public interface ConstantDao extends Repository<Constant,Long>{
	List<Constant> findByTypeNo(String typeNo);
}
