package Controller;
import model.BaseDao;

public class UserAddHandler {
	String sql;
	String id;
	String name;
	String pass;
	String userType;
	public UserAddHandler() {
    	super();
    }
	public UserAddHandler(String id, String name, String pass,String userType){
    	this.id=id;
        this.name=name;
        this.pass=pass;
        this.userType=userType;
    }
	public UserAddHandler(String[] str){
    	id=str[0];
        name=str[1];
        pass=str[2];
        userType=str[3];
    }
	public int addUser(){
    	sql="insert into user (id, name, pass,userType) values('"+id+"','" +name+"','"+pass+"','"+userType+"')";
    	int i=BaseDao. executeUpdate(sql);
    	return i;
    }
}
