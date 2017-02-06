package com.robertkoszewski.sqlgen;

import com.robertkoszewski.sqlgen.mysql.SQLFrom;
import com.robertkoszewski.sqlgen.mysql.SQLInto;
import com.robertkoszewski.sqlgen.mysql.SQLSet;

/**
 * Robert's OO SQL Generator
 * @author Robert Koszewski
 */
public interface Query {
		public SQLFrom select(String... columns);
		public SQLInto insert();
		public SQLFrom delete();
		public SQLSet update(String table);
}
