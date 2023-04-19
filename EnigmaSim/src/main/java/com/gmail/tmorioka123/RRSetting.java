package com.gmail.tmorioka123;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RRSetting implements AbstractSetting, Serializable{
	
	static int fixedId=1;	
	@Id
	@Column
	private int id=fixedId;
	@Column
	private int rRotorStart;
	@Column
	private int rRotorRing;
	@Column
	private int mRotorStart;
	@Column
	private int mRotorRing;
	@Column
	private int lRotorStart;
	@Column
	private int lRotorRing;
	@Column
	private int tRotorStart;
	@Column
	private int tRotorRing;

	public RRSetting() {
		this.id=fixedId;
	}
	

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = fixedId;
	}

	public int getrRotorStart() {
		return rRotorStart;
	}

	public void setrRotorStart(int rRotorStart) {
		this.rRotorStart = rRotorStart;
	}

	public int getrRotorRing() {
		return rRotorRing;
	}

	public void setrRotorRing(int rRotorRing) {
		this.rRotorRing = rRotorRing;
	}

	public int getmRotorStart() {
		return mRotorStart;
	}

	public void setmRotorStart(int mRotorStart) {
		this.mRotorStart = mRotorStart;
	}

	public int getmRotorRing() {
		return mRotorRing;
	}

	public void setmRotorRing(int mRotorRing) {
		this.mRotorRing = mRotorRing;
	}

	public int getlRotorStart() {
		return lRotorStart;
	}

	public void setlRotorStart(int lRotorStart) {
		this.lRotorStart = lRotorStart;
	}

	public int getlRotorRing() {
		return lRotorRing;
	}

	public void setlRotorRing(int lRotorRing) {
		this.lRotorRing = lRotorRing;
	}


	public int gettRotorStart() {
		return tRotorStart;
	}

	public void settRotorStart(int tRotorStart) {
		this.tRotorStart = tRotorStart;
	}

	public int gettRotorRing() {
		return tRotorRing;
	}

	public void settRotorRing(int tRotorRing) {
		this.tRotorRing = tRotorRing;
	}
}