package com.hlbb.module.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CompanyDao extends JpaRepository<Company,Long>{
	
}
