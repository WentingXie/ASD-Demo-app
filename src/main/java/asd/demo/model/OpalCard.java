/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model;

import java.io.Serializable;

/**
 *
 * @author jonny
 */
public class OpalCard implements Serializable {

	@Override
	public String toString() {
		return "OpalCard [opalCardID=" + opalCardID + ", balance=" + balance + ", description=" + description
				+ ", sequenceNumber=" + sequenceNumber + ", productTypeId=" + productTypeId + ", securityNumber="
				+ securityNumber + ", status=" + status + ", id=" + id + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6390643038067801756L;
	private String opalCardID;
	private double balance;
	private String description;
	private String sequenceNumber;
	private String productTypeId;
	private String securityNumber;
	private String status; // 0:unsaled 1:saled -1:locked
	private String id;

	public OpalCard(String opalCardID, double balance, String description, String sequenceNumber) {
		this.opalCardID = opalCardID;
		this.balance = balance;
		this.description = description;
		this.sequenceNumber = sequenceNumber;
	}

	public OpalCard() {
	}

	public void topUp(String opalCardID, double balance, String description, String sequenceNumber) {
		this.opalCardID = opalCardID;
		this.balance = balance;
		this.description = description;
		this.sequenceNumber = sequenceNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getSecurityNumber() {
		return securityNumber;
	}

	public void setSecurityNumber(String securityNumber) {
		this.securityNumber = securityNumber;
	}

	public String getOpalCardID() {
		return opalCardID;
	}

	public void setOpalCardID(String opalCardID) {
		this.opalCardID = opalCardID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public void addBalance(double amount) {
		this.balance = Double.sum(balance, amount);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}