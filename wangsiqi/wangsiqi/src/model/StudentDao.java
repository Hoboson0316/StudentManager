package model;

import java.sql.*; 
import java.util.*;
public class StudentDao {
	//根据从控制类得来的sno，执行查找操作，并包装成学生对象 
	public static student getStudent(String stu_no){
	String sql="select*from student where Sno='"+stu_no+"'";
	ResultSet rs=BaseDao.executeQuery(sql);
	student student=null;
	try {	
		//将查找结果包装成学生对象student
		if(rs.next()){
			student=new student();
			student.setStu_no(rs.getString ("Sno"));
			student.setStu_name(rs.getString("Sname"));
			student.setStu_sex(rs.getString("Ssex").charAt(0));
			student.setStu_age(rs.getByte("Sage"));
			student.setstu_dept (rs.getString ("Sdept"));
			student.setStu_classNo(rs.getString("ClassNo")); 
			}
	}catch(Exception e){
		e.printStackTrace();
	}
	BaseDao.close();
	return student;
	}
	//根据从控制类得来的SQL，执行查找操作，并包装成ArmyList类型对象list
	public static ArrayList getStudentList(String sql){ 
		ArrayList list=new ArrayList();
		ResultSet rs=BaseDao.executeQuery(sql);
		student student=null;
		try{
			while (rs.next()){
				student=new student();
				student.setStu_no(rs.getString ("Sno")); 
				student.setStu_name(rs.getString("Sname")); 
				student.setStu_sex (rs.getString ("Ssex") . charAt (0)); 
				student.setStu_age(rs.getByte("Sage")); 
				student.setstu_dept(rs.getString("Sdept")); 
				student.setStu_classNo (rs .getString ("ClassNo"));
				list.add(student);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		BaseDao.close(); 
		return list;
	}

}
