package view;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import Controller.ScAddHandler;

public class ScAdd extends JFrame {
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
	 public ScAdd(){
		initComponents();
	 }
	 private void initComponents() {
		 dialogPane=new JPanel();
		 contentPanel=new JPanel() ;
		 lb_sno=new JLabel();
		 tf_sno=new JTextField();
		 lb_cno=new JLabel ();
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
	     contentPanel.setLayout(new GridLayout(3,4,6,6));
	     lb_sno.setText("学生学号");
	     lb_sno.setHorizontalAlignment(SwingConstants.RIGHT);
	     contentPanel.add(lb_sno); 
	     contentPanel.add(tf_sno); 
	     lb_cno.setText("课程编程");
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
	       String[]  sc=new String[3];
	        sc[0]=new String(tf_sno.getText());
	        sc[1]=new String(tf_cno.getText()); 
	        sc[2]=new String(tf_grade.getText());
	        ScAddHandler sco=new ScAddHandler(sc) ;
	        int i=sco.addSc(); 
	        if(i==1) {
	            JOptionPane.showMessageDialog(null,"添加成功");
	            dispose() ;
	        }
	    }
}
