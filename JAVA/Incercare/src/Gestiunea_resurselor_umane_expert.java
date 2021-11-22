import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;

public class Gestiunea_resurselor_umane_expert extends JFrame {

	private JFrame frmExpertFinanciarContabil;
	private int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestiunea_resurselor_umane_expert window = new Gestiunea_resurselor_umane_expert();
					window.frmExpertFinanciarContabil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gestiunea_resurselor_umane_expert() {
		initialize();
	}
	public Gestiunea_resurselor_umane_expert(int idU) {
		this.id=idU;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExpertFinanciarContabil = new JFrame();
		frmExpertFinanciarContabil.setTitle("Expert financiar contabil");
		frmExpertFinanciarContabil.getContentPane().setBackground(new Color(240, 248, 255));
		frmExpertFinanciarContabil.getContentPane().setLayout(null);
		frmExpertFinanciarContabil.setVisible(true);
		Image i1=new ImageIcon(this.getClass().getResource("/info.png")).getImage();
		frmExpertFinanciarContabil.setIconImage(i1);
		
		JLabel lblNewLabel = new JLabel("<html>V-a\u021Bi logat ca \u0219i expert financiar contabil</html>");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(129, 121, 391, 37);
		frmExpertFinanciarContabil.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(10, 423, 85, 21);
		Image img=new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Selectare_modul m=new Selectare_modul(id);
				m.setLocationRelativeTo(null);
				m.setVisible(true);
				frmExpertFinanciarContabil.dispose();
			}

		});
		btnBack.setBackground(null);
		btnBack.setBorder(null);
		frmExpertFinanciarContabil.getContentPane().add(btnBack);
		
		JButton btnOrar = new JButton("");
		btnOrar.setBounds(100, 202, 200, 140);
		btnOrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Expert_ConsultareOrar o=new Expert_ConsultareOrar(id);
				o.setLocationRelativeTo(null);
				frmExpertFinanciarContabil.dispose();
			}
		});
		Image img1=new ImageIcon(this.getClass().getResource("/schedule3.png")).getImage();
		Image newImage1 = img1.getScaledInstance(200, 140, Image.SCALE_DEFAULT);
		btnOrar.setIcon(new ImageIcon(newImage1));
		btnOrar.setBackground(null);
		btnOrar.setBorder(null);
		frmExpertFinanciarContabil.getContentPane().add(btnOrar);
		
		
		JButton btnInfo = new JButton("");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Expert_InfoPers aux=new Expert_InfoPers(id);
				aux.setLocationRelativeTo(null);
				frmExpertFinanciarContabil.dispose();
			}
		});
		btnInfo.setBounds(414, 212, 130, 130);
		Image img2=new ImageIcon(this.getClass().getResource("/profile.png")).getImage();
		Image newImage2 = img2.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		btnInfo.setIcon(new ImageIcon(newImage2));
		btnInfo.setBackground(null);
		btnInfo.setBorder(null);
		frmExpertFinanciarContabil.getContentPane().add(btnInfo);
		
		JLabel lblNewLabel_1 = new JLabel("Consultare orar");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(129, 343, 146, 21);
		frmExpertFinanciarContabil.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Afi\u0219are informa\u021Bii personale");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(365, 346, 223, 15);
		frmExpertFinanciarContabil.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(154, 10, 346, 101);
		Image img3=new ImageIcon(this.getClass().getResource("financial.png")).getImage();
		Image newImage3=img3.getScaledInstance(350, 110, Image.SCALE_DEFAULT);
		lblNewLabel_3.setIcon(new ImageIcon(newImage3));
		frmExpertFinanciarContabil.getContentPane().add(lblNewLabel_3);
		frmExpertFinanciarContabil.setBackground(new Color(240, 248, 255));
		frmExpertFinanciarContabil.setBounds(100, 100, 660, 491);
		frmExpertFinanciarContabil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExpertFinanciarContabil.setVisible(true);
	}
}
