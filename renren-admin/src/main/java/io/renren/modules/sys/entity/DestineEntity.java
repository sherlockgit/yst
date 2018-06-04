package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 项目预约表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-04 21:54:43
 */
@TableName("destine")
public class DestineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一主键
	 */
	@TableId
	private String destineId;
	/**
	 * 会员ID
	 */
	private String userId;
	/**
	 * 预约姓名
	 */
	private String uname;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 项目ID
	 */
	private String proId;
	/**
	 * 项目类型[0-足疗 1-保健 2-纤体 3-养生]
	 */
	private String proType;
	/**
	 * 项目名称
	 */
	private String proName;
	/**
	 * 项目金额
	 */
	private BigDecimal proAmt;
	/**
	 * 预约状态[0-待确认 1-待服务 2-已取消 3-已完成]
	 */
	private String distineStatus;
	/**
	 * 预约服务时间
	 */
	private Date destineTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String memo;

	/**
	 * 设置：唯一主键
	 */
	public void setDestineId(String destineId) {
		this.destineId = destineId;
	}
	/**
	 * 获取：唯一主键
	 */
	public String getDestineId() {
		return destineId;
	}
	/**
	 * 设置：会员ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：会员ID
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：预约姓名
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * 获取：预约姓名
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * 设置：手机号码
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号码
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：项目ID
	 */
	public void setProId(String proId) {
		this.proId = proId;
	}
	/**
	 * 获取：项目ID
	 */
	public String getProId() {
		return proId;
	}
	/**
	 * 设置：项目类型[0-足疗 1-保健 2-纤体 3-养生]
	 */
	public void setProType(String proType) {
		this.proType = proType;
	}
	/**
	 * 获取：项目类型[0-足疗 1-保健 2-纤体 3-养生]
	 */
	public String getProType() {
		return proType;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * 设置：项目金额
	 */
	public void setProAmt(BigDecimal proAmt) {
		this.proAmt = proAmt;
	}
	/**
	 * 获取：项目金额
	 */
	public BigDecimal getProAmt() {
		return proAmt;
	}
	/**
	 * 设置：预约状态[0-待确认 1-待服务 2-已取消 3-已完成]
	 */
	public void setDistineStatus(String distineStatus) {
		this.distineStatus = distineStatus;
	}
	/**
	 * 获取：预约状态[0-待确认 1-待服务 2-已取消 3-已完成]
	 */
	public String getDistineStatus() {
		return distineStatus;
	}
	/**
	 * 设置：预约服务时间
	 */
	public void setDestineTime(Date destineTime) {
		this.destineTime = destineTime;
	}
	/**
	 * 获取：预约服务时间
	 */
	public Date getDestineTime() {
		return destineTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：
	 */
	public String getMemo() {
		return memo;
	}
}
