package com.gmail.tmorioka123;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PbSetting implements AbstractSetting, Serializable{
	
	static int fixedId=1;
	
	@Id
	@Column
	private int id=fixedId;
	@Column
	private String pbSet0;
	@Column
	private String pbSet1;
	@Column
	private String pbSet2;
	@Column
	private String pbSet3;
	@Column
	private String pbSet4;
	@Column
	private String pbSet5;
	@Column
	private String pbSet6;
	@Column
	private String pbSet7;
	@Column
	private String pbSet8;
	@Column
	private String pbSet9;
	

	public String getPbSet0() {
		return pbSet0;
	}

	public void setPbSet0(String pbSet0) {
		this.pbSet0 = pbSet0;
	}

	public String getPbSet1() {
		return pbSet1;
	}

	public void setPbSet1(String pbSet1) {
		this.pbSet1 = pbSet1;
	}

	public String getPbSet2() {
		return pbSet2;
	}

	public void setPbSet2(String pbSet2) {
		this.pbSet2 = pbSet2;
	}

	public String getPbSet3() {
		return pbSet3;
	}

	public void setPbSet3(String pbSet3) {
		this.pbSet3 = pbSet3;
	}

	public String getPbSet4() {
		return pbSet4;
	}

	public void setPbSet4(String pbSet4) {
		this.pbSet4 = pbSet4;
	}

	public String getPbSet5() {
		return pbSet5;
	}

	public void setPbSet5(String pbSet5) {
		this.pbSet5 = pbSet5;
	}
	public String getPbSet6() {
		return pbSet6;
	}

	public void setPbSet6(String pbSet6) {
		this.pbSet6 = pbSet6;
	}

	public String getPbSet7() {
		return pbSet7;
	}

	public void setPbSet7(String pbSet7) {
		this.pbSet7 = pbSet7;
	}

	public String getPbSet8() {
		return pbSet8;
	}

	public void setPbSet8(String pbSet8) {
		this.pbSet8 = pbSet8;
	}

	public String getPbSet9() {
		return pbSet9;
	}

	public void setPbSet9(String pbSet9) {
		this.pbSet9 = pbSet9;
	}
	
	public PbSetting() {
		this.id=fixedId;
		 pbSet0="";		
		 pbSet1="";
		 pbSet2="";
		 pbSet3="";
		 pbSet4="";
		 pbSet5="";
		 pbSet6="";
		 pbSet7="";
		 pbSet8="";
		 pbSet9="";
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = fixedId;
	}
	public String getConbinedPbSet() {
		String str=(pbSet0+pbSet1+pbSet2+pbSet3+pbSet4+pbSet5+pbSet6+pbSet7+pbSet8+pbSet9);
		str=str.toUpperCase();
		return str;
	}
}
	