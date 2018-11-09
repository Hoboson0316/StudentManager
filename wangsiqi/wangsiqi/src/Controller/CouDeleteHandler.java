package Controller;
import model.BaseDao;

public class CouDeleteHandler {
	String sql;
    String cno;
    public CouDeleteHandler() {
    	super();
    }
    public CouDeleteHandler(String cno){
    	this.cno=cno;
    }
    public int deleteCou(){
    	sql="delete*from Course where cno like'"+cno+"&'";
    	int i=BaseDao.executeUpdate(sql);
        return i;
    }
}
