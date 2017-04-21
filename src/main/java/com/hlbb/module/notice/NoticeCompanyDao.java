package com.hlbb.module.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
interface NoticeCompanyDao extends JpaRepository<NoticeCompany, Long>{
	void deleteByNoticeId(Long noticeId);
}
