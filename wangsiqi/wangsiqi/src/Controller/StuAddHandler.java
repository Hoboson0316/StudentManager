package Controller;

import model.BaseDao; 
public class StuAddHandler {
	String sql;
	String sno;
	String sname;
	String ssex;
	String sage;
	String sdept;
	String classNo;
	public StuAddHandler(){ 
		super();
	}
	//用构造方法接受图形界面传来的数据
	public StuAddHandler (String sno, String sname, String ssex, String sage, String sdept, String classNo){
		this.sno=sno; 
		this.sname=sname; 
		this.ssex=ssex; 
		this.sage=sage; 
		this.sdept=sdept; 
		this.classNo=classNo;
	}
	//用构造方法接受图形界面传来的数据
	public StuAddHandler(String[] str){ 
		sno=str[0]; 
		sname=str[1]; 
		ssex=str[2]; 
		sage=str[3]; 
		sdept=str[4]; 
		classNo=str[5];
	}
	//将图形界面的数据包装成SQL，然后交给BaseDao类执行查询数据库操作 
	public int addStu(){
		sql="insert into student (sno,sname,ssex,sage,sdept,classNo) values('" +sno+" ','"+sname+"','" +ssex+" ',' "+sage+",'"+sdept+"','"+classNo+" ')";
	//将包装的SQL调用BaseDao.executet/pc/ate方法完成查询任务
		int i=BaseDao.executeUpdate(sql); 
		return i;
	}
}
