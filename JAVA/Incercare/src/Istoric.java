import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Istoric extends JFrame {

	
	private JTable table_1;
	private JTextField textField;
	private JLabel lblNumePacient;
	
	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JLabel getLblNumePacient() {
		return lblNumePacient;
	}

	public void setLblNumePacient(JLabel lblNumePacient) {
		this.lblNumePacient = lblNumePacient;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Istoric window = new Istoric();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Istoric() {
		Image image = new ImageIcon(this.getClass().getResource("/medical-report-icon.png")).getImage();
		setIconImage(image);	
		setTitle("Istoric pacienti");
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.getContentPane().setBackground(new Color(216, 191, 216));
		this.setBounds(100, 100, 883, 495);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(27, 79, 813, 338);
		this.getContentPane().add(scrollPane);

		table_1 = new JTable();
		table_1.setBackground(new Color(230, 230, 250));
		table_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		table_1.setBorder(UIManager.getBorder("ComboBox.border"));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"<html><center>ID raport arhivat</center></html>", "<html><center>Data<br> inregistrare</center></html>", "<html> <center>Nume si prenume <br> medic</center> </html>", "<html> <center>Nume si prenume <br> asistent</center> ", "<html><center>Simptome</center></html>", "<html><center>Diagnostic</center></html>", "<html><center>Recomandari</center></html>", "<html><center>Rezultat <br> analize<html><center>", "Concluzii"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(43);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(85);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(85);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(80);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(95);
		table_1.getColumnModel().getColumn(7).setPreferredWidth(35);
		table_1.getColumnModel().getColumn(8).setPreferredWidth(95);
		table_1.getTableHeader().setPreferredSize(new Dimension(scrollPane.getWidth(),50));
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.setRowHeight(35);;
		scrollPane.setViewportView(table_1);

		textField = new JTextField();
		textField.setBounds(173, 30, 148, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Introduceti CNP pacient");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(27, 33, 148, 13);
		this.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Istoric rapoarte medicale");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(568, 29, 200, 16);
		this.getContentPane().add(lblNewLabel_1);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(21, 427, 77, 21);
		Image img2 = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		this.getContentPane().add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("Pacientul:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(27, 56, 60, 13);
		getContentPane().add(lblNewLabel_2);
		
		lblNumePacient = new JLabel("");
		lblNumePacient.setBounds(111, 56, 126, 13);
		getContentPane().add(lblNumePacient);

	}
}
