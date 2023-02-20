package com.project.IMS.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier" )
public class Supplier {
    
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private long supplierId;
	
	private String supplierName;

	private long suppContact;

	public Supplier(long supplierId, String supplierName, long suppContact) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.suppContact = suppContact;
	}

	public Supplier() {
		super();
		
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public long getSuppContact() {
		return suppContact;
	}

	public void setSuppContact(long suppContact) {
		this.suppContact = suppContact;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", suppContact=" + suppContact
				+ "]";
	}
	

	
}	