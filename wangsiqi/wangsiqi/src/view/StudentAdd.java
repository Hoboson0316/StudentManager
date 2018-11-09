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
		btn_add. setText ("���");	//������Ӱ�ť�ϵ�����
		//��Ӱ�ť�������ڲ��������
		btn_add.addActionListener(new ActionListener() {//�����ڲ��� 
			public void actionPerformed(ActionEvent e){
				btn_addActionPerformed (e);      //������Ӱ�ť��ִ�еķ���
		}
			});
		btn_close.setText("�ر�");
		btn_close.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				dispose();;
				}
			});
		buttonBar.add (btn_add);	//����Ӱ�ť�ŵ����� buttonBar ��
		buttonBar.add(btn_close); 
		dialogPane.add(buttonBar, BorderLayout.SOUTH); 
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize (450,175);	//���ô��ڳߴ�
		setLocationRelativeTo (getOwner () ) ;	//���ô��ڵ�λ��
		setVisible (true) ;	//���ô��ڵĿɼ���
		}
		//������Ӱ�ť��ִ�еķ��������ѧ����Ϣ���������
		private void btn_addActionPerformed(ActionEvent e){ 
			String[] s=new String[6];
			s[0] =new String (tf_sno.getText () ) ;	
			s[1]=new String (tf_sname.getText () ) ;
			s[2]=new String(tf_ssex.getText()); 
			s[3]=new String(tf_sage.getText());
			s[4]=new String(tf_sdept.getText()); 
			s[5]=new String(tf_classNo.getText());
			//����������StuAddHandler����stu�������ַ������鴫��stu
			StuAddHandler stu=new StuAddHandler(s);
				int i=stu.addStu () ;	// stuִ�����ѧ����Ϣ���� 
				if(i==1){
				JOptionPane. showMessageDialog (null,"��ӳɹ�");
					dispose();
					}
				}
		}
