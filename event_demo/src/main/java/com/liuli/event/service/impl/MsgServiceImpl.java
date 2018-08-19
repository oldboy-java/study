package com.liuli.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuli.event.mapper.TMsgMapper;
import com.liuli.event.pojo.TMsg;
import com.liuli.event.service.MsgService;

@Service
public class MsgServiceImpl implements MsgService {

	@Autowired
	private TMsgMapper msgMapper;
	
	@Override
	public void addMsg(TMsg msg) {
		msgMapper.insertSelective(msg);
	}

}
