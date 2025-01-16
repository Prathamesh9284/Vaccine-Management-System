package com.vms.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class LoginPage implements Runnable {
	
	private JTextField phoneNoOrEmail;
	private JTextField email;
	private JPasswordField pass1;
	private JLabel phoneNoRequired;
	private JLabel emailRequired;
	private JLabel pass1Required;
	
	private JLabel phoneNolbl;
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
	private JLabel LogInWithMail;
	private String userPhoneNo,userEmail,userPassword,userDbPassword;
	JFrame LoginPage;
	private JLabel lblCreateAccount;
	private static LoginPage window;
	private static JLabel h2;
	private JLabel mvd;
	private JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new LoginPage();
					window.LoginPage.setUndecorated(true);
					window.LoginPage.setLocationRelativeTo(null);
					window.LoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}
	public LoginPage(int a) {
		Thread t = new Thread(this);
		t.start();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		LoginPage = new JFrame();
		LoginPage.setBounds(100,100,1000,700);
		LoginPage.getContentPane().setLayout(null);
		ArrayList al = new ArrayList(7);
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(204, 0, 204), new Color(204, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204)));
		panel.setBounds(94, 204, 803, 391);
		panel.setOpaque(false);
		LoginPage.getContentPane().add(panel);
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
				
		new JButton("Log In");
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logInButton.setBackground(new Color(204, 0, 204));
		logInButton.setForeground(Color.WHITE);
		logInButton.setBounds(526, 269, 147, 31);
		panel.add(logInButton);
		
		
		logInButton.setFont(new Font("HP Simplified Hans", Font.PLAIN, 16));
		
		LogInWithMail = new JLabel("Log In with mail");
		
		LogInWithMail.setForeground(new Color(204, 0, 204));
		LogInWithMail.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		LogInWithMail.setBounds(550, 311, 98, 31);
		panel.add(LogInWithMail);
		
		JLabel invalidPhoneNo = new JLabel("* Invalid Phone Number or Email");
		invalidPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		invalidPhoneNo.setBounds(562, 95, 200, 20);
		panel.add(invalidPhoneNo);
		invalidPhoneNo.setForeground(Color.RED);
		invalidPhoneNo.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		phoneNoRequired = new JLabel("* Required");
		phoneNoRequired.setBounds(701, 126, 61, 24);
		panel.add(phoneNoRequired);
		phoneNoRequired.setForeground(Color.RED);
		phoneNoRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		JLabel invalidEmail = new JLabel("* Invalid Email Id");
		invalidEmail.setBounds(670, 95, 92, 20);
		panel.add(invalidEmail);
		invalidEmail.setForeground(Color.RED);
		invalidEmail.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		emailRequired = new JLabel("* Required");
		emailRequired.setBounds(701, 126, 61, 24);
		panel.add(emailRequired);
		emailRequired.setForeground(Color.RED);
		emailRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		pass1Required = new JLabel("* Required");
		pass1Required.setBounds(701, 211, 61, 24);
		panel.add(pass1Required);
		pass1Required.setForeground(Color.RED);
		pass1Required.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		JLabel invalidPassword = new JLabel("* Password does not match");
		invalidPassword.setBounds(615, 178, 147, 20);
		panel.add(invalidPassword);
		invalidPassword.setForeground(Color.RED);
		invalidPassword.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		
		phoneNolbl = new JLabel("Phone No. :");
		phoneNolbl.setForeground(new Color(204, 0, 204));
		phoneNolbl.setBounds(440, 88, 77, 29);
		panel.add(phoneNolbl);
		phoneNolbl.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		
		phoneNoOrEmail = new JTextField();
		phoneNoOrEmail.setBounds(440, 113, 235, 37);
		panel.add(phoneNoOrEmail);
		phoneNoOrEmail.setOpaque(false);
		phoneNoOrEmail.setBorder(null);
		phoneNoOrEmail.setColumns(10);
		
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
		
		
		pass1 = new JPasswordField();
		pass1.setBounds(440, 198, 235, 37);
		panel.add(pass1);
		pass1.setOpaque(false);
		pass1.setBorder(null);
		
		lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_1.setBounds(440, 173, 107, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		
		JLabel logInWithPhoneNo = new JLabel("Log In with Mobile no");
		
		logInWithPhoneNo.setForeground(new Color(204, 0, 204));
		logInWithPhoneNo.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		logInWithPhoneNo.setBounds(533, 311, 139, 31);
		panel.add(logInWithPhoneNo);
		
		lblCreateAccount = new JLabel("Create  Account");
		lblCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUpPage sp = new SignUpPage();
				
				LoginPage lp = new LoginPage();
				window.LoginPage.dispose();
				sp.main(null);
			}
		});
		lblCreateAccount.setForeground(new Color(204, 0, 204));
		lblCreateAccount.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblCreateAccount.setBounds(550, 342, 98, 31);
		panel.add(lblCreateAccount);
		
		JLabel registerPhoneNo = new JLabel("* Not Registered");
		registerPhoneNo.setHorizontalAlignment(SwingConstants.RIGHT);
		registerPhoneNo.setForeground(Color.RED);
		registerPhoneNo.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		registerPhoneNo.setVisible(false);
		registerPhoneNo.setBounds(584, 94, 178, 18);
		panel.add(registerPhoneNo);
		
		JLabel registerEmail = new JLabel("* Email ID is not registerd");
		registerEmail.setForeground(Color.RED);
		registerEmail.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		registerEmail.setVisible(false);
		registerEmail.setBounds(623, 95, 139, 20);
		panel.add(registerEmail);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setBounds(570, 16, 77, 47);
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
		
		JButton emailLogInButton = new JButton("Log In");
		emailLogInButton.setForeground(Color.WHITE);
		emailLogInButton.setFont(new Font("HP Simplified Hans", Font.PLAIN, 16));
		emailLogInButton.setBackground(new Color(204, 0, 204));
		emailLogInButton.setBounds(526, 269, 147, 31);
		panel.add(emailLogInButton);
		
		//email.setBorder(null);
		invalidPassword.setVisible(false);
		pass1Required.setVisible(false);
		emailRequired.setVisible(false);
		invalidEmail.setVisible(false);
		phoneNoRequired.setVisible(false);
		invalidPhoneNo.setVisible(false);
		
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
		LoginPage.getContentPane().add(close_lbl);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(LoginPage.class.getResource("/images/download (1).jpg")));
		lblNewLabel_5.setBounds(0, 122, 1000, 578);
		LoginPage.getContentPane().add(lblNewLabel_5);
		
		h2 = new JLabel();
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setForeground(Color.WHITE);
		h2.setFont(new Font("Dialog", Font.BOLD, 34));
		h2.setAlignmentY(0.0f);
		h2.setBounds(296, 40, 523, 50);
		LoginPage.getContentPane().add(h2);
		
		mvd = new JLabel("");
		mvd.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Pictures\\mvdl6.png"));
		mvd.setBounds(206, 0, 166, 118);
		LoginPage.getContentPane().add(mvd);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginPage.class.getResource("/images/photo-1621947081720-86970823b77a.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1020, 118);
		LoginPage.getContentPane().add(lblNewLabel_2);
		
		
		email.setVisible(false);
		emaillbl.setVisible(false);
		invalidEmail.setVisible(false);
		emailRequired.setVisible(false);
		logInWithPhoneNo.setVisible(false);
		emailLogInButton.setVisible(false);
		
		new LoginPage(0);
		
		LogInWithMail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//phoneNo.setVisible(false);
				phoneNolbl.setVisible(false);
				invalidPhoneNo.setVisible(false);
				phoneNoRequired.setVisible(false);
				LogInWithMail.setVisible(false);
				
				//email.setVisible(true);
				emaillbl.setVisible(true);
				
				logInWithPhoneNo.setVisible(true);
			}
		});
		logInWithPhoneNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//email.setVisible(false);
				emaillbl.setVisible(false);
				invalidEmail.setVisible(false);
				emailRequired.setVisible(false);
				logInWithPhoneNo.setVisible(false);
				
				//phoneNo.setVisible(true);
				phoneNolbl.setVisible(true);
				
				LogInWithMail.setVisible(true);
			}
		});
		logInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccessToDB out = new AccessToDB();
				Boolean b1,b2;
				
				b2 = true;
				if(LogInWithMail.isVisible()==true)
				{

					b1 = Pattern.compile("^[6-9]{1}[0-9]{9}$").matcher(phoneNoOrEmail.getText()).matches(); 
					if(phoneNoOrEmail.getText().trim().isEmpty()==true)
					{
						phoneNoRequired.setVisible(true);
						b2 = false;
					}
					else if(b1==false)
					{
						invalidPhoneNo.setVisible(true);
						b2 = false;
					}
					else 
					{
						phoneNoRequired.setVisible(false);
						invalidPhoneNo.setVisible(false);
					}
				}
				else
				{
					
					b1 = Pattern.compile("[a-zA-Z0-9]{3,20}@[A-Za-z]{3,10}.(com|in)").matcher(phoneNoOrEmail.getText()).matches(); 
					if(phoneNoOrEmail.getText().trim().isEmpty()==true)
					{
						phoneNoRequired.setVisible(true);
						b2 = false;
					}
					else if(b1==false)
					{
						invalidPhoneNo.setVisible(true);
						b2 = false;
					}
					else 
					{
						phoneNoRequired.setVisible(false);
						invalidPhoneNo.setVisible(false);
					}
				}
					if(pass1.getPassword().length==0)
					{
						pass1Required.setVisible(true);
						b2 = false;
					}
					else {
						pass1Required.setVisible(false);
						invalidPassword.setVisible(false);
						userPassword = new String(pass1.getPassword());
					}
					if(b1==true)
					{
						try {
							ArrayList al = new ArrayList(3);
							if(!LogInWithMail.isVisible())
							{
								al = out.validateEmailAndPassword(phoneNoOrEmail.getText());
							}
							else
							{
								al = out.validatePhoneNumberAndPassword(phoneNoOrEmail.getText());
							}
							
							if((Boolean)al.get(0)==true)
							{
								userDbPassword = (String)al.get(4);
								if(((Boolean)al.get(0)==true)&&!(userDbPassword.equals(userPassword)))
								{
									
									invalidPassword.setVisible(true);
								}
								else if(((Boolean)al.get(0)==true)&&(userDbPassword.equals(userPassword)))
								{
									
									JOptionPane.showMessageDialog(null, "Login successfull!!!");
									DashBoard d = new DashBoard();
									window.LoginPage.dispose();
									String Name = (String)al.get(1);
									
									d.build(al);
								}
								
							}
							else if((Boolean)al.get(0)==false)
							{
								registerPhoneNo.setVisible(true);
							}
						} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
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
