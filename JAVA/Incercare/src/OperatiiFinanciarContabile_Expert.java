import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class OperatiiFinanciarContabile_Expert  extends JFrame {
	
	private int id;
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_NAME = "policlinica";
	private final static String USER = "root";
	private final static String PASSWORD = "Diana07#";

	private JFrame frmProfituri;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatiiFinanciarContabile_Expert window = new OperatiiFinanciarContabile_Expert();
					window.frmProfituri.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OperatiiFinanciarContabile_Expert() {
		initialize();
	}
	
	public OperatiiFinanciarContabile_Expert(int id) {
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfituri = new JFrame();
		frmProfituri.setTitle("Profituri");
		frmProfituri.setBounds(00, 100, 659, 430);
		frmProfituri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfituri.setVisible(true);
		Image i1=new ImageIcon(this.getClass().getResource("/money-icon.png")).getImage();
		frmProfituri.setIconImage(i1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setForeground(Color.BLACK);
		frmProfituri.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Vizualizare profit policlinica:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(55, 130, 209, 30);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Back");
		Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selectare_modul s=new Selectare_modul(id);
				s.setVisible(true);
				s.setLocationRelativeTo(null);
				frmProfituri.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 353, 90, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Confirmare selectie");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatiiFC_profitpoliclinica p=new OperatiiFC_profitpoliclinica(id);
				p.setLocationRelativeTo(null);
				p.setVisible(true);
				frmProfituri.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(55, 194, 204, 57);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 222, 173));
		panel_1.setBounds(10, 10, 625, 57);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Delogare");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(511, 10, 104, 37);
		btnNewButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Policlinica.main(null);
				frmProfituri.dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Expert financiar-contabil");
		lblNewLabel.setBounds(214, 19, 215, 25);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Vizualizare profit medic: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(389, 114, 190, 62);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Confirmare selectie");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperatiiFC_profitMedic p=new OperatiiFC_profitMedic(id);
				p.setLocationRelativeTo(null);
				p.setVisible(true);
				frmProfituri.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(378, 194, 209, 56);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(389, 245, 178, 122);
		Image img1= new ImageIcon(this.getClass().getResource("/accounting-mail-icon.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img1));
		panel.add(lblNewLabel_3);
		
		JLabel lblCash = new JLabel("");
		lblCash.setBounds(110, 261, 181, 108);
		Image img2= new ImageIcon(this.getClass().getResource("/Cash-register-icon.png")).getImage();
		lblCash.setIcon(new ImageIcon(img2));
		panel.add(lblCash);
		
	}
}
