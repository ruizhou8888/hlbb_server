package com.hlbb.module.company;

import java.util.Date;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlbb.frm.kit.PageKit;
import com.hlbb.frm.kit.StrKit;
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

	public Page<Company> getCompanys(Map<String,String> map) {
		Specification<Company> param = (Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			if(StrKit.isBlank(map.get("name"))){
				return null;
			}
			Predicate p2 = cb.like(root.get("name").as(String.class),"%"+map.get("name")+"%");
			query.where(cb.or(p2));
			return query.getRestriction();
		};
		return companyDao.findAll(param,PageKit.buildPageRequest(map));
	}
}
