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
	//�ù��췽������ͼ�ν��洫��������
	public StuUpdateHandler(String sno, String sname, String ssex, String sage, String sdept, String classNo){
		this.sno=sno; 
		this.sname=sname; 
		this.ssex=ssex; 
		this.sage=sage; 
		this.sdept=sdept; 
		this.classNo=classNo;
	}
	//�ù��췽������ͼ�ν��洫��������
	public StuUpdateHandler(String[] str){ 
		sno=str[0]; 
		sname=str[1]; 
		ssex=str[2]; 
		sage=str[3]; 
		sdept=str[4]; 
		classNo=str[5];
	}
	/* StuUpdateHandler��ĳ�Ա�����͹��췽����StuAddHandler����ͬ���ڴ�ʡ��*/
	//���ѧ����Ϣ�ĸ�������
	public int updateStu(){
		sql="update student set Sname=' "+sname+" ', Ssex= ��"+ssex+"', Sage='"+sage+"', Sdept='"+sdept+"', classNo='"+classNo+"'where Sno='"+sno+"'"; 
		int i=BaseDao.executeUpdate (sql); 
		return i;
	}
}
