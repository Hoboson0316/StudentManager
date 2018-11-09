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
		
		setTitle("ɾ���γ�");
		setResizable(false);
		Container contentPane=getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		dialogPane.setBorder(new EmptyBorder(12,12,12,12));
		dialogPane.setLayout(new BorderLayout());
		contentPanel.setLayout(new GridLayout(3,4,6,6));
		
		lb_cno.setText("�γ̱��");
		lb_cno.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_cno);
		contentPanel.add(tf_cno);
		lb_cname.setText("�γ�����");
		lb_cname.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_cname);
		contentPanel.add(tf_cname);
		lb_ccredit.setText("ѧ��");
		lb_ccredit.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_ccredit);
		contentPanel.add(tf_ccredit);
		dialogPane.add(contentPanel,BorderLayout.CENTER);
		buttonBar.setBorder(new EmptyBorder(12,0,0,0));
		buttonBar.setLayout(new GridBagLayout());
		((GridBagLayout)buttonBar.getLayout()).columnWidths=new int[]{0,85,80};
		((GridBagLayout)buttonBar.getLayout()).columnWeights=new double[]{1.0,0.0,0.0};
		btn_add.setText("ɾ��");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_deleteActionPerformed(e);
			}
		});
		btn_close.setText("�ر�");
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
			JOptionPane.showMessageDialog(null, "û�����ſΣ�������ȷ���������ѧ�š�");
		}
	}
	private void btn_deleteActionPerformed(ActionEvent e) { 
		String c=new String(tf_cno.getText());
	     StuDeleteHandler cou=new StuDeleteHandler(c) ;
	     int i=cou.deleteCou(); 
	     if(i==1) {
	         JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
	         dispose() ;
	     }
	 }

}
