package com.vms.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.vms.dao.AccessToDB;
import com.vms.utility.EmailNotification;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class OTPConfirmation {
	
	private JTextField emailId;
	private JTextField email;
	private JLabel pass1Required;
	private JLabel emaillbl;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JLabel lblNewLabel_4;
	private JSeparator separator_1;
	private JSeparator separator_3;
	private JSeparator separator_5;
	private JSeparator separator_7;
	private JLabel close_lbl;
	private JLabel lblNewLabel_5;
	
	
	private JLabel change;
	
	private JLabel h2;
	private JLabel mvd;
	private JLabel lblNewLabel_2;
	private JFrame frame;
	private JTextField otp;
	private static ArrayList al;
	private static int num;
	private static OTPConfirmation window;
	/**
	 * Launch the application.
	 */
	public void start(ArrayList a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new OTPConfirmation();
					window.frame.setUndecorated(true);
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
					al = new ArrayList(a);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OTPConfirmation() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100,100,1000,700);
		frame.getContentPane().setLayout(null);
		
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(204, 0, 204), new Color(204, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204)));
		panel.setBounds(94, 204, 803, 391);
		panel.setOpaque(false);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Pictures\\lb.jpg"));
		lblNewLabel_4.setBounds(5, 5, 409, 384);
		panel.add(lblNewLabel_4);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(440, 148, 322, 2);
		panel.add(separator_1);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(440, 233, 322, 2);
		panel.add(separator_3);
		
		JButton logInButton = 
				
		new JButton("Create Account");
		
		logInButton.setBackground(new Color(204, 0, 204));
		logInButton.setForeground(Color.WHITE);
		logInButton.setBounds(526, 269, 147, 31);
		panel.add(logInButton);
		
		
		logInButton.setFont(new Font("HP Simplified Hans", Font.PLAIN, 16));
		
		pass1Required = new JLabel("* Required");
		pass1Required.setHorizontalAlignment(SwingConstants.RIGHT);
		pass1Required.setBounds(701, 176, 61, 24);
		panel.add(pass1Required);
		pass1Required.setForeground(Color.RED);
		pass1Required.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		JLabel invalidOtp = new JLabel("* Wrong OTP");
		invalidOtp.setHorizontalAlignment(SwingConstants.RIGHT);
		invalidOtp.setBounds(615, 178, 147, 20);
		panel.add(invalidOtp);
		invalidOtp.setForeground(Color.RED);
		invalidOtp.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		emailId = new JTextField();
		emailId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(al);
				emailId.setText((String)al.get(2));
			}
		});
		emailId.setBounds(440, 113, 235, 37);
		panel.add(emailId);
		emailId.setOpaque(false);
		emailId.setBorder(null);
		emailId.setEditable(false);
		emailId.setColumns(10);
		
		emaillbl = new JLabel("Email :");
		emaillbl.setForeground(new Color(204, 0, 204));
		emaillbl.setBounds(440, 88, 77, 29);
		panel.add(emaillbl);
		emaillbl.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		
		email = new JTextField();
		email.setBounds(440, 113, 235, 37);
		email.setOpaque(false);
		email.setBorder(null);
		panel.add(email);
		email.setColumns(10);
		
		lblNewLabel_1 = new JLabel("OTP :");
		lblNewLabel_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_1.setBounds(440, 173, 107, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		
		change = new JLabel("Change G-mail Account");
		change.setHorizontalAlignment(SwingConstants.CENTER);
		change.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUpPage sp = new SignUpPage();
				
				LoginPage lp = new LoginPage();
				window.frame.dispose();
				sp.main(null);
			}
		});
		change.setForeground(new Color(204, 0, 204));
		change.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		change.setBounds(526, 311, 147, 31);
		panel.add(change);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(556, 16, 102, 47);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(204, 0, 204));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 25));
		
		separator_5 = new JSeparator();
		separator_5.setForeground(new Color(204, 0, 204));
		separator_5.setBounds(538, 56, 135, 2);
		panel.add(separator_5);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(new Color(204, 0, 204));
		separator_7.setBounds(538, 61, 135, 2);
		panel.add(separator_7);
		
		otp = new JTextField();
		otp.setOpaque(false);
		otp.setColumns(10);
		otp.setBorder(null);
		otp.setBounds(438, 198, 235, 37);
		panel.add(otp);
		Random rm = new Random();
		num = rm.nextInt(999999); 
		JLabel lblGetOtp = new JLabel("Get OTP");
		lblGetOtp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGetOtp.setForeground(Color.gray);
				EmailNotification em = new EmailNotification();
				em.sendOtpTomail(num, (String)al.get(2));
			}
		});
		lblGetOtp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGetOtp.setForeground(new Color(204, 0, 204));
		lblGetOtp.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblGetOtp.setBounds(701, 204, 61, 31);
		panel.add(lblGetOtp);
		//email.setBorder(null);
		invalidOtp.setVisible(false);
		pass1Required.setVisible(false);
		
		close_lbl = new JLabel("X");
		close_lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		close_lbl.setForeground(Color.RED);
		close_lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		close_lbl.setBounds(970, 0, 36, 37);
		frame.getContentPane().add(close_lbl);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(LoginPage.class.getResource("/images/download (1).jpg")));
		lblNewLabel_5.setBounds(0, 122, 1000, 578);
		frame.getContentPane().add(lblNewLabel_5);
		
		h2 = new JLabel("MAHA VACCINATION DRIVE");
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setForeground(Color.WHITE);
		h2.setFont(new Font("Dialog", Font.BOLD, 34));
		h2.setAlignmentY(0.0f);
		h2.setBounds(296, 40, 523, 50);
		frame.getContentPane().add(h2);
		
		mvd = new JLabel("");
		mvd.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Pictures\\mvdl6.png"));
		mvd.setBounds(206, 0, 166, 118);
		frame.getContentPane().add(mvd);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginPage.class.getResource("/images/photo-1621947081720-86970823b77a.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1020, 118);
		frame.getContentPane().add(lblNewLabel_2);
		
		invalidOtp.setVisible(false);
		logInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccessToDB out = new AccessToDB();
				Boolean b1,b2;
				int rowsAffected;
				AccessToDB in = new AccessToDB();
				if(num==Integer.valueOf(otp.getText()))
				{
					try {
						rowsAffected = in.insertIntoDB(al);
						if(rowsAffected == 0)
						{
							JOptionPane.showMessageDialog(null,"Registration failed try again");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Account created successfully!!!");
							LoginPage lp = new LoginPage();
							lp.main(null);
							window.frame.dispose();
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					invalidOtp.setVisible(true);
				}
			}
		});
	}
}
