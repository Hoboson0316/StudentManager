package model;
import java.sql.*;
import java.util.*;

public class ScDao {
	public static Sc getSc(String stu_no,String cou_no) {
		String sql="select*from student,course where Sno='"+stu_no+"',Cno='"+cou_no+"'" ;
		ResultSet rs=BaseDao. executeQuery(sql) ;
		Sc sc=null;
		try{
	        if (rs.next()) {
	        	sc=new Sc();
	        	sc.setStu_no(rs.getString("Sno"));
	        	sc.setcou_no(rs.getString("Cno"));
	        	sc.setSc_Grade(rs.getInt("Grade"));
	        }
		}catch(Exception e){
				e.printStackTrace();
		}BaseDao.close();
		  return sc;
	}
	
	public static ArrayList getScList(String sql) {
		ArrayList list=new ArrayList();
		ResultSet rs=BaseDao.executeQuery(sql);
		Sc sc=null;
		try {
			while(rs.next()) {
				sc=new Sc();
	        	sc.setStu_no(rs.getString("Sno"));
	        	sc.setcou_no(rs.getString("Cno"));
	        	sc.setSc_Grade(rs.getInt("Grade"));
	        	list.add(sc);
			}
			
		}catch (Exception  e) {
	         e.printStackTrace();
		}BaseDao.close();
             return list;
	}
}
