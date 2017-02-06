import com.robertkoszewski.sqlgen.DataFilter;
import com.robertkoszewski.sqlgen.Query;
import com.robertkoszewski.sqlgen.mysql.SQLQuery;

public class Examples {

	public static void main(String[] args) {

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
		
	}

}
