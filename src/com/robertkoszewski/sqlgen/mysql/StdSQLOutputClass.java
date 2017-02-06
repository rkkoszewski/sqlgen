package com.robertkoszewski.sqlgen.mysql;

public class StdSQLOutputClass {
	private SQLQuery query;
	
	@Override
	public String toString(){
		return query.sql;
	}
}
