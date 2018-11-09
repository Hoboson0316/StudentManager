package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Controller.*;
import model.*;
public class CourseDelete extends JFrame{
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel lb_cno;
	private JTextField tf_cno;
	private JLabel lb_cname;
	private JTextField tf_cname;
	private JLabel lb_ccredit;
	private JTextField tf_ccredit;
	private JPanel buttonBar;
	private JButton btn_add;
	private JButton btn_close;
	private JLabel tf_cno_query;
	public CourseDelete(){
		initComponents();
	}
	private void initComponents() {
		dialogPane=new JPanel();
		contentPanel=new JPanel();
		lb_cno=new JLabel();
		tf_cno=new JTextField();
		lb_cname=new JLabel();
		tf_cname=new JTextField();
		lb_ccredit=new JLabel();
		tf_ccredit=new JTextField();
		buttonBar=new JPanel();
		btn_add=new JButton();
		btn_close=new JButton();
		
		setTitle("删除课程");
		setResizable(false);
		Container contentPane=getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		dialogPane.setBorder(new EmptyBorder(12,12,12,12));
		dialogPane.setLayout(new BorderLayout());
		contentPanel.setLayout(new GridLayout(3,4,6,6));
		
		lb_cno.setText("课程编号");
		lb_cno.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_cno);
		contentPanel.add(tf_cno);
		lb_cname.setText("课程名称");
		lb_cname.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_cname);
		contentPanel.add(tf_cname);
		lb_ccredit.setText("学分");
		lb_ccredit.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_ccredit);
		contentPanel.add(tf_ccredit);
		dialogPane.add(contentPanel,BorderLayout.CENTER);
		buttonBar.setBorder(new EmptyBorder(12,0,0,0));
		buttonBar.setLayout(new GridBagLayout());
		((GridBagLayout)buttonBar.getLayout()).columnWidths=new int[]{0,85,80};
		((GridBagLayout)buttonBar.getLayout()).columnWeights=new double[]{1.0,0.0,0.0};
		btn_add.setText("删除");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_deleteActionPerformed(e);
			}
		});
		btn_close.setText("关闭");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonBar.add(btn_add);
		buttonBar.add(btn_close);
		dialogPane.add(buttonBar,BorderLayout.SOUTH);
		contentPane.add(dialogPane,BorderLayout.CENTER);
		setSize(450,175);
		setLocationRelativeTo(getOwner());
		setVisible(true);     
	}
	private void btn_queryActionPerformed(ActionEvent e) {
		String cno=tf_cno_query.getText();
		StuQueryHandler couQuery=new StuQueryHandler(cno);
		student course=couQuery.query(cno);
		if(course!=null) {
			tf_cno.setText(course.getStu_no());
			tf_cname.setText(course.getStu_name());
			tf_ccredit.setText(String.valueOf(course.getStu_classNo()));
			
		}else{
			JOptionPane.showMessageDialog(null, "没有这门课！请认真确认所输入的学号。");
		}
	}
	private void btn_deleteActionPerformed(ActionEvent e) { 
		String c=new String(tf_cno.getText());
	     StuDeleteHandler cou=new StuDeleteHandler(c) ;
	     int i=cou.deleteCou(); 
	     if(i==1) {
	         JOptionPane.showMessageDialog(null,"删除成功");
	         dispose() ;
	     }
	 }

}
