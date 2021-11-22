import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Informatii extends JFrame {

	private JFrame frame;
	private JTextField tfCNP;
	private JTextField tfAdresa;
	private JTextField tfTelefon;
	private JTextField tfEmail;
	private JTextField tfIban;
	private JTextField tfContract;
	private JTextField tfAngajare;
	private JTextField tfSalar;
	private JTextField tfOre;
	private int id;
	private String nume;
	private String prenume;
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
					Informatii window = new Informatii();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Informatii() {
		initialize();
	}

	public Informatii(int id,String nume,String prenume,int idInsp) {
		this.id=id;
		this.nume=nume;
		this.prenume=prenume;
		this.idInsp=idInsp;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 248, 220));
		frame.setBounds(100, 100, 744, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(207, 10, 295, 19);
		frame.getContentPane().add(lblNewLabel);
	    lblNewLabel.setText("Informatiile angajatului "+nume+" "+prenume);
		
		JLabel lblNewLabel_1 = new JLabel("CNP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 60, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adresa");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 100, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numar de telefon");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(30, 140, 119, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(30, 180, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("IBAN");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(30, 220, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Numar contract");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(30, 260, 103, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Data angajarii");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(30, 300, 103, 19);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Salar negociat");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(30, 340, 103, 19);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Numar de ore");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(30, 380, 103, 13);
		frame.getContentPane().add(lblNewLabel_10);
		
		tfCNP = new JTextField();
		tfCNP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCNP.setBackground(new Color(240, 248, 255));
		tfCNP.setBounds(159, 60, 206, 19);
		frame.getContentPane().add(tfCNP);
		tfCNP.setColumns(10);
		
		tfAdresa = new JTextField();
		tfAdresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAdresa.setBackground(new Color(240, 248, 255));
		tfAdresa.setBounds(159, 100, 206, 19);
		frame.getContentPane().add(tfAdresa);
		tfAdresa.setColumns(10);
		
		tfTelefon = new JTextField();
		tfTelefon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTelefon.setBackground(new Color(240, 248, 255));
		tfTelefon.setBounds(159, 140, 206, 19);
		frame.getContentPane().add(tfTelefon);
		tfTelefon.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfEmail.setBackground(new Color(240, 248, 255));
		tfEmail.setBounds(159, 180, 206, 19);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		tfIban = new JTextField();
		tfIban.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfIban.setBackground(new Color(240, 248, 255));
		tfIban.setBounds(159, 220, 206, 19);
		frame.getContentPane().add(tfIban);
		tfIban.setColumns(10);
		
		tfContract = new JTextField();
		tfContract.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfContract.setBackground(new Color(240, 248, 255));
		tfContract.setBounds(159, 260, 206, 19);
		frame.getContentPane().add(tfContract);
		tfContract.setColumns(10);
		
		tfAngajare = new JTextField();
		tfAngajare.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAngajare.setBackground(new Color(240, 248, 255));
		tfAngajare.setBounds(159, 300, 206, 19);
		frame.getContentPane().add(tfAngajare);
		tfAngajare.setColumns(10);
		
		tfSalar = new JTextField();
		tfSalar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfSalar.setBackground(new Color(240, 248, 255));
		tfSalar.setBounds(159, 340, 206, 19);
		frame.getContentPane().add(tfSalar);
		tfSalar.setColumns(10);
		
		tfOre = new JTextField();
		tfOre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfOre.setBackground(new Color(240, 248, 255));
		tfOre.setBounds(159, 380, 206, 19);
		frame.getContentPane().add(tfOre);
		tfOre.setColumns(10);
		
		JButton btnNewButton = new JButton("Inapoi");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insp_AfisareAngajat a=new Insp_AfisareAngajat(idInsp);
				a.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(159, 420, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(388, 100, 319, 293);
		frame.getContentPane().add(lblNewLabel_11);
		Image img=new ImageIcon(this.getClass().getResource("/user-info-icon.png")).getImage();
		lblNewLabel_11.setIcon(new ImageIcon(img));
		Connection c;
			try {
				c = (Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
				Statement statement = c.createStatement();
				statement.execute("call preluareDate('"+id+"');");
				ResultSet rs=statement.getResultSet();
				if(rs.next()) {
					tfCNP.setText(rs.getString(1));
					tfCNP.setEditable(false);
					tfAdresa.setText(rs.getString(2));
					tfAdresa.setEditable(false);
					tfTelefon.setText(rs.getString(3));
					tfTelefon.setEditable(false);
					tfEmail.setText(rs.getString(4));
					tfEmail.setEditable(false);
					tfIban.setText(rs.getString(5));
					tfIban.setEditable(false);
					tfContract.setText(rs.getString(6));
					tfContract.setEditable(false);
					tfAngajare.setText(rs.getString(7));
					tfAngajare.setEditable(false);
					tfSalar.setText(rs.getString(8));
					tfSalar.setEditable(false);
					tfOre.setText(rs.getString(9));
					tfOre.setEditable(false);
					
					
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
	}
}
