package com.vms.services;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

import com.vms.dao.AccessToDB;

import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.SystemColor;

public class ViewAppointment implements Runnable {

	private JFrame frame;
	private static ViewAppointment window;
	private static JPanel board;
	private static ArrayList al;
	/**
	 * Launch the application.
	 */
	public void build(ArrayList a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ViewAppointment();
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
	public ViewAppointment() {
		
		initialize();
	}
	/*public ViewAppointment(String s) {
		
		Thread t = new Thread(this);
		t.start();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel h2 = new JLabel("MAHA VACCINATION DRIVE");
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setForeground(Color.WHITE);
		h2.setFont(new Font("Dialog", Font.BOLD, 34));
		h2.setAlignmentY(0.0f);
		h2.setBounds(289, 37, 523, 50);
		frame.getContentPane().add(h2);
		
		JLabel mvd = new JLabel("");
		mvd.setIcon(new ImageIcon(ViewAppointment.class.getResource("/images/mvdl6.png")));
		mvd.setBounds(193, 0, 166, 118);
		frame.getContentPane().add(mvd);
		
		JLabel lbl_exit = new JLabel("X");
		lbl_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lbl_exit.setForeground(Color.RED);
		lbl_exit.setFont(new Font("HP Simplified Hans", Font.PLAIN, 24));
		lbl_exit.setBounds(970, 10, 61, 29);
		frame.getContentPane().add(lbl_exit);
		
		board = new JPanel();
		board.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ViewAppointment(null);
			}
		});
		board.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 0, 204), new Color(51, 0, 255), new Color(51, 0, 255), new Color(51, 0, 255)));
		board.setBackground(new Color(255, 255, 255));
		board.setVisible(false);
		board.setBounds(0, 37, -200, 641);
		
		frame.getContentPane().add(board);
		board.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(204, 0, 204), new Color(204, 0, 204), new Color(204, 0, 204), new Color(204, 0, 204)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 200, 85);
		board.add(panel_1);
		
		JLabel name_1 = new JLabel("Unknown");
		name_1.setHorizontalAlignment(SwingConstants.LEFT);
		name_1.setForeground(new Color(0, 153, 255));
		name_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		name_1.setBounds(61, 24, 129, 38);
		panel_1.add(name_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(RegisterToVaccination.class.getResource("/com/vcs/images/user-286-256 (1).png")));
		lblNewLabel_4.setBounds(10, 20, 50, 50);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon(RegisterToVaccination.class.getResource("/images/photo-1621947081720-86970823b77a.jpg")));
		lblNewLabel_2_3.setBounds(2, 2, 196, 81);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_11 = new JLabel("View Appointment");
		lblNewLabel_11.setBounds(58, 170, 120, 50);
		lblNewLabel_11.setForeground(new Color(0, 153, 255));
		lblNewLabel_11.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		board.add(lblNewLabel_11);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterToVaccination rg = new RegisterToVaccination();
				AccessToDB a = new AccessToDB();
				try {
					if(!a.isRegistered((String)al.get(2)))
					{
						window.frame.dispose();
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
						window.frame.dispose();
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
				window.frame.dispose();
				LoginPage lp = new LoginPage();
				lp.main(null);
			}
		});
		lblNewLabel_1_2.setForeground(new Color(0, 153, 255));
		lblNewLabel_1_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(77, 605, 59, 25);
		board.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("");
		lblNewLabel_6_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				window.frame.dispose();
				LoginPage lp = new LoginPage();
				lp.main(null);
			}
		});
		lblNewLabel_6_1_1_1.setIcon(new ImageIcon(RegisterToVaccination.class.getResource("/images/transparent-login-icon-logout-ic.png")));
		lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_6_1_1_1.setBounds(10, 605, 25, 25);
		board.add(lblNewLabel_6_1_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204)));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(0, 81, 200, 78);
		board.add(panel_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 102, 255));
		separator.setBounds(10, 592, 180, 2);
		board.add(separator);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setBounds(10, 20, 50, 50);
		panel_1_1.add(lblNewLabel_4_2);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204)));
		panel_1_1_1.setBackground(SystemColor.menu);
		panel_1_1_1.setBounds(0, 157, 200, 78);
		board.add(panel_1_1_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("");
		lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_1.setBounds(10, 17, 50, 50);
		panel_1_1_1.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBounds(10, 11, 50, 50);
		panel_1_1_1.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setIcon(new ImageIcon(DashBoard.class.getResource("/images/istockphoto-1257955384-170667a-r.png")));
		
		JLabel menuBar = new JLabel("");
		menuBar.setIcon(new ImageIcon(ViewAppointment.class.getResource("/images/menu bar.png")));
		menuBar.setBounds(42, 37, 50, 50);
		frame.getContentPane().add(menuBar);
		
		JLabel lblNewLabel_1 = new JLabel("Appointment Details :");
		lblNewLabel_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_1.setFont(new Font("Script MT Bold", Font.BOLD, 30));
		lblNewLabel_1.setBounds(73, 137, 293, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(204, 0, 204), new Color(204, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204)));
		panel.setBounds(452, 204, 504, 500);
		panel.setOpaque(false);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("Vaccine                :");
		lblNewLabel_2_1_2_1_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_2_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1_2_1_1.setBounds(46, 100, 142, 35);
		panel.add(lblNewLabel_2_1_2_1_1);
		
		JLabel lblNewLabel_2_1_2_1_2 = new JLabel("Date                       :");
		lblNewLabel_2_1_2_1_2.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_2_1_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1_2_1_2.setBounds(46, 150, 142, 35);
		panel.add(lblNewLabel_2_1_2_1_2);
		
		JLabel lblNewLabel_2_1_2_1_2_1 = new JLabel("City                        :");
		lblNewLabel_2_1_2_1_2_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_2_1_2_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1_2_1_2_1.setBounds(46, 300, 142, 35);
		panel.add(lblNewLabel_2_1_2_1_2_1);
		
		JLabel lblNewLabel_2_1_2_1_2_2 = new JLabel("Center                   :");
		lblNewLabel_2_1_2_1_2_2.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_2_1_2_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1_2_1_2_2.setBounds(46, 250, 142, 35);
		panel.add(lblNewLabel_2_1_2_1_2_2);
		
		JLabel vaccineType = new JLabel("Unknown");
		vaccineType.setForeground(Color.BLACK);
		vaccineType.setFont(new Font("HP Simplified Hans", Font.PLAIN, 15));
		vaccineType.setBounds(198, 101, 215, 35);
		panel.add(vaccineType);
		
		JLabel date = new JLabel("Unknown");
		date.setForeground(Color.BLACK);
		date.setFont(new Font("HP Simplified Hans", Font.PLAIN, 15));
		date.setBounds(198, 151, 215, 35);
		panel.add(date);
		
		JLabel city = new JLabel("Unknown");
		city.setForeground(Color.BLACK);
		city.setFont(new Font("HP Simplified Hans", Font.PLAIN, 15));
		city.setBounds(198, 300, 215, 35);
		panel.add(city);
		
		JLabel center = new JLabel("Unknown");
		center.setForeground(Color.BLACK);
		center.setFont(new Font("HP Simplified Hans", Font.PLAIN, 15));
		center.setBounds(198, 250, 215, 35);
		panel.add(center);
		
		JLabel appointmentId = new JLabel("Unknown");
		appointmentId.setForeground(Color.BLACK);
		appointmentId.setFont(new Font("HP Simplified Hans", Font.PLAIN, 15));
		appointmentId.setBounds(198, 50, 215, 35);
		panel.add(appointmentId);
		
		JLabel time = new JLabel("Unknown");
		time.setForeground(Color.BLACK);
		time.setFont(new Font("HP Simplified Hans", Font.PLAIN, 15));
		time.setBounds(198, 200, 215, 35);
		panel.add(time);
		
		JButton btnNewButton = new JButton("Get Details");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				vaccineType.setText((String) al.get(4));
				date.setText((String) al.get(5));
				city.setText((String) al.get(6));
				center.setText((String) al.get(7));
				appointmentId.setText("MVD"+(String) al.get(8));
				time.setText("11am - 5pm");
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("HP Simplified Hans", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(204, 0, 204));
		btnNewButton.setBounds(185, 400, 135, 31);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2_1_2_1_2_3 = new JLabel("Appointment Id  :");
		lblNewLabel_2_1_2_1_2_3.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_2_1_2_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1_2_1_2_3.setBounds(46, 50, 130, 35);
		panel.add(lblNewLabel_2_1_2_1_2_3);
		
		JLabel lblNewLabel_2_1_2_1_2_1_1 = new JLabel("Time                      :");
		lblNewLabel_2_1_2_1_2_1_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_2_1_2_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1_2_1_2_1_1.setBounds(46, 200, 142, 35);
		panel.add(lblNewLabel_2_1_2_1_2_1_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(ViewAppointment.class.getResource("/images/Remove_Background_from_Image___remove.bg_-_Brave_17-08-2022_07_52_25-removebg-preview.png")));
		lblNewLabel_2.setBounds(21, 204, 400, 500);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(204, 0, 204));
		separator_3.setBounds(73, 178, 337, 2);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setForeground(new Color(204, 0, 204));
		separator_3_1.setBounds(63, 184, 347, 2);
		frame.getContentPane().add(separator_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ViewAppointment.class.getResource("/images/6390069-removebg-preview (1).png")));
		lblNewLabel_3.setBounds(21, 137, 50, 50);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(ViewAppointment.class.getResource("/images/download (1).jpg")));
		lblNewLabel_5.setBounds(0, 121, 1000, 618);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewAppointment.class.getResource("/images/photo-1621947081720-86970823b77a.jpg")));
		lblNewLabel.setBounds(0, 0, 1000, 121);
		frame.getContentPane().add(lblNewLabel);
		
		menuBar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				
				board.setVisible(false);
				new ViewAppointment(null);
				name_1.setText((String) al.get(1));
			}
			
		});
		
	}
	@Override
	public void run()
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
			}
		}
		catch (InterruptedException ep) {
			// TODO Auto-generated catch block
			ep.printStackTrace();
		}
	}
}
