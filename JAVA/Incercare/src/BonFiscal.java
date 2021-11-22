import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BonFiscal extends JFrame {

	private JTable table;
	private JTextField tfPretTotal;
	private int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BonFiscal window = new BonFiscal();
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
	public BonFiscal() {
		initialize();
	}
	public BonFiscal(int id) {
		this.id=id;
		initialize();
	}
	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.getContentPane().setBackground(new Color(176, 224, 230));
		this.getContentPane().setLayout(null);
		this.setTitle("Bon Fiscal");
		this.setIconImage(new ImageIcon(this.getClass().getResource("/Cash-register-icon.png")).getImage());
		JPanel panel = new JPanel();
		panel.setBounds(109, 33, 291, 202);
		this.getContentPane().add(panel);
		panel.setLayout(new BorderLayout());

		table = new JTable();
		table.setBounds(0, 0, 291, 202);
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Serviciul medical", "Durata", "Pret" }) {
					Class[] columnTypes = new Class[] { String.class, Integer.class, Object.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		Receptie.class.getDeclaredMethods();
		DefaultTableModel tableModelBon = (DefaultTableModel) table.getModel();

		tfPretTotal = new JTextField();
		tfPretTotal.setEditable(false);
		tfPretTotal.setBounds(291, 245, 96, 19);
		this.getContentPane().add(tfPretTotal);
		tfPretTotal.setColumns(10);

		JLabel lblPretTotal = new JLabel("Pret total:");
		lblPretTotal.setBounds(224, 248, 57, 13);
		this.getContentPane().add(lblPretTotal);

		JLabel lblBonFiscal = new JLabel("Bon fiscal");
		lblBonFiscal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBonFiscal.setBounds(21, 10, 96, 13);
		this.getContentPane().add(lblBonFiscal);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 244, 77, 21);
		Image img2 = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img2));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Receptie r=new Receptie(id);
				r.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		this.getContentPane().add(btnBack);
		this.setBounds(100, 100, 517, 315);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTfPretTotal() {
		return tfPretTotal;
	}

	public void setTfPretTotal(JTextField tfPretTotal) {
		this.tfPretTotal = tfPretTotal;
	}
}
