package view;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

import model.BaseDao; 

public class login extends JFrame{

	private JLabel lb_user;            //�����û�����ǩ
	private JTextField tf_user;        //�����û����ı���
	private JLabel lb_pass; //���������ǩ
	private JPasswordField pf_pass; //������������
	private JRadioButton rb_student; //����ѧ����ѡť
	private JRadioButton rb_teacher; 
	private JRadioButton rb_admin;
	private ButtonGroup bg_group;//������ѡ��ť��
	private JButton btn_ok; 
	private JButton btn_cancel; 
	public login(){
		initComponents();
	}
	private void initComponents(){
		lb_user=new JLabel(); //�����û�����ǩ����
		tf_user=new JTextField(); 
		lb_pass=new JLabel(); 
		pf_pass=new JPasswordField(); 
	    rb_student=new JRadioButton ("ѧ�� " );
	    rb_teacher=new JRadioButton("��ʦ"); 
	    rb_admin=new JRadioButton ("����Ա");
	    bg_group=new ButtonGroup();
	    btn_ok=new JButton();
	    btn_cancel=new JButton();
	    setTitle ("��¼����");	//���õ�¼�������
	    setResizable(false);
	    Container contentPane=getContentPane(); 
	    contentPane.setLayout(new BorderLayout());
	    //����contentPanel�е�����������벼�֣����е�¼���� 
	    JPanel contentPanel=new JPanel(); 
	    contentPanel.setLayout (new GridLayout (3,2)); 	
	    lb_user.setText ("�û���");
	    lb_user.setHorizontalAlignment(SwingConstants.RIGHT); 
	    contentPanel.add(lb_user); 
	    contentPanel.add(tf_user); 
	    lb_pass.setText ("����");
	    lb_pass.setHorizontalAlignment(SwingConstants.RIGHT); 
	    contentPanel.add(lb_pass); 
	    contentPanel.add(pf_pass); 
	    btn_ok.setText ("ȷ��");
	    btn_ok.addActionListener(new ActionListener(){ 
	    	public void actionPerformed(ActionEvent e){
	    		btn_okActionPerformed(e);
	    		}
	    	});
	    contentPanel.add(btn_ok); 
	    btn_cancel.setText ("ȡ��");
	    btn_cancel.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){ 
	    		dispose();
	    		}
	    	});
	    	contentPanel.add(btn_cancel); 
	    	contentPane.add(contentPanel, BorderLayout.CENTER); 
	    	bg_group.add(rb_student); 
	    	bg_group.add(rb_teacher); 
	    	bg_group.add(rb_admin);
	    	//����contentPanel2�еĵ�ѡ��ť���ã����ϵ�¼����
	    	JPanel contentPanel2=new JPanel();
	    	//����ѡ��ť��ӵ�����
	    	contentPanel2.add(rb_student,true); 
	    	contentPanel2.add(rb_teacher); 
	    	contentPanel2.add(rb_admin); 
	    	contentPane.add(contentPanel2,BorderLayout.SOUTH);
	    	setSize (250,150);
	    	setLocationRelativeTo(getOwner()); 
	    	setVisible(true);
	    	}
	//����ȷ����ť���¼���Ӧ���������ݿ����û����ж��û��Ƿ��ǺϷ��û�
	private void btn_okActionPerformed(ActionEvent e){
		String username=tf_user.getText().trim();
		String pass=String.valueOf(pf_pass.getPassword()).replaceAll(" ", "");
		String sql=null;
		int userTypeLog=0;
		if (username.equals("")){
			JOptionPane.showMessageDialog(this,"�û���������Ϊ�գ�");
			return;
			}
		if (rb_student.isSelected()) {	//�ж��Ƿ���ѧ���û�
			userTypeLog=1;
			sql="select*from userman where name='"+username+"'AND pass='"+pass+ "'AND userType='student'";
			}
		if (rb_teacher.isSelected () ) {	//�ж��Ƿ��ǽ�ʦ�û�
			userTypeLog=2;
			sql="select*from userman where name='"+username+" 'AND pass='"+pass+"'AND userType='teacher'";
			}
		if (rb_admin. isSelected () ) {	//�ж��Ƿ��ǹ���Ա�û�
			userTypeLog=3;
			sql="select*from userman where name='"+username+"'AND pass='"+pass+"'AND userType='admin'";
			}
		if (sql==null) {
			JOptionPane. showMessageDialog (this,"��ѡ���û�����!");
			return;
			}
		try{
			//�����û��������롢�û�������͖�ѯ���ݿ⣬�ж��Ƿ�Ϊ�Ϸ��û� 
			java.sql.ResultSet result=BaseDao.executeQuery(sql); 
			if( result.next () ==false) {	//�Ƿ��û����ر�����
				JOptionPane.showMessageDialog(this, "�û����벻��ȷ��");
				BaseDao.close(); 
				return;
				}
			MainView mainview=new MainView();	//�Ϸ��û�����������
			mainview.setUserview (userTypeLog) ;	//�����û���ݵ��ò�ͬ����
			dispose ();	//�رմ���
			}
		catch(Exception ee){
			ee.printStackTrace();
			}
		}
	public static void main(String[] args) {
		new login();
	}
}