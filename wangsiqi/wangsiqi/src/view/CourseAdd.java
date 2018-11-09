package view;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import Controller.CouAddHandler;
import Controller.StuAddHandler;

public class CourseAdd extends JFrame{
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
	 public CourseAdd(){
		initComponents();
    }
	 private void initComponents() {
		 dialogPane=new JPanel();
		 contentPanel=new JPanel() ;
		 lb_cno=new JLabel();
		 tf_cno=new JTextField();
		 lb_cname=new JLabel ();
		 tf_cname=new JTextField();
		 lb_ccredit=new JLabel();
		 tf_ccredit=new JTextField();
		 buttonBar=new JPanel();
		 btn_add=new JButton();
		 btn_close=new JButton();
		 
		 setTitle("添加新课程");
		 setResizable(false);
		 Container contentPane=getContentPane();  
		 contentPane.setLayout(new BorderLayout());
		 
		 dialogPane.setBorder(new EmptyBorder(12,12,12,12));
	      contentPanel.setLayout(new GridLayout(3,4,6,6));
	      lb_cno.setText("课程编号");
	      lb_cno.setHorizontalAlignment(SwingConstants.RIGHT);
	      contentPanel.add(lb_cno); 
	      contentPanel.add(tf_cno); 
	      lb_cname.setText("名称");
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
	        String[]  c=new String[3];
	         c[0]=new String(tf_cno.getText());
	         c[1]=new String(tf_cname.getText());
	         c[2]=new String(tf_ccredit.getText());
	         CouAddHandler cou=new CouAddHandler(c) ;
	         int i=cou.addCou(); 
	         if(i==1) {
	             JOptionPane.showMessageDialog(null,"添加成功");
	             dispose() ;
	         }
	     }
}

