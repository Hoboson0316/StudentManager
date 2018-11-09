package view;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Controller.*; 
import model.*;
public class StudentUpdate extends JFrame{
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
	public StudentUpdate(){ 
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
		setTitle ("�����ѧ��");
		setResizable(false);
		Container contentPane=getContentPane () ;	//��ô���
		contentPane.setLayout (new BorderLayout () ) ;	//���������Ĳ��ַ�ʽ
		dialogPane.setBorder(new EmptyBorder(12, 12, 12,12));//���ñ߿�
		dialogPane.setLayout(new BorderLayout());
		contentPanel.setLayout(new GridLayout(3,4,6,6)); 
		lb_sno.setText ("ѧ��");//���ñ�ǩ�ϵ�����
		//��������ˮƽ����Ķ��뷽ʽ
		lb_sno.setHorizontalAlignment(SwingConstants.RIGHT); 
		contentPanel.add (lb_sno);   //�� contentPanel ���������ѧ�ű�ǩ
		contentPanel.add (tf_sno) ;	//�����������ѧ���ı���
		lb_sname.setText ("����");
		lb_sname.setHorizontalAlignment(SwingConstants.RIGHT); 
		contentPanel.add(lb_sname); 
		contentPanel.add(tf_sname); 
		lb_ssex.setText ("�Ա�");
		lb_ssex.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_ssex);
		contentPanel.add(tf_ssex); 
		lb_sage.setText ("����") ;
		lb_sage.setHorizontalAlignment(SwingConstants.RIGHT); 
		contentPanel.add(lb_sage); 
		contentPanel.add(tf_sage); 
		lb_sdept.setText ("����ϵ");
		lb_sdept.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_sdept);
		contentPanel.add(tf_sdept);
		lb_classNo.setText ("�༶��");
		lb_classNo.setHorizontalAlignment(SwingConstants.RIGHT); 
		contentPanel.add(lb_classNo); 
		contentPanel.add(tf_classNo);
		//��װ��ѧ�š��������齨������contentPanel�ŵ�dialogPane�������� 
		dialogPane.add(contentPanel,BorderLayout.CENTER);
		//��ť������ñ߿�
		buttonBar.setBorder(new EmptyBorder(12,0,0,0)); 
		buttonBar.setLayout(new GridBagLayout());
		((GridBagLayout) buttonBar.getLayout()).columnWidths=new int[]{0,85, 80};	//�������񲼾���С���
		((GridBagLayout) buttonBar.getLayout()).columnWeights=new double []{1.0,0.0,0.0};  //�������񲼾���Ȩ��
		btn_add. setText ("���");	
	}
	//������ѯ��ť��ִ�в�ѯ������������ѯ�����ʾ��ͼ�����ı���� 
		private void btn_queryActionPerformed(ActionEvent e){ 
			String sno=tf_sno_query.getText();
		StuQueryHandler stuQuery=new StuQueryHandler(sno); 
		student student=stuQuery.query(sno); 
		if(student !=null){
			tf_sno.setText(student.getStu_no());
			tf_sname.setText(student.getStu_name());
			tf_ssex.setText(String.valueOf(student.getStu_sex()));
			tf_sage.setText(String.valueOf(student.getStu_age()));
			tf_sdept.setText(student.getStu_dept());
			tf_classNo.setText(student.getStu_classNo());
			}else{
				JOptionPane.showMessageDialog(null,"���޴��ˣ�������ȷ���������ѧ��.");
			}
		}
		private Object getStu_no() {
			// TODO Auto-generated method stub
			return null;
		}
		//�������°�ť��ִ��ѧ����Ϣ�ĸ��²���
		private void btn_updateActionPerformed(ActionEvent e){
			String[] s=new String[6];
			s[0]=new String(tf_sno.getText());
			s[1]=new String(tf_sname.getText());
			s[2]=new String(tf_ssex.getText());
			s[3]=new String(tf_sage.getText());
			s[4]=new String(tf_sdept.getText());
			s[5]=new String(tf_classNo.getText());
		StuUpdateHandler stu=new StuUpdateHandler(s);
		int i=stu.updateStu();
		if(i==1){
			JOptionPane. showMessageDialog(null,"�޸ĳɹ�");
			dispose();
			}
		}
}