package com.vms.services;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class BookApointment {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookApointment window = new BookApointment();
					window.frame.setUndecorated(true);
					window.frame.setLocationRelativeTo(null);
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
	public BookApointment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel mvd = new JLabel("");
		mvd.setIcon(new ImageIcon(BookApointment.class.getResource("/images/mvdl6.png")));
		mvd.setBounds(179, 3, 166, 118);
		frame.getContentPane().add(mvd);
		
		JLabel h2 = new JLabel("MAHA VACCINATION DRIVE");
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setForeground(Color.WHITE);
		h2.setFont(new Font("Dialog", Font.BOLD, 34));
		h2.setAlignmentY(0.0f);
		h2.setBounds(265, 37, 523, 50);
		frame.getContentPane().add(h2);
		
		JLabel menuBar = new JLabel("");
		menuBar.setIcon(new ImageIcon(BookApointment.class.getResource("/images/menu bar.png")));
		menuBar.setBounds(42, 37, 50, 50);
		frame.getContentPane().add(menuBar);
		
		JLabel lbl_exit = new JLabel("X");
		lbl_exit.setForeground(Color.RED);
		lbl_exit.setFont(new Font("HP Simplified Hans", Font.PLAIN, 24));
		lbl_exit.setBounds(862, 10, 61, 29);
		frame.getContentPane().add(lbl_exit);
		lbl_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BookApointment.class.getResource("/images/photo-1621947081720-86970823b77a.jpg")));
		lblNewLabel.setBounds(0, 0, 900, 121);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Pictures\\user.png"));
		lblNewLabel_1.setBounds(42, 165, 156, 121);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prathamesh");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel_2.setBounds(208, 187, 406, 62);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("UID : ");
		lblNewLabel_3.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(208, 245, 61, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("10000000");
		lblNewLabel_3_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(237, 245, 61, 22);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(51, 0, 204));
		separator.setBounds(90, 289, 311, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(51, 0, 204));
		separator_1.setBounds(90, 284, 311, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile No. :");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_4.setBounds(104, 311, 108, 29);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("9284669149");
		lblNewLabel_4_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(208, 311, 108, 29);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Email ID      :");
		lblNewLabel_4_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_4_2.setBounds(104, 358, 108, 29);
		frame.getContentPane().add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("opg0234@gmail.com");
		lblNewLabel_4_1_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(208, 358, 156, 29);
		frame.getContentPane().add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Vaccination Status :");
		lblNewLabel_4_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_4_2_1.setBounds(379, 450, 165, 29);
		frame.getContentPane().add(lblNewLabel_4_2_1);
	}
}
