package com.robertkoszewski.sqlgen;

/**
 * Group By Interface
 * @author Robert Koszewski
 */
public interface GroupBy {
	public Having group_by(String column_name);
	public String toString();
}
