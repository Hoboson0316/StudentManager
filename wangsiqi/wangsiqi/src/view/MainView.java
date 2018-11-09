package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class MainView extends JFrame {
	private JMenuBar menuBar; // 菜单栏对象
	
	private JMenu menuTable; // 基本表
	private JMenu menuSelect; // 选课和登录成绩
	private JMenu menuQuery; // 查询
	private JMenu menuSystem; // 系统维护
	
	private JMenu menuStudent; // 学生
	private JMenu menuCourse; // 课程
	private JMenu menuSC; // 选课
	
	private JMenuItem mi_StuAdd; // 添加学生菜单项
	private JMenuItem mi_StuUpdate; // 更新学生菜单项
	private JMenuItem mi_StuDelete; // 删除学生菜单项
	
	private JMenuItem mi_CouAdd; // 添加课程菜单项
	private JMenuItem mi_CouUpdate; // 更新课程菜单项
	private JMenuItem mi_CouDelete; // 删除课程菜单项
	
	private JMenuItem mi_ScAdd; // 添加选课菜单项
	private JMenuItem mi_ScUpdate; // 更新选课菜单项
	private JMenuItem mi_ScDelete; // 删除选课菜单项
	
	private JMenuItem mi_selectCourse; // 选课菜单项
	private JMenuItem mi_grade; // 登录成绩菜单项
	
	private JMenuItem mi_QueryStudent; // 查询学生菜单项
	private JMenuItem mi_QueryCourse; // 查询课程菜单项
	private JMenuItem mi_QueryGrade; // 查询成绩菜单项
	
	private JMenuItem mi_UpdatePassword; // 修改密码菜单项
	private JMenuItem mi_exit; // 退出系统菜单项
	
	public MainView(){
		menuBar=new JMenuBar();//创建菜单栏对象
		menuTable=new JMenu();//创建基本表菜单对象
		menuSelect=new JMenu(); // 创建选课和登录成绩菜单对象
		menuQuery=new JMenu(); // 创建查询菜单对象
		menuSystem=new JMenu(); // 创建系统维护菜单对象
		
		menuStudent=new JMenu(); // 创建学生菜单对象
		menuCourse=new JMenu(); // 创建课程菜单对象
		menuSC=new JMenu(); // 创建选课菜单对象
		
		mi_StuAdd=new JMenuItem(); // 创建添加学生菜单项
		mi_StuUpdate=new JMenuItem(); // 创建更新学生菜单项
		mi_StuDelete=new JMenuItem(); // 创建删除学生菜单项
		
		mi_CouAdd=new JMenuItem(); // 创建添加课程菜单项
		mi_CouUpdate=new JMenuItem(); // 创建更新课程菜单项
		mi_CouDelete=new JMenuItem(); // 创建删除课程菜单项
		
		mi_ScAdd=new JMenuItem(); // 创建添加选课菜单项
		mi_ScUpdate=new JMenuItem(); // 创建更新选课菜单项
		mi_ScDelete=new JMenuItem(); // 创建删除选课菜单项
		
		mi_selectCourse=new JMenuItem(); // 创建选课菜单项
		mi_grade=new JMenuItem(); // 创建登录成绩菜单项
		
		mi_QueryStudent=new JMenuItem(); // 创建查询学生菜单项
		mi_QueryCourse=new JMenuItem(); // 创建查询课程菜单项
		mi_QueryGrade=new JMenuItem(); // 创建查询成绩菜单项
		
		mi_UpdatePassword=new JMenuItem(); // 创建修改密码菜单项
		mi_exit=new JMenuItem(); // 创建退出系统菜单项
		
		setTitle("学生成绩管理系统");//设置窗口标题
		Container contentPane=getContentPane();
		contentPane.setLayout(new BorderLayout());
		  menuTable.setText("基本表管理");
		  
		    menuStudent.setText("学生表管理");
		      
		      mi_StuAdd.setText("添加学生信息");
		      mi_StuAdd.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					 new StudentAdd();
					
				}
			});
		      menuStudent.add(mi_StuAdd);
		      mi_StuUpdate.setText("更新学生信息");
		      mi_StuUpdate.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new StudentUpdate();
		    	  }	
		      });
		      menuStudent.add(mi_StuUpdate);
		      
		      mi_StuDelete.setText("删除学生信息");
		      mi_StuDelete.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new StudentDelete();
		    	  }	
		      });
		      menuStudent.add(mi_StuDelete);
		    menuTable.add(menuStudent);//将学生表菜单添加到基本表菜单上
		    
		    menuCourse.setText("课程表管理");
		      
		      mi_CouAdd.setText("添加课程信息");
		      mi_CouAdd.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new CourseAdd();
		    	  }	
		      });
		      menuCourse.add(mi_CouAdd);
		      
		      mi_CouUpdate.setText("更新课程信息");
		      mi_CouUpdate.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new CourseUpdate();
		    	  }	
		      });
		      menuCourse.add(mi_CouUpdate);
		      
		      mi_CouDelete.setText("删除课程信息");
		      mi_CouDelete.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new CourseDelete();
		    	  }	
		      });
		      menuCourse.add(mi_CouDelete);
		    menuTable.add(menuCourse);//将课程表菜单添加到基本表菜单上
		    
		    menuSC.setText("选课表管理");
		      
		      mi_ScAdd.setText("添加选课信息");
		      mi_ScAdd.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new ScAdd();
		    	  }	
		      });
		      menuSC.add(mi_ScAdd);
		      
		      mi_ScUpdate.setText("更新选课信息");
		      mi_ScUpdate.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new ScUpdate();
		    	  }	
		      });
		      menuSC.add(mi_ScUpdate);
		      
		      mi_ScDelete.setText("删除选课信息");
		      mi_ScDelete.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new ScDelete();
		    	  }	
		      });
		      menuSC.add(mi_ScDelete);
		    menuTable.add(menuSC);//将选课表菜单添加到基本表菜单上
		  
		  menuBar.add(menuTable);//将基本表菜单添加到菜单栏上
		  
		  
		  		 
		  menuSelect.setText("选课和成绩管理");
		    
		    mi_selectCourse.setText("选择课程");
		    mi_selectCourse.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    //new selectCourse();
	    	    }	
	        });
		    menuSelect.add(mi_selectCourse);//将选课菜单项添加到选课和成绩管理菜单上
		    
		    mi_grade.setText("登录成绩");
		    mi_grade.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    //new selectCourse();
	    	    }	
	        });
		    menuSelect.add(mi_grade);//将登录成绩菜单项添加到选课和成绩管理菜单上
		    
		  menuBar.add(menuSelect);//将选课和成绩管理菜单添加到菜单栏上
		  
		  
		  
		  
		  menuQuery.setText("查询管理");
		    
		    mi_QueryStudent.setText("查询学生信息");
		    mi_QueryStudent.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    new StudentQuery();
	    	    }	
	        });
		    menuQuery.add(mi_QueryStudent);//将查询学生信息菜单项添加到查询管理菜单上
		    
		    mi_QueryCourse.setText("查询课程信息");
		    mi_QueryCourse.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    new CourseQuery();
	    	    }	
	        });
		    menuQuery.add(mi_QueryCourse);//将查询课程信息菜单项添加到查询管理菜单上
		    
		    mi_QueryGrade.setText("查询课程成绩");
		    mi_QueryGrade.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    new ScQuery();
	    	    }	
	        });
		    menuQuery.add(mi_QueryGrade);//将查询课程成绩菜单项添加到查询管理菜单上
		    
		  menuBar.add(menuQuery);//将查询管理菜单添加到菜单栏上
		  
		  
		  
		  
		  menuSystem.setText("系统维护");
		    
		    mi_UpdatePassword.setText("更新密码");
		    mi_UpdatePassword.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    //new PasswordUpdate();
	    	    }	
	        });
		    menuSystem.add(mi_UpdatePassword);//将更新密码菜单项添加到系统维护菜单上
		    
		    menuSystem.addSeparator();//设置菜单分隔符
		    
		    mi_exit.setText("退出");
		    mi_exit.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    //dispose();
	    	    }	
	        });
		    menuSystem.add(mi_exit);//将退出菜单项添加到系统维护菜单上
		    
		  menuBar.add(menuSystem);//将系统维护菜单添加到菜单栏上
		  
		  
		  
		  
		  setJMenuBar(menuBar);//将menuBar设置为主界面的菜单栏
		  setSize(500,400);
		  setLocationRelativeTo(getOwner());
		  setVisible(true);
	
	}
	
	//根据用户身份，调用不同的界面
	public void setUserview(int userType) {
		switch(userType) {
		case 1://学生界面
			menuTable.setEnabled(false);
			mi_grade.setEnabled(false);
			break;
		case 2://教师界面
			menuTable.setEnabled(false);
			break;
		case 3://管理员界面，没有限制
			break;
	    default:
	    	JOptionPane.showMessageDialog(this, "用户类型错误！");
	 
			
			
		
		}
		
		
	}
	
	
	
	
}
