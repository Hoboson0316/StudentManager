package model;
import java.sql.*;

public class BaseDao {
	protected static String driver="com.mysql.jdbc.Driver";    //SQL Server 2008������������
			//StuGradeManΪѧ���ɼ�����ϵͳ��ʹ�õ����ݿ�����
			protected static String urI="jdbc:mysql://92.12.112.53:3306/mysql";
			protected static String dbUser="system";	//�ҵ� SQL Server 2008 ���û���
			protected static String dbPwd= "Sys@!2018"; //�ҵ� SQL Server 2008 ������
			private static Connection conn=null; 
			private BaseDao (){ 
				try{
					if(conn==null){
						Class.forName(driver);
						System.out.println ("���������ɹ�!");
						}
					else{
						return;
					}
			}catch(ClassNotFoundException e){ 
				e.printStackTrace();
				System.out.println ("��������ʧ��!");
			}
			try{
				conn=DriverManager.getConnection(urI, dbUser, dbPwd);
				System.out.println ("�������ݿ�ɹ���");
			}catch(SQLException e){ 
				e.printStackTrace();
				System.out .print ("SQL Server ���ݿ�����ʧ�ܣ�");
				}
			}
			//���ݴӿ����������SQL,ִ�����ݿ�Ĳ�ѯ���� 
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
			//���ݴӿ����������SQL��ִ�����ݿ����ӡ�ɾ���͸��²��� 
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
			//�ر����Ӷ���
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
