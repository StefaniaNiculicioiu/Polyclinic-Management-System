import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Investigatie {

	private JFrame frmInvestigatii;

	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Investigatie window = new Investigatie();
					window.frmInvestigatii.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Investigatie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInvestigatii = new JFrame();
		frmInvestigatii.setTitle("Investigatii");
		frmInvestigatii.getContentPane().setBackground(new Color(216, 191, 216));
		frmInvestigatii.getContentPane().setLayout(null);
		Image image = new ImageIcon(this.getClass().getResource("/medical-report-icon.png")).getImage();
		frmInvestigatii.setVisible(true);
		frmInvestigatii.setIconImage(image);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 264, 77, 21);
		Image img2 = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInvestigatii.dispose();
			}
		});
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		frmInvestigatii.getContentPane().add(btnBack);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 63, 437, 152);
		frmInvestigatii.getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setDocument(new PlainDocument() {
			@Override
			public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
				if (str == null || textArea.getText().length() >= 100) {
					return;
				}

				super.insertString(offs, str, a);
			}
		});
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);

		JLabel lblConcluzie = new JLabel("CONCLUZIE - INVESTIGATII");
		lblConcluzie.setForeground(new Color(0, 0, 0));
		lblConcluzie.setVisible(true);
		lblConcluzie.setBackground(new Color(230, 230, 250));
		lblConcluzie.setHorizontalAlignment(SwingConstants.CENTER);
		lblConcluzie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConcluzie.setBounds(156, 21, 215, 21);
		frmInvestigatii.getContentPane().add(lblConcluzie);

		JButton btnSave = new JButton("Salvati observatiile");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					String concluzii = textArea.getText();

					if (textArea.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Completati campul cu observatiile corespunzatoare ",
								"Eroare", JOptionPane.ERROR_MESSAGE);
					} else {
						int ok = 0;
						Connection c = (Connection) DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
						CallableStatement statement = (CallableStatement) c
								.prepareCall("{call adauga_investigatie(?, ?)}");
						{
							statement.setString(1, textArea.getText());
							statement.registerOutParameter(2, Types.INTEGER);
							statement.execute();
							ok = statement.getInt(2);

							statement.close();
						}
						c.close();
						if (ok == 1) {

							JOptionPane.showMessageDialog(null, "Investigatia a fost inregistratata cu succes.",
									"Investigatie inregistrat", JOptionPane.INFORMATION_MESSAGE);
							frmInvestigatii.dispose();
						}
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBounds(189, 236, 151, 21);
		frmInvestigatii.getContentPane().add(btnSave);
		frmInvestigatii.setBounds(100, 100, 533, 332);
		frmInvestigatii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
