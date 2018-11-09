package Controller;
import java.util.ArrayList;
import model.*;

public class StuQueryHandler {
	String sql;
	String sno;
	String sname;
	String ssex;
	String sage;
	String sdept;
	String classNo;
	Object[][] results; 
	public StuQueryHandler() { 
		super();
		}
	//用构造方法接受图形界面传来的学号sno 
	public StuQueryHandler(String sno){ 
		this.sno=sno;
		}
		//由学号sno包装成SQL,然后交给StudentDao类执行査询数据库操作 
		public student query(String sno){
			student student=null;
			if(sno!=null && sno.length()>0){
				sql="select*from student where Sno like'"+sno+"%'";
				student=StudentDao.getStudent(sno);
				}
			return student;
			}
		//查询一个学生或所有学生信息，并将查询结果包装成Object[][]返回界面
		public Object[][] query(){
			if(sno!=null && sno.length()>0){
				sql="select*from student where Sno like'"+sno+"%'";
			}
			else
				sql="select*from student";
			results=getResult(StudentDao. getStudentList(sql)); 
			return results;
			}
		//将查询结果包装成Object [][]类型数据的实现代码
		private Object[][] getResult(ArrayList list){
			Object [][] resu=new Object[list.size ()] [6]; 
			for(int i=0; i<list.size();i++){
				student student=(student)list.get (i);
				resu[i][0]=student.getStu_no(); 
				resu[i][1]=student.getStu_name(); 
				resu[i][2]=student.getStu_sex(); 
				resu[i][3]=student.getStu_age(); 
				resu[i][4]=student.getStu_dept(); 
				resu[i][5]=student.getStu_classNo();
			}
			return resu;
			}
	}
