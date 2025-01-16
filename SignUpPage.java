package com.vms.services;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.util.regex.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.vms.dao.AccessToDB;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
public class SignUpPage implements Runnable{

	JFrame SignUpPage;
	private JTextField phoneNo;
	private JTextField email;
	private JPasswordField pass1;
	private JPasswordField pass2;
	private JTextField name;
	private JLabel invalidName;
	private JLabel nameRequired;
	private JLabel phoneNoRequired;
	private JLabel emailRequired;
	private JLabel pass1Required;
	private JLabel pass2Required;
	private static ArrayList al; 
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JPanel panel;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_7;
	private JLabel close_lbl;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private static SignUpPage window;
	private JLabel lblNewLabel_7;
	private JLabel mvd;
	private JLabel lblNewLabel_4;
	private static JLabel h2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new SignUpPage();
					window.SignUpPage.setUndecorated(true);
					window.SignUpPage.setLocationRelativeTo(null);
					window.SignUpPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpPage() {
		initialize();
	}
	public SignUpPage(int a)
	{
		Thread t = new Thread(this);
		t.start();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		SignUpPage = new JFrame();
		SignUpPage.setBounds(100,100,1000,750);
		SignUpPage.getContentPane().setLayout(null);
		ArrayList al = new ArrayList(7);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(204, 0, 204), new Color(153, 0, 255), new Color(153, 0, 255), new Color(204, 0, 204)));
		panel.setBounds(98, 165, 797, 508);
		SignUpPage.getContentPane().add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		separator = new JSeparator();
		separator.setBounds(440, 104, 326, 2);
		panel.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(440, 178, 326, 2);
		panel.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(440, 252, 326, 2);
		panel.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(440, 323, 326, 2);
		panel.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(440, 401, 326, 2);
		panel.add(separator_4);
		invalidName = new JLabel("* Name must be in A to Z");
		invalidName.setBounds(631, 48, 135, 20);
		panel.add(invalidName);
		invalidName.setForeground(Color.RED);
		invalidName.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		nameRequired = new JLabel("* Required");
		nameRequired.setBounds(705, 79, 61, 24);
		panel.add(nameRequired);
		nameRequired.setForeground(Color.RED);
		nameRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		phoneNoRequired = new JLabel("* Required");
		phoneNoRequired.setBounds(705, 155, 61, 24);
		panel.add(phoneNoRequired);
		phoneNoRequired.setForeground(Color.RED);
		phoneNoRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		emailRequired = new JLabel("* Required");
		emailRequired.setBounds(705, 230, 61, 24);
		panel.add(emailRequired);
		emailRequired.setForeground(Color.RED);
		emailRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		pass1Required = new JLabel("* Required");
		pass1Required.setBounds(705, 301, 61, 24);
		panel.add(pass1Required);
		pass1Required.setForeground(Color.RED);
		pass1Required.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		pass2Required = new JLabel("* Required");
		pass2Required.setBounds(705, 379, 61, 24);
		panel.add(pass2Required);
		pass2Required.setForeground(Color.RED);
		pass2Required.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		JLabel invalidPassword = new JLabel("* Password does not match");
		invalidPassword.setBounds(619, 345, 147, 20);
		panel.add(invalidPassword);
		invalidPassword.setForeground(Color.RED);
		invalidPassword.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		JLabel invalidEmail = new JLabel("* Invalid Email Id");
		invalidEmail.setBounds(674, 199, 92, 20);
		panel.add(invalidEmail);
		invalidEmail.setForeground(Color.RED);
		invalidEmail.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		JLabel invalidPhoneNo = new JLabel("* Invalid Phone Number");
		invalidPhoneNo.setBounds(641, 124, 125, 20);
		panel.add(invalidPhoneNo);
		invalidPhoneNo.setForeground(Color.RED);
		invalidPhoneNo.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		invalidPhoneNo.setVisible(false);
		invalidEmail.setVisible(false);
		invalidPassword.setVisible(false);
		pass2Required.setVisible(false);
		pass1Required.setVisible(false);
		emailRequired.setVisible(false);
		phoneNoRequired.setVisible(false);
		nameRequired.setVisible(false);
		invalidName.setVisible(false);
		JButton btnNewButton = 
				
		new JButton("Next");
		btnNewButton.setBackground(new Color(204, 0, 204));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(535, 429, 142, 31);
		panel.add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Boolean b1,b2;
				b2 = true;
				b1 = Pattern.compile("([A-za-z]{1,30})[ ]([A-za-z]{1,30})").matcher(name.getText()).matches();
				if(name.getText().trim().isEmpty()==true)
				{
					nameRequired.setVisible(true);
					invalidName.setVisible(false);
					b2 = false;
				}
				else if(b1==false)
				{
					invalidName.setVisible(true);
					nameRequired.setVisible(true);
					b2 = false;
				}
				else
				{
					nameRequired.setVisible(false);
					invalidName.setVisible(false);
					al.add(name.getText());
				}
				
				b1 = Pattern.compile("^[6-9]{1}[0-9]{9}$").matcher(phoneNo.getText()).matches(); 
				if(phoneNo.getText().trim().isEmpty()==true)
				{
					phoneNoRequired.setVisible(true);
					invalidPhoneNo.setVisible(false);
					b2 = false;
				}
				else if(b1==false)
				{
					invalidPhoneNo.setVisible(true);
					phoneNoRequired.setVisible(false);
					b2 = false;
				}
				else 
				{
					phoneNoRequired.setVisible(false);
					invalidPhoneNo.setVisible(false);
					al.add(phoneNo.getText());
				}
				b1 = Pattern.compile("[a-zA-Z0-9]{3,20}@[A-Za-z]{3,10}.(com|in)").matcher(email.getText()).matches();
				if(email.getText().trim().isEmpty()==true)
				{
					emailRequired.setVisible(true);
					invalidEmail.setVisible(false);
					b2 = false;
				}
				else if(b1==false)
				{
					
					invalidEmail.setVisible(true);
					emailRequired.setVisible(false);
					b2 = false;
				}
				else
				{
					emailRequired.setVisible(false);
					invalidEmail.setVisible(false);
					al.add(email.getText());
				}
				String password1,password2;
				
				
				password1 = new String(pass1.getPassword());
				password2 = new String(pass2.getPassword());
				if(password1.trim().isEmpty()==true)
				{
					pass1Required.setVisible(true);
					b2 = false;
				}
				else
				{
					pass1Required.setVisible(false);
				}
				if(password2.trim().isEmpty()==true)
				{
					pass2Required.setVisible(true);
					invalidPassword.setVisible(false);
					b2 = false;
				}
				else if(!password1.equals(password2))
				{
					invalidPassword.setVisible(true);
					pass2Required.setVisible(true);
					b2 = false;
				}
				else
				{
					
					pass2Required.setVisible(false);
					invalidPassword.setVisible(false);
					al.add(password1);
				}
				if(b2==true)
				{
					window.SignUpPage.dispose();
					OTPConfirmation o = new OTPConfirmation();
					o.start(al);
				}
			
			}
		});
		btnNewButton.setFont(new Font("HP Simplified Hans", Font.PLAIN, 16));
		
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
		SignUpPage.getContentPane().add(close_lbl);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(SignUpPage.class.getResource("/images/download (1).jpg")));
		lblNewLabel_5.setBounds(0, 119, 1000, 639);
		SignUpPage.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Log In");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginPage lp = new LoginPage();
				lp.main(null);;
				window.SignUpPage.dispose();
			}
		});
		
		lblNewLabel_6.setForeground(new Color(204, 0, 204));
		lblNewLabel_6.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(590, 465, 46, 31);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(SignUpPage.class.getResource("/images/infographic-with-details-about-p.jpg")));
		lblNewLabel_7.setBounds(5, 0, 430, 511);
		panel.add(lblNewLabel_7);
		
		pass2 = new JPasswordField();
		pass2.setBounds(440, 366, 235, 37);
		panel.add(pass2);
		pass2.setOpaque(false);
		pass2.setBorder(null);
		
		lblNewLabel_3 = new JLabel("Confirm Password :");
		lblNewLabel_3.setForeground(new Color(204, 0, 204));
		lblNewLabel_3.setBounds(440, 340, 135, 29);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		
		pass1 = new JPasswordField();
		pass1.setBounds(440, 288, 235, 37);
		panel.add(pass1);
		pass1.setOpaque(false);
		pass1.setBorder(null);
		
		lblNewLabel_1 = new JLabel("Create Password :");
		lblNewLabel_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_1.setBounds(440, 265, 117, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		
		email = new JTextField();
		email.setBounds(440, 217, 235, 37);
		panel.add(email);
		email.setColumns(10);
		email.setOpaque(false);
		email.setBorder(null);
		
		lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setForeground(new Color(204, 0, 204));
		lblNewLabel_2.setBounds(440, 194, 77, 29);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		
		phoneNo = new JTextField();
		phoneNo.setBounds(440, 143, 235, 37);
		panel.add(phoneNo);
		phoneNo.setOpaque(false);
		phoneNo.setBorder(null);
		phoneNo.setColumns(10);
		
		lblNewLabel_2_2 = new JLabel("Mobile No. :");
		lblNewLabel_2_2.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_2.setBounds(440, 119, 77, 29);
		panel.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		
		name = new JTextField();
		name.setBounds(440, 69, 235, 37);
		panel.add(name);
		name.setColumns(10);
		name.setBorder(null);
		name.setOpaque(false);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name :");
		lblNewLabel_2_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1.setBounds(440, 43, 61, 29);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		
		JLabel lblNewLabel = new JLabel("Sign Up\r\n");
		lblNewLabel.setBounds(562, 0, 92, 47);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(204, 0, 204));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 25));
		
		separator_7 = new JSeparator();
		separator_7.setForeground(new Color(204, 0, 204));
		separator_7.setBounds(539, 35, 125, 2);
		panel.add(separator_7);
		
		JSeparator separator_7_1 = new JSeparator();
		separator_7_1.setForeground(new Color(204, 0, 204));
		separator_7_1.setBounds(539, 40, 125, 2);
		panel.add(separator_7_1);
		
		h2 = new JLabel();
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setForeground(Color.WHITE);
		h2.setFont(new Font("Dialog", Font.BOLD, 34));
		h2.setAlignmentY(0.0f);
		h2.setBounds(308, 34, 523, 50);
		SignUpPage.getContentPane().add(h2);
		
		mvd = new JLabel("");
		mvd.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Pictures\\mvdl6.png"));
		mvd.setBounds(210, 0, 166, 118);
		SignUpPage.getContentPane().add(mvd);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(SignUpPage.class.getResource("/images/photo-1621947081720-86970823b77a.jpg")));
		lblNewLabel_4.setBounds(0, 0, 1017, 118);
		SignUpPage.getContentPane().add(lblNewLabel_4);
		new SignUpPage(0);
		
	}
	@Override
	public void run()
	{
		String appName = "MAHA VACCINATION DRIVE";
		
		String head = "";
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0;i<=21;i++)
		{
			
			head = head + appName.charAt(i);
			h2.setText(head);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
