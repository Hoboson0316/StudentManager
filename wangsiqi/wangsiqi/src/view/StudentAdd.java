package view;
import java.awt.event.*;
import java.awt.*; 
import javax.swing.*; 
import javax.swing.border.*; 
import Controller.StuAddHandler; 

public class StudentAdd extends JFrame {
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
	public StudentAdd(){ 
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
		btn_add. setText ("添加");	//设置添加按钮上的文字
		//添加按钮的匿名内部类监听器
		btn_add.addActionListener(new ActionListener() {//匿名内部类 
			public void actionPerformed(ActionEvent e){
				btn_addActionPerformed (e);      //单击添加按钮后执行的方法
		}
			});
		btn_close.setText("关闭");
		btn_close.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				dispose();;
				}
			});
		buttonBar.add (btn_add);	//将添加按钮放到容器 buttonBar 上
		buttonBar.add(btn_close); 
		dialogPane.add(buttonBar, BorderLayout.SOUTH); 
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize (450,175);	//设置窗口尺寸
		setLocationRelativeTo (getOwner () ) ;	//设置窗口的位置
		setVisible (true) ;	//设置窗口的可见性
		}
		//单击添加按钮后执行的方法，完成学生信息的添加任务
		private void btn_addActionPerformed(ActionEvent e){ 
			String[] s=new String[6];
			s[0] =new String (tf_sno.getText () ) ;	
			s[1]=new String (tf_sname.getText () ) ;
			s[2]=new String(tf_ssex.getText()); 
			s[3]=new String(tf_sage.getText());
			s[4]=new String(tf_sdept.getText()); 
			s[5]=new String(tf_classNo.getText());
			//创建控制类StuAddHandler对象stu，并将字符串数组传给stu
			StuAddHandler stu=new StuAddHandler(s);
				int i=stu.addStu () ;	// stu执行添加学生信息操作 
				if(i==1){
				JOptionPane. showMessageDialog (null,"添加成功");
					dispose();
					}
				}
		}
