package ep.PreparedStatments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ep.DBConnection.DBConnection;
import ep.StudentBean.StudentBean;

public class DAO 
{
	
	public int studentInsertion(StudentBean student) throws ClassNotFoundException, SQLException
	{
		Connection con=DBConnection.getConnection();
		String sql="insert into studentDetails values(?,?,?)";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1,student.getRegno());
		stmt.setString(2,student.getName());
		stmt.setString(3,student.getEmail());
		return stmt.executeUpdate();
	}
	public void studentDisplay() throws ClassNotFoundException, SQLException
	{
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		String sql="select * from studentdetails";
		ResultSet rslt=st.executeQuery(sql);
		System.out.println("Student details are");
		while(rslt.next())
		{
			System.out.println(rslt.getInt(1)+" "+rslt.getString(2)+" "+rslt.getString(3));
		}
		
		
	}
	public int studentDelete(int regno) throws ClassNotFoundException, SQLException
	{
		Connection con=DBConnection.getConnection();
		String sql="delete from studentdetails where REGNO="+regno;
		PreparedStatement stmt=con.prepareStatement(sql);
		return stmt.executeUpdate();
	}
	public int studentUpdate(int regno,String name) throws ClassNotFoundException, SQLException
	{
		String sql="update studentdetails set NAME = ? where REGNO = ?";
		Connection con=DBConnection.getConnection();
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,name);
		stmt.setInt(2, regno);
		return stmt.executeUpdate();
	}
	
}
