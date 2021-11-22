import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

////import com.mysql.jdbc.CallableStatement;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import java.sql.*;

public class Policlinica extends JFrame {

	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Policlinica frame = new Policlinica();
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
	public Policlinica() {
	
	    initialize();
	}
	private void initialize() {
		setBackground(new Color(144, 238, 144));
		Image i=new ImageIcon(this.getClass().getResource("/iconfinder_Medical_health_medicine_healthcare_hospital-71_5897269.png")).getImage();
		setIconImage(i);
		setTitle("MedLife");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 529);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("          MedLife");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(142, 27, 297, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Servicii medicale dedicate");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(187, 87, 252, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(48, 215, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Parola");
		lblNewLabel_4.setBounds(48, 283, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(159, 213, 114, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(159, 278, 86, 20);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Intră în cont");
		Image img=new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
             String email_1=textField.getText();
             String password_1=passwordField_1.getText();
             if (email_1.isBlank() || password_1.isBlank())
             {
            	 JOptionPane.showMessageDialog(null,"Introduceți email/parola ","Eroare de logare",JOptionPane.ERROR_MESSAGE) ; 
              textField.setText(null);
              passwordField_1.setText(null);
             }
             else
             {
            	 try {
            	 Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
            	          			 
            			Statement stmt=(Statement) c.createStatement();
            			String sql="Select * from utilizator where email='"+email_1+"' and parola='"+password_1+"'";
            			ResultSet rs=stmt.executeQuery(sql);
            			Statement stmt1=(Statement) c.createStatement();
            			String sql1="Select id, id_tip_utilizator from utilizator where email='"+email_1+"' and parola='"+password_1+"'";
            			stmt1.executeQuery(sql1);
            			ResultSet rs2=stmt1.getResultSet();
            			if (rs.next())
            			{
            				 JOptionPane.showMessageDialog(null,"Login successfully!") ; 
            				 if(rs2.next()) 
            				{
            					 int id=rs2.getInt(1);
            					 int id_tip=rs2.getInt(2);
            					 if(id_tip==1 || id_tip==2)
            					 {
            						 Administrator a=new Administrator(id,id_tip);
            						 a.setLocationRelativeTo(null);
            						 a.setVisible(true);
            						 dispose();
            					 }
            					 else {
            					 Selectare_modul m=new Selectare_modul(id);
            					 m.setLocationRelativeTo(null);
            					 m.setVisible(true); 
            					 dispose();}
            					 
            				}
            				
            			}
            			else
    			        	 JOptionPane.showMessageDialog(null,"Email/parola incorect ","Eroare de logare",JOptionPane.ERROR_MESSAGE) ; 
    			         
            		c.close();
            	 }catch (Exception ex) {
     				ex.printStackTrace();
     			}
            	
             }
			}        
		});
		
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setBounds(48, 434, 150, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Nu ai cont?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(322, 397, 114, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Cont nou");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(286, 434, 150, 25);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContNou.main(null);
				dispose();
			}
		});
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(133, 120, 334, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/doctor.png")).getImage();
		Image newImage= img1.getScaledInstance(170, 170,Image.SCALE_DEFAULT);
		lblNewLabel_5.setIcon(new ImageIcon(newImage));
		lblNewLabel_5.setBounds(402, 174, 172, 173);
		contentPane.add(lblNewLabel_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(47, 388, 379, 1);
		contentPane.add(separator);
	}
}