package Controller;
import model.BaseDao;

public class StuUpdateHandler {
	String sql;
	String sno;
	String sname;
	String ssex;
	String sage;
	String sdept;
	String classNo;
	public StuUpdateHandler(){ 
		super();
	}
	//用构造方法接受图形界面传来的数据
	public StuUpdateHandler(String sno, String sname, String ssex, String sage, String sdept, String classNo){
		this.sno=sno; 
		this.sname=sname; 
		this.ssex=ssex; 
		this.sage=sage; 
		this.sdept=sdept; 
		this.classNo=classNo;
	}
	//用构造方法接受图形界面传来的数据
	public StuUpdateHandler(String[] str){ 
		sno=str[0]; 
		sname=str[1]; 
		ssex=str[2]; 
		sage=str[3]; 
		sdept=str[4]; 
		classNo=str[5];
	}
	/* StuUpdateHandler类的成员变量和构造方法与StuAddHandler类相同，在此省略*/
	//完成学生信息的更新任务
	public int updateStu(){
		sql="update student set Sname=' "+sname+" ', Ssex= ’"+ssex+"', Sage='"+sage+"', Sdept='"+sdept+"', classNo='"+classNo+"'where Sno='"+sno+"'"; 
		int i=BaseDao.executeUpdate (sql); 
		return i;
	}
}
