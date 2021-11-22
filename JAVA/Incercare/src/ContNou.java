import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ContNou extends JFrame {

	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContNou frame = new ContNou();
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
	public ContNou() {
		Image i=new ImageIcon(this.getClass().getResource("/Actions-contact-new-icon.png")).getImage();
		setIconImage(i);
		setTitle("Creare cont nou");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cont Nou");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(251, 11, 146, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tip utilizator");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(15, 330, 93, 26);
		contentPane.add(lblNewLabel_1);
		
		String functie[]= {"Administrator","Super-administrator","Angajat"};		
		JComboBox cb=new JComboBox(functie);
		cb.setModel(new DefaultComboBoxModel(new String[] {"Administrator", "Super-administrator", "Angajat"}));
		cb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb.setBackground(new Color(64, 224, 208));
		cb.setBounds(118,330,169,26);
		contentPane.add(cb);
		
		JLabel lblNewLabel_2 = new JLabel("CNP");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(15, 100, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(117, 97, 170, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nume");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(15, 139, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prenume");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(15, 175, 79, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Adresa");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(15, 211, 69, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefon");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(15, 247, 74, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(330, 100, 67, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 136, 170, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(117, 172, 170, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 208, 170, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(118, 244, 170, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(462, 97, 170, 25);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(462, 136, 170, 25);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("IBAN");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(330, 178, 67, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(462, 175, 170, 25);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(462, 211, 170, 25);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(462, 243, 170, 26);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		
		JLabel lblNewLabel_9 = new JLabel("Nr. contract");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(330, 214, 86, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Data angajării");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(330, 243, 86, 23);
		contentPane.add(lblNewLabel_10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 0, 0));
		separator.setBounds(218, 40, 183, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_11 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/Programming-Add-Property-icon.png")).getImage();
		Image newImage2=img.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		lblNewLabel_11.setIcon(new ImageIcon(newImage2));
		lblNewLabel_11.setBounds(381, 9, 46, 38);
		contentPane.add(lblNewLabel_11);
		
	JComboBox cb_2 = new JComboBox(new Object[]{});
		cb_2.setModel(new DefaultComboBoxModel(new String[] {"MedLife Cluj", "MedLife Valcea", "MedLife Sibiu", "MedLife Alba", "MedLife Oradea", "MedLife Timisoara", "MedLife Craiova", "MedLife Bucuresti"}));
		cb_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_2.setBackground(new Color(64, 224, 208));
		cb_2.setBounds(293, 367, 169, 26);
		contentPane.add(cb_2);
		
		
		JComboBox cb_1 = new JComboBox(new Object[]{});
		cb_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String tip_functie=(String)cb_1.getItemAt(cb_1.getSelectedIndex()); 
				if (tip_functie.compareToIgnoreCase("Medic")!=0)
					cb_2.setEnabled(true);
				else
					cb_2.setEnabled(false);
			}
			});
		cb_1.setModel(new DefaultComboBoxModel(new String[] {"Asistent medical", "Medic", "Inspector resurse umane", "Receptioner", "Expert financiar-contabil"}));
		cb_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cb_1.setBackground(new Color(64, 224, 208));
		cb_1.setBounds(462, 330, 170, 26);
		contentPane.add(cb_1);
		
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		String functie_angajat=(String) cb.getSelectedItem();
		if (functie_angajat.equals("Angajat"))
		{
			cb_1.setEnabled(true);
		}
		else
		{
			cb_1.setEnabled(false);
		}
			}	
		});
		
		JButton btnNewButton = new JButton("Continu\u0103");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Image img1=new ImageIcon(this.getClass().getResource("/Button-Next-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String cnp=textField.getText();
				String nume=textField_1.getText();
				String prenume=textField_2.getText();
				String adresa=textField_3.getText();
				String tel=textField_4.getText();
				String email=textField_5.getText();
				String iban=textField_7.getText();
				String nr=textField_8.getText();
				String data=textField_9.getText();
				String tip_util=(String)cb.getItemAt(cb.getSelectedIndex()); 
				String parola=textField_6.getText();
				String salar_neg=textField_10.getText();
				String nr_ore=textField_11.getText();
				String tip_functie=(String)cb_1.getItemAt(cb_1.getSelectedIndex()); 
				String unit_medicala=(String)cb_2.getItemAt(cb_2.getSelectedIndex()); 
				Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
				
				if (cnp.isBlank() || nume.isBlank() || prenume.isBlank() || adresa.isBlank() || tel.isBlank() || email.isBlank() || iban.isBlank() || nr.isBlank() || data.isBlank())
					{
					JOptionPane.showMessageDialog(null,"Vă rugăm să completați toate câmpurile goale ","Eroare de logare",JOptionPane.ERROR_MESSAGE) ; 
					}
				else
				{
					
					CallableStatement statement = (CallableStatement) c.prepareCall("{call cont_nou(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			         {
			        	 statement.setString(1, cnp);
			        	 statement.setString(2, nume);
			        	 statement.setString(3, prenume);
			        	 statement.setString(4, adresa);
			        	 statement.setString(5, tel);
			        	 statement.setString(6, email);
			        	 statement.setString(7, iban);
			        	 statement.setString(8, nr);
			        	 statement.setString(9, data);
			        	 statement.setString(10, tip_util);
			        	 statement.setString(11, parola);
			        	 statement.setString(12, salar_neg);
			        	 statement.setString(13, nr_ore);
			        	 statement.setString(14, tip_functie);
			        	 statement.setString(15, unit_medicala);
			        	 statement.execute();
			             statement.close();
			         }
			         
			         if (tip_util.equalsIgnoreCase("Angajat"))
			         {
			         if (tip_functie.equalsIgnoreCase("Asistent Medical"))
			         {
			        Statement stmt1=(Statement) c.createStatement();
         			String sql1="Select id from utilizator where email='"+email+"' and parola='"+parola+"'";
         			stmt1.executeQuery(sql1);
         			ResultSet rs2=stmt1.getResultSet();
         			if(rs2.next()) 
     				{
     			     int id=rs2.getInt(1);
		        		Asistent_Medical s=new Asistent_Medical(id);
		        		 s.setLocationRelativeTo(null);
		        		 s.setVisible(true);
		        		 dispose();
     				}  
			         }
			         else
			        	 if (tip_functie.equalsIgnoreCase("Medic"))
			        	 {  Statement stmt1=(Statement) c.createStatement();
		         			String sql1="Select id from utilizator where email='"+email+"' and parola='"+parola+"'";
		         			stmt1.executeQuery(sql1);
		         			ResultSet rs2=stmt1.getResultSet();
		         			if(rs2.next()) 
		     				{
		     			     int id=rs2.getInt(1);
				        		Functie_Medic s=new Functie_Medic(id);
				        		 s.setLocationRelativeTo(null);
				        		 s.setVisible(true);
				        		 dispose();
		     				}  
			        	 }
			        	 else {
			        		 
				        	    Statement stmt1=(Statement) c.createStatement();
		            			String sql1="Select id,id_tip_utilizator from utilizator where email='"+email+"' and parola='"+parola+"'";
		            			stmt1.executeQuery(sql1);
		            			ResultSet rs2=stmt1.getResultSet();
		            			if(rs2.next()) 
	            				{
	            			     int id=rs2.getInt(1);
	            			     int id2=rs2.getInt(2);
	            			     if(id2!=1 && id2!=2)
				        		 {Selectare_modul s=new Selectare_modul(id);
				        		 s.setLocationRelativeTo(null);
				        		 s.setVisible(true);}
	            			     else {
	            			    	 Administrator a=new Administrator(id,id2);
	            			    	 a.setLocationRelativeTo(null);
	            			    	 a.setVisible(true);
	            			     }
				        		 dispose();
	            				}  
				        	 
			        		 
			        	 }
			        	 
			         }
			        	 else
			        	 {   Statement stmt1=(Statement) c.createStatement();
	            			String sql1="Select id,id_tip_utilizator from utilizator where email='"+email+"' and parola='"+parola+"'";
	            			stmt1.executeQuery(sql1);
	            			ResultSet rs2=stmt1.getResultSet();
	            			if(rs2.next()) 
            				{
            			     int id=rs2.getInt(1);
            			     int id2=rs2.getInt(2);
            			     if(id2!=1 && id2!=2) {
			        		 Selectare_modul s=new Selectare_modul(id);
			        		 s.setLocationRelativeTo(null);
			        		 s.setVisible(true);}
            			     else {
            			    	 Administrator a=new Administrator(id,id2);
            			    	 a.setLocationRelativeTo(null);
            			    	 a.setVisible(true);
            			     }
			        		 dispose();
            				}  
			        	 }
			       
				}
				
			}catch (Exception ex) {
				ex.printStackTrace();
			}	
			}
		});
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setBounds(449, 412, 160, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Am deja un cont");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Image img2=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img2));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Policlinica.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 153));
		btnNewButton_1.setBounds(37, 412, 160, 23);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(15, 317, 646, 9);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_13 = new JLabel("Parola");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(331, 139, 46, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Functie");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(371, 336, 56, 14);
		contentPane.add(lblNewLabel_14);
			
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(15, 404, 636, 2);
		contentPane.add(separator_2);
		
		textField_10 = new JTextField();
		textField_10.setBounds(118, 280, 169, 26);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Salar negociat");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(10, 282, 98, 32);
		contentPane.add(lblNewLabel_15);
		
		textField_11 = new JTextField();
		textField_11.setBounds(462, 280, 170, 26);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Nr. ore");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(330, 291, 46, 14);
		contentPane.add(lblNewLabel_16);
		
	
		JLabel lblNewLabel_12 = new JLabel("Unitate medicala");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(128, 367, 143, 26);
		contentPane.add(lblNewLabel_12);
		
		
	}
}

