import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Gestiunea_resurselor_umane_inspector extends JFrame{

	private JFrame frmInspector;
	private int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestiunea_resurselor_umane_inspector window = new Gestiunea_resurselor_umane_inspector();
					window.frmInspector.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gestiunea_resurselor_umane_inspector() {
		initialize();
	}
	public Gestiunea_resurselor_umane_inspector(int id) {
		this.id=id;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInspector = new JFrame();
		frmInspector.setTitle("Inspector");
		frmInspector.getContentPane().setBackground(new Color(211, 211, 211));
		frmInspector.setBounds(100, 100, 594, 418);
		frmInspector.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInspector.getContentPane().setLayout(null);
		frmInspector.setVisible(true);
		Image i1=new ImageIcon(this.getClass().getResource("/profile.png")).getImage();
		frmInspector.setIconImage(i1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 10, 560, 361);
		frmInspector.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl1 = new JLabel("V-a\u021Bi logat ca \u0219i inspector resurse umane");
		lbl1.setBounds(47, 10, 465, 33);
		lbl1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		panel.add(lbl1);
		
		
		
		JButton btnOrar = new JButton("Consultare orar");
		btnOrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insp_ConsultareOrar a=new Insp_ConsultareOrar(id);
				a.setLocationRelativeTo(null);
				frmInspector.dispose();
			}
		});
		btnOrar.setBackground(new Color(255, 250, 250));
		btnOrar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnOrar.setBounds(233, 145, 296, 69);
		Image img1=new ImageIcon(this.getClass().getResource("/Actions-view-calendar-timeline-icon.png")).getImage();
		Image newImage1 = img1.getScaledInstance(55, 55, Image.SCALE_DEFAULT);
		btnOrar.setIcon(new ImageIcon(img1));
		panel.add(btnOrar);
		
	
		JButton btnAngajat = new JButton("Afi\u0219are angajat");
		btnAngajat.setBackground(new Color(255, 250, 250));
		btnAngajat.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnAngajat.setBounds(22, 53, 296, 69);
		Image image=new ImageIcon(this.getClass().getResource("/Medical-Pharmacist-Female-Dark-icon.png")).getImage();
		btnAngajat.setIcon(new ImageIcon(image));
		
		btnAngajat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insp_AfisareAngajat a=new Insp_AfisareAngajat(id);
				a.setLocationRelativeTo(null);
				frmInspector.dispose();
              
			}
		});
		panel.add(btnAngajat);
		
		JButton btnServMedicale = new JButton("Introducere concedii");
		btnServMedicale.setBackground(new Color(255, 250, 250));
		btnServMedicale.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnServMedicale.setBounds(22, 246, 296, 69);
		Image im=new ImageIcon(this.getClass().getResource("/k-services-icon.png")).getImage();
		btnServMedicale.setIcon(new ImageIcon(im));
		btnServMedicale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insp_Servicii i=new Insp_Servicii(id);
				i.setLocationRelativeTo(null);
				frmInspector.dispose();
			}
		});
		panel.add(btnServMedicale);	
	  
		JButton btnBack = new JButton("Back");
		Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Selectare_modul s=new Selectare_modul(id);
				s.setLocationRelativeTo(null);
				s.setVisible(true);
				frmInspector.dispose();
			}

		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(10, 330, 85, 21);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(346, 224, 180, 127);
		Image img2=new ImageIcon(this.getClass().getResource("/Supervisor-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(47, 132, 131, 104);
		Image img3=new ImageIcon(this.getClass().getResource("/heart-beat-icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img3));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(374, 38, 109, 97);
		Image img4=new ImageIcon(this.getClass().getResource("/stethoscope-icon.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img4));
		panel.add(lblNewLabel_2);
	}
}
