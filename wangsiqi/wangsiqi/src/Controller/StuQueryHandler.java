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
	//�ù��췽������ͼ�ν��洫����ѧ��sno 
	public StuQueryHandler(String sno){ 
		this.sno=sno;
		}
		//��ѧ��sno��װ��SQL,Ȼ�󽻸�StudentDao��ִ�Ж�ѯ���ݿ���� 
		public student query(String sno){
			student student=null;
			if(sno!=null && sno.length()>0){
				sql="select*from student where Sno like'"+sno+"%'";
				student=StudentDao.getStudent(sno);
				}
			return student;
			}
		//��ѯһ��ѧ��������ѧ����Ϣ��������ѯ�����װ��Object[][]���ؽ���
		public Object[][] query(){
			if(sno!=null && sno.length()>0){
				sql="select*from student where Sno like'"+sno+"%'";
			}
			else
				sql="select*from student";
			results=getResult(StudentDao. getStudentList(sql)); 
			return results;
			}
		//����ѯ�����װ��Object [][]�������ݵ�ʵ�ִ���
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
