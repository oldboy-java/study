package com.imooc.girl.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.girl.common.Result;
import com.imooc.girl.common.ResultUtils;
import com.imooc.girl.pojo.Girl;
import com.imooc.girl.service.GirlService;

@RestController
public class GirlController {

	private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

	@Autowired
	private GirlService girlService;

	/**
	 * 查询女生列表
	 * 
	 * @return
	 */
	@GetMapping(value = "girls")
	public Result<Object> girlList() {
		return ResultUtils.success(girlService.girlList());
	}

	/**
	 * 添加女生
	 * 
	 * @param age
	 * @param cupSize
	 * @return
	 */
	// @Valid:对girl对象进行验证，如果有错误，则结果保存再BindingResult
	@PostMapping(value = "girls")
	public Result<Object> addGirl(@Valid Girl girl, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			logger.info(bindingResult.getFieldError().getDefaultMessage());
			return ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtils.success(girlService.addGirl(girl));
	}

	/***
	 * 更新女生
	 * 
	 * @param age
	 * @param cupSize
	 * @param id
	 * @return
	 */
	@PutMapping(value = "girls/{id}")
	public Result<Object> updateGirl(@RequestParam("age") Integer age, @RequestParam("cupSize") String cupSize,
			@PathVariable("id") Integer id) {
		Girl girl = new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setCupSize(cupSize);
		return ResultUtils.success(girlService.updateGirl(girl));
	}

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "girls/{id}")
	public Result<Object> findGirl(@PathVariable("id") Integer id) {
		return ResultUtils.success(girlService.findGirl(id));
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@DeleteMapping(value = "girls/{id}")
	public Result<Object> deleteGirl(@PathVariable("id") Integer id) {
		girlService.deleteGirl(id);
		return ResultUtils.success(null);
	}

	/**
	 * 根据年龄查询女生列表
	 * 
	 * @return
	 */
	@GetMapping(value = "girls/age/{age}")
	public Result<Object> girlListByAge(@PathVariable("age") Integer age) {
		return ResultUtils.success(girlService.girlListByAge(age));
	}

	/***
	 * 查询女生年龄
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "girls/getAge/{id}")
	public Result<Object> getGirlAge(@PathVariable("id") Integer id) throws Exception {
		return ResultUtils.success(girlService.getGirlAge(id));
	}

}
