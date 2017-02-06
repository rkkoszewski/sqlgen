package com.robertkoszewski.sqlgen;

/**
 * Where Interface
 * @author Robert Koszewski
 */
public interface Where {
	public GroupBy where(String condition);
	public Having group_by(String column_name);
	public Filter filter(DataFilter... filter);
	public String toSQL();
}
