package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-05 21:47:20
 */
@TableName("user_info")
public class UserInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一主键
	 */
	@TableId
	private String userId;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户类型[1-VIP  2-普通用户]
	 */
	private String userType;
	/**
	 * 性别
	 */
	private String userSex;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 住址
	 */
	private String address;
	/**
	 * 微信名称
	 */
	private String wxUname;
	/**
	 * 微信OPENID
	 */
	private String wxOpenid;
	/**
	 * 微信头像
	 */
	private String wxHeadpic;
	/**
	 * 说明
	 */
	private String memo;
	/**
	 * 会员编号
	 */
	private String userNo;
	/**
	 * 注册时间
	 */
	private Date registTime;

	/**
	 * 设置：唯一主键
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：唯一主键
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：用户类型[1-VIP  2-普通用户]
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * 获取：用户类型[1-VIP  2-普通用户]
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * 设置：性别
	 */
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	/**
	 * 获取：性别
	 */
	public String getUserSex() {
		return userSex;
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
	 * 设置：住址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：住址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：微信名称
	 */
	public void setWxUname(String wxUname) {
		this.wxUname = wxUname;
	}
	/**
	 * 获取：微信名称
	 */
	public String getWxUname() {
		return wxUname;
	}
	/**
	 * 设置：微信OPENID
	 */
	public void setWxOpenid(String wxOpenid) {
		this.wxOpenid = wxOpenid;
	}
	/**
	 * 获取：微信OPENID
	 */
	public String getWxOpenid() {
		return wxOpenid;
	}
	/**
	 * 设置：微信头像
	 */
	public void setWxHeadpic(String wxHeadpic) {
		this.wxHeadpic = wxHeadpic;
	}
	/**
	 * 获取：微信头像
	 */
	public String getWxHeadpic() {
		return wxHeadpic;
	}
	/**
	 * 设置：说明
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：说明
	 */
	public String getMemo() {
		return memo;
	}


	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
}
