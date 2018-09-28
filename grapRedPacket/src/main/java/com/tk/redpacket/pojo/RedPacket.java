package com.tk.redpacket.pojo;
import java.math.BigDecimal;
import java.util.Date;

/** 红包表实体类 */
public class RedPacket{
	//Fields
	private Integer id;// 
	private Integer userId;// 发红包用户ID
	private BigDecimal amount; //红包金额
	private Date sendDate;// 发红包时间
	private Integer total;// 小红包总数
	private BigDecimal unitAmount; //单个小红包金额
	private Integer stock;// 剩余小红包数
	private Integer version;// 版本
	private String note;// 备注
	//Constructors
	/** default constructor */
	public RedPacket() {
	
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
	/** 获取发红包用户ID */
	public Integer getUserId() {
		return this.userId;
	}
	/** 设置发红包用户ID */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/** 获取发红包时间 */
	public Date getSendDate() {
		return this.sendDate;
	}
	/** 设置发红包时间 */
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	/** 获取小红包总数 */
	public Integer getTotal() {
		return this.total;
	}
	/** 设置小红包总数 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	/** 获取剩余红包数 */
	public Integer getStock() {
		return this.stock;
	}
	/** 设置剩余红包数 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	/** 获取版本 */
	public Integer getVersion() {
		return this.version;
	}
	/** 设置版本 */
	public void setVersion(Integer version) {
		this.version = version;
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

	public BigDecimal getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(BigDecimal unitAmount) {
		this.unitAmount = unitAmount;
	}
}
