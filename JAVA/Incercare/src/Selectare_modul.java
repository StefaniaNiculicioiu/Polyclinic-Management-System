import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Selectare_modul extends JFrame {
    
	private int id;
	private JPanel contentPane;
    
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selectare_modul frame = new Selectare_modul();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Selectare_modul() {
		initialize();
}
	public Selectare_modul(int idU) {
		this.id=idU;
		initialize();
	}
private void initialize() {
	Image i=new ImageIcon(this.getClass().getResource("/Programming-Add-Property-icon.png")).getImage();
	setIconImage(i);
	setTitle("Selectare modul");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 673, 466);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(204, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("V\u0103 rug\u0103m selecta\u021Bi modulul dorit");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel.setBounds(10, 94, 402, 50);
	contentPane.add(lblNewLabel);
	
	JButton btnNewButton = new JButton("Opera\u021Bii financiar-contabile");
	btnNewButton.setBackground(new Color(255, 255, 153));
	btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 16));
	btnNewButton.setBounds(337, 187, 300, 61);
	contentPane.add(btnNewButton);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
				Statement stmt=(Statement) c.createStatement();
    			String sql="Select id_functie from utilizator where id='"+id+"';";
    			stmt.executeQuery(sql);
    			ResultSet rs=stmt.getResultSet();
    			if(rs.next()) {
    				int id_tip=rs.getInt(1);
    				if(id_tip==3)
    				{ OperatiiFC_medic d=new OperatiiFC_medic(id);
    				  d.setVisible(true);
    				  d.setLocationRelativeTo(null);
    				}
    				
    				if(id_tip==1 || id_tip==5 || id_tip==4)
    				{ OperatiiFinanciarContabile_angajat op = new OperatiiFinanciarContabile_angajat(id);
    				  op.setLocationRelativeTo(null);
    				}
    			
    				if(id_tip==2)
    				{
    					OperatiiFinanciarContabile_Expert op1=new OperatiiFinanciarContabile_Expert(id);
    					op1.setLocationRelativeTo(null);
    				}
    				}
    			
    				dispose();
    			}
			 catch (SQLException e1) {

				e1.printStackTrace();
			}
			dispose();
		}
	});
	
	JButton btnNewButton_1 = new JButton("Gestiunea resurselor umane");
	btnNewButton_1.setBackground(new Color(255, 153, 153));
	btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
	btnNewButton_1.setBounds(10, 187, 300, 61);
	contentPane.add(btnNewButton_1);
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
				Statement stmt=(Statement) c.createStatement();
    			String sql="Select id_functie from utilizator where id='"+id+"';";
    			stmt.executeQuery(sql);
    			ResultSet rs=stmt.getResultSet();
    			if(rs.next()) {
    				int id_tip=rs.getInt(1);
    				if(id_tip==3 || id_tip==5 || id_tip==4)
    				{ Dep_Medical_Info d=new Dep_Medical_Info(id);
    				  d.setLocationRelativeTo(null);

    				}
    				
    				if(id_tip==1)
    					{Gestiunea_resurselor_umane_inspector insp=new Gestiunea_resurselor_umane_inspector(id);
    					insp.setLocationRelativeTo(null);
    					}
    					
    				if(id_tip==2)
    				{
    					Gestiunea_resurselor_umane_expert exp=new Gestiunea_resurselor_umane_expert(id);
    					exp.setLocationRelativeTo(null);
    				}
    				}
    			
    				dispose();
    			}
			 catch (SQLException e1) {

				e1.printStackTrace();
			}
				
		}
	});
	
	JButton btnNewButton_2 = new JButton("Gestiunea activit\u0103\u021Bilor opera\u021Bionale");
	btnNewButton_2.setBackground(new Color(204, 153, 204));
	btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
	btnNewButton_2.setBounds(188, 277, 300, 61);
	contentPane.add(btnNewButton_2);
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
				Statement stmt=(Statement) c.createStatement();
    			String sql="Select id_functie from utilizator where id='"+id+"';";
    			stmt.executeQuery(sql);
    			ResultSet rs=stmt.getResultSet();
    			if(rs.next()) {
    				int id_tip=rs.getInt(1);
    				if( id_tip==4 || id_tip==3 || id_tip==5 )
    				{
    					GestiuneActivitatiOp exp=new GestiuneActivitatiOp(id);
    					exp.setLocationRelativeTo(null);
    					exp.setVisible(true); 
    					dispose();
    				}
    				else
    					JOptionPane.showMessageDialog(null,"Acces restrictionat doar pentru utilizatorii de tip ASISTENT MEDICAL, MEDIC sau RECEPTIONIST ","Avertisment!",JOptionPane.ERROR_MESSAGE) ; 	    				
    				}  			
    			
    			}
			 catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	});
	
	JButton btnNewButton_3 = new JButton("Back");
	Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
	btnNewButton_3.setIcon(new ImageIcon(img));
	btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Policlinica.main(null);
			dispose();
		}
	});
	btnNewButton_3.setForeground(new Color(255, 0, 0));
	btnNewButton_3.setBackground(new Color(255, 255, 204));
	btnNewButton_3.setBounds(10, 386, 115, 23);
	contentPane.add(btnNewButton_3);
	
	JLabel lblNewLabel_1 = new JLabel("");
	Image img1=new ImageIcon(this.getClass().getResource("/Cursor-Select-icon.png")).getImage();
	lblNewLabel_1.setIcon(new ImageIcon(img1));
	lblNewLabel_1.setBounds(456, 31, 148, 133);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Bine a\u021Bi revenit!");
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	Image img2=new ImageIcon(this.getClass().getResource("/welcome-icon.png")).getImage();
	lblNewLabel_2.setIcon(new ImageIcon(img2));
	lblNewLabel_2.setForeground(new Color(0, 0, 0));
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
	
	lblNewLabel_2.setBounds(87, 10, 223, 50);
	contentPane.add(lblNewLabel_2);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setBounds(10, 142, 338, 2);
	contentPane.add(separator_1);
	contentPane.setVisible(true);
}
}
