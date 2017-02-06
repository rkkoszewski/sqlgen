package com.robertkoszewski.sqlgen;

/**
 * From Interface
 * @author Robert Koszewski
 */
public interface From {
	public Where from(String table);
	public Where from(String[] tables);
}
