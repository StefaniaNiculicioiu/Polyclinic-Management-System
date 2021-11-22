import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Types;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

public class Receptie extends JFrame {

	private JFrame frmReceptie;
	private JTextField tfNumePacient;
	private JComboBox tfOraProg;
	private JTable table;
	private JComboBox<String> comboServicii;
    private int id;
    
	public JTable getTable() {
		return table;
	}
	private ArrayList<Time> ore_prog= new ArrayList<Time>();
	private JTextField tfCnpMedic;
	private JTextField tfPrenumePacient;
	private JTextField tfNumeMedic;
	private JTextField tfPrenumeMedic;
	private JTextField tfCnpPacient;

	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Receptie window = new Receptie();
					window.frmReceptie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Receptie() {
		initialize();
	}
	public Receptie(int id) {
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void setOreProg() {
		this.ore_prog.add(Time.valueOf("07:00:00"));
		this.ore_prog.add(Time.valueOf("07:30:00"));
		this.ore_prog.add(Time.valueOf("08:00:00"));
		this.ore_prog.add(Time.valueOf("08:30:00"));
		this.ore_prog.add(Time.valueOf("09:00:00"));
		this.ore_prog.add(Time.valueOf("09:30:00"));
		this.ore_prog.add(Time.valueOf("10:00:00"));
		this.ore_prog.add(Time.valueOf("10:30:00"));
		this.ore_prog.add(Time.valueOf("11:00:00"));
		this.ore_prog.add(Time.valueOf("11:30:00"));
		this.ore_prog.add(Time.valueOf("12:00:00"));
		this.ore_prog.add(Time.valueOf("12:30:00"));
		this.ore_prog.add(Time.valueOf("13:00:00"));
		this.ore_prog.add(Time.valueOf("13:30:00"));
		this.ore_prog.add(Time.valueOf("14:00:00"));
		this.ore_prog.add(Time.valueOf("14:30:00"));
		this.ore_prog.add(Time.valueOf("15:00:00"));
		this.ore_prog.add(Time.valueOf("15:30:00"));
		this.ore_prog.add(Time.valueOf("16:00:00"));
		this.ore_prog.add(Time.valueOf("16:30:00"));
		this.ore_prog.add(Time.valueOf("17:00:00"));
		this.ore_prog.add(Time.valueOf("17:30:00"));
		this.ore_prog.add(Time.valueOf("18:00:00"));
		this.ore_prog.add(Time.valueOf("18:30:00"));
		this.ore_prog.add(Time.valueOf("19:00:00"));
		this.ore_prog.add(Time.valueOf("20:00:00"));
	}
	
	private void initialize() {
		frmReceptie = new JFrame();
		frmReceptie.setTitle("Receptie");
		frmReceptie.getContentPane().setBackground(new Color(173, 216, 230));
		frmReceptie.getContentPane().setLayout(null);
        frmReceptie.setVisible(true);
        Image i1=new ImageIcon(this.getClass().getResource("/Programming-Add-Property-icon.png")).getImage();
		frmReceptie.setIconImage(i1);
        
		JLabel lblLogoReceptie = new JLabel("<html>RECEPTIA MEDLIFE<br/> Bine ati venit! </html>");
		Image img = new ImageIcon(this.getClass().getResource("/plant-no-shadwo-icon.png")).getImage();
		lblLogoReceptie.setIcon(new ImageIcon(img));
		lblLogoReceptie.setBackground(new Color(245, 245, 220));
		lblLogoReceptie.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogoReceptie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogoReceptie.setBounds(0, 10, 204, 72);
		frmReceptie.getContentPane().add(lblLogoReceptie);
		

		JPanel panelProgramare = new JPanel();
		panelProgramare.setBackground(new Color(250, 250, 210));
		panelProgramare.setBounds(214, 38, 618, 419);
		frmReceptie.getContentPane().add(panelProgramare);
		panelProgramare.setLayout(null);
		
		tfOraProg = new JComboBox();
		tfOraProg.setBounds(144, 174, 85, 19);
		this.setOreProg();
		Iterator it = this.ore_prog.iterator();
		while(it.hasNext()) {
			tfOraProg.addItem(it.next());
		}
		panelProgramare.add(tfOraProg);

		JLabel lblNewBooking = new JLabel("Creeaza o programare");
		lblNewBooking.setBackground(new Color(224, 255, 255));
		lblNewBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewBooking.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewBooking.setBounds(172, 10, 214, 24);
		panelProgramare.add(lblNewBooking);

		JLabel lblNumePacient = new JLabel("Nume pacient");
		lblNumePacient.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumePacient.setBounds(23, 62, 91, 13);
		panelProgramare.add(lblNumePacient);

		JLabel lblDataProg = new JLabel("Data");
		lblDataProg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataProg.setBounds(23, 180, 45, 13);
		panelProgramare.add(lblDataProg);

		JLabel lblOraProg = new JLabel("Ora");
		lblOraProg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOraProg.setBounds(114, 180, 45, 13);
		panelProgramare.add(lblOraProg);

		tfNumePacient = new JTextField();
		lblNumePacient.setLabelFor(tfNumePacient);
		tfNumePacient.setBounds(114, 59, 152, 19);
		panelProgramare.add(tfNumePacient);
		tfNumePacient.setColumns(10);

		JLabel lblSelectedDate = new JLabel("");
		lblSelectedDate.setBounds(23, 357, 188, 13);
		panelProgramare.add(lblSelectedDate);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(23, 203, 206, 152);
		panelProgramare.add(calendar);
		Calendar c = Calendar.getInstance();

		// ---- Programarile se pot face doar pentru o data ulterioara

		calendar.setMinSelectableDate(c.getTime());
		calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				lblSelectedDate.setText(calendar.getDate().toString());
			}
		});

		calendar.getMonthChooser().addPropertyChangeListener("month", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				lblSelectedDate.setText(calendar.getDate().toString());
			}
		});
		calendar.getYearChooser().addPropertyChangeListener("year", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				lblSelectedDate.setText(calendar.getDate().toString());
			}
		});

		Format shortTime = DateFormat.getTimeInstance(DateFormat.SHORT);

	

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(394, 203, 214, 152);
		panelProgramare.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		table.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Serviciul Medical", "Durata" }) {
			Class[] columnTypes = new Class[] { String.class, Integer.class };

			@Override
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(139);
		table.getColumnModel().getColumn(1).setPreferredWidth(55);

		JButton btnGetServicii = new JButton("Cautati servicii");
		btnGetServicii.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnGetServicii.setBounds(248, 218, 124, 21);
		panelProgramare.add(btnGetServicii);

		JLabel lblServiciulMedical = new JLabel("Serviciul medical");
		lblServiciulMedical.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblServiciulMedical.setBounds(258, 249, 101, 13);
		panelProgramare.add(lblServiciulMedical);

		comboServicii = new JComboBox();
		comboServicii.setBounds(248, 272, 124, 19);
		panelProgramare.add(comboServicii);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(401, 175, 177, 17);
		panelProgramare.add(comboBox);

		btnGetServicii.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);

					Statement statement = c.createStatement();
					String cnpM = tfCnpMedic.getText();
					if (cnpM.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Va rugam completati campul 'CNP medic' ", "Eroare",
								JOptionPane.ERROR_MESSAGE);
					} else {
						statement.execute("call  getServiciiMedic(" + cnpM + " )");
						ResultSet rs = statement.getResultSet();
						while (rs.next()) {
							String serv = rs.getString(1);
							comboServicii.addItem(serv);

						}
						
					}
					Statement stmtt=c.createStatement();
					stmtt.executeQuery("select unitate_medicala.denumire from unitate_medicala,unitate_medic where"
							+" unitate_medic.cnp_medicul='"+cnpM+"' and unitate_medicala.id=unitate_medic.id_unitate_medicala;");
					ResultSet result=stmtt.getResultSet();
					while(result.next()) {
						comboBox.addItem(result.getString(1));
					}
					
					// se verifica toate programarile medicului din data selectata si se sterg optiunile de ora care au fost 
					// anterior selectate pentru alte programari 
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(calendar.getDate());
					Statement stmOreProg = c.createStatement();
					
					stmOreProg.executeQuery("select ora_programare, ADDTIME(ora_programare, SEC_TO_TIME(durata*60)) from programare where data_programare = '" +date + "' and cnp_medic = '"+cnpM+"';");
					ResultSet resultOp = stmOreProg.getResultSet();
					while(resultOp.next()) {
						Iterator it = ore_prog.iterator();
						
						while(it.hasNext()) {
							Time t = Time.valueOf(it.next().toString());
							if((t.after( Time.valueOf(resultOp.getString(1))) || t.equals(Time.valueOf(resultOp.getString(1)))) && ( t.before(Time.valueOf(resultOp.getString(2))) || t.equals(Time.valueOf(resultOp.getString(1))))) {
								tfOraProg.removeItem(t);
							}
						}
					}
					
					c.close();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});


		JLabel lblCnpMedic = new JLabel("CNP medic");
		lblCnpMedic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCnpMedic.setBounds(23, 148, 80, 13);
		panelProgramare.add(lblCnpMedic);

		tfCnpMedic = new JTextField();
		tfCnpMedic.setColumns(10);
		tfCnpMedic.setBounds(114, 145, 238, 19);
		panelProgramare.add(tfCnpMedic);
		tfCnpMedic.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateLabel(e);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateLabel(e);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateLabel(e);
			}

			private void updateLabel(DocumentEvent e) {
				java.awt.EventQueue.invokeLater(new Runnable() {

					@Override
					public void run() {
						comboServicii.removeAllItems();
					}
				});
			}
		});
	
		JButton btnConfirmareProg = new JButton("Confirmati programarea");

		btnConfirmareProg.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmareProg.setBounds(213, 376, 188, 21);
		panelProgramare.add(btnConfirmareProg);

		JButton btnBonFiscal = new JButton("Generare bon fiscal");
		btnBonFiscal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				if (!tableModel.getDataVector().isEmpty()) {
					BonFiscal bf = new BonFiscal(id);
					bf.setVisible(true);
					JTable bft = bf.getTable();
					

					try {
						while(bft.getRowCount() > 0) 
				        {
				            ( (DefaultTableModel) bft.getModel()).removeRow(0);
				        }	
						
						for(int i = 0;i<table.getRowCount();i++) {
							((DefaultTableModel) bft.getModel()).insertRow(i, new Object[bft.getColumnCount()]);;
							String den = table.getValueAt(i, 0).toString();
							String dur = table.getValueAt(i, 1).toString();
							bft.setValueAt(den, i, 0);
							bft.setValueAt(dur, i, 1);
						}
						int pretTotal = 0;
						Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
						PreparedStatement stm = c.prepareStatement("Select pret from servicii where denumire_serviciu = ?;" );
						for(int i = 0;i<table.getRowCount();i++) {
							String  arg2 = table.getValueAt(i, 0).toString();
							
							stm.setString(1, arg2);
							ResultSet r = stm.executeQuery();
							if(r.next()) {
							bft.setValueAt(r.getObject(1), i, bft.getColumnCount()-1);
							pretTotal += Integer.parseInt(r.getObject(1).toString());}
						}
						stm.close();
						Statement ss=c.createStatement();
						LocalDate d=calendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
						ss.execute("call adaugaBon('"+tfCnpMedic.getText().toString()+"','"+pretTotal+"','"+d+"');");
						ss.close();
					    c.close();
						
					    bf.getTfPretTotal().setText(String.valueOf(pretTotal));
							
						

					} catch (Exception ex) {
						ex.printStackTrace();
					}
			
				
				}
				frmReceptie.dispose();
			}
			
		});
		btnBonFiscal.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBonFiscal.setBounds(432, 377, 146, 21);
		panelProgramare.add(btnBonFiscal);

		JButton btnServicii = new JButton("Adauga");

		btnServicii.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cnpM = tfCnpMedic.getText();
				String cnpP = tfCnpPacient.getText();

				String ora = tfOraProg.getSelectedItem().toString();
				String numeM = tfNumeMedic.getText();
				String numeP = tfNumePacient.getText();
				String prenumeM = tfPrenumeMedic.getText();
				String prenumeP = tfPrenumePacient.getText();
				String selServ = comboServicii.getSelectedItem().toString();
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				for (int i = 0; i < tableModel.getRowCount(); i++) {
					if (tableModel.getValueAt(i, 0).toString().contains(selServ)) {
						JOptionPane.showMessageDialog(null, null, "Eroare: Serviciul medical a fost deja adaugat.",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				if (numeM.isBlank() || numeP.isBlank() || prenumeM.isBlank() || prenumeP.isBlank() || ora.isBlank()
						|| cnpP.isBlank() || cnpM.isBlank() || selServ.isBlank()) {
					JOptionPane.showMessageDialog(null, "Completati toate campurile ", "Eroare de logare",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String durataServ = "";
					try {
						Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);

						String denumireServ = comboServicii.getSelectedItem().toString();
						CallableStatement statement = c
								.prepareCall("{call  getDurataServiciiMedic(?)}");
						statement.setString(1, denumireServ);
						if (denumireServ.isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"Serviciul medical nu a fost selectat. Va rugam selectati un serviciu medical.",
									"Eroare", JOptionPane.ERROR_MESSAGE);
						} else {

							statement.execute();
							ResultSet rs = statement.getResultSet();
							if (rs.next()) {
								durataServ = rs.getString(1);

							}
							c.close();
						}

					} catch (Exception ex) {
						ex.printStackTrace();
					}

					if (!(selServ == null) && !(durataServ == null) && !selServ.isEmpty())
						tableModel.addRow(new Object[] { selServ, durataServ });
					else
						JOptionPane.showMessageDialog(null,
								"Serviciul medical selectat este incorect. Va rugam selectati un serviciu medical diferit.",
								"Eroare", JOptionPane.ERROR_MESSAGE);
				}

				/*
				 * tfCnpMedic.setText(null); tfCnpPacient.setText(null);
				 * tfDurataServ.setText(null); tfOraProg.setText(null);
				 * tfNumeMedic.setText(null); tfNumePacient.setText(null);
				 * tfPrenumeMedic.setText(null); tfPrenumePacient.setText(null);
				 */
			}
		});

		btnServicii.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnServicii.setBounds(271, 310, 76, 24);
		panelProgramare.add(btnServicii);

		JLabel lblPrenumePacient = new JLabel("Prenume pacient");
		lblPrenumePacient.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenumePacient.setBounds(289, 62, 102, 13);
		panelProgramare.add(lblPrenumePacient);

		tfPrenumePacient = new JTextField();
		tfPrenumePacient.setColumns(10);
		tfPrenumePacient.setBounds(401, 59, 173, 19);
		panelProgramare.add(tfPrenumePacient);

		JLabel lblNumeMedic = new JLabel("Nume medic");
		lblNumeMedic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeMedic.setBounds(23, 120, 95, 13);
		panelProgramare.add(lblNumeMedic);

		tfNumeMedic = new JTextField();
		tfNumeMedic.setColumns(10);
		tfNumeMedic.setBounds(114, 117, 156, 19);
		panelProgramare.add(tfNumeMedic);

		JLabel lblPrenumeMedic = new JLabel("Prenume medic");
		lblPrenumeMedic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenumeMedic.setBounds(293, 120, 102, 13);
		panelProgramare.add(lblPrenumeMedic);

		tfPrenumeMedic = new JTextField();
		tfPrenumeMedic.setColumns(10);
		tfPrenumeMedic.setBounds(401, 117, 177, 19);
		panelProgramare.add(tfPrenumeMedic);

		JLabel lblCnpPacient = new JLabel("CNP pacient");
		lblCnpPacient.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCnpPacient.setBounds(23, 88, 91, 13);
		panelProgramare.add(lblCnpPacient);

		tfCnpPacient = new JTextField();
		tfCnpPacient.setColumns(10);
		tfCnpPacient.setBounds(114, 85, 234, 19);
		panelProgramare.add(tfCnpPacient);

		JButton btnBack = new JButton("Back");
		Image img2 = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GestiuneActivitatiOp g=new GestiuneActivitatiOp(id);
				g.setLocationRelativeTo(null);
				g.setVisible(true);
				frmReceptie.dispose();
			}
		});
		btnBack.setBounds(10, 436, 65, 21);
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		frmReceptie.getContentPane().add(btnBack);

		frmReceptie.setBackground(new Color(173, 216, 230));
		frmReceptie.setBounds(100, 100, 856, 504);
		frmReceptie.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		btnConfirmareProg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					String cnpM = tfCnpMedic.getText();
					String cnpP = tfCnpPacient.getText();
					Integer durata = 0;
					Time ora = Time.valueOf(tfOraProg.getSelectedItem().toString());
					String numeM = tfNumeMedic.getText();
					String numeP = tfNumePacient.getText();
					String prenumeM = tfPrenumeMedic.getText();
					String prenumeP = tfPrenumePacient.getText();
					String selServ = comboServicii.getSelectedItem().toString();
					String unitate=comboBox.getSelectedItem().toString();
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					for (int i = 0; i < tableModel.getRowCount(); i++) {
						int d = Integer.parseInt(tableModel.getValueAt(i, 1).toString());
						if (d > 0) {
							durata += d;
						}
					}

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(calendar.getDate());

					if (numeM.isBlank() || numeP.isBlank() || prenumeM.isBlank() || prenumeP.isBlank() || ora.toString().isBlank()
							|| durata == 0 || cnpP.isBlank() || cnpM.isBlank() || selServ.isBlank() || date.isBlank()  || unitate.isBlank()) {
						JOptionPane.showMessageDialog(null, "Completati toate campurile ", "Eroare de logare",
								JOptionPane.ERROR_MESSAGE);
					} else {

						Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
						Statement st=c.createStatement();
						st.executeQuery("select id from unitate_medicala where denumire='"+unitate+"';");
						ResultSet r=st.getResultSet();
						int id_unitate=0;
						if(r.next())
							id_unitate=r.getInt(1);
						CallableStatement statement = c
								.prepareCall("{call adauga_programare(?, ?,?,?,?,?,?,?,?,?)}");
						{
							statement.setString(1, cnpM);
							statement.setString(2, cnpP);
							statement.setString(3, numeP);
							statement.setString(4, prenumeP);
							statement.setString(5, numeM);
							statement.setString(6, prenumeM);
							statement.setString(7, date);
							statement.setTime(8, ora);
							statement.setString(9, durata.toString());
							statement.setInt(10, id_unitate);

							statement.execute();
							statement.close();
						}
						c.close();

					}
					int ok = 0;
					Connection c1 = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
					for (int i = 0; i < tableModel.getRowCount(); i++) {
						CallableStatement statement1 = c1
								.prepareCall("{call adauga_serviciu_prog(?, ?, ?, ?, ?)}");
						{

							String d = tableModel.getValueAt(i, 1).toString();
							String serv = tableModel.getValueAt(i, 0).toString();
							statement1.setString(1, cnpM);
							statement1.setString(2, cnpP);
							statement1.setString(3, serv);
							statement1.setString(4, d);
							statement1.registerOutParameter(5, Types.INTEGER);

							statement1.execute();
							ok = statement1.getInt(5);
							statement1.close();
						}
					}
					c1.close();
					if (ok == 1) {
						JOptionPane.showMessageDialog(null, "Programarea a fost inregistratata cu succes.",
								"Programare confirmata", JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

	}
}
