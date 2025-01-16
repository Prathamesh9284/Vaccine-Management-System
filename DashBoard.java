package com.vms.services;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.SoftBevelBorder;

import com.vms.dao.AccessToDB;

import javax.swing.border.BevelBorder;



public class DashBoard implements Runnable {
	private static JLabel menuBar;
	
	private static JFrame Home;
	private static ArrayList al;
	
	private static JPanel board;
	private static JLabel name;
	static DashBoard window;
	private static JLabel h2 ;
	private static int a = 0;
	/**
	 * Launch the application.
	 */
	public void build (ArrayList a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new DashBoard();
					window.Home.setUndecorated(true);
					window.Home.setLocationRelativeTo(null);
					window.Home.setVisible(true);
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
	public DashBoard() {
		//userName = (String) Al.get(1);
		initialize();
	}
	public DashBoard(int a)
	{
		Thread t = new Thread(this);
		t.start();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Home = new JFrame();
		Home.getContentPane().setBackground(Color.WHITE);
		Home.setBackground(Color.WHITE);
		
		Home.setBounds(100, 100, 1000, 739);
		Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Home.getContentPane().setLayout(null);
		
		JLabel lbl_exit = new JLabel("X");
		lbl_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lbl_exit.setForeground(Color.RED);
		lbl_exit.setFont(new Font("HP Simplified Hans", Font.PLAIN, 24));
		lbl_exit.setBounds(970, 10, 36, 37);
		Home.getContentPane().add(lbl_exit);
		
		h2 = new JLabel();
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setForeground(Color.WHITE);
		h2.setFont(new Font("Dialog", Font.BOLD, 34));
		h2.setAlignmentY(0.0f);
		h2.setBounds(289, 37, 523, 50);
		Home.getContentPane().add(h2);
		
		board = new JPanel();
		board.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 0, 204), new Color(51, 0, 255), new Color(51, 0, 255), new Color(51, 0, 255)));
		menuBar = new JLabel("");
		board.setBackground(Color.WHITE);
		board.setBounds(0, 37, 200, 641);
		Home.getContentPane().add(board);
		board.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 20, 50, 50);
		lblNewLabel_4.setIcon(new ImageIcon(DashBoard.class.getResource("/com/vcs/images/user-286-256 (1).png")));
		board.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("");
		lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1_1.setBounds(10, 605, 25, 25);
		lblNewLabel_6_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.Home.dispose();
				LoginPage lp = new LoginPage();
				lp.main(null);
			}
		});
		lblNewLabel_6_1_1_1.setIcon(new ImageIcon(DashBoard.class.getResource("/images/transparent-login-icon-logout-ic.png")));
		lblNewLabel_6_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1_1.setBackground(Color.WHITE);
		board.add(lblNewLabel_6_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 85);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(204, 0, 204), new Color(204, 0, 204), new Color(204, 0, 204), new Color(204, 0, 204)));
		panel.setBackground(Color.WHITE);
		board.add(panel);
		panel.setLayout(null);
		
		name = new JLabel("Unknown");
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setForeground(new Color(0, 153, 255));
		name.setBounds(61, 24, 129, 38);
		panel.add(name);
		
		name.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DashBoard.class.getResource("/images/photo-1621947081720-86970823b77a.jpg")));
		lblNewLabel_2.setBounds(2, 2, 196, 81);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("View Appointment");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewAppointment vp = new ViewAppointment();
				AccessToDB a = new AccessToDB();
				ArrayList ad = new ArrayList();
				try {
					
					ad = a.getAppointmentDetails((String) al.get(2));
					
					if(!(Boolean)ad.get(0))
					{
						JOptionPane.showMessageDialog(null, "First book appointment");
					}
					else
					{
						window.Home.dispose();
						vp.build(ad);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		lblNewLabel_1.setBounds(58, 170, 120, 50);
		lblNewLabel_1.setForeground(new Color(0, 153, 255));
		lblNewLabel_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		board.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterToVaccination rg = new RegisterToVaccination();
				AccessToDB a = new AccessToDB();
				try {
					if(!a.isRegistered((String)al.get(2)))
					{
						window.Home.dispose();
						rg.build(al);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You have already booked appointment");
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Downloads\\appointment-icon-png-27 (1).png"));
		lblNewLabel_4_1_1.setBounds(10, 96, 50, 50);
		board.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book Appointment");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterToVaccination rg = new RegisterToVaccination();
				AccessToDB a = new AccessToDB();
				try {
					if(!a.isRegistered((String)al.get(2)))
					{
						window.Home.dispose();
						rg.build(al);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You have already booked appointment");
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_1_1.setBounds(58, 96, 120, 50);
		lblNewLabel_1_1.setForeground(new Color(0, 153, 255));
		lblNewLabel_1_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		board.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Log Out");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.Home.dispose();
				LoginPage lp = new LoginPage();
				lp.main(null);
			}
		});
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(0, 153, 255));
		lblNewLabel_1_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(77, 605, 59, 25);
		board.add(lblNewLabel_1_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204)));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(0, 81, 200, 78);
		board.add(panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204)));
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(0, 157, 200, 78);
		board.add(panel_1_1_1);
		board.setVisible(true);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewAppointment vp = new ViewAppointment();
				AccessToDB a = new AccessToDB();
				ArrayList ad = new ArrayList();
				try {
					
					ad = a.getAppointmentDetails((String) al.get(2));
					
					if(!(Boolean)ad.get(0))
					{
						JOptionPane.showMessageDialog(null, "First book appointment");
					}
					else
					{
						window.Home.dispose();
						vp.build(ad);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_4_1.setBounds(10, 11, 50, 50);
		panel_1_1_1.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setIcon(new ImageIcon(DashBoard.class.getResource("/images/istockphoto-1257955384-170667a-r.png")));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 102, 255));
		separator.setBounds(10, 592, 180, 2);
		board.add(separator);
		
		menuBar.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Downloads\\menu bar.png"));
		menuBar.setBounds(42, 37, 50, 50);
		Home.getContentPane().add(menuBar);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 668, 750, -72);
		Home.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("Contact Us At -");
		lblNewLabel_7.setFont(new Font("HP Simplified Hans", Font.PLAIN, 16));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(427, 689, 200, 19);
		Home.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_6_1_1_2 = new JLabel("");
		lblNewLabel_6_1_1_2.setIcon(new ImageIcon(DashBoard.class.getResource("/com/vcs/images/icon-email-icon-clip-art-at-clke (1).png")));
		lblNewLabel_6_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_6_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_6_1_1_2.setBounds(387, 689, 30, 30);
		Home.getContentPane().add(lblNewLabel_6_1_1_2);
		
		JLabel lblNewLabel_7_1 = new JLabel("mahavaccinationdrive@gmail.com");
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 16));
		lblNewLabel_7_1.setBounds(427, 710, 250, 19);
		Home.getContentPane().add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_6_1_1_2_1 = new JLabel("");
		lblNewLabel_6_1_1_2_1.setIcon(new ImageIcon(DashBoard.class.getResource("/com/vcs/images/fb.png")));
		lblNewLabel_6_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1_2_1.setBackground(Color.WHITE);
		lblNewLabel_6_1_1_2_1.setBounds(907, 689, 30, 30);
		Home.getContentPane().add(lblNewLabel_6_1_1_2_1);
		
		JLabel lblNewLabel_6_1_1_2_1_1 = new JLabel("");
		lblNewLabel_6_1_1_2_1_1.setIcon(new ImageIcon(DashBoard.class.getResource("/com/vcs/images/twitter (1).png")));
		lblNewLabel_6_1_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_6_1_1_2_1_1.setBounds(946, 689, 30, 30);
		Home.getContentPane().add(lblNewLabel_6_1_1_2_1_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("More -");
		lblNewLabel_7_2.setForeground(Color.WHITE);
		lblNewLabel_7_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 16));
		lblNewLabel_7_2.setBounds(843, 689, 61, 19);
		Home.getContentPane().add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(DashBoard.class.getResource("/com/vcs/images/h1.jpg")));
		lblNewLabel_8.setBounds(0, 679, 1000, 60);
		Home.getContentPane().add(lblNewLabel_8);
		
		JLabel bg = new JLabel();
		bg.setBackground(Color.WHITE);
		bg.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Pictures\\coronavirus-safety-tw.jpg"));
		bg.setBounds(0, 166, 1000, 550);
		Home.getContentPane().add(bg);
		
		JLabel mvd = new JLabel("");
		mvd.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Pictures\\mvdl6.png"));
		mvd.setBounds(193, 0, 166, 118);
		Home.getContentPane().add(mvd);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DashBoard.class.getResource("/images/photo-1621947081720-86970823b77a.jpg")));
		lblNewLabel.setBounds(0, 0, 1000, 121);
		Home.getContentPane().add(lblNewLabel);
		
		new DashBoard(a);
		
		menuBar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				a = 1;
				board.setVisible(false);
				new DashBoard(a);
				name.setText((String) al.get(1));
			}
			
		});
		
		board.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a = 1;
				board.setVisible(true);
				new DashBoard(a);
				
			}
			
		});
		
		
		
	}
	@Override
	public void run()
	{
		if(a ==1)
		{
		try {
			if(!board.isVisible())
			{
			board.setVisible(true);
			
				for(int x=-200;x<=0;x++)
				{
					board.setBounds(x,37,200,641);
					Thread.sleep(1);
				}
			}
			else
			{
			
				for(int x=0;x>=-200;x--)
				{
					board.setBounds(x,37,200,641);
					Thread.sleep(1);
					
				}
				board.setVisible(false);
			}
		}
		catch (InterruptedException ep) {
			// TODO Auto-generated catch block
			ep.printStackTrace();
		}
		}
		else
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
	
}
