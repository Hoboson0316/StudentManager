package view;
import Controller.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StudentDelete extends JFrame{
	private JPanel dialogPanel;
	private JPanel contentPanel;
	private JLabel lb_sno1,lb_sno2, lb_sname, lb_ssex, lb_sage, lb_sdept, lb_sclassNo,lb_empty;
	private JTextField  tf_sno1,tf_sno2, tf_sname,tf_ssex, tf_sage, tf_sdept, tf_sclassNo;
	private JPanel buttonBar;
	private JButton bt_delete, bt_close, bt_search;

	public StudentDelete() {
		initComponents();
	}

	public void initComponents() {
		dialogPanel = new JPanel();
		contentPanel = new JPanel();
		lb_sno1 = new JLabel("学号");
		lb_sno2 = new JLabel("学号");
		lb_sname = new JLabel("姓名");
		lb_ssex = new JLabel("性别");
		lb_sage = new JLabel("年龄");
		lb_sdept = new JLabel("所在系");
		lb_sclassNo = new JLabel("班级号");
		tf_sno1=new JTextField();
		tf_sno2=new JTextField();
		tf_sname=new JTextField();
		tf_ssex=new JTextField();
		tf_sage=new JTextField();
		tf_sdept=new JTextField();
		tf_sclassNo=new JTextField();
		buttonBar = new JPanel();
		bt_delete = new JButton("删除");
		bt_close = new JButton("关闭");
		bt_search = new JButton("查找");
		lb_empty= new JLabel();

		setTitle("删除学生信息");
		setResizable(false); // 窗口大小是否可有用户调整

		Container contentPane = getContentPane(); // 获得窗体容器
		contentPane.setLayout(new BorderLayout()); // 设置容器的布局方式

		//dialogPanel.setBorder(new EmptyBorder(12, 12, 12, 12));  //设置边框
		dialogPanel.setLayout(new BorderLayout());
			contentPanel.setLayout(new GridLayout(4, 4, 6, 6));
			
			lb_sno1.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sno1);
			contentPanel.add(tf_sno1);
			
			contentPanel.add(bt_search);
			bt_search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bt_searchActionPerformed(e);
				}
			});
			contentPanel.add(lb_empty);
			
			lb_sno2.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sno2);
			contentPanel.add(tf_sno2);
			
			lb_sname.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sname);
			contentPanel.add(tf_sname);
			
			lb_ssex.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_ssex);
			contentPanel.add(tf_ssex);
			
			lb_sage.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sage);
			contentPanel.add(tf_sage);
			
			lb_sdept.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sdept);
			contentPanel.add(tf_sdept);
			
			lb_sclassNo.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sclassNo);
			contentPanel.add(tf_sclassNo);
			
		dialogPanel.add(contentPanel,BorderLayout.CENTER);
			buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
			buttonBar.setLayout(new GridBagLayout());
			((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[] {0,85,80};    //设置网格布局最小宽度
			((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[] {1.0,0.0,0.0};  //设置网格布局列权重
			
			bt_delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bt_deleteActionPerformed(e);
				}
			});
			
			bt_close.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			buttonBar.add(bt_delete);
			buttonBar.add(bt_close);
		dialogPanel.add(buttonBar, BorderLayout.SOUTH);
		contentPane.add(dialogPanel,BorderLayout.CENTER);
		setSize(450,175);
		setLocationRelativeTo(getOwner());
		setVisible(true);
	}

	public void bt_searchActionPerformed(ActionEvent e) {
		
		String sno = tf_sno1.getText().trim();  //获取输入的账号
		StuQueryHandler stuQuery = new StuQueryHandler(sno);
		student student = stuQuery.query(sno);  //查询输入的用户，返回一个Student类型的student
		//通过get()方法获取学生的相关信息并将信息设置给text
		if (student != null) {
			tf_sno2.setText(student.getStu_no());
			tf_sname.setText(student.getStu_name());
			tf_ssex.setText(String.valueOf(student.getStu_sex()));
			tf_sage.setText(String.valueOf(student.getStu_age()));
			tf_sdept.setText(student.getStu_dept());
			tf_sclassNo.setText(student.getStu_classNo());
		} else {
			JOptionPane.showMessageDialog(null, "查无此人!请重新输入学号！");
		}
	}
	
	public void bt_deleteActionPerformed(ActionEvent e) {
		String s= new String(tf_sno2.getText());  //获取要删除学生的学号
		StuDeleteHandler stu = new StuDeleteHandler(s);
		int i = stu.deleteCou();  //调用delect方法进行学生信息的删除
		if(i == 1) {
			JOptionPane.showMessageDialog(null,"删除成功");
			dispose();
		}
	}
	
	
}
