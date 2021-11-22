import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;

import com.jgoodies.looks.Options;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
public class Insp_ConsultareOrar extends JFrame {

	private JFrame frame;
	private JTable table;
    private JLabel lblNewLabel_3;
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";
	private int id;

	public JTable getTable() {
		return table;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insp_ConsultareOrar window = new Insp_ConsultareOrar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void time() {
		Thread clock=new Thread() {
		public void run() {
		
		try {
			while(true) {
			Calendar c= Calendar.getInstance();
			lblNewLabel_3.setText("Data curentă:"+c.getTime());
			sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		
	};
	clock.start();
	}
	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}

	/**
	 * Create the application.
	 */
	public Insp_ConsultareOrar() {
		initialize();
		time();
	}
	public Insp_ConsultareOrar(int id) {
		this.id=id;
		initialize();
		time();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Orar");
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		Image i1=new ImageIcon(this.getClass().getResource("/orar.png")).getImage();
		frame.setIconImage(i1);
		
		JLabel lblNewLabel = new JLabel("Consultare orar s\u0103pt\u0103m\u00E2nal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(116, 38, 378, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alege\u021Bi departamentul");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(18, 102, 173, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnRS = new JRadioButton("Resurse umane");
		rdbtnRS.setOpaque(false);
		rdbtnRS.setBorder(null);
		rdbtnRS.setFont(new Font("Tahoma", Font.ITALIC, 13));
		rdbtnRS.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnRS.setBounds(201, 105, 131, 21);
		frame.getContentPane().add(rdbtnRS);
		
		JRadioButton rdbtnEc = new JRadioButton("Economic");
		rdbtnEc.setFont(new Font("Tahoma", Font.ITALIC, 13));
		rdbtnEc.setOpaque(false);
		rdbtnEc.setBounds(360, 105, 103, 21);
		frame.getContentPane().add(rdbtnEc);
		
		JRadioButton rdbtnMed = new JRadioButton("Medical");
		rdbtnMed.setOpaque(false);
		rdbtnMed.setFont(new Font("Tahoma", Font.ITALIC, 13));
		rdbtnMed.setBounds(484, 105, 103, 21);
		frame.getContentPane().add(rdbtnMed);
		
		JLabel lblNewLabel_2 = new JLabel("Selecta\u021Bi angajatul");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(10, 148, 156, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.ITALIC, 13));
		comboBox.setBounds(206, 151, 226, 21);
		frame.getContentPane().add(comboBox);
		
		rdbtnRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnRS.isSelected())
				{
					rdbtnMed.setSelected(false);
					rdbtnEc.setSelected(false);
					Connection c;
					try {
						c = (Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
						Statement statement = c.createStatement();
						statement.executeQuery("select nume,prenume from utilizator where id_departament='1';");
						ResultSet rs=statement.getResultSet();
						comboBox.removeAllItems();
						 while (rs.next())
					        {      
					           String s = rs.getString(1)+" "+rs.getString(2);  
					           comboBox.addItem(s);
					         
					        }
					} catch (SQLException e1) {
						e1.printStackTrace();
					}		
					
					
					
				}
			}
		});
		
		rdbtnEc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnEc.isSelected())
				{
					rdbtnMed.setSelected(false);
					rdbtnRS.setSelected(false);
					Connection c;
					try {
						c = (Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
						Statement statement = c.createStatement();
						statement.executeQuery("select nume,prenume from utilizator where id_departament='2';");
						ResultSet rs=statement.getResultSet();
						comboBox.removeAllItems();
						 while (rs.next())
					        {      
					           String s = rs.getString(1)+" "+rs.getString(2);  
					           comboBox.addItem(s);
					         
					        }
					} catch (SQLException e1) {
						e1.printStackTrace();
					}		
					
					
					
				}
			}
		});
		
		rdbtnMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMed.isSelected())
				{
					rdbtnEc.setSelected(false);
					rdbtnRS.setSelected(false);
					Connection c;
					try {
						c = (Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
						Statement statement = c.createStatement();
						statement.executeQuery("select nume,prenume from utilizator where id_departament='3';");
						ResultSet rs=statement.getResultSet();
						comboBox.removeAllItems();
						 while (rs.next())
					        {      
					           String s = rs.getString(1)+" "+rs.getString(2);
					           comboBox.addItem(s);
					         
					        }
					} catch (SQLException e1) {
						e1.printStackTrace();
					}		
					
					
					
				}
			}
		});
		
		JButton btnBack = new JButton("");
		Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestiunea_resurselor_umane_inspector insp=new Gestiunea_resurselor_umane_inspector(id);
				insp.setLocationRelativeTo(null);
				frame.dispose();
				
			}
		});
		btnBack.setOpaque(false);
		btnBack.setBounds(10, 10, 48, 21);
		btnBack.setBorder(null);
		btnBack.setBackground(null);
		frame.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 213, 556, 227);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
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
			table.setRowHeight(35);;
		
		JButton btnNewButton = new JButton("Confirmare");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date=(String) comboBox.getSelectedItem();
				String[] words = date.split(" ");  
				String nume=words[0];
				String prenume=words[1];
				Connection c;
				try {
					int rowCount = table.getRowCount();
					for (int ii = rowCount - 1; ii >= 0; ii--) 
						{table.getModel().setValueAt(null, ii, 0);
					table.getModel().setValueAt(null, ii, 1);
					table.getModel().setValueAt(null, ii, 2);
					table.getModel().setValueAt(null, ii, 3);}
					c = (Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);	
					Statement statement = c.createStatement();
					statement.executeQuery("select id,id_functie,id_unitate_medicala from utilizator where nume='"+nume+"' and prenume='"+prenume+"';");
					ResultSet rs=statement.getResultSet();
					int id=0;
					int id_functie = 0;
					int id_unitate=0;
					if(rs.next()) {
						id=rs.getInt(1);
						id_functie=rs.getInt(2);
						id_unitate=rs.getInt(3);
					}
					if(id_functie!=3) {
					
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
							Statement stmt=c.createStatement();
							stmt.executeQuery("SELECT * FROM policlinica.program "
									+ "order by ora_sfarsit;");
							ResultSet result=stmt.getResultSet();
							Statement stmt1=c.createStatement();
							stmt1.executeQuery("select denumire from unitate_medicala where id='"+id_unitate+"';");
							ResultSet result1=stmt1.getResultSet();
							if(result1.next()) {
							String unitate=result1.getString(1);
							int i=0;
							while(result.next()) {
								table.getModel().setValueAt(inceputSaptamana.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)).toString()+" "+result.getString(1),i,0);
								int zi=result.getInt(2);
								if(zi==1)
								  table.getModel().setValueAt(result.getTime(3).toString()+" - "+result.getTime(4).toString(), i, 1);
								else table.getModel().setValueAt("Zi Libera", i, 1);
								table.getModel().setValueAt(unitate, i, 2);
								table.getModel().setValueAt("---",i,3);
								i++;
								inceputSaptamana=inceputSaptamana.plusDays(1);
								
							}
							}
							
						}
						else 
						{   
						
							JOptionPane.showMessageDialog(null, "Angajatul este in concediu in saptamana curenta");
							table.getModel().setValueAt("---", 0, 0);
							table.getModel().setValueAt("---", 0, 1);
							table.getModel().setValueAt("---", 0, 2);
							table.getModel().setValueAt("DA", 0, 3);
							
						}
						}
						else 
							JOptionPane.showMessageDialog(null, "Nu există concediu înregistrat și nu se poate afișa orarul");
							
						
						 
						
					}
					else {
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
						}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
				
                
			}
		});
		btnNewButton.setHorizontalTextPosition(SwingConstants.LEADING);
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnNewButton.setBounds(484, 152, 117, 21);
		Image img1=new ImageIcon(this.getClass().getResource("/ok-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		frame.getContentPane().add(btnNewButton);
		
	    lblNewLabel_3 = new JLabel("");
	    lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(201, 201, 410, 13);
		
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(55, 28, 73, 64);
		Image i=new ImageIcon(this.getClass().getResource("/schedule2.png")).getImage();
		Image newImage = i.getScaledInstance(85, 65, Image.SCALE_DEFAULT);
		lblNewLabel_4.setIcon(new ImageIcon(newImage));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(484, 28, 75, 64);
		lblNewLabel_5.setIcon(new ImageIcon(newImage));
		frame.getContentPane().add(lblNewLabel_5);
		
	
		frame.setBounds(100, 100, 658, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
