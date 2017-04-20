package com.hlbb.module.constant;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ConstantTypeDao extends JpaRepository<ConstantType,Long>{
	Page<ConstantType> findAll(Specification<ConstantType> param,Pageable pb);
	List<ConstantType> findByTypeNo(String typeNo);
}
