package view;

import javax.swing.*;
import javax.swing.border.LineBorder; 
import javax.swing.table.*; 
import Controller.StuQueryHandler; 
import java.awt.*; 
import java.awt.event.*;

public class StudentQuery extends JFrame{
	private JTable table;	//声明一个 JTable 类的表格对象
	private JTextField tf_sno;	//声明一个 JTextField 类的学号文本框对象
	//定义表格头部信息的字符串数组
	private String[] heads={"Sno","Sname","Ssex","Sage","Sdept","ClassNo"};
	public StudentQuery (){ 
		super();
	final BorderLayout borderLayout=new BorderLayout(); 
	getContentPane().setLayout (borderLayout) ;	//设置容器布局方式
	setTitle ("学生信息査询") ; 
	final JPanel panel_browser=new JPanel();	//创建 JPanel 型容器对象
	getContentPane().add(panel_browser, BorderLayout.NORTH); 
	panel_browser.setLayout(new GridLayout(1,3));
	JLabel lb_sno=new JLabel ("学号");
	lb_sno.setHorizontalAlignment(SwingConstants.RIGHT); 
	tf_sno=new JTextField () ;	//创建学号文本框对象
	JButton btn_query=new JButton ("查询");	//创建查询按钮对象
	//査询按钮的匿名内部类监听器
	btn_query.addActionListener(new ActionListener(){ 
		public void actionPerformed(ActionEvent e){ 
			btn_queryActionPerformed(e);
			}
		});
	panel_browser.add(lb_sno);
	panel_browser.add(tf_sno); 
	panel_browser.add(btn_query);
	
	final JPanel panel_main=new JPanel();
	final BorderLayout borderLayout_main=new BorderLayout(); 
	borderLayout_main.setVgap (5) ;	//设置组件之间的垂直间距
	panel_main.setLayout(borderLayout_main); 
	getContentPane().add(panel_main,BorderLayout.CENTER); 
	final JScrollPane scrollPane=new JScrollPane () ;	//创建滚动类对象
	panel_main.add (scrollPane) ;	//添加滚动面板
	table=new JTable () ;	//创建表格对象
	//当表格对象被调整时，设置表格是否自动调整宽度。设为不调整宽度 
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
	scrollPane.setViewportView (table) ;	//创建一个视口并设置其视图
	final JPanel panel_close=new JPanel();
	//设置panel_close边的颜色（为当前活动窗口的边框颜色）、厚度和拐角类型 
	panel_close.setBorder(new LineBorder(SystemColor.activeCaptionBorder,1,false));
	getContentPane().add(panel_close,BorderLayout.SOUTH);
	final FlowLayout flowLayout=new FlowLayout();
	flowLayout. setVgap (2) ;	//设置组件之间的垂直间距
	flowLayout. setHgap (30) ;	//设置组件之间的水平间距
	flowLayout. setAlignment (FlowLayout. RIGHT) ; //设置组件之f司的只才齐方式
	panel_close.setLayout(flowLayout);
	final JButton btn_close=new JButton();
	btn_close.addActionListener(new ActionListener(){
		public void actionPerformed(final ActionEvent e){ 
			dispose ();
			}
		});
	btn_close.setText ("关闭");
	panel_close.add(btn_close); 
	setSize(500,320);
	setLocationRelativeTo (getOwner () ) ;	//设置窗口居中显示
	setVisible(true);
	}
	//单击查询按钮后，事件响应执行查询操作，通过控制类对象stuQuery来执行查询操作
	private void btn_queryActionPerformed(ActionEvent e){
		String sno=tf_sno.getText();
		StuQueryHandler stuQuery=new StuQueryHandler(sno);
		Object [][] results=null;	//记录查询结果的二维数组
		results=stuQuery.query(); 
		if (results.length==0)
			JOptionPane.showMessageDialog(null, "抱歉！没有要査找的学生");
		DefaultTableModel model=new DefaultTableModel () ;//—个零列零行的表
		model.setDataVector (results, heads) ;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		table. setModel (model) ;	//将此表的数据源设置为model
		}
}
