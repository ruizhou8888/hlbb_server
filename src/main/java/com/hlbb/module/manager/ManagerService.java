package com.hlbb.module.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlbb.frm.enums.ResultEnum;
import com.hlbb.frm.exception.GlobalException;
import com.hlbb.frm.kit.HashKit;

@Service
public class ManagerService {
	@Autowired
	private ManagerDao managerDao;
	
	public Manager login(String userName,String password){
		Manager mng = managerDao.findByLoginName(userName);
		if(mng==null){
			throw new GlobalException(ResultEnum.NOTEXSIS_USER);
		}
		String salt = mng.getRandomFactor();
		String realPwd = HashKit.md5(HashKit.md5(password)+salt);
		if(!realPwd.equals(mng.getPassword())){
			throw new GlobalException(ResultEnum.NOTFOUND_USER);
		}
		return mng;
	}

	public void register(String loginName,String code,String password,String surepwd) {
		Manager mng = managerDao.findByLoginName(loginName);
		if(mng!=null){
			throw new GlobalException(ResultEnum.EXSIS_USER);
		}
		if(!password.equals(surepwd)){
			throw new GlobalException(ResultEnum.PWD_NOSAME);
		}
		String salt = String.valueOf(Math.round(Math.random()*9000+1000));
		Manager mngd = new Manager();
		mngd.setLoginName(loginName);
		mngd.setRandomFactor(salt);
		mngd.setPassword(password);
	}
}
