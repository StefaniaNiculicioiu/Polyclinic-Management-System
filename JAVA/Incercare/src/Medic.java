import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import com.toedter.calendar.JDateChooser;

public class Medic extends JFrame{

	private JFrame frame;
	private JTextField tfNumePacient;
	private JTextField tfCnpMedic;
	private JTextField tfPrenumePacient;
	private JTextField tfNumeMedic;
	private JTextField tfPrenumeMedic;
	private JTextField tfCnpPacient;
	private JTextField tfCnpAsistent;
	private JTextField tfNumeAsistent;
	private JTextField tfPrenumeAsistent;
	private JComboBox<String> comboRez;

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
			@Override
			public void run() {
				try {
					Medic window = new Medic();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Medic() {
		initialize();
	}
	public Medic(int id) {
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("RAPORT MEDICAL");
		Image image = new ImageIcon(this.getClass().getResource("/medical-report-icon.png")).getImage();
        frame.setVisible(true);
		frame.setIconImage(image);
		frame.getContentPane().setBackground(new Color(216, 191, 216));
		frame.setBounds(100, 100, 856, 504);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 10));
		Image img2 = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GestiuneActivitatiOp op=new GestiuneActivitatiOp(id);
				op.setLocationRelativeTo(null);
				op.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		btnBack.setBounds(10, 436, 65, 21);
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		frame.getContentPane().add(btnBack);

		JLabel lblIconRaport = new JLabel("");
		lblIconRaport.setBackground(new Color(255, 248, 220));
		Image img3 = new ImageIcon(this.getClass().getResource("/medical-suitecase-icon.png")).getImage();
		lblIconRaport.setIcon(new ImageIcon(img3));
		lblIconRaport.setBounds(10, 10, 72, 72);
		frame.getContentPane().add(lblIconRaport);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(103, 10, 729, 447);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblRaportMed = new JLabel("RAPORT MEDICAL");
		lblRaportMed.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaportMed.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRaportMed.setBounds(230, 10, 238, 19);
		panel.add(lblRaportMed);

		JLabel lblNumePacient = new JLabel("Nume pacient");
		lblNumePacient.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumePacient.setBounds(24, 52, 91, 13);
		panel.add(lblNumePacient);

		tfNumePacient = new JTextField();
		tfNumePacient.setColumns(10);
		tfNumePacient.setBounds(136, 49, 173, 19);
		panel.add(tfNumePacient);

		JLabel lblCnpMedic = new JLabel("CNP medic");
		lblCnpMedic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCnpMedic.setBounds(24, 190, 80, 13);
		panel.add(lblCnpMedic);

		tfCnpMedic = new JTextField();
		tfCnpMedic.setColumns(10);
		tfCnpMedic.setBounds(136, 187, 173, 19);
		panel.add(tfCnpMedic);

		JLabel lblPrenumePacient = new JLabel("Prenume pacient");
		lblPrenumePacient.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenumePacient.setBounds(24, 83, 102, 13);
		panel.add(lblPrenumePacient);

		tfPrenumePacient = new JTextField();
		tfPrenumePacient.setColumns(10);
		tfPrenumePacient.setBounds(136, 80, 173, 19);
		panel.add(tfPrenumePacient);

		JLabel lblNumeMedic = new JLabel("Nume medic");
		lblNumeMedic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeMedic.setBounds(24, 135, 95, 13);
		panel.add(lblNumeMedic);

		tfNumeMedic = new JTextField();
		tfNumeMedic.setColumns(10);
		tfNumeMedic.setBounds(136, 132, 173, 19);
		panel.add(tfNumeMedic);

		JLabel lblPrenumeMedic = new JLabel("Prenume medic");
		lblPrenumeMedic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenumeMedic.setBounds(24, 164, 102, 13);
		panel.add(lblPrenumeMedic);

		tfPrenumeMedic = new JTextField();
		tfPrenumeMedic.setColumns(10);
		tfPrenumeMedic.setBounds(136, 161, 173, 19);
		panel.add(tfPrenumeMedic);

		JLabel lblCnpPacient = new JLabel("CNP pacient");
		lblCnpPacient.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCnpPacient.setBounds(24, 109, 91, 13);
		panel.add(lblCnpPacient);

		tfCnpPacient = new JTextField();
		tfCnpPacient.setColumns(10);
		tfCnpPacient.setBounds(136, 106, 173, 19);
		panel.add(tfCnpPacient);

		JLabel lblCnpAsistent = new JLabel("CNP asistent");
		lblCnpAsistent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCnpAsistent.setBounds(24, 271, 80, 13);
		panel.add(lblCnpAsistent);

		tfCnpAsistent = new JTextField();
		tfCnpAsistent.setColumns(10);
		tfCnpAsistent.setBounds(136, 268, 173, 19);
		panel.add(tfCnpAsistent);

		JLabel lblNumeAsistent = new JLabel("Nume asistent");
		lblNumeAsistent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeAsistent.setBounds(24, 216, 95, 13);
		panel.add(lblNumeAsistent);

		tfNumeAsistent = new JTextField();
		tfNumeAsistent.setColumns(10);
		tfNumeAsistent.setBounds(136, 213, 173, 19);
		panel.add(tfNumeAsistent);

		JLabel lblPrenumeAsistent = new JLabel("Prenume asistent");
		lblPrenumeAsistent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenumeAsistent.setBounds(24, 245, 102, 13);
		panel.add(lblPrenumeAsistent);

		tfPrenumeAsistent = new JTextField();
		tfPrenumeAsistent.setColumns(10);
		tfPrenumeAsistent.setBounds(136, 242, 173, 19);
		panel.add(tfPrenumeAsistent);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(136, 297, 173, 19);
		panel.add(dateChooser);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setBounds(24, 299, 102, 13);
		panel.add(lblData);

		JTextArea taSimptome = new JTextArea();
		taSimptome.setLineWrap(true);
		taSimptome.setBounds(468, 48, 238, 70);

		taSimptome.setDocument(new PlainDocument() {
			@Override
			public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
				if (str == null || taSimptome.getText().length() >= 100) {
					return;
				}

				super.insertString(offs, str, a);
			}
		});
		panel.add(taSimptome);

