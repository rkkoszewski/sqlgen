package com.robertkoszewski.sqlgen.utils;

public class SQLTools {
	
	/**
	 * A very minimalistic escapeString method (Not production ready)
	 */
	public static String escapeString(String sql){
		return sql.replaceAll("\"", "\\\\\"");
	}
}
