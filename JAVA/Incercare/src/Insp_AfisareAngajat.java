import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Insp_AfisareAngajat extends JFrame{

	private JFrame frmDateAngajati;
	private JTextField tfNume;
	private JTextField tfPrenume;
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";
	private int idInsp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insp_AfisareAngajat window = new Insp_AfisareAngajat();
					window.frmDateAngajati.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Insp_AfisareAngajat() {
		initialize();
	}
	public Insp_AfisareAngajat(int id) {
		this.idInsp=id;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDateAngajati = new JFrame();
		frmDateAngajati.setTitle("Date angajati");
		frmDateAngajati.setBounds(100, 100, 513, 343);
		frmDateAngajati.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDateAngajati.setVisible(true);
		Image i1=new ImageIcon(this.getClass().getResource("/profile.png")).getImage();
		frmDateAngajati.setIconImage(i1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		frmDateAngajati.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduce\u021Bi datele angajatului");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setBounds(104, 10, 263, 50);
		panel.add(lblNewLabel);
		
		tfNume = new JTextField();
		tfNume.setBounds(214, 70, 212, 29);
		panel.add(tfNume);
		tfNume.setColumns(10);
		
		tfPrenume = new JTextField();
		tfPrenume.setBounds(214, 126, 212, 29);
		panel.add(tfPrenume);
		tfPrenume.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Introduce\u021Bi numele");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(40, 72, 175, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Introduce\u021Bi prenumele");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(40, 128, 164, 21);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Introduce\u021Bi func\u021Bia");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_3.setBounds(40, 179, 164, 21);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Afi\u0219eaz\u0103 date");
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(214, 177, 212, 29);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Inspector resurse umane",
				 "Expert financiar-contabil",
				"Medic",
				"Asistent medical",
				"Receptioner"}));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nume=tfNume.getText();
				String prenume=tfPrenume.getText();
				String functia=(String) comboBox.getSelectedItem();
				int id_f=0;
				if(functia=="Inspector resurse umane") id_f=1;
				if(functia=="Expert financiar-contabil") id_f=2;
				if(functia=="Medic")id_f=3;
				if(functia=="Asistent medical")id_f=4;
				if(functia=="Receptioner") id_f=5;
				Connection c;
				try {
					c = (Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
					Statement statement = c.createStatement();
					statement.executeQuery("select id from utilizator where nume='"+nume+"' and prenume='"+prenume+"'and id_functie='"+id_f+"';");
					ResultSet rs=statement.getResultSet();
					if(rs.next()) {
						int id=rs.getInt(1);
						Informatii aux=new Informatii(id,nume,prenume,idInsp);
						aux.setLocationRelativeTo(null);
						frmDateAngajati.dispose();
					}
					else JOptionPane.showMessageDialog(null, "Angajatul introdus nu exista in baza de date");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnNewButton.setBounds(268, 229, 142, 36);
		Image img=new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon( img));
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(50, 197, 93, 99);
		Image img1=new ImageIcon(this.getClass().getResource("/info.png")).getImage();
		Image newImage = img1.getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		lblNewLabel_4.setIcon(new ImageIcon(newImage));
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestiunea_resurselor_umane_inspector insp=new Gestiunea_resurselor_umane_inspector(idInsp);
				insp.setLocationRelativeTo(null);
				frmDateAngajati.dispose();
			}
		});
		Image img2=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnNewButton_1.setBounds(404, 10, 85, 21);
		btnNewButton_1.setIcon(new ImageIcon(img2));
		panel.add(btnNewButton_1);
		
		
	}
}
