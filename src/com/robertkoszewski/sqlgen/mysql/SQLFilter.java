package com.robertkoszewski.sqlgen.mysql;

import com.robertkoszewski.sqlgen.DataFilter;
import com.robertkoszewski.sqlgen.Filter;
import com.robertkoszewski.sqlgen.utils.SQLTools;

public class SQLFilter implements Filter{

	private SQLQuery query;
	
	public SQLFilter(SQLQuery query, DataFilter[] filters){
		this.query = query;
		
		if(filters!=null && filters.length!=0){
			this.query.sql += " WHERE ";
			
			String value;
			String uid;
			boolean first = true;
			for(DataFilter filter: filters){
				// Is first?
				if(first){
					first = false;
				}else{
					query.sql += " AND ";
				}
				
				uid = filter.getUid();
				value = filter.getValue();
				if(value.length()>=2){
					if(value.charAt(0)=='>' || value.charAt(0)=='<' || value.charAt(0)=='='){	
						query.sql += uid+" "+value.charAt(0)+" \""+SQLTools.escapeString(value.substring(1).trim())+"\"";
					}else{
						query.sql += uid+" LIKE \"%"+SQLTools.escapeString(value)+"%\"";
					}
				}else{
					query.sql += uid+" LIKE \"%"+SQLTools.escapeString(value)+"%\"";
				}
			}
		}
	};

	@Override
	public String getSQLString() {
		return query.sql;
	}
	
	@Override
	public String toString(){
		return query.sql;
	}

}
