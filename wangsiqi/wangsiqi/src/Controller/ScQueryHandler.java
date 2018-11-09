package Controller;
import java.util.ArrayList;
import model.*;

public class ScQueryHandler {
	String sql;
	String sno;
	String cno;
	String grade;
	Object[][]results;
	public ScQueryHandler() {
    	super();
    }
	public ScQueryHandler(String sno, String cno){
    	this.sno=sno;
        this.cno=cno;
    }
	public Sc query(String sno,String cno){
	    Sc sc=null;
	    if(cno!=null&cno.length()>0&sno!=null&sno.length()>0){
	    	sql="select*from sc where cno like'"+cno+"&'"+"and Cno like'"+cno+"&'";
	    	sc=ScDao.getSc(sno,cno);
	    }return sc;
	}
	public Object[][] query(){
    	if(cno!=null&cno.length()>0&sno!=null&sno.length()>0){
    		sql="select*from sc where cno like'"+cno+"&'"+"and Cno like'"+cno+"&'";
    	}
    	else
    		sql="select*from sc";
    	results=getResult(ScDao.getScList(sql));
    	return results;
    }
	private Object [][] getResult(ArrayList list){
		Object[][] resu=new Object [list.size()][3];
        for (int i=0; i<list.size(); i++) {
        	Sc sc= (Sc)list.get(i);
            resu[i][0]=sc.getStu_no();
            resu[i][1]=sc.getcou_no();
            resu[i][2]=sc.getSc_Grade();
           
        }return resu;
	}
}
