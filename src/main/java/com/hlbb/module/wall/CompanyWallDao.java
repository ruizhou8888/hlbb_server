package com.hlbb.module.wall;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface CompanyWallDao extends JpaRepository<CompanyWall,Long>{
    Page<CompanyWall> findAll(Specification<CompanyWall> param, Pageable pageable);
}
