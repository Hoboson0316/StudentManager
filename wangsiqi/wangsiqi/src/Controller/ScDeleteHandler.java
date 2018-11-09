package Controller;
import model.BaseDao;

public class ScDeleteHandler {
	String sql;
    String sno;
    String cno;
    public ScDeleteHandler() {
    	super();
    }
    public ScDeleteHandler(String sno,String cno){
    	this.sno=sno;
    	this.cno=cno;
    }
    public int deleteSc(){
    sql="delete*from student where Sno like'"+sno+"&'"+"and Cno like'"+cno+"&'";
	int i=BaseDao.executeUpdate(sql);
    return i;
    }
}
