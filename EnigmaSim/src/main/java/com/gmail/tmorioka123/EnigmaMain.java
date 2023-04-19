package com.gmail.tmorioka123;

import java.io.Serializable;

import enigmasrc.AbstractEnigma;
import enigmasrc.KriegsmarineEnigmaM3;
import enigmasrc.KriegsmarineEnigmaM4;
import enigmasrc.WehrmachtEnigmaI;

public class EnigmaMain implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int[]rRtrSet;
	private int[]mRtrSet;
	private int[]lRtrSet;
	private int[]tRtrSet;
	private int rflctrSet;
	private String  pbSet;
	private String ukwDSet;
	private AbstractEnigma enigma;
	private boolean hasUKWD=false;
	private boolean hasThin=false;

	public void constructEnigma(int enigmaType,int refType,int tRotorType,int lRotorType,int mRotorType,
			int rRotorType,int tRotorStart,int lRotorStart,int 	mRotorStart,int rRotorStart,int	tRotorRing,
			int rRotorRing,int mRotorRing,int lRotorRing,String pbSet0,String pbSet1,String pbSet2,
			String pbSet3,String pbSet4,String pbSet5,String pbSet6,String pbSet7,String pbSet8,String pbSet9,
			String ukwDSet0,String ukwDSet1,String ukwDSet2,String ukwDSet3,String ukwDSet4,String ukwDSet5,
			String ukwDSet6,String ukwDSet7,String ukwDSet8,String ukwDSet9,String ukwDSet10,String ukwDSet11
			,boolean hasUKWD){
		this.rflctrSet=refType;
		tRtrSet= new int[]{tRotorType,tRotorStart,tRotorRing};
		lRtrSet= new int[]{lRotorType,lRotorStart,lRotorRing};
		mRtrSet= new int[]{mRotorType,mRotorStart,mRotorRing};
		rRtrSet= new int[]{rRotorType,rRotorStart,rRotorRing};
		pbSet=(pbSet0+pbSet1+pbSet2+pbSet3+pbSet4+pbSet5+pbSet6+pbSet7+pbSet8+pbSet9);
		ukwDSet=(ukwDSet0+ukwDSet1+ukwDSet2+ukwDSet3+ukwDSet4+ukwDSet5+ukwDSet6+ukwDSet7+
				ukwDSet8+ukwDSet9+ukwDSet10+ukwDSet11);
		this.hasUKWD=hasUKWD;
		this.hasThin=!(hasUKWD);

		switch(enigmaType){		
		case 0:
			if(this.hasUKWD) {
				enigma=new WehrmachtEnigmaI(rRtrSet,mRtrSet,lRtrSet,
						 ukwDSet, pbSet);
			}else{
				enigma=new WehrmachtEnigmaI(rRtrSet,mRtrSet,lRtrSet,
						 rflctrSet, pbSet);
			}
			break;
		case 1:
			if(this.hasUKWD) {
				enigma=new KriegsmarineEnigmaM3(rRtrSet,mRtrSet,lRtrSet,
						 ukwDSet, pbSet);
			}else{
				enigma=new KriegsmarineEnigmaM3(rRtrSet,mRtrSet,lRtrSet,
						 rflctrSet, pbSet);
			}
			break;
		case 2:
			if(this.hasUKWD) {
				enigma =new KriegsmarineEnigmaM4(rRtrSet,mRtrSet,lRtrSet,ukwDSet,pbSet);
			}else if(this.hasThin) {
				enigma =new KriegsmarineEnigmaM4(rRtrSet,mRtrSet,lRtrSet,tRtrSet,
						rflctrSet,pbSet);
			}
			break;
		default:
			System.out.println("enigmaTypeの値が不正");
			break;

		}
	}
	public String executeEnigma(String s) {
		s=enigma.input(s);
		return s;
	}
	
	public boolean isHasUKWD() {
		return hasUKWD;
	}

	public void setHasUKWD(boolean hasUKWD) {
		this.hasUKWD = hasUKWD;
	}

	public boolean isHasThin() {
		return hasThin;
	}

	public void setHasThin(boolean hasThin) {
		this.hasThin = hasThin;
	}
}