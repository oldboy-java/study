package com.tk.redpacket.service;

import com.tk.redpacket.pojo.RedPacket;
import com.tk.redpacket.pojo.UserRedPacket;

/**红包服务接口 */
public interface IRedpacketService {

	/**
	 * 获取红包
	 * @param id 编号
	 * @return 红包信息
	 */
	public RedPacket schRedPacketById(Integer id);

	/**
	 * 获取红包(for update 语句加锁)
	 * @param id 编号
	 * @return 红包信息
	 */
	public RedPacket schRedPacketByIdForUpdate(Integer id);

	/**
	 * 扣减红包
	 * @param id 编号
	 * @return  影响行数
	 */
	public int decreaseRedPacket(Integer id);
}
