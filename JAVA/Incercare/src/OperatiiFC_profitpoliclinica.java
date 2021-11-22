import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class OperatiiFC_profitpoliclinica extends JFrame {
	
	private int id;
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatiiFC_profitpoliclinica frame = new OperatiiFC_profitpoliclinica();
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
	public OperatiiFC_profitpoliclinica() {
		Image i1=new ImageIcon(this.getClass().getResource("/money-icon.png")).getImage();
		setIconImage(i1);
		setTitle("Profit policlinica");
      initialize();
	}
	
	public OperatiiFC_profitpoliclinica(int id) {
		Image i1=new ImageIcon(this.getClass().getResource("/money-icon.png")).getImage();
		setIconImage(i1);
		setTitle("Profit policlinica");
		this.id=id;
	      initialize();
		}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vizulizare profit policlinica:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(52, 107, 200, 46);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(10, 10, 527, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Expert financiar-contabil");
		lblNewLabel_1.setBounds(148, 9, 215, 25);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("Delogare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Policlinica.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(416, 10, 101, 27);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Selectarea lunii:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(350, 107, 113, 13);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie", "Iulie", "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie"}));
		comboBox.setBounds(350, 121, 113, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Back");
		Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatiiFinanciarContabile_Expert opex = new OperatiiFinanciarContabile_Expert(id);
				opex.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 286, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblProfit = new JLabel("Profit:");
		lblProfit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfit.setBounds(149, 268, 78, 13);
		contentPane.add(lblProfit);
		lblProfit.setVisible(false);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 245, 238));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(247, 267, 129, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("Confirmarea selectiei");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s= (String) comboBox.getSelectedItem();
				int luna=0;
				if(s.compareTo("Ianuarie")==0)
					luna=1;
				if(s.compareTo("Februarie")==0)
					luna=2;
				if(s.compareTo("Martie")==0)
					luna=3;
				if(s.compareTo("Aprilie")==0)
					luna=4;
				if(s.compareTo("Mai")==0)
					luna=5;
				if(s.compareTo("Iunie")==0)
					luna=6;
				if(s.compareTo("Iulie")==0)
					luna=7;
				if(s.compareTo("August")==0)
					luna=8;
				if(s.compareTo("Septembrie")==0)
					luna=9;
				if(s.compareTo("Octombrie")==0)
					luna=10;
				if(s.compareTo("Noiembrie")==0)
					luna=11;
				if(s.compareTo("Decembrie")==0)
					luna=12;
				
				Connection c;
				try {
					c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
					Statement statement = c.createStatement();
				    statement.executeQuery("select id_unitate_medicala from utilizator where id='"+id+"';");
				    ResultSet rs=statement.getResultSet();
				    int idUnitate=0;
				    if(rs.next())
				    	idUnitate=rs.getInt(1);
				    statement.clearBatch();
				    statement.executeQuery("select salariu_negociat from utilizator where id_unitate_medicala='"+idUnitate+"';");
				    float salarii=0;
				    rs=statement.getResultSet();
				    while(rs.next())
				    	salarii=salarii+rs.getFloat(1);
				    statement.clearBatch();
				    statement.executeQuery("select medic.cnp_medic from medic,unitate_medic where medic.cnp_medic=unitate_medic.cnp_medicul and unitate_medic.id_unitate_medicala='"+idUnitate+"';");
				    rs=statement.getResultSet();
				    float profitMedici=0;
				    while(rs.next())
				    {
				    	String cnp=rs.getString(1);
				    	Statement stmt=c.createStatement();
				    	stmt.executeQuery("select id from utilizator where cnp='"+cnp+"';");
				    	ResultSet result=stmt.getResultSet();
				    	int idMedic=0;
				    	if(result.next())
				    		id=result.getInt(1);
				    	stmt.clearBatch();
				    	stmt.executeQuery("select pret_servicii from bonFiscal where id_medic='"+idMedic+"' and month(data_bon)='"+luna+"';");
				    	float profitMedic=0;
				    	result=stmt.getResultSet();
				    	while(result.next())
				    		profitMedic=profitMedic+result.getInt(1);
				    	stmt.clearBatch();
				    	stmt.executeQuery("select procent_aditional from medic where cnp_medic='"+cnp+"';");
				    	result=stmt.getResultSet();
				    	float procent=0;
				    	if(result.next())
				    		procent=result.getFloat(1);
				    	float profitPoliclinica=profitMedic;
				    	profitMedic=procent*profitMedic;
				    	profitMedic=profitMedic/100;
				    	profitPoliclinica=profitPoliclinica-profitMedic;
				    	profitMedici=profitMedici+profitPoliclinica;
				    	stmt.close();
				    	
				    }
				    float total=profitMedici-salarii;
				    textField.setText(String.valueOf(total));
				    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			
				lblProfit.setVisible(true);
				textField.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(195, 163, 181, 46);
		contentPane.add(btnNewButton_2);
		
		JLabel lblSpital = new JLabel("");
		lblSpital.setBounds(409, 186, 113, 103);
		Image img1=new ImageIcon(this.getClass().getResource("/hospital-icon (1).png")).getImage();
		lblSpital.setIcon(new ImageIcon(img1));
		contentPane.add(lblSpital);
		
		JLabel lblBani = new JLabel("");
		lblBani.setBounds(24, 148, 140, 128);
		Image img2=new ImageIcon(this.getClass().getResource("/money-icon.png")).getImage();
		lblBani.setIcon(new ImageIcon(img2));
		contentPane.add(lblBani);
		
	
	}
}
