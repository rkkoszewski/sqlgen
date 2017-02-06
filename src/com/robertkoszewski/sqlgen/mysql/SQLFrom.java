package com.robertkoszewski.sqlgen.mysql;

import com.robertkoszewski.sqlgen.From;
import com.robertkoszewski.sqlgen.Where;

public class SQLFrom implements From {
	private SQLQuery query;
	
	public SQLFrom(SQLQuery query){
		this.query = query;
	};

	@Override
	public Where from(String table) {
		this.query.sql += " FROM "+table;
		return new SQLWhere(query);
	}

	@Override
	public Where from(String[] tables) {
		query.sql += " FROM";
		for(String table: tables)
			query.sql += " "+table+",";
		query.sql = query.sql.substring(0, query.sql.length()-1); // Removes last ","
		return new SQLWhere(query);
	}
	
	@Override
	public String toString(){
		return query.sql;
	}
}
