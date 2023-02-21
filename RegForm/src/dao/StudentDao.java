package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.connection.DbConnection;

import Beans.Student;


public class StudentDao  extends DbConnection{
	public int save(Student s) throws Exception {
		Connection con=getConnection();
        int idNum=1;
        PreparedStatement ps=con.prepareStatement("select max(id) as id from student.student");
        ResultSet rs= ps.executeQuery();
        if(rs!=null && rs.next()) {
        	idNum=rs.getInt("id");
        	idNum=idNum+1;
        }
         ps=con.prepareStatement("insert into student.student values(?,?,?,?,?,?)");
        ps.setInt(1,idNum);
        ps.setString(2,s.getFirst_name());
        ps.setString(3, s.getLast_name());
        ps.setString(4, s.getDob());
        ps.setString(5, s.getCity());
        ps.setString(6, s.getPassword());
        int i=ps.executeUpdate();
        con.close();
        return i;    
	}
	
	public ResultSet find(int Id)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from student where id=?");
        ps.setInt(1,Id);
       ResultSet rs= ps.executeQuery();
       System.out.print("DAO");
       return rs;
     
	}
	
	public ResultSet findAll(int start , int total)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from student limit "+(start-1)+","+total);	
       ResultSet rs= ps.executeQuery();
       System.out.print("DAO");
       return  rs;	
    }
	
	
	public ResultSet findAll()throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from student ");	
       ResultSet rs= ps.executeQuery();
       System.out.print("DAO");
       return  rs;	
    }
 
	
	public boolean update(Student s)throws Exception {
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("update student set first_name=?,last_name=?,dob=?,city=?,password=? where id=?");
        ps.setString(1, s.getFirst_name());
        ps.setString(2, s.getLast_name());
        ps.setString(3, s.getDob());
        ps.setString(4, s.getCity());
        ps.setString(5, s.getPassword());
        ps.setInt(6, s.getId());
        int i=ps.executeUpdate();
        con.close();
        if(i!=0)
        	return true;
        else
        	return false;
	}
	
	public boolean delete(Student s)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("delete from Student  where id=?");
        ps.setInt(1,s.getId());
        int i=ps.executeUpdate();
        con.close();
        if(i!=0)
        	return true;
        else
        	return false;
	}
	
	public ResultSet findempcrud(Student s)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from Student where id=? or first_name=?");
        ps.setInt(1,s.getId());
        ps.setString(2,s.getFirst_name());
       ResultSet rs= ps.executeQuery();
       System.out.print("DAO");
       return rs;
     
	}
}
