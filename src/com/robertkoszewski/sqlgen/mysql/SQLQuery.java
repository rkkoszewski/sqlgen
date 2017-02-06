package com.robertkoszewski.sqlgen.mysql;

import com.robertkoszewski.sqlgen.Query;

/**
 * Robert's OO SQL Generator
 * @author Robert Koszewski
 */
public class SQLQuery implements Query{
	// SQL Reference: http://www.w3schools.com/sql/sql_quickref.asp
	String sql;

	// SELECT
	public SQLFrom select(String... columns){
		if(columns.length==0){
			sql = "SELECT *";
			return new SQLFrom(this);
			
		}else if(columns.length==1){
			sql = "SELECT "+columns[0];
			return new SQLFrom(this);
			
		}else{
			sql = "SELECT ";
			for(String column: columns)
				sql += column+", ";
			sql = sql.substring(0, sql.length()-2); // Remove last ", "
			return new SQLFrom(this);
		}
	};
	
	// INSERT
	public SQLInto insert(){
		sql = "INSERT";
		return new SQLInto(this);
	};

	// DELETE
	public SQLFrom delete(){
		sql = "DELETE";
		return new SQLFrom(this);
	};
	
	public SQLSet update(String table){
		sql = "UPDATE "+table;
		return new SQLSet(this);
	};
	
	@Override
	public String toString(){
		return sql;
	}
}
