package model;

public class student {

	private String stu_no; 
	private String stu_name; 
	private char stu_sex; 
	private byte stu_age; 
	private String stu_dept; 
	private String stu_classNo;
	
	public student(String stu_no, String stu_name, char stu_sex, byte stu_age, String stu_dept, String stu_classNo){ 
		this.stu_no=stu_no; 
		this.stu_name=stu_name;
		this.stu_sex=stu_sex; 
		this.stu_age=stu_age; 
		this.stu_dept=stu_dept; 
		this.stu_classNo=stu_classNo;
	}
	public student(){
		super();
	}
	
	public String getStu_no(){ 
		return stu_no;
	}
	public void setStu_no(String stu_no){ 
		this.stu_no=stu_no;
	}
	public String getStu_name(){ 
		return stu_name;
	}
	public void setStu_name(String stu_name){ 
		this.stu_name=stu_name;
	}
	public byte getStu_age(){ 
		return stu_age;
	}
	public void setStu_age(byte stu_age){ 
		this.stu_age=stu_age;
	}
	public char getStu_sex(){ 
		return stu_sex;
	}
	public void setStu_sex(char stu_sex){ 
		this.stu_sex=stu_sex;
	}
	public String getStu_dept(){ 
		return stu_dept;
	}
	public void setstu_dept(String stu_dept){ 
		this.stu_dept=stu_dept;
	}
	public String getStu_classNo(){ 
		return stu_classNo;
	}
	public void setStu_classNo(String stu_classNo){ 
		this.stu_classNo=stu_classNo;
	}
}

