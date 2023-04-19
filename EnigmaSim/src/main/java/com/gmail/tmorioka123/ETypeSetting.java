package com.gmail.tmorioka123;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ETypeSetting implements AbstractSetting, Serializable{
	
	static int fixedId=1;
	
	@Id
	@Column
	private int id=fixedId;
	@Column
	private int enigmaType;
	
	public ETypeSetting() {
		this.enigmaType=0;
	}
	
	public int getId() {
		return id;
	}

	public void setId() {
		this.id = fixedId;
	}

	public int getEnigmaType() {
		return enigmaType;
	}

	public void setEnigmaType(int enigmaType) {
		this.enigmaType = enigmaType;
	}
}
	
	
	
	
