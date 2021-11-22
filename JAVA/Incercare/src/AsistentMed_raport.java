import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.toedter.calendar.JDateChooser;

public class AsistentMed_raport extends JFrame {

	private JFrame frmRaportAnalize;
	private JTextField tfNumePacient;
	private JTextField tfCnpMedic;
	private JTextField tfPrenumePacient;
	private JTextField tfNumeMedic;
	private JTextField tfPrenumeMedic;
	private JTextField tfCnpPacient;
	private JTextField tfCnpAsistent;
	private JTextField tfNumeAsistent;
	private JTextField tfPrenumeAsistent;
	private JComboBox comboRez;
	private int id;

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
					AsistentMed_raport window = new AsistentMed_raport();
					window.frmRaportAnalize.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AsistentMed_raport() {
		initialize();
	}
	public AsistentMed_raport(int id) {
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRaportAnalize = new JFrame();
		frmRaportAnalize.setTitle("Raport analize");
		frmRaportAnalize.getContentPane().setBackground(new Color(216, 191, 216));
		frmRaportAnalize.setBounds(100, 100, 856, 504);
		frmRaportAnalize.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frmRaportAnalize.setVisible(true);
        Image image = new ImageIcon(this.getClass().getResource("/medical-report-icon.png")).getImage();
        frmRaportAnalize.setVisible(true);
        frmRaportAnalize.setIconImage(image);
        
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
				frmRaportAnalize.dispose();
			}
		});
		frmRaportAnalize.getContentPane().setLayout(null);
		btnBack.setBounds(10, 436, 65, 21);
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		frmRaportAnalize.getContentPane().add(btnBack);

		JLabel lblIconRaport = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/smallmedical-report-icon.png")).getImage();
		lblIconRaport.setIcon(new ImageIcon(img3));
		lblIconRaport.setBounds(10, 10, 64, 64);
		frmRaportAnalize.getContentPane().add(lblIconRaport);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(103, 10, 729, 447);
		frmRaportAnalize.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblRaportMed = new JLabel("RAPORT ANALIZE MEDICALE");
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

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBounds(468, 48, 238, 70);
		textArea.setEnabled(false);
		panel.add(textArea);

		JLabel lblNewLabel = new JLabel("Simptome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(380, 48, 88, 13);
		panel.add(lblNewLabel);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEnabled(false);
		textArea_1.setEditable(false);
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(468, 131, 238, 55);
		panel.add(textArea_1);

		JLabel lblDiagostic = new JLabel("Diagostic");
		lblDiagostic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiagostic.setBounds(380, 131, 88, 13);
		panel.add(lblDiagostic);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setLineWrap(true);
		textArea_2.setBounds(468, 199, 238, 81);
		textArea_2.setEnabled(false);
		panel.add(textArea_2);

		JLabel lblRecomandari = new JLabel("Recomandari");
		lblRecomandari.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRecomandari.setBounds(380, 199, 88, 13);
		panel.add(lblRecomandari);

		JButton btnInvestigatii = new JButton("Investigatii >>");
		btnInvestigatii.setEnabled(false);
		btnInvestigatii.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInvestigatii.setBounds(585, 295, 121, 21);
		panel.add(btnInvestigatii);

		JButton btnParafa = new JButton("Validati raportul");
		btnParafa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(dateChooser.getDate());

				if (numeM.isBlank() || numeP.isBlank() || prenumeM.isBlank() || prenumeP.isBlank()
						|| numeA.isBlank() || prenumeA.isBlank() || cnpP.isBlank() || cnpM.isBlank()
						|| cnpA.isBlank() || rez.isBlank() || date.isBlank()) {
					JOptionPane.showMessageDialog(null, "Completati toate campurile", "Eroare",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int ok = 0;
					Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
					PreparedStatement stm = c.prepareStatement("select id_pacient from pacienti where cnp = " + cnpP + ";" );	
					ResultSet r = stm.executeQuery();
					String idP ="";
					if(r.next()) {
						 idP = r.getObject(1).toString();
					}
					stm.close();

					if(!idP.isBlank()) {
					PreparedStatement statement = c.prepareStatement("Update raport set rezultat = ? where id_pacient = ? and cnp_medic = ?"
							+ " and cnp_asistent = ? and dataRap = ? ;" );					
					{
						statement.setString(1, rez);
						statement.setString(2, idP);
						statement.setString(3, cnpM);
						statement.setString(4, cnpA);
						statement.setString(5, date);

						statement.execute();
						statement.close();
					}
					c.close();
					
						AsistentMed_raport op=new AsistentMed_raport(id);
						op.setLocationRelativeTo(null);
						JOptionPane.showMessageDialog(null, "Raportul a fost inregistratat cu succes.",
								"Raport inregistrat", JOptionPane.INFORMATION_MESSAGE);
						frmRaportAnalize.dispose();
					
				
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
		btnIstoric.setEnabled(false);
		btnIstoric.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIstoric.setBounds(585, 337, 121, 21);
		panel.add(btnIstoric);

		JLabel lblRezultat = new JLabel("Rezultat");
		lblRezultat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRezultat.setBounds(24, 326, 80, 13);
		panel.add(lblRezultat);

		comboRez = new JComboBox();
		comboRez.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboRez.setModel(new DefaultComboBoxModel(new String[] { "Pozitiv", "Negativ" }));
		comboRez.setBounds(136, 323, 173, 19);
		panel.add(comboRez);

	}
}
