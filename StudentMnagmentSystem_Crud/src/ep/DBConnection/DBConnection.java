package ep.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

public class DBConnection
{
	public static final String driver="oracle.jdbc.driver.OracleDriver";
	public static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	public static final String user="hr";
	public static final String password="hr";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);
		return con;
	}
	
	
}
