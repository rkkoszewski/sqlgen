# SQLGen - A quick and dirty SQL Query generator for Java.

This is a small set of Java classes I developed for a University project in 2015 to speedup the prototyping of simple MySQL queries.

Main goals of this library:
- Allow to use directly a MySQL like OO syntax in Java without having to manually write SQL queries as a String and having to manually escape all parameters, which just looks ugly and clutters up the source code and only leads to forget escape something or do some mistake.
- Due to its OO nature it takes full advantage of current modern IDE code autocompletition feature speeding up development.
- It is interface based, and the query implementation can be customized to support similar SQL languages like PostgreSQL or MSSQL, etc. This way if required it is possible to change the implementation of SQLGen without having to rewrite all the queries in the app.
- Just be simple, small and easier to use than other alternatives like QueryDSL or jOOQ.

PLEASE NOTE: As of now this project is in a working state but should be considered to be in a alpha-stage. 

Examples:

	// Simple Select
	System.out.println(new SQLQuery().select("user", "password").from("users"));
	// Result: SELECT user, password FROM users

	// Group By
	System.out.println(new SQLQuery().select("group", "count(group)").from("users").group_by("group"));
	// Result: SELECT group, count(group) FROM users GROUP BY group
	
	// Simple Insert
	System.out.println(new SQLQuery().insert().into("users","user","password").values("johndoe","1234"));
	// Result: INSERT INTO users (user, password) VALUES ("johndoe","1234");
	
	// Simple Delete (RAW WHERE statement)
	System.out.println(new SQLQuery().delete().from("users").where("uid=1"));
	// Result: DELETE FROM users WHERE uid=1
	
	// Simple Delete (Filtered WHERE statement)
	System.out.println(new SQLQuery().delete().from("users").filter(new DataFilter("name","John")));
	// Result: DELETE FROM users WHERE name LIKE "%John%"
	
	// Interface based Query
	Query q = new SQLQuery(); // Could be replaced by a Factory Class
	System.out.println(q.select("user", "password").from("users"));
	// Result: SELECT user, password FROM users
		