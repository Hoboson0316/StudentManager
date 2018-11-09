package model;
import java.sql.*;
import java.util.*;

public class CourseDao {
	public static course getCourse(String cou_no) {
		String sql="select*from course where Cno='"+cou_no+"'" ;
		ResultSet rs=BaseDao. executeQuery(sql) ;
		course course=null;
		try{
	        if (rs.next()) {
			     course=new course();
			     course.setCou_no(rs.getString("cno"));
			     course.setCou_name(rs.getString("cname"));
		         course.setCou_credit(rs.getString("Ccredit"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}BaseDao.close();
		  return course;
	}
	
	public static ArrayList getCourseList(String sql) {
		ArrayList list=new ArrayList();
		ResultSet rs=BaseDao.executeQuery(sql);
	    student course=null ;
	    try{
	    	while(rs.next()) {
	    		 course=new student();
			     course.setStu_no(rs.getString("sno"));
			     course.setStu_name(rs.getString("sname"));
		         course.setStu_age(rs.getByte("sage"));
		         course.setstu_dept(rs.getString("sdept"));
		         course.setStu_classNo(rs.getString("SclassNo"));
		         list.add(course);
	    	}
	    
	    }catch (Exception  e) {
	         e.printStackTrace();
	    }BaseDao.close();
             return list;
	}
}
