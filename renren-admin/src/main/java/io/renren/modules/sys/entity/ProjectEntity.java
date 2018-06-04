package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 项目信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-04 21:54:43
 */
@TableName("project")
public class ProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一主键
	 */
	@TableId
	private String proId;
	/**
	 * 项目名称
	 */
	private String proName;
	/**
	 * 项目推荐语
	 */
	private String proBrief;
	/**
	 * 项目状态[0-新建 1-已上线 2-已下线]
	 */
	private String proStatus;
	/**
	 * 项目类型[0-足疗 1-保健 2-纤体 3-养生]
	 */
	private String proType;
	/**
	 * 项目定价
	 */
	private BigDecimal proAmt;
	/**
	 * 服务时长/分钟
	 */
	private String proLong;
	/**
	 * 项目介绍
	 */
	private String proContent;
	/**
	 * 每天人数限制
	 */
	private String maxPeople;
	/**
	 * 封面图
	 */
	private String coverPic;
	/**
	 * 介绍轮播图
	 */
	private String cyclePic;
	/**
	 * 受理预约开始时间
	 */
	private Date beginTime;
	/**
	 * 受理预约结束时间
	 */
	private Date endTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 项目说明
	 */
	private String memo;

	/**
	 * 设置：唯一主键
	 */
	public void setProId(String proId) {
		this.proId = proId;
	}
	/**
	 * 获取：唯一主键
	 */
	public String getProId() {
		return proId;
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
	 * 设置：项目推荐语
	 */
	public void setProBrief(String proBrief) {
		this.proBrief = proBrief;
	}
	/**
	 * 获取：项目推荐语
	 */
	public String getProBrief() {
		return proBrief;
	}
	/**
	 * 设置：项目状态[0-新建 1-已上线 2-已下线]
	 */
	public void setProStatus(String proStatus) {
		this.proStatus = proStatus;
	}
	/**
	 * 获取：项目状态[0-新建 1-已上线 2-已下线]
	 */
	public String getProStatus() {
		return proStatus;
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
	 * 设置：项目定价
	 */
	public void setProAmt(BigDecimal proAmt) {
		this.proAmt = proAmt;
	}
	/**
	 * 获取：项目定价
	 */
	public BigDecimal getProAmt() {
		return proAmt;
	}
	/**
	 * 设置：服务时长/分钟
	 */
	public void setProLong(String proLong) {
		this.proLong = proLong;
	}
	/**
	 * 获取：服务时长/分钟
	 */
	public String getProLong() {
		return proLong;
	}
	/**
	 * 设置：项目介绍
	 */
	public void setProContent(String proContent) {
		this.proContent = proContent;
	}
	/**
	 * 获取：项目介绍
	 */
	public String getProContent() {
		return proContent;
	}
	/**
	 * 设置：每天人数限制
	 */
	public void setMaxPeople(String maxPeople) {
		this.maxPeople = maxPeople;
	}
	/**
	 * 获取：每天人数限制
	 */
	public String getMaxPeople() {
		return maxPeople;
	}
	/**
	 * 设置：封面图
	 */
	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}
	/**
	 * 获取：封面图
	 */
	public String getCoverPic() {
		return coverPic;
	}
	/**
	 * 设置：介绍轮播图
	 */
	public void setCyclePic(String cyclePic) {
		this.cyclePic = cyclePic;
	}
	/**
	 * 获取：介绍轮播图
	 */
	public String getCyclePic() {
		return cyclePic;
	}
	/**
	 * 设置：受理预约开始时间
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	/**
	 * 获取：受理预约开始时间
	 */
	public Date getBeginTime() {
		return beginTime;
	}
	/**
	 * 设置：受理预约结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：受理预约结束时间
	 */
	public Date getEndTime() {
		return endTime;
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
	 * 设置：项目说明
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：项目说明
	 */
	public String getMemo() {
		return memo;
	}
}
