package model;

public class course {
	private String cou_no; 
	private String cou_name; 
	private String cou_credit; 
	
	public course(String cou_no, String cou_name, String cou_credit){ 
		this.cou_no=cou_no; 
		this.cou_name=cou_name;
		this.cou_credit=cou_credit; 
	}
	public course(){
		super();
	}
	
	public String getCou_no(){ 
		return cou_no;
	}
	public void setCou_no(String cou_no){ 
		this.cou_no=cou_no;
	}
	public String getCou_name(){ 
		return cou_name;
	}
	public void setCou_name(String cou_name){ 
		this.cou_name=cou_name;
	}
	public String getCou_credit(){ 
		return cou_credit;
	}
	public void setCou_credit(String cou_credit){ 
		this.cou_credit=cou_credit;
	}
}
