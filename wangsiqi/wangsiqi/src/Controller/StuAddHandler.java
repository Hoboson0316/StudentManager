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
	//�ù��췽������ͼ�ν��洫��������
	public StuAddHandler (String sno, String sname, String ssex, String sage, String sdept, String classNo){
		this.sno=sno; 
		this.sname=sname; 
		this.ssex=ssex; 
		this.sage=sage; 
		this.sdept=sdept; 
		this.classNo=classNo;
	}
	//�ù��췽������ͼ�ν��洫��������
	public StuAddHandler(String[] str){ 
		sno=str[0]; 
		sname=str[1]; 
		ssex=str[2]; 
		sage=str[3]; 
		sdept=str[4]; 
		classNo=str[5];
	}
	//��ͼ�ν�������ݰ�װ��SQL��Ȼ�󽻸�BaseDao��ִ�в�ѯ���ݿ���� 
	public int addStu(){
		sql="insert into student (sno,sname,ssex,sage,sdept,classNo) values('" +sno+" ','"+sname+"','" +ssex+" ',' "+sage+",'"+sdept+"','"+classNo+" ')";
	//����װ��SQL����BaseDao.executet/pc/ate������ɲ�ѯ����
		int i=BaseDao.executeUpdate(sql); 
		return i;
	}
}
