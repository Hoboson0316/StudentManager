package view;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

import model.BaseDao; 

public class login extends JFrame{

	private JLabel lb_user;            //声明用户名标签
	private JTextField tf_user;        //声明用户名文本框
	private JLabel lb_pass; //声明密码标签
	private JPasswordField pf_pass; //声明密码口令框
	private JRadioButton rb_student; //声明学生单选钮
	private JRadioButton rb_teacher; 
	private JRadioButton rb_admin;
	private ButtonGroup bg_group;//声明单选按钮组
	private JButton btn_ok; 
	private JButton btn_cancel; 
	public login(){
		initComponents();
	}
	private void initComponents(){
		lb_user=new JLabel(); //创建用户名标签对象
		tf_user=new JTextField(); 
		lb_pass=new JLabel(); 
		pf_pass=new JPasswordField(); 
	    rb_student=new JRadioButton ("学生 " );
	    rb_teacher=new JRadioButton("教师"); 
	    rb_admin=new JRadioButton ("管理员");
	    bg_group=new ButtonGroup();
	    btn_ok=new JButton();
	    btn_cancel=new JButton();
	    setTitle ("登录界面");	//设置登录界面标题
	    setResizable(false);
	    Container contentPane=getContentPane(); 
	    contentPane.setLayout(new BorderLayout());
	    //容器contentPanel中的组件的设置与布局，居中登录界面 
	    JPanel contentPanel=new JPanel(); 
	    contentPanel.setLayout (new GridLayout (3,2)); 	
	    lb_user.setText ("用户名");
	    lb_user.setHorizontalAlignment(SwingConstants.RIGHT); 
	    contentPanel.add(lb_user); 
	    contentPanel.add(tf_user); 
	    lb_pass.setText ("密码");
	    lb_pass.setHorizontalAlignment(SwingConstants.RIGHT); 
	    contentPanel.add(lb_pass); 
	    contentPanel.add(pf_pass); 
	    btn_ok.setText ("确定");
	    btn_ok.addActionListener(new ActionListener(){ 
	    	public void actionPerformed(ActionEvent e){
	    		btn_okActionPerformed(e);
	    		}
	    	});
	    contentPanel.add(btn_ok); 
	    btn_cancel.setText ("取消");
	    btn_cancel.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){ 
	    		dispose();
	    		}
	    	});
	    	contentPanel.add(btn_cancel); 
	    	contentPane.add(contentPanel, BorderLayout.CENTER); 
	    	bg_group.add(rb_student); 
	    	bg_group.add(rb_teacher); 
	    	bg_group.add(rb_admin);
	    	//容器contentPanel2中的单选按钮设置，居南登录界面
	    	JPanel contentPanel2=new JPanel();
	    	//将单选按钮添加到容器
	    	contentPanel2.add(rb_student,true); 
	    	contentPanel2.add(rb_teacher); 
	    	contentPanel2.add(rb_admin); 
	    	contentPane.add(contentPanel2,BorderLayout.SOUTH);
	    	setSize (250,150);
	    	setLocationRelativeTo(getOwner()); 
	    	setVisible(true);
	    	}
	//单击确定按钮，事件响应，查找数据库中用户表，判断用户是否是合法用户
	private void btn_okActionPerformed(ActionEvent e){
		String username=tf_user.getText().trim();
		String pass=String.valueOf(pf_pass.getPassword()).replaceAll(" ", "");
		String sql=null;
		int userTypeLog=0;
		if (username.equals("")){
			JOptionPane.showMessageDialog(this,"用户名不允许为空！");
			return;
			}
		if (rb_student.isSelected()) {	//判断是否是学生用户
			userTypeLog=1;
			sql="select*from userman where name='"+username+"'AND pass='"+pass+ "'AND userType='student'";
			}
		if (rb_teacher.isSelected () ) {	//判断是否是教师用户
			userTypeLog=2;
			sql="select*from userman where name='"+username+" 'AND pass='"+pass+"'AND userType='teacher'";
			}
		if (rb_admin. isSelected () ) {	//判断是否是管理员用户
			userTypeLog=3;
			sql="select*from userman where name='"+username+"'AND pass='"+pass+"'AND userType='admin'";
			}
		if (sql==null) {
			JOptionPane. showMessageDialog (this,"请选择用户类型!");
			return;
			}
		try{
			//根据用户名、密码、用户身份类型査询数据库，判断是否为合法用户 
			java.sql.ResultSet result=BaseDao.executeQuery(sql); 
			if( result.next () ==false) {	//非法用户，关闭连接
				JOptionPane.showMessageDialog(this, "用户密码不正确！");
				BaseDao.close(); 
				return;
				}
			MainView mainview=new MainView();	//合法用户调用主界面
			mainview.setUserview (userTypeLog) ;	//根据用户身份调用不同界面
			dispose ();	//关闭窗口
			}
		catch(Exception ee){
			ee.printStackTrace();
			}
		}
	public static void main(String[] args) {
		new login();
	}
}