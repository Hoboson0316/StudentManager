package Controller;
import java.util.ArrayList;
import model.*;

public class CouQueryHandler {
	String sql;
    String cno;
    String cname;
    String ccredit;
    Object[][]results;
    public CouQueryHandler() {
    	super();
    }
    public CouQueryHandler(String cno){
    	this.cno=cno;
    }
    public course query(String cno){
    	course course=null;
    	if(cno!=null&cno.length()>0){
    		sql="select*from course where cno like'"+cno+"&'";
    		course=CourseDao.getCourse(cno);
    	}return course;
    }
    public Object[][] query(){
    	if(cno!=null&cno.length()>0){
    		sql="select*from course where cno like'"+cno+"&'";
    	}
    	else
    		sql="select*from course";
    	results=getResult(CourseDao.getCourseList(sql));
    	return results;
    }
    private Object [][] getResult(ArrayList list){
    	Object[][] resu=new Object [list.size()][3];
        for (int i=0; i<list.size(); i++) {
        	course course= (course)list.get(i);
            resu[i][0]=course.getCou_no();
            resu[i][1]=course.getCou_name();
            resu[i][3]=course.getCou_credit();
        }return resu;
    }
}

