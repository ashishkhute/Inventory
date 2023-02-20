package com.project.IMS.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers" )
public class Customer{
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private long custId;
	private String custName;
	private String custContact;
	private String address;

	public Customer(long custId, String custName, String custContact, String address) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custContact = custContact;
		this.address = address;
	}

	public Customer() {
		super();
	
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustContact() {
		return custContact;
	}

	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custContact=" + custContact + ", address=" + address +"]";
	}
	
	
	
	
}