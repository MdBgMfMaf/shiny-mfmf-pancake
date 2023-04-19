package com.gmail.tmorioka123;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnigmaDataManager {

	final String[]enigmaTypeByName= {"Enigma I","Enigma M3","Enigma M4"};
	final String[]rotorSetByName0= {"I","II","III","IV","V"};
	final String[]rotorSetByName1_2= {"I","II","III","IV","V","VI","VII","VIII"};
	final String[]alphabetsByletter = {"A","B","C","D","E","F","G","H","I","J",
			"K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	final String[]refSetByName= {"UKW-A","UKW-B","UKW-C","UKW-D","UKW-B(thin)","UKW-C(thin)"};
	public String[] getRefSetByName() {
		return refSetByName;
	}
	final String[]refSetByName0= {"UKW-A","UKW-B","UKW-C","UKW-D"};
	final String[]refSetByName1= {"UKW-B","UKW-C","UKW-D"};
	final String[]refSetByName2= {"UKW-D","UKW-B(thin)","UKW-C(thin)"};
	final String[]thinRSetByName= {" ","β","γ"};
	private boolean isUKWDValid =true;
	private boolean isPbValid=true;
	private boolean isRRvalid=true;
	private boolean hasUKWD=false;
	private boolean hasThin=false;


	public boolean checkIsPbSetValid(String pbSet0,String pbSet1,String pbSet2,String pbSet3,
			String pbSet4,String pbSet5,String pbSet6,String pbSet7,String pbSet8,String pbSet9) {
		String str=(pbSet0+pbSet1+pbSet2+pbSet3+pbSet4+pbSet5+pbSet6+pbSet7+pbSet8+pbSet9);
		if(str.length()==0) {
			this.setPbValid(true);
			return true;

		}
		char[]chars=str.toCharArray();
		List<Character>list=new ArrayList<>();
		for(char c:chars) {
			list.add(c);
		}
		for(int i=0;i<list.size();i++) {
			if(list.indexOf(list.get(i))!=(list.lastIndexOf(list.get(i)))){
				this.setPbValid(false);
				return false;
			}
		}
		this.setPbValid(true);
		return true; 
	}
	public boolean checkIsUKWDSetValid(String ukwDSet0,String ukwDSet1,String ukwDSet2,String ukwDSet3,String ukwDSet4,String ukwDSet5,
			String ukwDSet6,String ukwDSet7,String ukwDSet8,String ukwDSet9,String ukwDSet10,String ukwDSet11){
		String str=(ukwDSet0+ukwDSet1+ukwDSet2+ukwDSet3+ukwDSet4+ukwDSet5+ukwDSet6+ukwDSet7+
				ukwDSet8+ukwDSet9+ukwDSet10+ukwDSet11);
		if((str.length()==0)) {
			this.setUKWDValid(false);
			return false;
		}
		str=str.toUpperCase();
		char[]chars = str.toCharArray();
		List<Character>list=new ArrayList<>();
		for(char c:chars) {
			list.add(c);
		}
		for(int i=0;i<list.size();i++) {
			//重複してはならない。
			if(list.indexOf(list.get(i))!=(list.lastIndexOf(list.get(i)))){
				this.setUKWDValid(false);
				return false;
			}
			//JとYは固定されているので設定の対象に出来ない。
			if(list.get(i)=='J'||list.get(i)=='Y') {
				this.setUKWDValid(false);
				return false;

			}
		}
		this.setUKWDValid(true);
		return true;
	}
	public boolean checkisRRValid(int refType,int tRotorType) {
		if(0<tRotorType) {
			if((refType==4||refType==5)) {
				this.setRRvalid(true);
				return true;
			}else {
				this.setRRvalid(false);
				return false;
			}
		}else {
			if((refType==4||refType==5)) {
				this.setRRvalid(false);
				return false;
			}else {
				this.setRRvalid(true);
				return true;
			}
		}
	}
	public String[]setRandomUKWDSet(){
		List<String>letterList=new ArrayList<>();
		for(String s:alphabetsByletter) {
			if(s.equals("J")||s.equals("Y")) {
				continue;
			}
			letterList.add(s);
		}
		Collections.shuffle(letterList);
		String[]values=new String[] {"","","","","","","","","","","",""};
		for(int i=0,j=0;j<12;i++) {
			values[j]+=letterList.get(i);
			if(values[j].length()==2) {
				j++;
			}
		}
		return values;
	}
	public String[]setRandomPbSet(){
		List<String>letterList=new ArrayList<>();
		for(String s:alphabetsByletter) {
			letterList.add(String.valueOf(s));
		}
		Collections.shuffle(letterList);
		String[]values=new String[] {"","","","","","","","","",""};
		for(int i=0,j=0;j<10;i++) {
			values[j]+=letterList.get(i);
			if(values[j].length()==2) {
				j++;
			}
		}
		return values;
	}


	public  String[] getEnigmaTypesByName() {
		return enigmaTypeByName;
	}
	public  String[] getRotorSetByNameForI() {
		return rotorSetByName0;
	}
	public  String[] getRotorSetByNameForM() {
		return rotorSetByName1_2;
	}

	public  String[] getAlphabetsbyletter() {
		return alphabetsByletter;
	}

	public  String[] getRefsetByName0() {
		return refSetByName0;
	}
	public  String[] getRefsetByName1() {
		return refSetByName1;
	}
	public  String[] getRefsetByName2() {
		return refSetByName2;
	}
	public  String[] getThinrsetbyname() {
		return thinRSetByName;
	}
	public  String getSingleEnigmaTypeByName(int n) {
		String s =enigmaTypeByName[n]; 
		return s;
	}
	public  String getSingleRotorTypeByName(int n) {
		String s =rotorSetByName1_2[n]; 
		return s;
	}
	public String getSingleRefSetByName(int n) {
		return refSetByName[n];
	}
	public String getSingleTRotorTypeByName(int n) {
		String s =thinRSetByName[n];
		return s;
	}
	public String getAlphabets(int n) {
		String s =alphabetsByletter[n];
		return s;
	}
	public boolean isUKWDValid() {
		return isUKWDValid;
	}
	public void setUKWDValid(boolean isUKWDValid) {
		this.isUKWDValid = isUKWDValid;
	}
	public boolean isPbValid() {
		return isPbValid;
	}
	public void setPbValid(boolean isPbValid) {
		this.isPbValid = isPbValid;
	}
	public boolean isRRvalid() {
		return isRRvalid;
	}
	public void setRRvalid(boolean isRRvalid) {
		this.isRRvalid = isRRvalid;
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
	public boolean isNotHasBothUKWDandThin() {
		if(hasThin&&hasUKWD) {
			return false;
		}
		return true;
	}
	public void checkAndValidateAllSetting(PbSetting pbSet,RRTypeSetting rrTSet,
			RRSetting rrSet,UKWDSetting dSet) {
		if(rrTSet.getRefType()==3) {
			this.setHasUKWD(true);
		}else {
			this.setHasUKWD(false);
		}
		if(((rrTSet.getRefType()==4)||(rrTSet.getRefType()==5)||(0!=rrTSet.gettRotorType()))) {
			this.setHasThin(true);
		}else {
			this.setHasThin(false);
		}
		this.setRRvalid(this.checkisRRValid(rrTSet.getRefType(),rrTSet.gettRotorType()));
		this.setPbValid(this.checkIsPbSetValid(pbSet.getPbSet0(),pbSet.getPbSet1(),pbSet.getPbSet2(),pbSet.getPbSet3(),
				pbSet.getPbSet4(),pbSet.getPbSet5(),pbSet.getPbSet6(),pbSet.getPbSet7(),pbSet.getPbSet8()
				,pbSet.getPbSet9()));
		this.setUKWDValid(this.checkIsUKWDSetValid(dSet.getUkwDSet0(),dSet.getUkwDSet1(),dSet.getUkwDSet2(),dSet.getUkwDSet3(),
				dSet.getUkwDSet4(),dSet.getUkwDSet5(),dSet.getUkwDSet6(),dSet.getUkwDSet7(),
				dSet.getUkwDSet8(),	dSet.getUkwDSet9(),dSet.getUkwDSet10(),dSet.getUkwDSet11()));
	}
}