		JLabel lblNewLabel = new JLabel("Simptome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(380, 48, 88, 13);
		panel.add(lblNewLabel);

		JTextArea taDiagnostic = new JTextArea();
		taDiagnostic.setLineWrap(true);
		taDiagnostic.setBounds(468, 131, 238, 55);
		taDiagnostic.setDocument(new PlainDocument() {
			@Override
			public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
				if (str == null || taDiagnostic.getText().length() >= 30) {
					return;
				}

				super.insertString(offs, str, a);
			}
		});
		panel.add(taDiagnostic);

		JLabel lblDiagostic = new JLabel("Diagostic");
		lblDiagostic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiagostic.setBounds(380, 131, 88, 13);
		panel.add(lblDiagostic);

		JTextArea taRecomandari = new JTextArea();
		taRecomandari.setLineWrap(true);
		taRecomandari.setBounds(468, 199, 238, 81);

		taRecomandari.setDocument(new PlainDocument() {
			@Override
			public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
				if (str == null || taRecomandari.getText().length() >= 100) {
					return;
				}

				super.insertString(offs, str, a);
			}
		});
		panel.add(taRecomandari);

		JLabel lblRecomandari = new JLabel("Recomandari");
		lblRecomandari.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRecomandari.setBounds(380, 199, 88, 13);
		panel.add(lblRecomandari);

		JButton btnInvestigatii = new JButton("Investigatii >>");
		btnInvestigatii.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Investigatie.main(null);
			}
		});
		btnInvestigatii.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInvestigatii.setBounds(585, 295, 121, 21);
		panel.add(btnInvestigatii);

		JButton btnParafa = new JButton("Parafati raportul");
		btnParafa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					String cnpM = tfCnpMedic.getText();
					String cnpP = tfCnpPacient.getText();
					String numeM = tfNumeMedic.getText();
					String numeP = tfNumePacient.getText();
					String prenumeM = tfPrenumeMedic.getText();
					String prenumeP = tfPrenumePacient.getText();
					String cnpA = tfCnpAsistent.getText();
					String numeA = tfNumeAsistent.getText();
					String prenumeA = tfPrenumeAsistent.getText();
					String rez = comboRez.getSelectedItem().toString();
					String diagn = taDiagnostic.getText();
					String simptome = taSimptome.getText();
					String recom = taRecomandari.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(dateChooser.getDate());

					if (numeM.isBlank() || numeP.isBlank() || prenumeM.isBlank() || prenumeP.isBlank()
							|| numeA.isBlank() || prenumeA.isBlank() || cnpP.isBlank() || cnpM.isBlank()
							|| cnpA.isBlank() || rez.isBlank() || diagn.isBlank() || simptome.isBlank()
							|| recom.isBlank() || date.isBlank()) {
						JOptionPane.showMessageDialog(null, "Completati toate campurile ", "Eroare",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int ok = 0;
						Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
						CallableStatement statement = c
								.prepareCall("{call adauga_raport(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
						{
							statement.setString(1, cnpM);
							statement.setString(2, cnpP);
							statement.setString(3, cnpA);
							statement.setString(4, diagn);
							statement.setString(5, simptome);
							statement.setString(6, recom);
							statement.setString(7, rez);
							statement.registerOutParameter(8, Types.INTEGER);
							statement.setString(9, numeM);
							statement.setString(10, prenumeM);
							statement.setString(11, numeA);
							statement.setString(12, prenumeA);
							statement.setString(13, date);


							statement.execute();
							ok = statement.getInt(8);
							statement.close();
						}
						c.close();
						if (ok == 1) {
							Medic op=new Medic(id);
							op.setLocationRelativeTo(null);
							JOptionPane.showMessageDialog(null, "Raportul a fost inregistratat cu succes.",
									"Raport inregistrat", JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
						}
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		btnParafa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnParafa.setBounds(285, 381, 160, 21);
		panel.add(btnParafa);

		JButton btnIstoric = new JButton("Istoric >>");
		btnIstoric.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String prenumeP = tfPrenumePacient.getText();
				String numeP = tfNumePacient.getText();
				String cnpP = tfCnpPacient.getText();
				Istoric is = new Istoric();
				is.setVisible(true);
				is.getLblNumePacient().setText(numeP + " " + prenumeP);
				is.getTextField().setText(cnpP);
				
				try {

					String cnpM = tfCnpMedic.getText();
					
					

					if ( numeP.isBlank() || prenumeP.isBlank() ||
							cnpP.isBlank() || cnpM.isBlank()) {
						JOptionPane.showMessageDialog(null, "Completati toate campurile referitoare la medic si pacient.", "Eroare",
								JOptionPane.ERROR_MESSAGE);
					} else {

						Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
						CallableStatement statement = c.prepareCall("{call getIstoric( ?)}");
						{
							statement.setString(1, cnpP);
							statement.execute();
							JTable t = is.getTable_1();
							ResultSet rs = statement.getResultSet();
							 while(t.getRowCount() > 0) 
						        {
						            ( (DefaultTableModel) t.getModel()).removeRow(0);
						        }
						        int columns = rs.getMetaData().getColumnCount();
						        while(rs.next())
						        {  
						            Object[] row = new Object[columns];
						            for (int i = 1; i <= columns - 1 ; i++)
						            {  
						           
						            	if(i == 3) {
						            		
						            		row[i-1] = rs.getObject(i).toString() + " " + rs.getObject(i+1).toString();
						            		
						            	}
						            	else if ( i == 4) {
						            		
						            		row[i-1] = rs.getObject(i+1).toString() + " " + rs.getObject(i+2).toString();
						            		
						            	}
						            	else if (i > 5)
						            		row[i -2 ] = rs.getObject(i + 1);
						            	else if(i < 3 )
							                row[i- 1] = rs.getObject(i);

						            }
						            ((DefaultTableModel) t.getModel()).insertRow(rs.getRow()-1,row);
						        }

						        rs.close();
							statement.close();
							
							PreparedStatement stm = c.prepareStatement("Select concluzie from investigatii where id_raport = ?;" );
							for(int i = 0;i<t.getRowCount();i++) {
								String  arg2 = t.getValueAt(i, 0).toString();
								stm.setString(1, arg2);
								ResultSet r = stm.executeQuery();
								if(r.next())
								t.setValueAt(r.getObject(1), i, t.getColumnCount()-1);
							}
							
							stm.close();
						}
						c.close();
					
						
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			
			for (int row = 0; row < is.getTable_1().getRowCount(); row++)
		    {
		        int rowHeight = is.getTable_1().getRowHeight();

		        for (int column = 0; column < is.getTable_1().getColumnCount(); column++)
		        {
		            Component comp = is.getTable_1().prepareRenderer(is.getTable_1().getCellRenderer(row, column), row, column);
		            rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
		        }

		        is.getTable_1().setRowHeight(row, rowHeight);
		    }
			}
		
		});
		btnIstoric.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIstoric.setBounds(585, 337, 121, 21);
		panel.add(btnIstoric);

		JLabel lblRezultat = new JLabel("Reazultat");
		lblRezultat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRezultat.setBounds(24, 326, 80, 13);
		panel.add(lblRezultat);

		comboRez = new JComboBox<String>();
		comboRez.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboRez.setModel(new DefaultComboBoxModel<String>(new String[] { "Pozitiv", "Negativ" }));
		comboRez.setBounds(136, 323, 173, 19);
		panel.add(comboRez);


		JButton btnOrarMed = new JButton("Orar");
		btnOrarMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnpM = tfCnpMedic.getText();
				 try {
	            	 Connection c=(Connection) DriverManager.getConnection(URL+DB_NAME, USER, PASSWORD);
	            	 Statement stmt1=(Statement) c.createStatement();  			
	            			String sql1="Select id from utilizator where cnp ='"+ cnpM +"';";
	            			stmt1.executeQuery(sql1);
	            			ResultSet rs2=stmt1.getResultSet();
	            			if (rs2.next())
	            			{
	            				int id = rs2.getInt(1);
	            				System.out.println(id);
	            				OrarMedic om = new OrarMedic(id);
	            				om.setLocationRelativeTo(null);
	            				//om.setVisible(true);
	            			}
	            			else {
	            				JOptionPane.showMessageDialog(null, "Va rugam sa introduceti corect CNP-ul medicului.",
										"Eroare", JOptionPane.INFORMATION_MESSAGE);
	            			}
	            			
	            		c.close();
	            	 }catch (Exception ex) {
	     				ex.printStackTrace();
	     			}
	            	
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/Programming-Add-Property-icon.png")).getImage();
		btnOrarMed.setIcon(new ImageIcon(img4));
		btnOrarMed.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOrarMed.setBounds(8, 102, 85, 21);
		frame.getContentPane().add(btnOrarMed);

	}
}