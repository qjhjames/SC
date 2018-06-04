package com.qjhjames.filter;

import java.io.Serializable;

/**
 * 三段码、分单JSON请求报文实体类
 * 
 * @author XieXiCai
 * @created 2014年6月29日下午3:52:48
 */
public class OrderAddress implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String objectId;			
	private String orderChannelCode;	// 订单渠道，分单、三段码必填
	private String waybillNo;			// 单号，分单、三段码必填
	private String senderAddress;		// 发件人地址
	private String senderProvName;		// 发件人省名称，三段码必填
	private String senderCityName;		// 发件人市名称，三段码必填
	private String senderCountyName;	// 发件人区县名称，三段码必填
    private String senderTownName;		// 发件人乡镇名称，预留字段	
    private String recipientAddress;	// 收件人地址，分单、三段码必填
	private String recipientProvName;	// 收件人省名称，分单、三段码必填
	private String recipientCityName;	// 收件人市名称，分单、三段码必填
	private String recipientCountyName; // 收件人区名称，分单、三段码必填
	private String recipientTownName;   // 收件人乡镇名称，预留字段
    private String orgCode;				// 末端网点，物料发放三段码必填
	
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getOrderChannelCode() {
		return orderChannelCode;
	}
	public void setOrderChannelCode(String orderChannelCode) {
		this.orderChannelCode = orderChannelCode;
	}
	public String getWaybillNo() {	
		return waybillNo;
	}
	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getSenderProvName() {
		return senderProvName;
	}
	public void setSenderProvName(String senderProvName) {
		this.senderProvName = senderProvName;
	}
	public String getSenderCityName() {
		return senderCityName;
	}
	public void setSenderCityName(String senderCityName) {
		this.senderCityName = senderCityName;
	}
	public String getSenderCountyName() {
		return senderCountyName;
	}
	public void setSenderCountyName(String senderCountyName) {
		this.senderCountyName = senderCountyName;
	}
	public String getSenderTownName() {
		return senderTownName;
	}
	public void setSenderTownName(String senderTownName) {
		this.senderTownName = senderTownName;
	}
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public String getRecipientProvName() {
		return recipientProvName;
	}
	public void setRecipientProvName(String recipientProvName) {
		this.recipientProvName = recipientProvName;
	}
	public String getRecipientCityName() {
		return recipientCityName;
	}
	public void setRecipientCityName(String recipientCityName) {
		this.recipientCityName = recipientCityName;
	}
	public String getRecipientCountyName() {
		return recipientCountyName;
	}
	public void setRecipientCountyName(String recipientCountyName) {
		this.recipientCountyName = recipientCountyName;
	}
	public String getRecipientTownName() {
		return recipientTownName;
	}
	public void setRecipientTownName(String recipientTownName) {
		this.recipientTownName = recipientTownName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
}

