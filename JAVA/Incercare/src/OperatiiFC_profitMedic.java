import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class OperatiiFC_profitMedic extends JFrame {
	
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";
	private int id;

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatiiFC_profitMedic frame = new OperatiiFC_profitMedic();
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
	public OperatiiFC_profitMedic() {
		Image i1=new ImageIcon(this.getClass().getResource("/People-Doctor-Female-icon.png")).getImage();
		setIconImage(i1);
		setTitle("Profit medici");
		initialize();
		
	}
	public OperatiiFC_profitMedic(int id) {
		Image i1=new ImageIcon(this.getClass().getResource("/People-Doctor-Female-icon.png")).getImage();
		setIconImage(i1);
		setTitle("Profit medici");
		this.id=id;
		initialize();
		
	}
    public void initialize() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 405);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vizualizare profit medic:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(239, 66, 194, 46);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(10, 10, 671, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Expert financiar-contabil");
		lblNewLabel_1.setBounds(201, 9, 215, 25);
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
		btnNewButton.setBounds(537, 10, 101, 27);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Selectarea lunii:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(62, 132, 113, 13);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboLuna = new JComboBox();
		comboLuna.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboLuna.setModel(new DefaultComboBoxModel(new String[] {"Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie", "Iulie", "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie"}));
		comboLuna.setBounds(56, 146, 119, 21);
		contentPane.add(comboLuna);
		
		JButton btnNewButton_1 = new JButton("Back");
		Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatiiFinanciarContabile_Expert exp=new OperatiiFinanciarContabile_Expert(id);
				exp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(10, 337, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblMedic = new JLabel("");
		lblMedic.setBounds(512, 177, 128, 130);
		Image img1=new ImageIcon(this.getClass().getResource("/People-Doctor-Female-icon.png")).getImage();
		lblMedic.setIcon(new ImageIcon(img1));
		contentPane.add(lblMedic);
		
		JLabel lblPortofel = new JLabel("");
		lblPortofel.setBounds(28, 197, 132, 105);
		Image img2=new ImageIcon(this.getClass().getResource("/wallet-icon.png")).getImage();
		lblPortofel.setIcon(new ImageIcon(img2));
		contentPane.add(lblPortofel);
		
		JComboBox comboMedic = new JComboBox();

		try {
			Connection c;
			c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);	
			Statement statement = c.createStatement();
			statement.executeQuery("select nume,prenume from utilizator where id_functie='3'");
			ResultSet rs=statement.getResultSet();
			while(rs.next())
			{
				comboMedic.addItem(rs.getString(1)+" "+rs.getString(2));
			}
			c.close();
			} catch (SQLException e1) {

			e1.printStackTrace();
			}
		comboMedic.setBounds(466, 148, 193, 21);
		contentPane.add(comboMedic);
		
		JLabel lblNewLabel_5 = new JLabel("Selectarea medicului:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(466, 132, 163, 13);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(301, 326, 193, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		JLabel lblProfit = new JLabel("Profit:");
		lblProfit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfit.setBounds(197, 327, 94, 13);
		contentPane.add(lblProfit);
		lblProfit.setVisible(false);
		JButton btnNewButton_2 = new JButton("Confirmarea selectiei");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s= (String) comboLuna.getSelectedItem();
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
				String num=(String) comboMedic.getSelectedItem();
				String[] medic=num.split(" ");
				Connection c;
				try {
					c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
					Statement statement = c.createStatement();
					statement.executeQuery("select id,cnp from utilizator where nume='"+medic[0]+"' and prenume='"+medic[1]+"';");
					ResultSet rs=statement.getResultSet();
					int idMedic=0;
					String cnpMedic=null;
					if(rs.next())
						{idMedic=rs.getInt(1);
						cnpMedic=rs.getString(2);
						}
						
					statement.clearBatch();
					statement.executeQuery("select pret_servicii from bonFiscal where id_medic='"+idMedic+"' and month(data_bon)='"+luna+"';");
					rs=statement.getResultSet();
					int pret_total=0;
					while(rs.next())
						pret_total=pret_total+rs.getInt((1));
					statement.clearBatch();
					statement.executeQuery("select procent_aditional from medic where cnp_medic='"+cnpMedic+"';");
					rs=statement.getResultSet();
					float procent = 0;
					if(rs.next())
						procent=rs.getFloat(1);
					float total;
					total=procent*pret_total;
					total=total/100;
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
		btnNewButton_2.setBounds(263, 201, 163, 46);
		contentPane.add(btnNewButton_2);
		
    }
}
