package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Controller.*;
import model.*;

public class ScDelete extends JFrame{
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
	private JLabel tf_sno_query;
	private JLabel tf_cno_query;
	public ScDelete(){
		initComponents();
	}
	private void initComponents() {
		dialogPane=new JPanel();
		contentPanel=new JPanel();
		lb_sno=new JLabel();
		tf_sno=new JTextField();
		lb_cno=new JLabel();
		tf_cno=new JTextField();
		lb_grade=new JLabel();
		tf_grade=new JTextField();
		buttonBar=new JPanel();
		btn_add=new JButton();
		btn_close=new JButton();
		
		setTitle("ɾ��ѡ��");
		setResizable(false);
		Container contentPane=getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		dialogPane.setBorder(new EmptyBorder(12,12,12,12));
		dialogPane.setLayout(new BorderLayout());
		contentPanel.setLayout(new GridLayout(3,4,6,6));
		
		lb_sno.setText("ѧ��ѧ��");
		lb_sno.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_sno);
		contentPanel.add(tf_sno);
		lb_cno.setText("�γ̱��");
		lb_cno.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_cno);
		contentPanel.add(tf_cno);
		lb_grade.setText("�ɼ�");
		lb_grade.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPanel.add(lb_grade);
		contentPanel.add(tf_grade);
		dialogPane.add(contentPanel,BorderLayout.CENTER);
		buttonBar.setBorder(new EmptyBorder(12,0,0,0));
		buttonBar.setLayout(new GridBagLayout());
		((GridBagLayout)buttonBar.getLayout()).columnWidths=new int[]{0,85,80};
		((GridBagLayout)buttonBar.getLayout()).columnWeights=new double[]{1.0,0.0,0.0};
		btn_add.setText("ɾ��");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_deleteActionPerformed(e);
			}
		});
		btn_close.setText("�ر�");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonBar.add(btn_add);
		buttonBar.add(btn_close);
		dialogPane.add(buttonBar,BorderLayout.SOUTH);
		contentPane.add(dialogPane,BorderLayout.CENTER);
		setSize(450,175);
		setLocationRelativeTo(getOwner());
		setVisible(true);
	}
	private void btn_queryActionPerformed(ActionEvent e) {
		String sno=tf_sno_query.getText();
		String cno=tf_cno_query.getText();
		ScQueryHandler scQuery=new ScQueryHandler(sno,cno);
		Sc sc=scQuery.query(sno,cno);
		if(sc!=null) {
			tf_sno.setText(sc.getStu_no());
			tf_cno.setText(sc.getcou_no());
			tf_grade.setText(String.valueOf(sc.getSc_Grade()));
			
		}else{
			JOptionPane.showMessageDialog(null, "û�����ѡ�Σ�������ȷ���������ѧ�źͿγ̱�š�");
		}
	}
	private void btn_deleteActionPerformed(ActionEvent e) { 
		String s=new String(tf_sno.getText());
		String c=new String(tf_cno.getText());
	     ScDeleteHandler sc=new ScDeleteHandler(s,c) ;
	     int i=sc.deleteSc(); 
	     if(i==1) {
	         JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
	         dispose() ;
	     }
	 }
}
