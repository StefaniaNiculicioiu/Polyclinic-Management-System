import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class Functie_Medic extends JFrame {
    private int id;
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Functie_Medic frame = new Functie_Medic();
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
	public Functie_Medic() {
    initialize();
}
	
	public Functie_Medic(int idU) {
		this.id=idU;
		initialize();
	}
private void initialize()
{
	Image i=new ImageIcon(this.getClass().getResource("/Injection-icon.png")).getImage();
	setIconImage(i);
	setTitle("Medic");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(500, 100, 558, 350);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 204, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Date suplimentare");
	lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
	lblNewLabel.setBounds(57, 25, 182, 32);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Specialitate");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_1.setBounds(10, 104, 73, 17);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Grad");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_2.setBounds(10, 144, 46, 14);
	contentPane.add(lblNewLabel_2);
	
	JComboBox cb = new JComboBox(new Object[]{});
	cb.setModel(new DefaultComboBoxModel(new String[] {"Specialist", "Primar"}));
	cb.setFont(new Font("Tahoma", Font.PLAIN, 14));
	cb.setBackground(new Color(153, 255, 153));
	cb.setBounds(93, 138, 146, 26);
	contentPane.add(cb);
	
	JLabel lblNewLabel_3 = new JLabel("Cod paraf\u0103");
	lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_3.setBounds(10, 178, 73, 17);
	contentPane.add(lblNewLabel_3);
	
	textField_1 = new JTextField();
	textField_1.setBounds(93, 178, 146, 26);
	contentPane.add(textField_1);
	textField_1.setColumns(10);
	
	JLabel lblNewLabel_5 = new JLabel("Titlu \u0219tiin\u021Bific");
	lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_5.setBounds(334, 104, 91, 17);
	contentPane.add(lblNewLabel_5);
	
	JLabel lblNewLabel_6 = new JLabel("Post didactic");
	lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_6.setBounds(334, 144, 91, 14);
	contentPane.add(lblNewLabel_6);
	
	JComboBox cb_2 = new JComboBox(new Object[]{});
	cb_2.setModel(new DefaultComboBoxModel(new String[] {"Doctorand ", "Doctor în științe medicale", "Fără titlu științific"}));
	cb_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	cb_2.setBackground(new Color(153, 255, 153));
	cb_2.setBounds(435, 99, 99, 26);
	contentPane.add(cb_2);
	
	JComboBox cb_3 = new JComboBox(new Object[]{});
	cb_3.setModel(new DefaultComboBoxModel(new String[] {"Preparator", "Asistent", "\u0218ef de lucr\u0103ri (lector)", "Conferen\u021Biar", "Profesor", "F\u0103r\u0103 post didactic"}));
	cb_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	cb_3.setBackground(new Color(153, 255, 153));
	cb_3.setBounds(435, 138, 99, 26);
	contentPane.add(cb_3);
	
	JLabel lblNewLabel_10 = new JLabel("");
	Image img=new ImageIcon(this.getClass().getResource("/People-Doctor-Male-icon.png")).getImage();
	Image newImage2=img.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
	lblNewLabel_10.setIcon(new ImageIcon(newImage2));
	lblNewLabel_10.setBounds(262, 11, 116, 79);
	contentPane.add(lblNewLabel_10);
	
	JComboBox cb_4 = new JComboBox(new Object[]{});
	cb_4.setModel(new DefaultComboBoxModel(new String[] {"Radiologie si Imagistica medicala", "Cardiologie", "Urologie", "Diabet si Nutritie", "Chirurgie generala", "Chirurgie toracica", "Nefrologie", "Neurochirurgie", "Neurologie", "Pneumologie", "Chirurgie Pediatrica", "Gastroenterologie", "Chirurgie spinala"}));
	cb_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
	cb_4.setBackground(new Color(152, 251, 152));
	cb_4.setBounds(93, 99, 231, 26);
	contentPane.add(cb_4);
	
	JButton btnNewButton_1 = new JButton("Continuă");
	btnNewButton_1.setBackground(new Color(204, 255, 153));
	Image img1=new ImageIcon(this.getClass().getResource("/Button-Next-icon.png")).getImage();
	btnNewButton_1.setIcon(new ImageIcon(img1));
	btnNewButton_1.setBounds(423, 274, 111, 23);
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			 JOptionPane.showMessageDialog(null,"Login successfully!") ; 
	         Selectare_modul s=new Selectare_modul(id);
	         s.setLocationRelativeTo(null);
	         s.setVisible(true);
		dispose();
		}
	});
		
	
	contentPane.add(btnNewButton_1);
	JButton btnNewButton_2 = new JButton("Introducere date");
	btnNewButton_2.setBackground(new Color(152, 251, 152));
	btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnNewButton_2.setBounds(206, 227, 156, 23);
		
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String specialitate=(String) cb_4.getSelectedItem();
				String grad=(String) cb.getSelectedItem();
				String cod_parafa= textField_1 .getText();
				String titlu=(String) cb_2.getSelectedItem();
				String post=(String) cb_3.getSelectedItem();
				String procent=textField_2 .getText();
				Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
				CallableStatement statement = (CallableStatement) c.prepareCall("{call insert_medic(?,?,?,?,?,?)}");
		         {
		        	 statement.setString(1,grad);
		        	 statement.setString(2, cod_parafa);
		        	 statement.setString(3, titlu);	
		        	 statement.setString(4, post);
		        	 statement.setString(5, procent);
		        	 statement.setString(6,specialitate);
		        	 
		        	 statement.execute();
		             statement.close();
		         }			        
            }
			
		catch (Exception ex) {
			ex.printStackTrace();
		        }	
		}	
	});

	contentPane.add(btnNewButton_2);
	JLabel lblNewLabel_7 = new JLabel("Procent");
	lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_7.setBounds(334, 179, 73, 14);
	contentPane.add(lblNewLabel_7);
	
	textField_2 = new JTextField();
	textField_2.setText("");
	textField_2.setBounds(433, 176, 101, 26);
	contentPane.add(textField_2);
	textField_2.setColumns(10);
	
	JComboBox cb_4_1 = new JComboBox(new Object[]{});
	cb_4_1.setModel(new DefaultComboBoxModel(new String[] {"MedLife Cluj", "MedLife Valcea", "MedLife Sibiu", "MedLife Alba", "MedLife Oradea", "MedLife Timisoara", "MedLife Craiova", "MedLife Bucuresti"}));
	cb_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	cb_4_1.setBackground(new Color(221, 160, 221));
	cb_4_1.setBounds(118, 274, 135, 26);
	contentPane.add(cb_4_1);
	
	JLabel lblNewLabel_4 = new JLabel("Unitate medicala");
	lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_4.setBounds(10, 274, 135, 26);
	contentPane.add(lblNewLabel_4);
	
	JButton btnNewButton = new JButton("Adauga");
	btnNewButton.setBackground(new Color(221, 160, 221));
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	btnNewButton.setBounds(289, 276, 89, 23);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				
				String unit_medicala=(String) cb_4_1.getSelectedItem();
				Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
				CallableStatement statement = (CallableStatement) c.prepareCall("{call insert_unitate(?)}");
		         {
		        	 
		        	 statement.setString(1,unit_medicala);
		        	 statement.execute();
		             statement.close();
		         }	
            }
			
		catch (Exception ex) {
			ex.printStackTrace();
		        }	
		}	
	});
	contentPane.add(btnNewButton);
	
	JSeparator separator = new JSeparator();
	separator.setBounds(12, 261, 522, 2);
	contentPane.add(separator);
	
	
	
	
}
}

