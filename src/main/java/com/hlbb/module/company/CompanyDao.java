package com.hlbb.module.company;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CompanyDao extends JpaRepository<Company,Long>{
	Page<Company> findAll(Specification<Company> param, Pageable pageable);
}
