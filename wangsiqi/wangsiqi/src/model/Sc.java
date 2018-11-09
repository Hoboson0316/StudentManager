package model;

public class Sc {
	 private String Stu_no;
	 private String cou_no;
	 private int Sc_Grade;
	 
	 public Sc(String Stu_no,String cou_no,int Sc_Grade) {
		 this.Stu_no=Stu_no;
		 this.cou_no=cou_no;
		 this.Sc_Grade=Sc_Grade; 
	 }
	 public Sc(){
		 super();
	 }
	 
	 public String getStu_no() {
		 return Stu_no;
	 }
	 public void setStu_no(String Stu_no) {
		 this.Stu_no=Stu_no;
	 }
	 
	 public String getcou_no() {
		 return cou_no;
	 }
	 public void setcou_no(String cou_no) {
		 this.cou_no=cou_no;
	 }
	 
	 public int getSc_Grade() {
		 return Sc_Grade;
	 }
	 public void setSc_Grade(int Sc_Grade) {
		 this.Sc_Grade=Sc_Grade;
	 }
}
