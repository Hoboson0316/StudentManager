package view;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import Controller.ScQueryHandler;
import java.awt.*;
import java.awt.event.*;

public class ScQuery extends JFrame {
	private JTable table;  
    private JTextField tf_sno; 
    private JTextField tf_cno;
    private String[] heads={"sno", "cno","grade"};
    public ScQuery(){
    	super();
        final BorderLayout borderLayout=new BorderLayout();
        getContentPane().setLayout (borderLayout);  
        setTitle( "ѡ����Ϣ��ѯ"); 
        final JPanel panel_browser=new JPanel();
        getContentPane().add(panel_browser,BorderLayout.NORTH);
        panel_browser.setLayout (new GridLayout(1,3));
        JLabel lb_sno=new JLabel("ѧ��");
        lb_sno.setHorizontalAlignment (SwingConstants.RIGHT);
        tf_sno=new JTextField() ;
        JLabel lb_cno=new JLabel("�γ̱��");
        lb_cno.setHorizontalAlignment (SwingConstants.RIGHT);
        tf_cno=new JTextField() ;
        JButton btn_query=new JButton("��ѯ");  
        btn_query. addActionListener (new ActionListener() {
             public void actionPerformed (ActionEvent e) {
                    btn_queryActionPerformed(e) ;
             }
        });
        panel_browser.add(lb_sno) ;
        panel_browser.add(tf_sno) ;  
        panel_browser.add(lb_cno) ;
        panel_browser.add(tf_cno) ;
        panel_browser.add(btn_query) ;
        final JPanel panel_main=new JPanel () ;
        final BorderLayout borderLayout_main=new BorderLayout();
        borderLayout_main. setVgap(5) ;  
        panel_main. setLayout (borderLayout_main) ;
        getContentPane().add(panel_main,BorderLayout. CENTER) ;
        final JScrollPane scrollPane=new JScrollPane(); 
        panel_main.add (scrollPane);  
        table=new JTable();
        table. setAutoResizeMode (JTable. AUTO_RESIZE_OFF);
        scrollPane.setViewportView(table);  
        final JPanel panel_close=new JPanel();
        panel_close.setBorder (new LineBorder (SystemColor .activeCaptionBorder,1,false));
        getContentPane().add (panel_close, BorderLayout.SOUTH) ;
        final FlowLayout flowLayout=new FlowLayout ();
        flowLayout. setVgap(2) ;  
        flowLayout. setHgap (30) ;  
        flowLayout. setAlignment (FlowLayout. RIGHT); 
        panel_close. setLayout (flowLayout) ;
        final JButton btn_close=new JButton() ;
        btn_close. addActionListener (new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                 dispose () ;
             }
        });
        btn_close.setText("�ر�");
        panel_close.add (btn_close);
        setSize (500,320);
        setLocationRelativeTo (getOwner()); 
        setVisible(true);
      }
    private void btn_queryActionPerformed (ActionEvent e){
        String sno=tf_sno.getText();
        String cno=tf_cno.getText();
        ScQueryHandler scQuery=new ScQueryHandler (sno,cno) ;
        Object[][] results=null ;  
        results=scQuery.query() ;
        if (results. length==0)
            JOptionPane.showMessageDialog(null,"��Ǹ��û��Ҫ���ҵ�ѧ����");
        DefaultTableModel model=new DefaultTableModel () ;
        model.setDataVector(results,heads);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        table.setModel(model);  
    }
}
