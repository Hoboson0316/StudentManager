package Controller;
import model.BaseDao;

public class CouAddHandler {
	String sql;
    String cno;
    String cname;
    String ccredit;
    public CouAddHandler() {
    	super();
    }
    public CouAddHandler(String cno, String cname,  String ccredit){
    	this.cno=cno;
        this.cname=cname;
        this.ccredit=ccredit;
    }
    public CouAddHandler(String[] str){
    	cno=str[0];
    	cname=str[1];
    	ccredit=str[2];
    }
    public int addCou(){
    	sql="insert into Course (cno, cname,ccredit) values('"+cno+"','" +cname+"','"+ccredit+"')";
    	int i=BaseDao. executeUpdate(sql);
    	return i;
    }
}

