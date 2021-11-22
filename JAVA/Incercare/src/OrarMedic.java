
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

public class OrarMedic extends JFrame {
    
	private int id;
	private JFrame frmOrarMedici;
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
			lblNewLabel_5.setText("Data curenta:"+c.getTime());
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
					OrarMedic window = new OrarMedic();
					window.frmOrarMedici.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OrarMedic() {
		initialize();
	    time();
	}
    public OrarMedic(int idU) {
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
		frmOrarMedici = new JFrame();
		frmOrarMedici.setTitle("Orar medici");
		frmOrarMedici.setVisible(true);
		frmOrarMedici.getContentPane().setBackground(new Color(230, 230, 250));
		frmOrarMedici.setBounds(100, 100, 768, 546);
		frmOrarMedici.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOrarMedici.getContentPane().setLayout(null);
		frmOrarMedici.setVisible(true);
		Image i1=new ImageIcon(this.getClass().getResource("/People-Doctor-Female-icon.png")).getImage();
		frmOrarMedici.setIconImage(i1);  
		
		JLabel lblImg = new JLabel("");
		lblImg.setBounds(556, 21, 184, 151);
		Image img1=new ImageIcon(this.getClass().getResource("/Doctor_icon (1).png")).getImage();
		lblImg.setIcon(new ImageIcon(img1));
		frmOrarMedici.getContentPane().add(lblImg);
		
		JButton btnBack = new JButton("");
		btnBack.setBounds(10, 10, 50, 21);
		Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmOrarMedici.dispose();
			}

		});
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		frmOrarMedici.getContentPane().add(btnBack);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 241, 602, 227);
		frmOrarMedici.getContentPane().add(scrollPane);
		
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
		lblNewLabel_5.setBounds(327, 203, 351, 28);
		frmOrarMedici.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("/screenshot.png")).getImage();
		Image newImage2 = img2.getScaledInstance(627, 151, Image.SCALE_DEFAULT);
		lblNewLabel_6.setIcon(new ImageIcon(newImage2));
		lblNewLabel_6.setBounds(59, 21, 627, 151);
		frmOrarMedici.getContentPane().add(lblNewLabel_6);
		Connection c;
		try {
			c = (Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
		
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
