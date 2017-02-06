package com.robertkoszewski.sqlgen;

/**
 * Into Interface
 * @author Robert Koszewski
 */
public interface Into {
	public Values into(String table);
	//public Values into(String table, String column);
	public Values into(String table, String... columns);
}
