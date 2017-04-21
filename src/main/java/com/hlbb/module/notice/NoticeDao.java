package com.hlbb.module.notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface NoticeDao extends JpaRepository<Notice,Long>{
	@Query(value="select * from ( "
				+ "select * from notice where send_type = 1 "
				+ " union "
				+ "(select B.* from notice_company A "
				+ "inner join notice B on A.notice_id = B.id "
				+ "where A.company_id = :companyId)) a "
				+ "order by a.created_time desc" ,
				nativeQuery=true)
	List<Notice> findByCompany(@Param("companyId") Long companyId);
}
