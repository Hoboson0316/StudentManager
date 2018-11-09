package view;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import Controller.UserAddHandler;

public class UserAdd extends JFrame{
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
	 public UserAdd(){
		initComponents();
    }
	 private void initComponents() {
		 dialogPane=new JPanel();
		 contentPanel=new JPanel() ;
		 lb_id=new JLabel();
		 tf_id=new JTextField();
		 lb_name=new JLabel ();
		 tf_name=new JTextField();
		 lb_pass=new JLabel();
		 tf_pass=new JTextField();
		 lb_userType=new JLabel();
		 tf_userType=new JTextField();
		 buttonBar=new JPanel();
		 btn_add=new JButton();
		 btn_close=new JButton();
		 
		 setTitle("添加新用户");
		 setResizable(false);
		 Container contentPane=getContentPane();  
		 contentPane.setLayout(new BorderLayout());
		 dialogPane.setBorder(new EmptyBorder(12,12,12,12));
	      contentPanel.setLayout(new GridLayout(3,4,6,6));
	      lb_id.setText("课程编号");
	      lb_id.setHorizontalAlignment(SwingConstants.RIGHT);
	      contentPanel.add(lb_id); 
	      contentPanel.add(tf_id); 
	      lb_name.setText("名称");
	      lb_name.setHorizontalAlignment(SwingConstants.RIGHT);
	      contentPanel.add(lb_name);
	      contentPanel.add(tf_name);
	      lb_pass.setText("先修课编号");
	      lb_pass.setHorizontalAlignment(SwingConstants.RIGHT);
	      contentPanel.add(lb_pass);
	      contentPanel.add(tf_pass);
	      lb_userType.setText("学分");
	      lb_userType.setHorizontalAlignment(SwingConstants.RIGHT);
	      contentPanel.add(lb_userType);
	      contentPanel.add(tf_userType);
	      dialogPane.add(contentPanel,BorderLayout.CENTER);
	      buttonBar.setBorder(new EmptyBorder(12,0,0,0));
	      buttonBar.setLayout(new GridBagLayout());
	      ((GridBagLayout) buttonBar.getLayout()).columnWidths=new int[]{0,85,80};
	      ((GridBagLayout) buttonBar.getLayout()).columnWeights=new double[]{1.0,0.0,0.0};
	      btn_add.setText ("添加");
	      btn_add.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e) {
		            btn_addActionPerformed(e);
		         }
		      });
		      btn_close.setText("关闭");
		      btn_close.addActionListener(new ActionListener(){
		         public void actionPerformed(ActionEvent e){
		            dispose();;
		         }
		             }) ;
		             buttonBar.add(btn_add) ;  
		             buttonBar.add(btn_close) ;
		           dialogPane.add(buttonBar,BorderLayout.SOUTH);
		           contentPane.add(dialogPane,BorderLayout.CENTER);
		           setSize(450,175) ;
		           setLocationRelativeTo(getOwner());
		           
	      }
	 private void btn_addActionPerformed(ActionEvent e) { 
	        String[]  u=new String[4];
	         u[0]=new String(tf_id.getText());
	         u[1]=new String(tf_name.getText()); 
	         u[2]=new String(tf_pass.getText());
	         u[3]=new String(tf_userType.getText());
	         UserAddHandler user=new UserAddHandler(u) ;
	         int i=user.addUser(); 
	         if(i==1) {
	             JOptionPane.showMessageDialog(null,"添加成功");
	             dispose() ;
	         }
	     }
}
