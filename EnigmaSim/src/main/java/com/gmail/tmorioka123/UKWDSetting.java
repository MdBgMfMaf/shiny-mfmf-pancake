package com.gmail.tmorioka123;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UKWDSetting implements AbstractSetting, Serializable{
	
	static int fixedId=1;
	
	@Id
	@Column
	private int id=fixedId;
	@Column
	private String ukwDSet0;
	@Column
	private String ukwDSet1;
	@Column
	private String ukwDSet2;
	@Column
	private String ukwDSet3;
	@Column
	private String ukwDSet4;
	@Column
	private String ukwDSet5;
	@Column
	private String ukwDSet6;
	@Column
	private String ukwDSet7;
	@Column
	private String ukwDSet8;
	@Column
	private String ukwDSet9;
	@Column
	private String ukwDSet10;
	@Column
	private String ukwDSet11;
	
	public UKWDSetting() {
		this.id=fixedId;
		this.ukwDSet0="";
		this.ukwDSet1="";
		this.ukwDSet2="";
		this.ukwDSet3="";
		this.ukwDSet4="";
		this.ukwDSet5="";
		this.ukwDSet6="";
		this.ukwDSet7="";
		this.ukwDSet8="";
		this.ukwDSet9="";
		this.ukwDSet10="";
		this.ukwDSet11="";
	}
	
	public String getUkwDSet0() {
		return ukwDSet0;
	}

	public void setUkwDSet0(String ukwDSet0) {
		this.ukwDSet0 = ukwDSet0;
	}

	public String getUkwDSet1() {
		return ukwDSet1;
	}

	public void setUkwDSet1(String ukwDSet1) {
		this.ukwDSet1 = ukwDSet1;
	}

	public String getUkwDSet2() {
		return ukwDSet2;
	}

	public void setUkwDSet2(String ukwDSet2) {
		this.ukwDSet2 = ukwDSet2;
	}

	public String getUkwDSet3() {
		return ukwDSet3;
	}

	public void setUkwDSet3(String ukwDSet3) {
		this.ukwDSet3 = ukwDSet3;
	}

	public String getUkwDSet4() {
		return ukwDSet4;
	}

	public void setUkwDSet4(String ukwDSet4) {
		this.ukwDSet4 = ukwDSet4;
	}

	public String getUkwDSet5() {
		return ukwDSet5;
	}

	public void setUkwDSet5(String ukwDSet5) {
		this.ukwDSet5 = ukwDSet5;
	}

	public String getUkwDSet6() {
		return ukwDSet6;
	}

	public void setUkwDSet6(String ukwDSet6) {
		this.ukwDSet6 = ukwDSet6;
	}

	public String getUkwDSet7() {
		return ukwDSet7;
	}

	public void setUkwDSet7(String ukwDSet7) {
		this.ukwDSet7 = ukwDSet7;
	}

	public String getUkwDSet8() {
		return ukwDSet8;
	}

	public void setUkwDSet8(String ukwDSet8) {
		this.ukwDSet8 = ukwDSet8;
	}

	public String getUkwDSet9() {
		return ukwDSet9;
	}

	public void setUkwDSet9(String ukwDSet9) {
		this.ukwDSet9 = ukwDSet9;
	}

	public String getUkwDSet10() {
		return ukwDSet10;
	}

	public void setUkwDSet10(String ukwDSet10) {
		this.ukwDSet10 = ukwDSet10;
	}

	public String getUkwDSet11() {
		return ukwDSet11;
	}

	public void setUkwDSet11(String ukwDSet11) {
		this.ukwDSet11 = ukwDSet11;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = fixedId;
	}
	public String getConbinedUkwDSet() {
		String str=(ukwDSet0+ukwDSet1+ukwDSet2+ukwDSet3+ukwDSet4+ukwDSet5+ukwDSet6+ukwDSet7+
				ukwDSet8+ukwDSet9+ukwDSet10+ukwDSet11);
		str=str.toUpperCase();
		return str;
	}
}
