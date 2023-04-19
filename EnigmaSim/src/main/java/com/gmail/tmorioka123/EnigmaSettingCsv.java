package com.gmail.tmorioka123;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;


@JsonPropertyOrder({"rRtrType0","mRtrType0","lRtrType0","refType0","tRtrType0",
	"rRtrType1","mRtrType1","lRtrType1","refType1","tRtrType1",
	"rRtrType2","mRtrType2","lRtrType2","refType2","tRtrType2",
	"rRtrStart","rRtrRing","mRtrStart","mRtrRing","lRtrStart","lRtrRing",
	"tRtrStart","tRtrRing","pbSet","ukwDSet"})
@AllArgsConstructor
@Data
public class EnigmaSettingCsv {
	@JsonProperty("rRtrType0")
	private int rRtrType0;
	@JsonProperty("mRtrType0")
	private int mRtrType0;
	@JsonProperty("lRtrType0")
	private int lRtrType0;
	@JsonProperty("refType0")
	private int refType0;
	@JsonProperty("tRtrType0")
	private int tRtrType0;
	@JsonProperty("rRtrType1")
	private int rRtrType1;
	@JsonProperty("mRtrType1")
	private int mRtrType1;
	@JsonProperty("lRtrType1")
	private int lRtrType1;
	@JsonProperty("refType1")
	private int refType1;
	@JsonProperty("tRtrType1")
	private int tRtrType1;
	@JsonProperty("rRtrType2")
	private int rRtrType2;
	@JsonProperty("mRtrType2")
	private int mRtrType2;
	@JsonProperty("lRtrType2")
	private int lRtrType2;
	@JsonProperty("refType2")
	private int refType2;
	@JsonProperty("tRtrType2")
	private int tRtrType2;
	@JsonProperty("rRtrStart")
	private int rRotorStart;
	@JsonProperty("rRtrRing")
	private int rRotorRing;
	@JsonProperty("mRtrStart")
	private int mRotorStart;
	@JsonProperty("mRtrRing")
	private int mRotorRing;
	@JsonProperty("lRtrStart")
	private int lRotorStart;
	@JsonProperty("lRtrRing")
	private int lRotorRing;
	@JsonProperty("tRtrStart")
	private int tRotorStart;
	@JsonProperty("tRtrRing")
	private int tRotorRing;
	@JsonProperty("pbSet")
	private String pbSet;
	@JsonProperty("ukwDSet")
	private String ukwDSet;
}
