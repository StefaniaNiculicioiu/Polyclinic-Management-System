import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class Administrator extends JFrame {
	
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";
	private int id;
	private int id_tip;

	private JPanel contentPane;
	private JTextField textSalar;
	private JTextField textAdr;
	private JTextField textTlf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
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
	
	public Administrator() {
		initialize();
	}
	
	public Administrator(int id,int id_tip) {
		this.id=id;
		this.id_tip=id_tip;
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 432);
		Image i=new ImageIcon(this.getClass().getResource("/iconfinder_Medical_health_medicine_healthcare_hospital-71_5897269.png")).getImage();
		setIconImage(i);
		setTitle("Administrare policlinica");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(10, 10, 722, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		if(id_tip==2)
			lblNewLabel.setText("Super-administrator");
		if(id_tip==1)
			lblNewLabel.setText("Administrator");
		lblNewLabel.setBounds(182, 5, 272, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Delogare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Policlinica.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(603, 3, 109, 35);
		panel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 111, 13);
		panel.add(separator);
		separator.setBackground(new Color(255, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 182, 193));
		panel_1.setBounds(10, 50, 111, 335);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Modificare:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 141, 91, 13);
		panel_1.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("Back");
		Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Policlinica.main(null);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(10, 304, 85, 21);
		panel_1.add(btnBack);
		
		JLabel lblSalariu = new JLabel("Salariu:");
		lblSalariu.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalariu.setBounds(311, 107, 82, 13);
		contentPane.add(lblSalariu);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdresa.setBounds(311, 194, 82, 13);
		contentPane.add(lblAdresa);
		
		JLabel lblNewLabel_2 = new JLabel("Telefon:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(311, 279, 82, 13);
		contentPane.add(lblNewLabel_2);
		
		textSalar = new JTextField();
		textSalar.setBounds(433, 103, 96, 25);
		contentPane.add(textSalar);
		textSalar.setColumns(10);
		
		textAdr = new JTextField();
		textAdr.setBounds(433, 190, 96, 25);
		contentPane.add(textAdr);
		textAdr.setColumns(10);
		
		textTlf = new JTextField();
		textTlf.setBounds(433, 275, 96, 25);
		contentPane.add(textTlf);
		textTlf.setColumns(10);
		
		

		JComboBox comboUtilizator = new JComboBox();
		
		try {
			Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
			Statement stmt = c.createStatement();
			if(id_tip==1)
				stmt.executeQuery("select nume,prenume from utilizator where id_tip_utilizator!='2' and id_tip_utilizator!='1'");
			else if(id_tip==2)
				stmt.executeQuery("select nume,prenume from utilizator where id_tip_utilizator!='2'");
				
			ResultSet rst = stmt.getResultSet();
			while(rst.next()) 
			{
				comboUtilizator.addItem(rst.getString(1)+" "+rst.getString(2));
			}
			c.close();
		} 
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		comboUtilizator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux=(String) comboUtilizator.getSelectedItem();
				String[] n=aux.split(" ");
				try {
					Connection c;
					c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
					Statement statement = c.createStatement();
				statement.executeQuery("select nume from utilizator where nume='"+n[0]+"' and prenume='"+n[1]+"';");
				ResultSet rs=statement.getResultSet();
				
				c.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		
		comboUtilizator.setBounds(143, 192, 123, 21);
		contentPane.add(comboUtilizator);
		
		
		
		JButton btnNewButton_1 = new JButton("Confirmare");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String nume=comboUtilizator.getSelectedItem().toString();
					String[] aux=nume.split(" ");
					String salar=textSalar.getText();
					String adresa=textAdr.getText();
					String tel=textTlf.getText();
					
					Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
					Statement stmt=c.createStatement();
					stmt.executeQuery("select id from utilizator where nume='"+aux[0]+"' and prenume='"+aux[1]+"';");
					ResultSet result=stmt.getResultSet();
					int idU=0;
					if(result.next())
						idU=result.getInt(1);
					stmt.close();
					result.close();
					if(textSalar.getText().isBlank() || textAdr.getText().isBlank() || textTlf.getText().isBlank())
						{
							JOptionPane.showMessageDialog(null,"Va rugam, completati cel putin un camp! ","Eroare inregistrare modificare",JOptionPane.ERROR_MESSAGE) ; 	
						}
								
					else
					{
						CallableStatement statement = (CallableStatement) c.prepareCall("{call modificareDate(?,?,?,?)}");
				         {
				        	 statement.setInt(1, idU);
				        	 statement.setString(2, salar);
				        	 statement.setString(3, adresa);
				        	 statement.setString(4, tel);
				        	 statement.execute();
				             statement.close();
				         }
				        
				       
						JOptionPane.showMessageDialog(null,"Modificare adaugata!. ","Confirmare modificare",JOptionPane.INFORMATION_MESSAGE);
					    
						textSalar.setText(null);
						textAdr.setText(null);
						textTlf.setText(null);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
							}
				
	});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(597, 181, 111, 41);
		contentPane.add(btnNewButton_1);
		
		
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(new Color(255, 105, 180));
		separator_1.setBounds(281, 93, 8, 244);
		contentPane.add(separator_1);
		
		JLabel lblAlegere = new JLabel("Alegere utilizator:");
		lblAlegere.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlegere.setBounds(149, 164, 117, 18);
		contentPane.add(lblAlegere);
		
		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setBounds(585, 257, 147, 128);
		Image img1=new ImageIcon(this.getClass().getResource("/Global-Manager-icon.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img1));
		contentPane.add(lblNewLabel_3);
		
		
	}
}
