package Controller;
import model.BaseDao;

public class UserDeleteHandler {
	String sql;
	String id;
	public UserDeleteHandler() {
    	super();
    }
	public UserDeleteHandler(String id){
    	this.id=id;
    }
	public int deleteUser(){
    	sql="delete*from userman where id like'"+id+"&'";
    	int i=BaseDao.executeUpdate(sql);
        return i;
    }
}
