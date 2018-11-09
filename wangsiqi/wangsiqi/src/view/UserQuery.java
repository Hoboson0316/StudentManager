package view;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import Controller.UserQueryHandler;
import java.awt.*;
import java.awt.event.*;

public class UserQuery extends JFrame{

	private JTable table;  
    private JTextField tf_id; 
    private String[] heads={"id", "name","pass", "userYype"};
    public UserQuery(){
      super();
      final BorderLayout borderLayout=new BorderLayout();
      getContentPane().setLayout (borderLayout);  
      setTitle( "用户信息查询"); 
      final JPanel panel_browser=new JPanel();
      getContentPane().add(panel_browser,BorderLayout.NORTH);
      panel_browser.setLayout (new GridLayout(1,3));
      JLabel lb_id=new JLabel("用户编号");
      lb_id.setHorizontalAlignment (SwingConstants.RIGHT);
      tf_id=new JTextField() ; 
      JButton btn_query=new JButton("查询");  
      btn_query. addActionListener (new ActionListener() {
           public void actionPerformed (ActionEvent e) {
                  btn_queryActionPerformed(e) ;
           }
      });
      panel_browser.add(lb_id) ;
      panel_browser.add(tf_id) ;  
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
      btn_close.setText("关闭");
      panel_close.add (btn_close);
      setSize (500,320);
      setLocationRelativeTo (getOwner()); 
      setVisible(true);
    }
    private void btn_queryActionPerformed (ActionEvent e){
        String id=tf_id.getText() ;
        UserQueryHandler userQuery=new UserQueryHandler (id) ;
        Object[][] results=null;  
        results=userQuery.query();
        if (results.length==0)
            JOptionPane.showMessageDialog(null,"抱歉！没有要查找的学生！");
        DefaultTableModel model=new DefaultTableModel () ;
        model.setDataVector(results,heads);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        table.setModel(model);  
    }
}
