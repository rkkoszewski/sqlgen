package com.robertkoszewski.sqlgen.mysql;

import com.robertkoszewski.sqlgen.Into;

public class SQLInto implements Into {

	private SQLQuery query;
	
	public SQLInto(SQLQuery query){
		this.query = query;
	};

	@Override
	public SQLValues into(String table) {
		query.sql += " INTO "+table;
		return new SQLValues(query);
	}

	/*
	@Override
	public SQLValues into(String table, String column) {
		query.sql += " INTO "+table+" ("+column+")";
		return new SQLValues(query);
	}*/

	@Override
	public SQLValues into(String table, String... columns) {
		query.sql += " INTO "+table+" (";
		for(String column: columns)
			query.sql += column + ", ";
		query.sql = query.sql.substring(0, query.sql.length()-2)+") "; // Remove last ", "
		return new SQLValues(query);
	}
	
	@Override
	public String toString(){
		return query.sql;
	}
}
