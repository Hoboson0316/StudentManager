package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class MainView extends JFrame {
	private JMenuBar menuBar; // �˵�������
	
	private JMenu menuTable; // ������
	private JMenu menuSelect; // ѡ�κ͵�¼�ɼ�
	private JMenu menuQuery; // ��ѯ
	private JMenu menuSystem; // ϵͳά��
	
	private JMenu menuStudent; // ѧ��
	private JMenu menuCourse; // �γ�
	private JMenu menuSC; // ѡ��
	
	private JMenuItem mi_StuAdd; // ���ѧ���˵���
	private JMenuItem mi_StuUpdate; // ����ѧ���˵���
	private JMenuItem mi_StuDelete; // ɾ��ѧ���˵���
	
	private JMenuItem mi_CouAdd; // ��ӿγ̲˵���
	private JMenuItem mi_CouUpdate; // ���¿γ̲˵���
	private JMenuItem mi_CouDelete; // ɾ���γ̲˵���
	
	private JMenuItem mi_ScAdd; // ���ѡ�β˵���
	private JMenuItem mi_ScUpdate; // ����ѡ�β˵���
	private JMenuItem mi_ScDelete; // ɾ��ѡ�β˵���
	
	private JMenuItem mi_selectCourse; // ѡ�β˵���
	private JMenuItem mi_grade; // ��¼�ɼ��˵���
	
	private JMenuItem mi_QueryStudent; // ��ѯѧ���˵���
	private JMenuItem mi_QueryCourse; // ��ѯ�γ̲˵���
	private JMenuItem mi_QueryGrade; // ��ѯ�ɼ��˵���
	
	private JMenuItem mi_UpdatePassword; // �޸�����˵���
	private JMenuItem mi_exit; // �˳�ϵͳ�˵���
	
	public MainView(){
		menuBar=new JMenuBar();//�����˵�������
		menuTable=new JMenu();//����������˵�����
		menuSelect=new JMenu(); // ����ѡ�κ͵�¼�ɼ��˵�����
		menuQuery=new JMenu(); // ������ѯ�˵�����
		menuSystem=new JMenu(); // ����ϵͳά���˵�����
		
		menuStudent=new JMenu(); // ����ѧ���˵�����
		menuCourse=new JMenu(); // �����γ̲˵�����
		menuSC=new JMenu(); // ����ѡ�β˵�����
		
		mi_StuAdd=new JMenuItem(); // �������ѧ���˵���
		mi_StuUpdate=new JMenuItem(); // ��������ѧ���˵���
		mi_StuDelete=new JMenuItem(); // ����ɾ��ѧ���˵���
		
		mi_CouAdd=new JMenuItem(); // ������ӿγ̲˵���
		mi_CouUpdate=new JMenuItem(); // �������¿γ̲˵���
		mi_CouDelete=new JMenuItem(); // ����ɾ���γ̲˵���
		
		mi_ScAdd=new JMenuItem(); // �������ѡ�β˵���
		mi_ScUpdate=new JMenuItem(); // ��������ѡ�β˵���
		mi_ScDelete=new JMenuItem(); // ����ɾ��ѡ�β˵���
		
		mi_selectCourse=new JMenuItem(); // ����ѡ�β˵���
		mi_grade=new JMenuItem(); // ������¼�ɼ��˵���
		
		mi_QueryStudent=new JMenuItem(); // ������ѯѧ���˵���
		mi_QueryCourse=new JMenuItem(); // ������ѯ�γ̲˵���
		mi_QueryGrade=new JMenuItem(); // ������ѯ�ɼ��˵���
		
		mi_UpdatePassword=new JMenuItem(); // �����޸�����˵���
		mi_exit=new JMenuItem(); // �����˳�ϵͳ�˵���
		
		setTitle("ѧ���ɼ�����ϵͳ");//���ô��ڱ���
		Container contentPane=getContentPane();
		contentPane.setLayout(new BorderLayout());
		  menuTable.setText("���������");
		  
		    menuStudent.setText("ѧ�������");
		      
		      mi_StuAdd.setText("���ѧ����Ϣ");
		      mi_StuAdd.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					 new StudentAdd();
					
				}
			});
		      menuStudent.add(mi_StuAdd);
		      mi_StuUpdate.setText("����ѧ����Ϣ");
		      mi_StuUpdate.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new StudentUpdate();
		    	  }	
		      });
		      menuStudent.add(mi_StuUpdate);
		      
		      mi_StuDelete.setText("ɾ��ѧ����Ϣ");
		      mi_StuDelete.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new StudentDelete();
		    	  }	
		      });
		      menuStudent.add(mi_StuDelete);
		    menuTable.add(menuStudent);//��ѧ����˵���ӵ�������˵���
		    
		    menuCourse.setText("�γ̱����");
		      
		      mi_CouAdd.setText("��ӿγ���Ϣ");
		      mi_CouAdd.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new CourseAdd();
		    	  }	
		      });
		      menuCourse.add(mi_CouAdd);
		      
		      mi_CouUpdate.setText("���¿γ���Ϣ");
		      mi_CouUpdate.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new CourseUpdate();
		    	  }	
		      });
		      menuCourse.add(mi_CouUpdate);
		      
		      mi_CouDelete.setText("ɾ���γ���Ϣ");
		      mi_CouDelete.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new CourseDelete();
		    	  }	
		      });
		      menuCourse.add(mi_CouDelete);
		    menuTable.add(menuCourse);//���γ̱�˵���ӵ�������˵���
		    
		    menuSC.setText("ѡ�α����");
		      
		      mi_ScAdd.setText("���ѡ����Ϣ");
		      mi_ScAdd.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new ScAdd();
		    	  }	
		      });
		      menuSC.add(mi_ScAdd);
		      
		      mi_ScUpdate.setText("����ѡ����Ϣ");
		      mi_ScUpdate.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new ScUpdate();
		    	  }	
		      });
		      menuSC.add(mi_ScUpdate);
		      
		      mi_ScDelete.setText("ɾ��ѡ����Ϣ");
		      mi_ScDelete.addActionListener(new ActionListener(){
		    	  public void actionPerformed(ActionEvent e){
		    		  new ScDelete();
		    	  }	
		      });
		      menuSC.add(mi_ScDelete);
		    menuTable.add(menuSC);//��ѡ�α�˵���ӵ�������˵���
		  
		  menuBar.add(menuTable);//��������˵���ӵ��˵�����
		  
		  
		  		 
		  menuSelect.setText("ѡ�κͳɼ�����");
		    
		    mi_selectCourse.setText("ѡ��γ�");
		    mi_selectCourse.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    //new selectCourse();
	    	    }	
	        });
		    menuSelect.add(mi_selectCourse);//��ѡ�β˵�����ӵ�ѡ�κͳɼ�����˵���
		    
		    mi_grade.setText("��¼�ɼ�");
		    mi_grade.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    //new selectCourse();
	    	    }	
	        });
		    menuSelect.add(mi_grade);//����¼�ɼ��˵�����ӵ�ѡ�κͳɼ�����˵���
		    
		  menuBar.add(menuSelect);//��ѡ�κͳɼ�����˵���ӵ��˵�����
		  
		  
		  
		  
		  menuQuery.setText("��ѯ����");
		    
		    mi_QueryStudent.setText("��ѯѧ����Ϣ");
		    mi_QueryStudent.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    new StudentQuery();
	    	    }	
	        });
		    menuQuery.add(mi_QueryStudent);//����ѯѧ����Ϣ�˵�����ӵ���ѯ����˵���
		    
		    mi_QueryCourse.setText("��ѯ�γ���Ϣ");
		    mi_QueryCourse.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    new CourseQuery();
	    	    }	
	        });
		    menuQuery.add(mi_QueryCourse);//����ѯ�γ���Ϣ�˵�����ӵ���ѯ����˵���
		    
		    mi_QueryGrade.setText("��ѯ�γ̳ɼ�");
		    mi_QueryGrade.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    new ScQuery();
	    	    }	
	        });
		    menuQuery.add(mi_QueryGrade);//����ѯ�γ̳ɼ��˵�����ӵ���ѯ����˵���
		    
		  menuBar.add(menuQuery);//����ѯ����˵���ӵ��˵�����
		  
		  
		  
		  
		  menuSystem.setText("ϵͳά��");
		    
		    mi_UpdatePassword.setText("��������");
		    mi_UpdatePassword.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    //new PasswordUpdate();
	    	    }	
	        });
		    menuSystem.add(mi_UpdatePassword);//����������˵�����ӵ�ϵͳά���˵���
		    
		    menuSystem.addSeparator();//���ò˵��ָ���
		    
		    mi_exit.setText("�˳�");
		    mi_exit.addActionListener(new ActionListener(){
	    	    public void actionPerformed(ActionEvent e){
	    		    //dispose();
	    	    }	
	        });
		    menuSystem.add(mi_exit);//���˳��˵�����ӵ�ϵͳά���˵���
		    
		  menuBar.add(menuSystem);//��ϵͳά���˵���ӵ��˵�����
		  
		  
		  
		  
		  setJMenuBar(menuBar);//��menuBar����Ϊ������Ĳ˵���
		  setSize(500,400);
		  setLocationRelativeTo(getOwner());
		  setVisible(true);
	
	}
	
	//�����û���ݣ����ò�ͬ�Ľ���
	public void setUserview(int userType) {
		switch(userType) {
		case 1://ѧ������
			menuTable.setEnabled(false);
			mi_grade.setEnabled(false);
			break;
		case 2://��ʦ����
			menuTable.setEnabled(false);
			break;
		case 3://����Ա���棬û������
			break;
	    default:
	    	JOptionPane.showMessageDialog(this, "�û����ʹ���");
	 
			
			
		
		}
		
		
	}
	
	
	
	
}
