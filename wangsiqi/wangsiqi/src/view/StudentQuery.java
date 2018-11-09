package view;

import javax.swing.*;
import javax.swing.border.LineBorder; 
import javax.swing.table.*; 
import Controller.StuQueryHandler; 
import java.awt.*; 
import java.awt.event.*;

public class StudentQuery extends JFrame{
	private JTable table;	//����һ�� JTable ��ı�����
	private JTextField tf_sno;	//����һ�� JTextField ���ѧ���ı������
	//������ͷ����Ϣ���ַ�������
	private String[] heads={"Sno","Sname","Ssex","Sage","Sdept","ClassNo"};
	public StudentQuery (){ 
		super();
	final BorderLayout borderLayout=new BorderLayout(); 
	getContentPane().setLayout (borderLayout) ;	//�����������ַ�ʽ
	setTitle ("ѧ����Ϣ��ѯ") ; 
	final JPanel panel_browser=new JPanel();	//���� JPanel ����������
	getContentPane().add(panel_browser, BorderLayout.NORTH); 
	panel_browser.setLayout(new GridLayout(1,3));
	JLabel lb_sno=new JLabel ("ѧ��");
	lb_sno.setHorizontalAlignment(SwingConstants.RIGHT); 
	tf_sno=new JTextField () ;	//����ѧ���ı������
	JButton btn_query=new JButton ("��ѯ");	//������ѯ��ť����
	//��ѯ��ť�������ڲ��������
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
	borderLayout_main.setVgap (5) ;	//�������֮��Ĵ�ֱ���
	panel_main.setLayout(borderLayout_main); 
	getContentPane().add(panel_main,BorderLayout.CENTER); 
	final JScrollPane scrollPane=new JScrollPane () ;	//�������������
	panel_main.add (scrollPane) ;	//��ӹ������
	table=new JTable () ;	//����������
	//�������󱻵���ʱ�����ñ���Ƿ��Զ�������ȡ���Ϊ��������� 
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
	scrollPane.setViewportView (table) ;	//����һ���ӿڲ���������ͼ
	final JPanel panel_close=new JPanel();
	//����panel_close�ߵ���ɫ��Ϊ��ǰ����ڵı߿���ɫ������Ⱥ͹ս����� 
	panel_close.setBorder(new LineBorder(SystemColor.activeCaptionBorder,1,false));
	getContentPane().add(panel_close,BorderLayout.SOUTH);
	final FlowLayout flowLayout=new FlowLayout();
	flowLayout. setVgap (2) ;	//�������֮��Ĵ�ֱ���
	flowLayout. setHgap (30) ;	//�������֮���ˮƽ���
	flowLayout. setAlignment (FlowLayout. RIGHT) ; //�������֮f˾��ֻ���뷽ʽ
	panel_close.setLayout(flowLayout);
	final JButton btn_close=new JButton();
	btn_close.addActionListener(new ActionListener(){
		public void actionPerformed(final ActionEvent e){ 
			dispose ();
			}
		});
	btn_close.setText ("�ر�");
	panel_close.add(btn_close); 
	setSize(500,320);
	setLocationRelativeTo (getOwner () ) ;	//���ô��ھ�����ʾ
	setVisible(true);
	}
	//������ѯ��ť���¼���Ӧִ�в�ѯ������ͨ�����������stuQuery��ִ�в�ѯ����
	private void btn_queryActionPerformed(ActionEvent e){
		String sno=tf_sno.getText();
		StuQueryHandler stuQuery=new StuQueryHandler(sno);
		Object [][] results=null;	//��¼��ѯ����Ķ�ά����
		results=stuQuery.query(); 
		if (results.length==0)
			JOptionPane.showMessageDialog(null, "��Ǹ��û��Ҫ���ҵ�ѧ��");
		DefaultTableModel model=new DefaultTableModel () ;//�����������еı�
		model.setDataVector (results, heads) ;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		table. setModel (model) ;	//���˱������Դ����Ϊmodel
		}
}
