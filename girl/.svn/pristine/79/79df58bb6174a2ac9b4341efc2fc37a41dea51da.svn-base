package com.imooc.girl.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.girl.dao.GirlRespository;
import com.imooc.girl.enums.ResultEnum;
import com.imooc.girl.exception.GirlException;
import com.imooc.girl.pojo.Girl;
import com.imooc.girl.service.GirlService;

@Service
public class GirlServiceImpl implements GirlService {

	@Autowired
	private GirlRespository girlRespository;

	@Override
	public List<Girl> girlList() {
		return girlRespository.findAll();
	}

	@Override
	@Transactional //事务处理，出现异常自动回滚
	public Girl addGirl(Girl girl) throws Exception{
		 girl =  girlRespository.save(girl);
		 
		 //模拟发生异常
		 if(1==1) {
			 throw new RuntimeException("daaa"); 
		 }
		 return girl;
	}

	@Override
	public Girl updateGirl(Girl girl) {
		return girlRespository.save(girl);
	}

	@Override
	public Girl findGirl(Integer id) {
		return girlRespository.findOne(id);
	}

	@Override
	public void deleteGirl(Integer id) {
		girlRespository.delete(id);		
	}

	@Override
	public List<Girl> girlListByAge(Integer age) {
		return girlRespository.findByAge(age);
	}

	@Override
	public Integer getGirlAge(Integer id) throws Exception {
		Girl girl = girlRespository.findOne(id);
		Integer age  = girl.getAge();
		if(age < 10 ) {
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL.getCode(),ResultEnum.PRIMARY_SCHOOL.getMessage());
		}else if( age > 10 && age <16) {
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL.getCode(),ResultEnum.MIDDLE_SCHOOL.getMessage());
		}
		return age;
	}
	
	
}
