package com.project.IMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemCode;
	
	@NotEmpty(message="Please Enter the Item Name")
	@Column(name = "item_name")
	private String itemName;
	
	@NotEmpty(message="Please Enter the Description")
	@Size(min=15)
	@Column(name = "description")
	private String description;
	
	@NotNull
	@Min(value=1)
	@Column(name = "available_quantity")
	private long availableQuantity;

	@NotNull
	@Min(value=1)
	@Column(name = "reorder_level")
	private long reorderLevel;
	
	@NotNull
	@Min(value=1)
	@Column(name = "price")
	private double price;
	
	
	public Item() {
		
	}

	public long getItemCode() {
		return itemCode;
	}

	public void setItemCode(long itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public long getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(long reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

}


	