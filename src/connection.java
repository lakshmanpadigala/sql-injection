import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {
	public Connection c;  // used to set up connection with mysql
	public Statement st;
    public connection() {
    	 
		try {
           Class.forName("com.mysql.cj.jdbc.Driver"); // Load mysql jdbc driver
           c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?allowMultiQueries=true","lakshman","1406");
           st = c.createStatement(); // helpful to execute query
       } catch(Exception e) {
           e.printStackTrace();
       }
    }
}
