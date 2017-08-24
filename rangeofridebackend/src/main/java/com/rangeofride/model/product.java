package com.rangeofride.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int pId;
	@Column
	String pName;
	@Column
	String pDiscription;
	@Column
	int pQty;
	@Column
	int pprice;
	@Column
	String pSupplierName;
	@Column
	String pCategoryName;
	@Transient
	MultipartFile productImage;

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDiscription() {
		return pDiscription;
	}

	public void setpDiscription(String pDiscription) {
		this.pDiscription = pDiscription;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getpSupplierName() {
		return pSupplierName;
	}

	public void setpSupplierName(String pSupplierName) {
		this.pSupplierName = pSupplierName;
	}

	public String getpCategoryName() {
		return pCategoryName;
	}

	public void setpCategoryName(String pCategoryName) {
		this.pCategoryName = pCategoryName;
	}
}