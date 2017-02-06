package com.robertkoszewski.sqlgen.mysql;

import com.robertkoszewski.sqlgen.Set;
import com.robertkoszewski.sqlgen.Where;

public class SQLSet implements Set {
	private SQLQuery query;
	
	public SQLSet(SQLQuery query){
		this.query = query;
	};

	@Override
	public Where set(String... column_values) {
		query.sql += " SET ";
		
		for(String column_value: column_values)
			query.sql += column_value+", ";
		query.sql = query.sql.substring(0, query.sql.length()-2); // Remove last ", "
		
		return new SQLWhere(query);
	}

}
