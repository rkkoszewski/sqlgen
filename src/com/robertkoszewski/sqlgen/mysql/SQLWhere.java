package com.robertkoszewski.sqlgen.mysql;

import com.robertkoszewski.sqlgen.DataFilter;
import com.robertkoszewski.sqlgen.Filter;
import com.robertkoszewski.sqlgen.Where;

public class SQLWhere implements Where{
	
	private SQLQuery query;
	
	public SQLWhere(SQLQuery query){
		this.query = query;
	};

	@Override
	public SQLGroupBy where(String condition) {
		query.sql += " WHERE "+condition;
		return new SQLGroupBy(query);
	}
	
	@Override
	public SQLHaving group_by(String column_name) {
		query.sql += " GROUP BY "+column_name;
		return new SQLHaving(query);
	}
	
	@Override
	public String toSQL(){
		return query.sql;
	}
	
	@Override
	public String toString(){
		return query.sql;
	}

	@Override
	public Filter filter(DataFilter... filters) {
		return new SQLFilter(query, filters);
	}

}
