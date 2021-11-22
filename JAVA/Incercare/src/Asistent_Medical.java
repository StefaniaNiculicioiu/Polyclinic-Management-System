import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Asistent_Medical extends JFrame {

	
	private int id;
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Asistent_Medical frame = new Asistent_Medical();
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
	
	public Asistent_Medical() {
		initialize();
}
	public Asistent_Medical(int idU) {
		this.id=idU;
		initialize();}
private void initialize() {
	Image i=new ImageIcon(this.getClass().getResource("/stethoscope-icon.png")).getImage();
	setIconImage(i);
	setTitle("Asistent medical");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(153, 255, 153));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Date suplimentare ");
	lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
	lblNewLabel.setBounds(83, 29, 208, 49);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Tip");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_1.setBounds(17, 124, 63, 18);
	contentPane.add(lblNewLabel_1);
	
	JComboBox cb = new JComboBox(new Object[]{});
	cb.setModel(new DefaultComboBoxModel(new String[] {"Generalist", "Laborator", " Radiologie"}));
	cb.setFont(new Font("Tahoma", Font.PLAIN, 14));
	cb.setBackground(new Color(64, 224, 208));
	cb.setBounds(83, 120, 169, 26);
	contentPane.add(cb);
	
	
	JComboBox cb_1 = new JComboBox(new Object[]{});
	cb_1.setModel(new DefaultComboBoxModel(new String[] {"Secundar", "Principal"}));
	cb_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	cb_1.setBackground(new Color(64, 224, 208));
	cb_1.setBounds(83, 187, 169, 26);
	contentPane.add(cb_1);
	
	
	JLabel lblNewLabel_2 = new JLabel("Grad");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblNewLabel_2.setBounds(17, 185, 56, 31);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("");
	Image img=new ImageIcon(this.getClass().getResource("/Asistent_1.png")).getImage();
	Image newImage2=img.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
	lblNewLabel_3.setIcon(new ImageIcon(newImage2));
	lblNewLabel_3.setBounds(297, 29, 111, 174);
	contentPane.add(lblNewLabel_3);
	
	
	JButton btnNewButton_1 = new JButton("Continuă");
	btnNewButton_1.setBackground(new Color(204, 255, 153));
	Image img1=new ImageIcon(this.getClass().getResource("/Button-Next-icon.png")).getImage();
	btnNewButton_1.setIcon(new ImageIcon(img1));
	btnNewButton_1.setBounds(297, 227, 111, 23);
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String tip=(String) cb.getSelectedItem();
				String grad=(String) cb_1.getSelectedItem();
				Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
				CallableStatement statement = (CallableStatement) c.prepareCall("{call insert_asistent(?,?)}");
		         {
		        	 statement.setString(1, tip);
		        	 statement.setString(2, grad);
		        	 			        	 
		        	 statement.execute();
		             statement.close();
		         }	
	        		 Selectare_modul s=new Selectare_modul(id);
	        		 s.setLocationRelativeTo(null);
	        		 s.setVisible(true);
	        		 dispose();
 				 
            }
			
		catch (Exception ex) {
			ex.printStackTrace();
		        }	
		}	
	});
	contentPane.add(btnNewButton_1);
}
}

