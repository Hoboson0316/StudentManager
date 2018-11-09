package model;
import java.sql.*;

public class BaseDao {
	protected static String driver="com.mysql.jdbc.Driver";    //SQL Server 2008驱动程序类名
			//StuGradeMan为学生成绩管理系统所使用的数据库名称
			protected static String urI="jdbc:mysql://92.12.112.53:3306/mysql";
			protected static String dbUser="system";	//我的 SQL Server 2008 的用户名
			protected static String dbPwd= "Sys@!2018"; //我的 SQL Server 2008 的密码
			private static Connection conn=null; 
			private BaseDao (){ 
				try{
					if(conn==null){
						Class.forName(driver);
						System.out.println ("加载驱动成功!");
						}
					else{
						return;
					}
			}catch(ClassNotFoundException e){ 
				e.printStackTrace();
				System.out.println ("加载驱动失败!");
			}
			try{
				conn=DriverManager.getConnection(urI, dbUser, dbPwd);
				System.out.println ("连接数据库成功！");
			}catch(SQLException e){ 
				e.printStackTrace();
				System.out .print ("SQL Server 数据库连接失败！");
				}
			}
			//根据从控制类得来的SQL,执行数据库的查询操作 
			public static ResultSet executeQuery(String sql) { 
				try{
					if (conn==null)
						new BaseDao ();
					System.out.println("sql===="+sql);
					return	conn.createStatement (ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
			}catch(SQLException e){ 
				e.printStackTrace(); 
				return null;
				}
			}
			//根据从控制类得来的SQL，执行数据库的添加、删除和更新操作 
			public static int executeUpdate(String sql){ 
				try{
					if(conn==null)
					new BaseDao();
					return conn.createStatement () .executeUpdate (sql);
			}catch(SQLException e){
				System.out.println(e.getMessage()); 
				return -1;
			}finally{	}
		}
			//关闭连接对象
			public static void close(){ 
				try{
					conn.close();
					}catch(SQLException e){ 
						e.printStackTrace();
						}finally{
							conn=null;
						}
				}
}
