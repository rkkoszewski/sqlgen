package com.robertkoszewski.sqlgen.mysql;

import com.robertkoszewski.sqlgen.Code;
import com.robertkoszewski.sqlgen.Values;

public class SQLValues implements Values {
	
	private SQLQuery query;
	
	public SQLValues(SQLQuery query){
		this.query = query;
	};
/*
	@Override
	public String values(Object value) {
		query.sql += "VALUES (";
		if(int.class.isInstance(value) || Integer.class.isInstance(value))
			query.sql += value + ")";
		else
			query.sql += "\"" + value + "\")";
		return query.sql;
	}*/

	@Override
	public String values(Object... values) {
		query.sql += "VALUES (";
		for(Object value : values){
			if(int.class.isInstance(value) || Integer.class.isInstance(value)) // Integer
				query.sql += value + ",";
			else if(Code.class.isInstance(value)) // Unwrapped SQL Code
				query.sql += ((Code)value).getCode() + ",";
			else // String
				query.sql += "\"" + value + "\",";
		}
		return query.sql.substring(0,query.sql.length()-1) + ");";
	}

	@Override
	public String toString(){
		return query.sql;
	}
}
