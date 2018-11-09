package Controller;
import model.BaseDao;

public class UserUpdateHandler {
     String sql;
	 String id;
	 String name;
	 String pass;
	 String userType;
	public UserUpdateHandler() {
   	super();
   }
	public UserUpdateHandler(String id, String name, String pass,String userType){
		 this.id=id;
		 this.name=name;
		 this.pass=pass;
		 this.userType=userType;
   }
	public UserUpdateHandler(String[] str){
   	   id=str[0];
       name=str[1];
       pass=str[2];
       userType=str[3];
   }
	public int  updateUser() {
   	sql="update  uesrman  set  userType='"+userType+"', name='"+name+"', pass='"+pass+"'where id='"+id+'"';
       int i=BaseDao.executeUpdate(sql);
       return i;
   }
}

