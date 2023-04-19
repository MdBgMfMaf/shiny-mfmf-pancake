package com.gmail.tmorioka123;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RRTypeSetting {
	
	private final int fixedId;
	
	@Id
	@Column
	private int id;
	@Column
	private int rRotorType;
	@Column
	private int mRotorType;
	@Column
	private int lRotorType;
	@Column
	private int refType;
	@Column
	private int tRotorType;
	
	
	public RRTypeSetting() {
		this(1);
	}
	public RRTypeSetting(int n) {
		fixedId=n;
		id=fixedId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = fixedId;
	}

	public int getrRotorType() {
		return rRotorType;
	}

	public void setrRotorType(int rRotorType) {
		this.rRotorType = rRotorType;
	}

	public int getmRotorType() {
		return mRotorType;
	}

	public void setmRotorType(int mRotorType) {
		this.mRotorType = mRotorType;
	}

	public int getlRotorType() {
		return lRotorType;
	}

	public void setlRotorType(int lRotorType) {
		this.lRotorType = lRotorType;
	}

	public int getRefType() {
		return refType;
	}

	public void setRefType(int refType) {
		this.refType = refType;
	}

	public int gettRotorType() {
		return tRotorType;
	}

	public void settRotorType(int tRotorType) {
		this.tRotorType = tRotorType;
	}
	
}
