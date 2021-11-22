import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Insp_Servicii extends JFrame {

	private JFrame frmConcedii;
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";
    private int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insp_Servicii window = new Insp_Servicii();
					window.frmConcedii.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Insp_Servicii() {
		initialize();
	}
	public Insp_Servicii(int id) {
		this.id=id;
		initialize();
	}
	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConcedii = new JFrame();
		frmConcedii.setTitle("Concedii");
		frmConcedii.getContentPane().setBackground(new Color(240, 255, 240));
		frmConcedii.setBounds(100, 100, 613, 413);
		frmConcedii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConcedii.getContentPane().setLayout(null);
		frmConcedii.setVisible(true);
		Image i1=new ImageIcon(this.getClass().getResource("/infopers.png")).getImage();
		frmConcedii.setIconImage(i1);
		
		JLabel lblNewLabel = new JLabel("Introducere concedii");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(111, 20, 350, 22);
		frmConcedii.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("");
		Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.setOpaque(false);
		btnBack.setBorder(null);
		btnBack.setBackground(null);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestiunea_resurselor_umane_inspector a=	new Gestiunea_resurselor_umane_inspector(id);
				a.setLocationRelativeTo(null);
				frmConcedii.dispose();
				
			}
		});
		btnBack.setBounds(10, 20, 40, 21);
		frmConcedii.getContentPane().add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Selecta\u021Bi angajatul al c\u0103rui concediu dori\u021Bi s\u0103 \u00EEl introduce\u021Bi</html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(27, 60, 219, 62);
		frmConcedii.getContentPane().add(lblNewLabel_1);
		
		JLabel lblInceput = new JLabel("<html>Selecta\u021Bi data \u00EEnceputului concediului</html>");
		lblInceput.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblInceput.setBounds(27, 160, 198, 40);
		frmConcedii.getContentPane().add(lblInceput);
		lblInceput.setVisible(false);
		
		JLabel lblSfarsit = new JLabel("<html>Selecta\u021Bi data sf\u00E2r\u0219itului concediului</html>");
		lblSfarsit.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblSfarsit.setBounds(27, 260, 166, 40);
		frmConcedii.getContentPane().add(lblSfarsit);
		lblSfarsit.setVisible(false);
		
		JDateChooser inceputConcediu = new JDateChooser();
		inceputConcediu.setSize(255, 22);
		inceputConcediu.setLocation(299, 166);
		frmConcedii.getContentPane().add(inceputConcediu);
		inceputConcediu.setVisible(false);
		
		JDateChooser sfarsitConcediu = new JDateChooser();
		sfarsitConcediu.setSize(255, 22);
		sfarsitConcediu.setLocation(299, 262);
		frmConcedii.getContentPane().add(sfarsitConcediu);
		sfarsitConcediu.setVisible(false);
		
		JButton btnNewButton = new JButton("Confirmare");
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnNewButton.setBounds(239, 328, 112, 30);
		frmConcedii.getContentPane().add(btnNewButton);
		btnNewButton.setVisible(false);
		
		JComboBox<String> comboBox = new JComboBox();
	
		try {	
			Connection c= DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
			Statement stmt=c.createStatement();
			stmt.executeQuery("select id,nume,prenume from utilizator order by id;");
			ResultSet rs=stmt.getResultSet();
			while(rs.next()) {
				comboBox.addItem(rs.getInt(1)+". "+rs.getString(2)+" "+rs.getString(3));
			}
			c.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux=comboBox.getSelectedItem().toString();
				if(!aux.isBlank())
				{   
					lblInceput.setVisible(true);
					lblSfarsit.setVisible(true);
					inceputConcediu.setVisible(true);
					sfarsitConcediu.setVisible(true);
					btnNewButton.setVisible(true);
				}
				}
			
		});
		comboBox.setBackground(new Color(245, 255, 250));
		comboBox.setFont(new Font("Tahoma", Font.ITALIC, 14));
		comboBox.setBounds(299, 83, 255, 21);
		frmConcedii.getContentPane().add(comboBox);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux=comboBox.getSelectedItem().toString();
				LocalDate dataInceput=inceputConcediu.getDate().toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate();;
				LocalDate dataSfarsit=sfarsitConcediu.getDate().toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDate();
				if(dataInceput.getDayOfWeek()!=DayOfWeek.MONDAY)
				{
					JOptionPane.showMessageDialog(null, "<html>Data început concediu trebuie sa fie Luni, vă rugăm selectați altă dată</html>");
					inceputConcediu.setDate(null);
				}
				else {
					if(dataSfarsit.getDayOfWeek()!=DayOfWeek.SUNDAY)
					{
						JOptionPane.showMessageDialog(null, "<html>Data sfârșit concediu trebuie sa fie Duminică, vă rugăm selectați altă dată</html>");
						sfarsitConcediu.setDate(null);
					}
					else {
						String[] a=aux.split(". ");
						int idUtilizator=Integer.parseInt(a[0]);
						Connection c;
						try {
							c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);	
							Statement stmt=c.createStatement();
							stmt.execute("call inserareConcediu('"+idUtilizator+"','"+dataInceput+"','"+dataSfarsit+"');");
							stmt.close();
							JOptionPane.showMessageDialog(null,"Concediu adaugat");
							lblInceput.setVisible(false);
							lblSfarsit.setVisible(false);
							inceputConcediu.setVisible(false);
							inceputConcediu.setDate(null);
							sfarsitConcediu.setDate(null);
							sfarsitConcediu.setVisible(false);
							btnNewButton.setVisible(false);
						
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					}
				}
				
			}
		});
		
	
		
	}
}
