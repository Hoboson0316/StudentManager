package view;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Controller.*; 
import model.*;
public class StudentUpdate extends JFrame{
	private JPanel dialogPane;
	private JPanel contentPanel; 
	private JLabel lb_sno; 
	private JTextField tf_sno; 
	private JLabel lb_sname; 
	private JTextField tf_sname; 
	private JLabel lb_ssex; 
	private JTextField tf_ssex; 
	private JLabel lb_sage; 
	private JTextField tf_sage; 
	private JLabel lb_sdept; 
	private JTextField tf_sdept; 
	private JLabel lb_classNo; 
	private JTextField tf_classNo; 
	private JPanel buttonBar; 
	private JButton btn_add; 
	private JButton btn_close; 
	public StudentUpdate(){ 
		initComponents();
		}
	private void initComponents(){
		dialogPane=new JPanel(); 
		contentPanel=new JPanel(); 
		lb_sno=new JLabel(); 
		tf_sno=new JTextField(); 
		lb_sname=new JLabel(); 
		tf_sname=new JTextField(); 
		lb_ssex=new JLabel(); 
		tf_ssex=new JTextField(); 
		lb_sage=new JLabel(); 
		tf_sage=new JTextField(); 
		lb_sdept=new JLabel(); 
		tf_sdept=new JTextField(); 
		lb_classNo=new JLabel();
		tf_classNo=new JTextField(); 
		buttonBar=new JPanel(); 
		btn_add=new JButton(); 
		btn_close=new JButton(); 
		setTitle ("添加新学生");
		setResizable(false);
		Container contentPane=getContentPane () ;	//获得窗器
		contentPane.setLayout (new BorderLayout () ) ;	//设置容器的布局方式
		dialogPane.setBorder(new EmptyBorder(12, 12, 12,12));//设置边框
		dialogPane.setLayout(new BorderLayout());
		contentPanel.setLayout(new GridLayout(3,4,6,6)); 
		lb_sno.setText ("学号");//设置标签上的文字
		//设置文字水平方向的对齐方式
		lb_sno.setHorizontalAlignment(SwingConstants.RIGHT); 
		contentPanel.add (lb_sno);   //在 contentPanel 容器上添加学号标签
		contentPanel.add (tf_sno) ;	//在容器上添加学号文本框
		lb_sname.setText ("姓名");
		lb_sname.setHorizontalAlignment(SwingConstants.RIGHT); 
		contentPanel.add(lb_sname); 
		contentPanel.add(tf_sname); 
		lb_ssex.setText ("性别");
		lb_ssex.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_ssex);
		contentPanel.add(tf_ssex); 
		lb_sage.setText ("年龄") ;
		lb_sage.setHorizontalAlignment(SwingConstants.RIGHT); 
		contentPanel.add(lb_sage); 
		contentPanel.add(tf_sage); 
		lb_sdept.setText ("所在系");
		lb_sdept.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_sdept);
		contentPanel.add(tf_sdept);
		lb_classNo.setText ("班级号");
		lb_classNo.setHorizontalAlignment(SwingConstants.RIGHT); 
		contentPanel.add(lb_classNo); 
		contentPanel.add(tf_classNo);
		//将装有学号、姓名的组建的容器contentPanel放到dialogPane容器中央 
		dialogPane.add(contentPanel,BorderLayout.CENTER);
		//按钮面板设置边框
		buttonBar.setBorder(new EmptyBorder(12,0,0,0)); 
		buttonBar.setLayout(new GridBagLayout());
		((GridBagLayout) buttonBar.getLayout()).columnWidths=new int[]{0,85, 80};	//设置网格布局最小宽度
		((GridBagLayout) buttonBar.getLayout()).columnWeights=new double []{1.0,0.0,0.0};  //设置网格布局列权重
		btn_add. setText ("添加");	
	}
	//单击査询按钮后，执行查询操作，并将查询结果显示在图像界面的表格中 
		private void btn_queryActionPerformed(ActionEvent e){ 
			String sno=tf_sno_query.getText();
		StuQueryHandler stuQuery=new StuQueryHandler(sno); 
		student student=stuQuery.query(sno); 
		if(student !=null){
			tf_sno.setText(student.getStu_no());
			tf_sname.setText(student.getStu_name());
			tf_ssex.setText(String.valueOf(student.getStu_sex()));
			tf_sage.setText(String.valueOf(student.getStu_age()));
			tf_sdept.setText(student.getStu_dept());
			tf_classNo.setText(student.getStu_classNo());
			}else{
				JOptionPane.showMessageDialog(null,"査无此人！请认真确认所输入的学号.");
			}
		}
		private Object getStu_no() {
			// TODO Auto-generated method stub
			return null;
		}
		//单击更新按钮后，执行学生信息的更新操作
		private void btn_updateActionPerformed(ActionEvent e){
			String[] s=new String[6];
			s[0]=new String(tf_sno.getText());
			s[1]=new String(tf_sname.getText());
			s[2]=new String(tf_ssex.getText());
			s[3]=new String(tf_sage.getText());
			s[4]=new String(tf_sdept.getText());
			s[5]=new String(tf_classNo.getText());
		StuUpdateHandler stu=new StuUpdateHandler(s);
		int i=stu.updateStu();
		if(i==1){
			JOptionPane. showMessageDialog(null,"修改成功");
			dispose();
			}
		}
}