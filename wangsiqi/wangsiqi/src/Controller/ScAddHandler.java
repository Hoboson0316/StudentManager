package Controller;
import model.BaseDao;

public class ScAddHandler {
	String sql;
	String sno;
	String cno;
	String grade;
	public ScAddHandler() {
    	super();
    }
	public ScAddHandler(String sno, String cno, String grade){
    	this.sno=sno;
        this.cno=cno;
        this.grade=grade;
    }
	public ScAddHandler(String[] str){
    	sno=str[0];
        cno=str[1];
        grade=str[2];
    }
	public int addSc(){
    	sql="insert into sc values('"+sno+"','" +cno+"','"+grade+"')";
    	int i=BaseDao. executeUpdate(sql);
    	return i;
    }
}
