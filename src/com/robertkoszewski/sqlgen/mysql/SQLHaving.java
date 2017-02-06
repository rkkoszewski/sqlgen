package com.robertkoszewski.sqlgen.mysql;

import com.robertkoszewski.sqlgen.Having;

public class SQLHaving implements Having {
	
	private SQLQuery query;
	
	public SQLHaving(SQLQuery query){
		this.query = query;
	};

	@Override
	public String having(String condition) {
		return query.sql + " HAVING " + condition;
	}
	
	@Override
	public String toString(){
		return query.sql;
	}
}
