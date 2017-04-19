package com.hlbb.module.constant;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hlbb.frm.kit.PageKit;
import com.hlbb.frm.kit.StrKit;

@Service
public class ConstantService {
	@Autowired
	private ConstantDao constantDao;
	@Autowired
	private ConstantTypeDao constantTypeDao;
	
	public Page<Constant> findConstantByTypeNo(Map<String,String> map){
		Page<Constant> constants = constantDao.findByTypeNo(map.get("typeNo"),PageKit.buildPageRequest(map));
		return constants;
	}
	
	public Page<ConstantType> findConstantTypeAll(Map<String,String> map){

		Specification<ConstantType> param = new Specification<ConstantType>() {
			@Override
			public Predicate toPredicate(Root<ConstantType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(StrKit.isBlank(map.get("content"))){
					return null;
				}
				Predicate p1 = cb.like(root.get("typeNo").as(String.class), "%"+map.get("content")+"%");  					
				Predicate p2 = cb.like(root.get("name").as(String.class),"%"+map.get("content")+"%");  
	        	query.where(cb.or(p1,p2));  		        	
		        return query.getRestriction();
			}
		};
		Page<ConstantType> contypes = constantTypeDao.findAll(param,PageKit.buildPageRequest(map));
		return contypes;
	}
	
	@Transactional
	public void delConstantType(List<ConstantType> cts){
		cts.forEach((ct)->{
			String typeNo = ct.getTypeNo();
			constantDao.deleteByTypeNo(typeNo);
			constantTypeDao.delete(ct.getId());			
		});
	}
}
