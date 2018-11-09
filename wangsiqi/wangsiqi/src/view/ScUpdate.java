package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Controller.*;
import model.*;

public class ScUpdate extends JFrame{
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel lb_sno;
	private JTextField tf_sno;
	private JLabel lb_cno;
	private JTextField tf_cno;
	private JLabel lb_grade;
	private JTextField tf_grade;
	private JPanel buttonBar;
	private JButton btn_add;
	private JButton btn_close;
	private JLabel tf_sno_query;
	private JLabel tf_cno_query;
	public ScUpdate(){
		initComponents();
	}
	private void initComponents() {
		dialogPane=new JPanel();
		contentPanel=new JPanel();
		lb_sno=new JLabel();
		tf_sno=new JTextField();
		lb_cno=new JLabel();
		tf_cno=new JTextField();
		lb_grade=new JLabel();
		tf_grade=new JTextField();
		buttonBar=new JPanel();
		btn_add=new JButton();
		btn_close=new JButton();
		
		setTitle("添加新选课");
		setResizable(false);
		Container contentPane=getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		dialogPane.setBorder(new EmptyBorder(12,12,12,12));
		dialogPane.setLayout(new BorderLayout());
		contentPanel.setLayout(new GridLayout(3,4,6,6));
		
		lb_sno.setText("学生学号");
		lb_sno.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_sno);
		contentPanel.add(tf_sno);
		lb_cno.setText("课程编号");
		lb_cno.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_cno);
		contentPanel.add(tf_cno);
		lb_grade.setText("成绩");
		lb_grade.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_grade);
		contentPanel.add(tf_grade);
		dialogPane.add(contentPanel,BorderLayout.CENTER);
		buttonBar.setBorder(new EmptyBorder(12,0,0,0));
		buttonBar.setLayout(new GridBagLayout());
		((GridBagLayout)buttonBar.getLayout()).columnWidths=new int[]{0,85,80};
		((GridBagLayout)buttonBar.getLayout()).columnWeights=new double[]{1.0,0.0,0.0};
		btn_add.setText("添加");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_updateActionPerformed(e);
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
		String sno=tf_sno_query.getText();
		String cno=tf_cno_query.getText();
		ScQueryHandler scQuery=new ScQueryHandler(sno,cno);
		Sc sc=scQuery.query(sno,cno);
		if(sc!=null) {
			tf_sno.setText(sc.getStu_no());
			tf_cno.setText(sc.getcou_no());
			tf_grade.setText(String.valueOf(sc.getSc_Grade()));
			
		}else{
			JOptionPane.showMessageDialog(null, "没有这个选课！请认真确认所输入的学号和课程编号。");
		}
	}
	private void btn_updateActionPerformed(ActionEvent e) { 
		String[] s=new String[3];
	     s[0]=new String(tf_sno.getText());
	     s[1]=new String(tf_cno.getText()); 
	     s[2]=new String(tf_grade.getText());
	     ScUpdateHandler sc=new ScUpdateHandler(s) ;
	     int i=sc.updateSc(); 
	     if(i==1) {
	         JOptionPane.showMessageDialog(null,"修改成功");
	         dispose() ;
	     }
	 }
}
