package com.robertkoszewski.sqlgen;

/**
 * Where Union Interface
 * @author Robert Koszewski
 */
public interface WhereUnion {
	public String where(String condition);
	public Where union(String querie);
	public Where union_all(String query);
	public Having group_by(String column_name);
	public String toString();
}
