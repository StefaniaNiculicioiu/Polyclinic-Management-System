import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color; 
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class OperatiiFinanciarContabile_angajat extends JFrame{
	
	private int id;
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";

	private JFrame frmSalarii;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatiiFinanciarContabile_angajat window = new OperatiiFinanciarContabile_angajat();
					window.frmSalarii.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OperatiiFinanciarContabile_angajat() {
		initialize();
	}
	
	public OperatiiFinanciarContabile_angajat(int id) {
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSalarii = new JFrame();
		frmSalarii.setTitle("Salarii");
		frmSalarii.setVisible(true);
		frmSalarii.setBounds(100, 100, 577, 389);
		frmSalarii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image i1=new ImageIcon(this.getClass().getResource("/money-icon.png")).getImage();
		frmSalarii.setIconImage(i1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		frmSalarii.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vizualizare salariu:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(97, 158, 189, 31);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selectare_modul m=new Selectare_modul(id);
				m.setLocationRelativeTo(null);
				m.setVisible(true);
				frmSalarii.dispose();
			}
		});
		btnNewButton.setBounds(10, 321, 85, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Vizualizarea salariilor");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(169, 83, 208, 38);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Autentificat ca: Angajat");
		
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBackground(new Color(255, 228, 225));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(60, 10, 258, 31);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Delogare ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Policlinica.main(null);
				frmSalarii.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(414, 10, 106, 32);
		panel.add(btnNewButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 51, 543, 2);
		panel.add(separator);
		
		JLabel lblAngajat = new JLabel("");
		lblAngajat.setBounds(413, 201, 140, 141);
		Image img1=new ImageIcon(this.getClass().getResource("/Medical-Immunologist-Female-Light-icon.png")).getImage();
		lblAngajat.setIcon(new ImageIcon(img1));
		panel.add(lblAngajat);
		
		JLabel lblBani = new JLabel("");
		lblBani.setBounds(50, 199, 124, 112);
		Image img2=new ImageIcon(this.getClass().getResource("/coins-icon.png")).getImage();
		lblBani.setIcon(new ImageIcon(img2));
		panel.add(lblBani);
		
		textField = new JTextField();
		textField.setBounds(296, 158, 124, 30);
		panel.add(textField);
		textField.setColumns(10);
		try {
			Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
			Statement stmt = c.createStatement();
			stmt.executeQuery("select salariu_negociat from utilizator where id='"+id+"';");
			ResultSet rst = stmt.getResultSet();
			if(rst.next()) {
				textField.setText(rst.getString(1));
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
}
