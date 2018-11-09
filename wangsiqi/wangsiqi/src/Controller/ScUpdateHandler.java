package Controller;
import model.BaseDao;

public class ScUpdateHandler {
	String sql;
	String sno;
	String cno;
	String grade;
	public ScUpdateHandler() {
    	super();
    }
	public ScUpdateHandler(String sno, String cno, String grade){
    	this.sno=sno;
        this.cno=cno;
        this.grade=grade;
    }
	public ScUpdateHandler(String[] str){
    	sno=str[0];
        cno=str[1];
        grade=str[2];
    }
	public int  updateSc() {
    	sql="update  sc  set  Grade='"+grade+"'where Sno='"+sno+"'"+"and Cno='"+cno+"'";
        int i=BaseDao.executeUpdate(sql);
        return i;
    }
}
