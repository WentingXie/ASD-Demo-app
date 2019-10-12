/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;

import java.io.Serializable;

/**
 *
 * @author suyixin
 */
public class Order implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1171568948806763208L;
	private String id;
	private String userId;
	private String OpalCardSequenceNumber;
	private String productTypeId;
	private String orderDate;
	private String userAddress;
	private String postalCode;
	private String status;// 0:Unbound 1:Binded

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOpalCardSequenceNumber() {
		return OpalCardSequenceNumber;
	}

	public void setOpalCardSequenceNumber(String opalCardSequenceNumber) {
		OpalCardSequenceNumber = opalCardSequenceNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", OpalCardSequenceNumber=" + OpalCardSequenceNumber
				+ ", orderDate=" + orderDate + ", userAddress=" + userAddress + ", postalCode=" + postalCode
				+ ", status=" + status + "]";
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

}
