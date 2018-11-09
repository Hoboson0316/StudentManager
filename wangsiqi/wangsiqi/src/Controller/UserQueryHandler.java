package Controller;
import java.util.ArrayList;
import model.*;

public class UserQueryHandler {
	String sql;
	String id;
	String name;
	String pass;
	String userType;
	Object[][] results;
	public UserQueryHandler() {
    	super();
    }
	public  UserQueryHandler(String id){
    	this.id=id;
    }
	public user query(String id){
    	user user=null;
    	if(id!=null&id.length()>0){
    		sql="select*from userman where id like'"+id+"&'";
    		user=UserDao.getUser(id);
    	}return user;
    }
	public Object[][] query(){
    	if(id!=null&id.length()>0){
    		sql="select*from userman where id like'"+id+"&'";
    	}
    	else
    		sql="select*from userman";
    	results=getResult(UserDao.getUserList(sql));
    	return results;
    }
	private Object[][] getResult(ArrayList list){
		 Object[][] resu=new Object[list.size()][6];
		 for (int i=0; i<list.size(); i++) {
		   user user= (user)list.get(i);
		   resu[i][0]=user.getUser_id();
		   resu[i][1]=user.getUser_name();
		   resu[i][2]=user.getUser_pass();
		   resu[i][3]=user.getUser_Type();
		}return resu;
	}
}
