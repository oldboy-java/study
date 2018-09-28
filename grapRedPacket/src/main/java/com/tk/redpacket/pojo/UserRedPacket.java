package com.tk.redpacket.pojo;
import java.math.BigDecimal;
import java.util.Date;

/** 用户抢红包表实体类 */
public class UserRedPacket{
	//Fields
	private Integer id;// 
	private Integer redPacketId;// 红包ID
	private Integer userId;// 抢红包用户ID
	private BigDecimal amount; //抢红包金额
	private Date grabTime;// 抢红包时间
	private String note;// 备注
	//Constructors
	/** default constructor */
	public UserRedPacket() {
	
	}	
	//getter and setter
	/** 获取 */
	public Integer getId() {
		return this.id;
	}
	/** 设置 */
	public void setId(Integer id) {
		this.id = id;
	}
	/** 获取红包ID */
	public Integer getRedPacketId() {
		return this.redPacketId;
	}
	/** 设置红包ID */
	public void setRedPacketId(Integer redPacketId) {
		this.redPacketId = redPacketId;
	}
	/** 获取抢红包用户ID */
	public Integer getUserId() {
		return this.userId;
	}
	/** 设置抢红包用户ID */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/** 获取抢红包时间 */
	public Date getGrabTime() {
		return this.grabTime;
	}
	/** 设置抢红包时间 */
	public void setGrabTime(Date grabTime) {
		this.grabTime = grabTime;
	}
	/** 获取备注 */
	public String getNote() {
		return this.note;
	}
	/** 设置备注 */
	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
