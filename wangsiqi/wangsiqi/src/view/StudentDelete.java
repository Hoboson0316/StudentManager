package view;
import Controller.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StudentDelete extends JFrame{
	private JPanel dialogPanel;
	private JPanel contentPanel;
	private JLabel lb_sno1,lb_sno2, lb_sname, lb_ssex, lb_sage, lb_sdept, lb_sclassNo,lb_empty;
	private JTextField  tf_sno1,tf_sno2, tf_sname,tf_ssex, tf_sage, tf_sdept, tf_sclassNo;
	private JPanel buttonBar;
	private JButton bt_delete, bt_close, bt_search;

	public StudentDelete() {
		initComponents();
	}

	public void initComponents() {
		dialogPanel = new JPanel();
		contentPanel = new JPanel();
		lb_sno1 = new JLabel("ѧ��");
		lb_sno2 = new JLabel("ѧ��");
		lb_sname = new JLabel("����");
		lb_ssex = new JLabel("�Ա�");
		lb_sage = new JLabel("����");
		lb_sdept = new JLabel("����ϵ");
		lb_sclassNo = new JLabel("�༶��");
		tf_sno1=new JTextField();
		tf_sno2=new JTextField();
		tf_sname=new JTextField();
		tf_ssex=new JTextField();
		tf_sage=new JTextField();
		tf_sdept=new JTextField();
		tf_sclassNo=new JTextField();
		buttonBar = new JPanel();
		bt_delete = new JButton("ɾ��");
		bt_close = new JButton("�ر�");
		bt_search = new JButton("����");
		lb_empty= new JLabel();

		setTitle("ɾ��ѧ����Ϣ");
		setResizable(false); // ���ڴ�С�Ƿ�����û�����

		Container contentPane = getContentPane(); // ��ô�������
		contentPane.setLayout(new BorderLayout()); // ���������Ĳ��ַ�ʽ

		//dialogPanel.setBorder(new EmptyBorder(12, 12, 12, 12));  //���ñ߿�
		dialogPanel.setLayout(new BorderLayout());
			contentPanel.setLayout(new GridLayout(4, 4, 6, 6));
			
			lb_sno1.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sno1);
			contentPanel.add(tf_sno1);
			
			contentPanel.add(bt_search);
			bt_search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bt_searchActionPerformed(e);
				}
			});
			contentPanel.add(lb_empty);
			
			lb_sno2.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sno2);
			contentPanel.add(tf_sno2);
			
			lb_sname.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sname);
			contentPanel.add(tf_sname);
			
			lb_ssex.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_ssex);
			contentPanel.add(tf_ssex);
			
			lb_sage.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sage);
			contentPanel.add(tf_sage);
			
			lb_sdept.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sdept);
			contentPanel.add(tf_sdept);
			
			lb_sclassNo.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lb_sclassNo);
			contentPanel.add(tf_sclassNo);
			
		dialogPanel.add(contentPanel,BorderLayout.CENTER);
			buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
			buttonBar.setLayout(new GridBagLayout());
			((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[] {0,85,80};    //�������񲼾���С���
			((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[] {1.0,0.0,0.0};  //�������񲼾���Ȩ��
			
			bt_delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bt_deleteActionPerformed(e);
				}
			});
			
			bt_close.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			buttonBar.add(bt_delete);
			buttonBar.add(bt_close);
		dialogPanel.add(buttonBar, BorderLayout.SOUTH);
		contentPane.add(dialogPanel,BorderLayout.CENTER);
		setSize(450,175);
		setLocationRelativeTo(getOwner());
		setVisible(true);
	}

	public void bt_searchActionPerformed(ActionEvent e) {
		
		String sno = tf_sno1.getText().trim();  //��ȡ������˺�
		StuQueryHandler stuQuery = new StuQueryHandler(sno);
		student student = stuQuery.query(sno);  //��ѯ������û�������һ��Student���͵�student
		//ͨ��get()������ȡѧ���������Ϣ������Ϣ���ø�text
		if (student != null) {
			tf_sno2.setText(student.getStu_no());
			tf_sname.setText(student.getStu_name());
			tf_ssex.setText(String.valueOf(student.getStu_sex()));
			tf_sage.setText(String.valueOf(student.getStu_age()));
			tf_sdept.setText(student.getStu_dept());
			tf_sclassNo.setText(student.getStu_classNo());
		} else {
			JOptionPane.showMessageDialog(null, "���޴���!����������ѧ�ţ�");
		}
	}
	
	public void bt_deleteActionPerformed(ActionEvent e) {
		String s= new String(tf_sno2.getText());  //��ȡҪɾ��ѧ����ѧ��
		StuDeleteHandler stu = new StuDeleteHandler(s);
		int i = stu.deleteCou();  //����delect��������ѧ����Ϣ��ɾ��
		if(i == 1) {
			JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
			dispose();
		}
	}
	
	
}
