package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Controller.*;
import model.*;

public class UserDelete extends JFrame{
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel lb_id;
	private JTextField tf_id;
	private JLabel lb_name;
	private JTextField tf_name;
	private JLabel lb_pass;
	private JTextField tf_pass;
	private JLabel lb_userType;
	private JTextField tf_userType;
	private JPanel buttonBar;
	private JButton btn_add;
	private JButton btn_close;
	private JLabel tf_id_query;
	public UserDelete(){
		initComponents();
	}
	private void initComponents() {
		dialogPane=new JPanel();
		contentPanel=new JPanel();
		lb_id=new JLabel();
		tf_id=new JTextField();
		lb_name=new JLabel();
		tf_name=new JTextField();
		lb_pass=new JLabel();
		tf_pass=new JTextField();
		lb_userType=new JLabel();
		tf_userType=new JTextField();
		buttonBar=new JPanel();
		btn_add=new JButton();
		btn_close=new JButton();
		
		setTitle("删除用户");
		setResizable(false);
		Container contentPane=getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		dialogPane.setBorder(new EmptyBorder(12,12,12,12));
		dialogPane.setLayout(new BorderLayout());
		contentPanel.setLayout(new GridLayout(3,4,6,6));
		
		lb_id.setText("用户编号");
		lb_id.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_id);
		contentPanel.add(tf_id);
		lb_name.setText("用户名");
		lb_name.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_name);
		contentPanel.add(tf_name);
		lb_pass.setText("用户密码");
		lb_pass.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_pass);
		contentPanel.add(tf_pass);
		lb_userType.setText("用户类型");
		lb_userType.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_userType);
		contentPanel.add(tf_userType);
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
		String id=tf_id_query.getText();
		UserQueryHandler userQuery=new UserQueryHandler(id);
		user user=userQuery.query(id);
		if(user!=null) {
			tf_id.setText(String.valueOf(user.getUser_id()));
			tf_name.setText(user.getUser_name());
			tf_pass.setText(user.getUser_pass());
			tf_userType.setText(user.getUser_Type());
			
		}else{
			JOptionPane.showMessageDialog(null, "查无此人！请认真确认所输入的用户编号。");
		}
	}
	private void btn_deleteActionPerformed(ActionEvent e) { 
		String u=new String(tf_id.getText());
	     UserDeleteHandler user=new UserDeleteHandler(u) ;
	     int i=user.deleteUser(); 
	     if(i==1) {
	         JOptionPane.showMessageDialog(null,"删除成功");
	         dispose() ;
	     }
	 }
}
