package com.hlbb.module.company;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlbb.module.manager.Manager;
import com.hlbb.module.manager.ManagerDao;

@Service
public class CompanyService {
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private ManagerDao managerDao;
	
	@Transactional
	public Company perfect(Company company,String mngId){
		company.setCreatedTime(new Date());
		company.setUpdateTime(new Date());
		company = companyDao.save(company);
		Manager mng = managerDao.findOne(Long.valueOf(mngId));
		mng.setCompanyId(company.getId());
		mng.setIsActive(1);
		managerDao.save(mng);
		return company;
	}
	
	public Company getCompanyByMngId(String mngId){
		Manager mng = managerDao.findOne(Long.valueOf(mngId));
		Long companyId = mng.getCompanyId();
		Company c = companyDao.findOne(companyId);
		return c;
	}
}
