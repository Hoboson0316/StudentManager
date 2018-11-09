package Controller;
import model.BaseDao;

public class CouUpdateHandler {
	String sql;
    String cno;
    String cname;
    String cpno;
    String ccredit;
    public CouUpdateHandler() {
    	super();
    }
    public CouUpdateHandler(String cno, String cname, String cpno, String ccredit){
    	this.cno=cno;
        this.cname=cname;
        this.cpno=cpno;
        this.ccredit=ccredit;
    }
    public CouUpdateHandler(String[] str){
    	cno=str[0];
    	cname=str[1];
    	cpno=str[2];
    	ccredit=str[3];
    }
    public int  updateCou() {
    	sql="update course set cname='"+cname+"', cpno='"+cpno+"', ccredit=' "+"'where cno='"+cno+"'";
        int i=BaseDao.executeUpdate(sql);
        return i;
    }
}
