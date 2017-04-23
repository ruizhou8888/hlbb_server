package com.hlbb.module.wall;

import com.hlbb.frm.kit.PageKit;
import com.hlbb.frm.kit.StrKit;
import com.hlbb.module.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.Map;

@Service
public class WallService {
	@Autowired
	private CompanyWallDao wallDao;
	
	public Page<CompanyWall> getWalls(Map<String,String> map){
		Specification<CompanyWall> param = (Root<CompanyWall> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			Predicate p1,p2 = null;
			if(!StrKit.isBlank(map.get("state"))){
				p1 = cb.equal(root.get("state").as(String.class),map.get("state"));
				query.where(p1);
			}
			if(!StrKit.isBlank(map.get("companyId"))){
//				Join<CompanyWall,Company> companyJoin = root.join(root.getModel().getSingularAttribute("company",Company.class) , JoinType.INNER);
				p2 = cb.equal(root.get("companyId").as(String.class),map.get("companyId"));
				query.where(p2);
			}
			return query.getRestriction();
		};
		return wallDao.findAll(param,PageKit.buildPageRequest(map));
	}


	public CompanyWall saveWall(CompanyWall wall){
		wallDao.save(wall);
		return wall;
	}

	public CompanyWall getWallById(String id) {
		return wallDao.findOne(Long.valueOf(id));
	}
}
