import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.Component;
import javax.swing.border.EmptyBorder;

public class GestiuneActivitatiOp extends JFrame{

	private static int id;
	private JFrame frame;

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
					GestiuneActivitatiOp window = new GestiuneActivitatiOp();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestiuneActivitatiOp() {
		initialize();
	}
	public GestiuneActivitatiOp(int id) {
		this.id=id;
		initialize();
	}
	public void initialize() {
       setTitle("Gestiunea activitatilor operationale");
		
		getContentPane().setBackground(new Color(245, 245, 220));
		setBounds(100, 100, 642, 445);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
				JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(28, 79, 574, 69);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDeptMed = new JLabel("DEPARTAMENTUL MEDICAL");
		lblDeptMed.setForeground(Color.DARK_GRAY);
		lblDeptMed.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeptMed.setBounds(82, 10, 391, 46);
		panel_1.add(lblDeptMed);
		lblDeptMed.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		JButton btnAsistentMed = new JButton("");
		Image i=new ImageIcon(this.getClass().getResource("/nurse-pngrepo-com.png")).getImage();
		btnAsistentMed.setIcon(new ImageIcon(i));
		btnAsistentMed.setBorder(null);
		btnAsistentMed.setBackground(null);
		btnAsistentMed.setBounds(267, 216, 96, 96);
		getContentPane().add(btnAsistentMed);
		
		btnAsistentMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
					Statement stmt=(Statement) c.createStatement();
	    			String sql="Select id_functie from utilizator where id='"+id+"';";
	    			stmt.executeQuery(sql);
	    			ResultSet rs=stmt.getResultSet();
	    			if(rs.next()) {
	    				int id_tip=rs.getInt(1);
	    				if( id_tip==4 )
	    				{
	    					AsistentMed_raport as=new AsistentMed_raport(id);
	    					as.setLocationRelativeTo(null);
	    					dispose();
	    				}
	    				else
	    					JOptionPane.showMessageDialog(null,"Acces restrictionat doar pentru utilizatorii de tip ASISTENT MEDICAL ","Avertisment!",JOptionPane.ERROR_MESSAGE) ; 	    				
	    				}  			
	    			
	    			}
				 catch (SQLException e1) {

					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnMedic = new JButton("");
		Image ii=new ImageIcon(this.getClass().getResource("/doctor-icon (1).png")).getImage();
		btnMedic.setIcon(new ImageIcon(ii));
		btnMedic.setSelectedIcon(new ImageIcon(ii));
		btnMedic.setBounds(437, 216, 96, 96);
		btnMedic.setBackground(null);
		btnMedic.setBorder(null);
		getContentPane().add(btnMedic);
		
		btnMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
					Statement stmt=(Statement) c.createStatement();
	    			String sql="Select id_functie from utilizator where id='"+id+"';";
	    			stmt.executeQuery(sql);
	    			ResultSet rs=stmt.getResultSet();
	    			if(rs.next()) {
	    				int id_tip=rs.getInt(1);
	    				if( id_tip==3 )
	    				{
	    					Medic m=new Medic(id);
	    					m.setLocationRelativeTo(null);
	    					dispose();
	    				}
	    				else
	    					JOptionPane.showMessageDialog(null,"Acces restrictionat doar pentru utilizatorii de tip MEDIC ","Avertisment!",JOptionPane.ERROR_MESSAGE) ; 	    				
	    				}
	    			
	    			
	    			}
				 catch (SQLException e1) {

					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnReceptionist = new JButton("");
		Image img=new ImageIcon(this.getClass().getResource("/medical-report-icon.png")).getImage();
		btnReceptionist.setIcon(new ImageIcon(img));
		Image imgRecep=new ImageIcon(this.getClass().getResource("/medical-report-icon.png")).getImage();
		setIconImage(imgRecep);
		btnReceptionist.setBorder(null);
		btnReceptionist.setBounds(93, 216, 96, 96);
		btnReceptionist.setBackground(null);
		
		btnReceptionist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
					Statement stmt=(Statement) c.createStatement();
	    			String sql="Select id_functie from utilizator where id='"+id+"';";
	    			stmt.executeQuery(sql);
	    			ResultSet rs=stmt.getResultSet();
	    			if(rs.next()) {
	    				int id_tip=rs.getInt(1);
	    				if( id_tip==5 )
	    				{
	    				 Receptie r=new Receptie(id);
	    				 r.setLocationRelativeTo(null);
	    				dispose();
	    				}
	    				else
	    					JOptionPane.showMessageDialog(null,"Acces restrictionat doar pentru utilizatorii de tip RECEPTIONIST ","Avertisment!",JOptionPane.ERROR_MESSAGE) ; 	    				
	    				}
	    			
	    			
	    			}
				 catch (SQLException e1) {

					e1.printStackTrace();
				}
				
				
			}
		});
		
		getContentPane().add(btnReceptionist);
		
		JLabel lblReceptionist = new JLabel("Receptionist");
		lblReceptionist.setLabelFor(btnReceptionist);
		lblReceptionist.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblReceptionist.setForeground(Color.BLACK);
		lblReceptionist.setBounds(88, 328, 120, 27);
		getContentPane().add(lblReceptionist);
		
		JLabel lblAsistent = new JLabel("Asistent Medical");
		lblAsistent.setLabelFor(btnAsistentMed);
		lblAsistent.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAsistent.setBounds(249, 322, 143, 39);
		getContentPane().add(lblAsistent);
		
		JLabel lblMedic = new JLabel("Medic");
		lblMedic.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMedic.setBounds(461, 328, 57, 27);
		getContentPane().add(lblMedic);
		
		JLabel lblNewLabel = new JLabel("SELECTATI DOMENIUL DE ACTIVITATE: ");
		lblNewLabel.setBackground(new Color(176, 224, 230));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(31, 166, 571, 27);
		getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		Image img1=new ImageIcon(this.getClass().getResource("/hospital-icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(276, 10, 72, 72);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		Image img2=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 Selectare_modul sel=new Selectare_modul(id);
			 sel.setLocationRelativeTo(null);
			 sel.setVisible(true);
			 dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 204));
		btnNewButton.setBounds(10, 10, 49, 20);
		getContentPane().add(btnNewButton);
		
	}
}