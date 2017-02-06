package com.robertkoszewski.sqlgen.mysql;

import com.robertkoszewski.sqlgen.Having;
import com.robertkoszewski.sqlgen.Where;
import com.robertkoszewski.sqlgen.WhereUnion;

public class SQLWhereUnion implements WhereUnion {
	
	private SQLQuery query;
	
	public SQLWhereUnion(SQLQuery query){
		this.query = query;
	};

	@Override
	public String where(String condition) {
		return query.sql+" WHERE "+condition;
	}

	@Override
	public Where union(String second_query) {
		query.sql += " UNION "+second_query;
		return new SQLWhere(query);
	}
	
	@Override
	public Where union_all(String second_query) {
		query.sql += " UNION ALL "+second_query;
		return new SQLWhere(query);
	}
	
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
