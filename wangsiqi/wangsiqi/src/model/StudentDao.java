package model;

import java.sql.*; 
import java.util.*;
public class StudentDao {
	//���ݴӿ����������sno��ִ�в��Ҳ���������װ��ѧ������ 
	public static student getStudent(String stu_no){
	String sql="select*from student where Sno='"+stu_no+"'";
	ResultSet rs=BaseDao.executeQuery(sql);
	student student=null;
	try {	
		//�����ҽ����װ��ѧ������student
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
	//���ݴӿ����������SQL��ִ�в��Ҳ���������װ��ArmyList���Ͷ���list
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
