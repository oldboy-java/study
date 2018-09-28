package com.tk.redpacket.service.impl;


import com.github.pagehelper.PageHelper;
import com.tk.redpacket.mapper.RedPacketMapper;
import com.tk.redpacket.mapper.UserRedPacketMapper;
import com.tk.redpacket.pojo.RedPacket;
import com.tk.redpacket.pojo.UserRedPacket;
import com.tk.redpacket.service.IRedpacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 红包服务实现类 */
@Service("redpacketService")
public class RedpacketServiceImpl implements IRedpacketService {

	@Autowired
	private RedPacketMapper redPacketMapper;


	@Override
	public RedPacket schRedPacketById(Integer id) {
		return redPacketMapper.schRedPacketById(id);
	}

	@Override
	public RedPacket schRedPacketByIdForUpdate(Integer id) {
		return redPacketMapper.schRedPacketByIdForUpdate(id);
	}

	@Override
	public int decreaseRedPacket(Integer id) {
		return redPacketMapper.decreaseRedPacket(id);
	}
}//end
