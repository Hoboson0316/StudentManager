package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Controller.*;
import model.*;
public class CourseUpdate extends JFrame{
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel lb_cno;
	private JTextField tf_cno;
	private JLabel lb_cname;
	private JTextField tf_cname;
	private JLabel lb_Ccredit;
	private JTextField tf_Ccredit;
	private JPanel buttonBar;
	private JButton btn_add;
	private JButton btn_close;
	private JLabel tf_cno_query;
	public CourseUpdate(){
		initComponents();
	}
	private void initComponents() {
		dialogPane=new JPanel();
		contentPanel=new JPanel();
		lb_cno=new JLabel();
		tf_cno=new JTextField();
		lb_cname=new JLabel();
		tf_cname=new JTextField();
		lb_Ccredit=new JLabel();
		tf_Ccredit=new JTextField();
		buttonBar=new JPanel();
		btn_add=new JButton();
		btn_close=new JButton();
		
		setTitle("添加新课程");
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
		lb_Ccredit.setText("学分");
		lb_Ccredit.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_Ccredit);
		contentPanel.add(tf_Ccredit);
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
		String cno=tf_cno_query.getText();
		CouQueryHandler couQuery=new CouQueryHandler(cno);
		course course=couQuery.query(cno);
		if(course!=null) {
			tf_cno.setText(course.getCou_no());
			tf_cname.setText(course.getCou_name());
			tf_Ccredit.setText(String.valueOf(course.getCou_credit()));
			
		}else{
			JOptionPane.showMessageDialog(null, "没有这门课！请认真确认所输入的课程编号。");
		}
	}
	private void btn_updateActionPerformed(ActionEvent e) { 
		String[] c=new String[3];
	     c[0]=new String(tf_cno.getText());
	     c[1]=new String(tf_cname.getText()); 
	     c[2]=new String(tf_Ccredit.getText());
	     CouUpdateHandler cou=new CouUpdateHandler(c) ;
	     int i=cou.updateCou(); 
	     if(i==1) {
	         JOptionPane.showMessageDialog(null,"修改成功");
	         dispose() ;
	     }
	 }
}
