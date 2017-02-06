package com.robertkoszewski.sqlgen.mysql;

import com.robertkoszewski.sqlgen.GroupBy;
import com.robertkoszewski.sqlgen.Having;

public class SQLGroupBy implements GroupBy {
	
	private SQLQuery query;
	
	public SQLGroupBy(SQLQuery query){
		this.query = query;
	};

	@Override
	public Having group_by(String column_name) {
		query.sql += " GROUP BY "+column_name;
		return new SQLHaving(query);
	}
	
	@Override
	public String toString(){
		return query.sql;
	}
}
