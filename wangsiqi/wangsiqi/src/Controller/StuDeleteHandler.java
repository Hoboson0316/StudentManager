package Controller;
import model.BaseDao;
public class StuDeleteHandler {
	String sql;
    String cno;
    public StuDeleteHandler() {
    	super();
    }
    public StuDeleteHandler(String cno){
    	this.cno=cno;
    }
    public int deleteCou(){
    	sql="delete*from Course where cno like'"+cno+"&'";
    	int i=BaseDao.executeUpdate(sql);
        return i;
    }
}
