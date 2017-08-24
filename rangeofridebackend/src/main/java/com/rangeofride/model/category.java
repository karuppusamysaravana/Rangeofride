package com.rangeofride.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cid;
	@Column
	String cName;
	@Column
	String cDiscription;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcDiscription() {
		return cDiscription;
	}

	public void setcDiscription(String cDiscription) {
		this.cDiscription = cDiscription;
	}
}
