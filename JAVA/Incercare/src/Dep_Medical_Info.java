import java.awt.Color;
import java.awt.Dimension;
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
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Dep_Medical_Info extends JFrame {
    
	private int id;
	private JFrame frmInformatiiPersonale;
	private JTextField tfIBAN;
	private JTextField tfNrContr;
	private JTextField tfData;
	private JTextField tfSalar;
	private JTable table;
	private JLabel lblNewLabel_5;
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";
    
	public void time() {
		Thread clock=new Thread() {
		public void run() {
		
		try {
			while(true) {
			Calendar c= Calendar.getInstance();
			lblNewLabel_5.setText("Data curentă:"+c.getTime());
			sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		
	};
	clock.start();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dep_Medical_Info window = new Dep_Medical_Info();
					window.frmInformatiiPersonale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dep_Medical_Info() {
		initialize();
	    time();
	}
    public Dep_Medical_Info(int idU) {
    	this.id=idU;
    	initialize();
    	time();
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
		frmInformatiiPersonale = new JFrame();
		frmInformatiiPersonale.setTitle("Informatii personale");
		frmInformatiiPersonale.getContentPane().setBackground(new Color(230, 230, 250));
		frmInformatiiPersonale.setBounds(100, 100, 764, 751);
		frmInformatiiPersonale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInformatiiPersonale.getContentPane().setLayout(null);
		frmInformatiiPersonale.setVisible(true);
		 Image i1=new ImageIcon(this.getClass().getResource("/doctor-icon.png")).getImage();
			frmInformatiiPersonale.setIconImage(i1);
		
		JLabel lblNewLabel = new JLabel("Informa\u021Bii personale");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.BOLD, 24));
		lblNewLabel.setBounds(208, 217, 296, 33);
		frmInformatiiPersonale.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IBAN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(95, 285, 90, 24);
		frmInformatiiPersonale.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numar contract");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(95, 311, 134, 30);
		frmInformatiiPersonale.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data angajare");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(95, 343, 114, 24);
		frmInformatiiPersonale.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Salar");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(95, 369, 114, 30);
		frmInformatiiPersonale.getContentPane().add(lblNewLabel_4);
		
		tfIBAN = new JTextField();
		tfIBAN.setBackground(new Color(248, 248, 255));
		tfIBAN.setBounds(259, 285, 184, 19);
		frmInformatiiPersonale.getContentPane().add(tfIBAN);
		tfIBAN.setColumns(10);
		
		tfNrContr = new JTextField();
		tfNrContr.setBackground(new Color(248, 248, 255));
		tfNrContr.setBounds(259, 314, 184, 19);
		frmInformatiiPersonale.getContentPane().add(tfNrContr);
		tfNrContr.setColumns(10);
		
		tfData = new JTextField();
		tfData.setBackground(new Color(248, 248, 255));
		tfData.setBounds(259, 343, 184, 19);
		frmInformatiiPersonale.getContentPane().add(tfData);
		tfData.setColumns(10);
		
		tfSalar = new JTextField();
		tfSalar.setBackground(new Color(248, 248, 255));
		tfSalar.setBounds(259, 372, 184, 19);
		frmInformatiiPersonale.getContentPane().add(tfSalar);
		tfSalar.setColumns(10);
		
		JLabel lblImg = new JLabel("");
		lblImg.setBounds(516, 258, 184, 151);
		Image img1=new ImageIcon(this.getClass().getResource("/Doctor_icon (1).png")).getImage();
		lblImg.setIcon(new ImageIcon(img1));
		frmInformatiiPersonale.getContentPane().add(lblImg);
		
		JButton btnBack = new JButton("");
		btnBack.setBounds(10, 10, 50, 21);
		Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Selectare_modul s=new Selectare_modul(id);
				s.setLocationRelativeTo(null);
				s.setVisible(true);
				frmInformatiiPersonale.dispose();
			}

		});
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		frmInformatiiPersonale.getContentPane().add(btnBack);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 436, 602, 227);
		frmInformatiiPersonale.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(248, 248, 255));
		table.setBounds(101, 294, 578, 179);
		scrollPane.setViewportView(table);
		table.setBounds(337, 285, 236, 100);
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null}
				},
				new String[] {
					"Data", "Interval orar","Locatia","Concediu"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(90);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			table.getColumnModel().getColumn(2).setPreferredWidth(90);
			table.getColumnModel().getColumn(3).setPreferredWidth(30);
			table.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(),20));
			table.getTableHeader().setReorderingAllowed(false);
			table.setRowHeight(35);
		
	    lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(330, 673, 351, 28);
		frmInformatiiPersonale.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("/screenshot.png")).getImage();
		Image newImage2 = img2.getScaledInstance(627, 151, Image.SCALE_DEFAULT);
		lblNewLabel_6.setIcon(new ImageIcon(newImage2));
		lblNewLabel_6.setBounds(59, 21, 627, 151);
		frmInformatiiPersonale.getContentPane().add(lblNewLabel_6);
		Connection c;
		try {
			c = (Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
			Statement statement = c.createStatement();
            String sql1="select IBAN,nr_contract,data_angajarii,salariu_negociat from utilizator where id='"+id+"'";
			statement.executeQuery(sql1);
			ResultSet rs=statement.getResultSet();
			if(rs.next()) {
				tfIBAN.setText(rs.getString(1));
				tfNrContr.setText(String.valueOf(rs.getInt(2)));
				tfData.setText(rs.getDate(3).toString());
				tfSalar.setText(String.valueOf(rs.getInt(4)));
				
			}
			tfData.setEditable(false);
			tfNrContr.setEditable(false);
			tfIBAN.setEditable(false);
			tfSalar.setEditable(false);
			Statement statement1 = c.createStatement();
			statement1.executeQuery("select data_inceput_concediu,data_sfarsit_concediu from orar_generic "
					+ "where id='"+id+"';");
			ResultSet rs1=statement1.getResultSet();
	       
			if(rs1.next()){
				LocalDate data_inceput=convertToLocalDateViaMilisecond(rs1.getDate(1));
				LocalDate data_sfarsit=convertToLocalDateViaMilisecond(rs1.getDate(2));
			LocalDate data=LocalDate.now();
			if(data.isBefore(data_inceput)|| data.isAfter(data_sfarsit)) {
				LocalDate inceputSaptamana=null;
				
				if(data.getDayOfWeek()==DayOfWeek.MONDAY) 
					inceputSaptamana=data;
				if(data.getDayOfWeek()==DayOfWeek.TUESDAY)
					inceputSaptamana=data.minusDays(1);
				if(data.getDayOfWeek()==DayOfWeek.WEDNESDAY)
					inceputSaptamana=data.minusDays(2);
				if(data.getDayOfWeek()==DayOfWeek.THURSDAY)
					inceputSaptamana=data.minusDays(3);
				if(data.getDayOfWeek()==DayOfWeek.FRIDAY)
					inceputSaptamana=data.minusDays(4);
				if(data.getDayOfWeek()==DayOfWeek.SATURDAY)
					inceputSaptamana=data.minusDays(5);
				if(data.getDayOfWeek()==DayOfWeek.SUNDAY)
					inceputSaptamana=data.minusDays(6);
				LocalDate sfarsitSaptamana=inceputSaptamana.plusDays(6);
				Statement stmt3=c.createStatement();
				stmt3.execute("select cnp from utilizator where id='"+id+"';");
				ResultSet r=stmt3.getResultSet();
				String cnp=null;
				if(r.next())
				{   
					cnp=r.getString(1);
					Statement stmt4=c.createStatement();
					stmt4.execute("call  getOrarProgramari('"+cnp+"');");
					ResultSet r1=stmt4.getResultSet();
					int j=0;
					while(r1.next()) {
						
						LocalDate d=convertToLocalDateViaMilisecond(r1.getDate(1));
						if(d.isBefore(sfarsitSaptamana)&& d.isAfter(inceputSaptamana))
						{ 
							table.getModel().setValueAt(d.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)).toString(),j, 0);
							LocalTime t=r1.getTime(2).toLocalTime();
							LocalTime t2=t.plusMinutes(r1.getInt(3));
							table.getModel().setValueAt(t.toString()+" - "+t2.toString(), j, 1);
							table.getModel().setValueAt(r1.getString(4), j, 2);
							table.getModel().setValueAt("---", j, 3);
							j++;
							
						}
					}
				}
				
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Angajatul este in concediu in saptamana curenta");
				table.getModel().setValueAt("---", 0, 0);
				table.getModel().setValueAt("---", 0, 1);
				table.getModel().setValueAt("---", 0, 2);
				table.getModel().setValueAt("DA", 0, 3);
			}
			}
			else JOptionPane.showMessageDialog(null, "Nu există concediu înregistrat și nu se poate afișa orarul");
			
			   
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	
	}
}
