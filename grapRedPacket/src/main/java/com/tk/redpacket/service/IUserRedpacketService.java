package com.tk.redpacket.service;

import com.tk.redpacket.pojo.RedPacket;
import com.tk.redpacket.pojo.UserRedPacket;

/**抢红包服务接口 */
public interface IUserRedpacketService {

	/**
	 * 生成抢红包信息
	 *@param  redPacketId 红包编号
	 *@param  userId 抢红包用户编号
	 * @return 返回影响的行数
	 */
	public Integer grabUserRedPacket(Integer redPacketId,Integer userId);

}
