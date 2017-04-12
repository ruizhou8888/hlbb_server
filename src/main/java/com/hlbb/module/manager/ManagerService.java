package com.hlbb.module.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.hlbb.frm.enums.ResultEnum;
import com.hlbb.frm.exception.GlobalException;
import com.hlbb.frm.kit.HashKit;

@Service
public class ManagerService {
	@Autowired
	private ManagerDao managerDao;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
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

	public Manager register(String email, String password, String surepwd, String checkCode) {
		String code = stringRedisTemplate.opsForValue().get(email);
		if(!code.equals(checkCode)){
			throw new GlobalException(ResultEnum.CHECKCODE_ERROR);
		}
		if(!password.equals(surepwd)){
			throw new GlobalException(ResultEnum.PWD_NOTSAME);
		}
		Manager mng = managerDao.findByLoginName(email);
		if(mng!=null){
			throw new GlobalException(ResultEnum.EXSIS_USER);
		}
		long randomcode = Math.round(Math.random()*9000+1000);
		String realpwd = HashKit.md5(HashKit.md5(password)+randomcode);
		Manager m = new Manager(email, realpwd, String.valueOf(randomcode));
		managerDao.save(m);
		System.out.println(m.getId());
		return m;
	}
}
