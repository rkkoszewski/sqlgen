package com.robertkoszewski.sqlgen;

/**
 * Data Filter Class
 * @author Robert Koszewski
 */
public class DataFilter {
	private String uid;
	private String value;
	
	public DataFilter(String uid, String value){
		this.uid = uid;
		this.value = value;
	}
	
	public String getUid(){
		return this.uid;
	}
	
	public String getValue(){
		return this.value;
	}
}
