package model;
import java.sql.*;
import java.util.*;

public class UserDao {
	public static user getUser(String User_id) {
		String sql="select*from User where id='"+User_id+"'" ;
		ResultSet rs=BaseDao. executeQuery(sql) ;
		user user=null;
		try{
			if (rs.next()) {
	        	user=new user();
	        	user.setUser_id(rs.getInt("id"));
	        	user.setUser_name(rs.getString("name"));
	        	user.setUser_pass(rs.getString("pass"));
	        	user.setUser_Type(rs.getString("userType"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}BaseDao.close();
		  return user;
	}
		public static ArrayList getUserList(String sql) {
			ArrayList list=new ArrayList();
			ResultSet rs=BaseDao.executeQuery(sql);
			user user=null;
			try {
				while(rs.next()) {
					user=new user();
					user.setUser_id(rs.getInt("id"));
		        	user.setUser_name(rs.getString("name"));
		        	user.setUser_pass(rs.getString("pass"));
		        	user.setUser_Type(rs.getString("userType"));
		        	list.add(user);
				}
				
				}catch (Exception  e) {
			         e.printStackTrace();
				}BaseDao.close();
	             return list;	         
			}
}
