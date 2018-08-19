package com.imooc.girl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.girl.propertites.GirlProperties;

@RestController
@RequestMapping("hello")
public class HelloController {
	
	/*@Value("${girl.cupSize}")
	private String cupSize;
	
	@Value("${girl.content}")
	private String content;
*/	
	@Autowired
	private GirlProperties girlProperties;
	
	
	@RequestMapping(value="say",method=RequestMethod.GET)
	public String say() {
		//return "girl.cupSize=" + cupSize+",girl.content="+content;
		return girlProperties.getCupSize() + "," + girlProperties.getAge();
	}

	
	//@RequestMapping(value="say2",method=RequestMethod.GET)
	@GetMapping(value="say2")
	public String say2(@RequestParam(value="id",required=false,defaultValue="0") int id) {
		return "Id=" + id;
	}
	
	@GetMapping(value="say3/{id}")
	public String say3(@PathVariable("id") int id) {
		return "Id=" + id;
	}
}
