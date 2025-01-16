package com.vms.services;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JYearChooser;
import com.vms.dao.AccessToDB;
import com.vms.utility.EmailNotification;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class RegisterToVaccination implements Runnable {

	private JFrame frame;
	private JTextField name;
	private JTextField addharNo;
	private JTextField mobileNo;
	private static JPanel board;
	private ArrayList<String> al;
	private static JLabel h2;
	private static ArrayList ad;
	private static ArrayList temp;
	private static RegisterToVaccination window;
	private static String name_s,mobile,gmail;
	private static int a = 0;
	/**
	 * Launch the application.
	 */
	public void build(ArrayList a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new RegisterToVaccination();
					window.frame.setUndecorated(true);
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
					ad = new ArrayList(a);
					name_s = (String) ad.get(1);
					mobile = (String) ad.get(2);
					System.out.print(name_s);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterToVaccination() {
		initialize();
	}
	/*public RegisterToVaccination(String s) {
		Thread t = new Thread(this);
		t.start();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		a = 0;
		frame = new JFrame();
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		frame.setBounds(100, 100 ,1000, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel mvd = new JLabel("");
		mvd.setBounds(193, 0, 166, 118);
		mvd.setIcon(new ImageIcon(RegisterToVaccination.class.getResource("/images/mvdl6.png")));
		frame.getContentPane().add(mvd);
		
		h2 = new JLabel("MAHA VACCINATION DRIVE");
		h2.setBounds(289, 37, 523, 50);
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setHorizontalAlignment(SwingConstants.CENTER);
		h2.setForeground(Color.WHITE);
		h2.setFont(new Font("Dialog", Font.BOLD, 34));
		h2.setAlignmentY(0.0f);
		frame.getContentPane().add(h2);
		
		
		
		JLabel lbl_exit = new JLabel("X");
		lbl_exit.setBounds(970, 10, 61, 29);
		lbl_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lbl_exit.setForeground(Color.RED);
		lbl_exit.setFont(new Font("HP Simplified Hans", Font.PLAIN, 24));
		frame.getContentPane().add(lbl_exit);
		
		board = new JPanel();
		board.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new RegisterToVaccination(null);
			}
		});
		board.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 0, 204), new Color(51, 0, 255), new Color(51, 0, 255), new Color(51, 0, 255)));
		board.setBackground(Color.WHITE);
		board.setVisible(false);
		board.setBounds(0, 37, 200, 641);
		
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
		
		JLabel menuBar = new JLabel("");
		menuBar.setBounds(42, 37, 50, 50);
		menuBar.setIcon(new ImageIcon(RegisterToVaccination.class.getResource("/images/menu bar.png")));
		frame.getContentPane().add(menuBar);
		
		JLabel lblNewLabel_1 = new JLabel("Book slot for Vaccination :");
		lblNewLabel_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_1.setBounds(73, 137, 368, 50);
		lblNewLabel_1.setFont(new Font("Script MT Bold", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name :");
		lblNewLabel_2_1.setBounds(472, 230, 80, 29);
		lblNewLabel_2_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_2_1);
		
		name = new JTextField();
		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText((String) ad.get(1));
				mobileNo.setText((String) ad.get(2));
			}
		});
		name.setBounds(613, 228, 235, 37);
		name.setOpaque(false);
		name.setBorder(null);
		name.setColumns(10);
		name.setEditable(false);
		frame.getContentPane().add(name);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Addhar Card No. :");
		lblNewLabel_2_1_1_1.setBounds(472, 348, 105, 29);
		lblNewLabel_2_1_1_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_1_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_2_1_1_1);
		
		addharNo = new JTextField();
		addharNo.setBounds(613, 346, 235, 37);
		addharNo.setOpaque(false);
		addharNo.setBorder(null);
		addharNo.setColumns(10);
		frame.getContentPane().add(addharNo);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Mobile No. :");
		lblNewLabel_2_1_1_2.setBounds(472, 290, 105, 29);
		lblNewLabel_2_1_1_2.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_1_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_2_1_1_2);
		
		mobileNo = new JTextField(mobile);
		mobileNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText((String) ad.get(1));
				mobileNo.setText((String) ad.get(2));
			}
		});
		mobileNo.setBounds(613, 288, 235, 37);
		mobileNo.setOpaque(false);
		mobileNo.setBorder(null);
		mobileNo.setColumns(10);
		mobileNo.setEditable(false);
		frame.getContentPane().add(mobileNo);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Select Date & Month :");
		lblNewLabel_2_1_1_1_1.setBounds(472, 470, 129, 29);
		lblNewLabel_2_1_1_1_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_1_1_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_2_1_1_1_1);
		
		JYearChooser year = new JYearChooser();
		year.getSpinner().setBounds(0, 0, 66, 30);
		year.setBounds(780, 469, 66, 30);
		year.setYear(0);
		year.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		year.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		year.setMinimum(2022);
		year.setMaximum(2023);
		year.setValue(0);
		frame.getContentPane().add(year);
		year.setLayout(null);
		
		JYearChooser month = new JYearChooser();
		month.getSpinner().setBounds(0, 0, 66, 30);
		month.setBounds(695, 469, 66, 30);
		month.setYear(0);
		month.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		month.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		month.setMinimum(8);
		month.setMaximum(12);
		month.setValue(0);
		frame.getContentPane().add(month);
		month.setLayout(null);

		JYearChooser day = new JYearChooser();
		day.getSpinner().setBounds(0, 0, 66, 30);
		day.setBounds(613, 469, 66, 30);
		day.setValue(1);
		day.setYear(0);
		day.setOpaque(false);
		day.getSpinner().setForeground(new Color(0, 0, 0));
		day.setBorder(new LineBorder(new Color(0, 51, 102), 2, true));
		day.setMaximum(31);
		day.setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		day.getSpinner().setFont(new Font("Euclid Circular A", Font.PLAIN, 14));
		frame.getContentPane().add(day);
		day.setLayout(null);
		
		JComboBox<String> city = new JComboBox<String>();
		city.setBackground(Color.WHITE);
		city.setFont(new Font("HP Simplified Hans", Font.PLAIN, 13));
		city.setForeground(Color.BLACK);
		city.setOpaque(false);
		city.setBorder(null);
		city.setBounds(613, 528, 235, 37);
		frame.getContentPane().add(city);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Select City  :");
		lblNewLabel_2_1_1_1_1_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_1.setBounds(472, 532, 129, 29);
		frame.getContentPane().add(lblNewLabel_2_1_1_1_1_1);
		
		
		city.addItem("Choose your City");
		city.addItem("Mumbai");
		city.addItem("Pune");
		city.addItem("Solapur");
		
		JLabel lblNewLabel_2_1_1_1_1_2 = new JLabel("Select Vaccine :");
		lblNewLabel_2_1_1_1_1_2.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_1_1_1_2.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_2.setBounds(472, 409, 129, 29);
		frame.getContentPane().add(lblNewLabel_2_1_1_1_1_2);
		
		JRadioButton covishield = new JRadioButton("Covishield");
		covishield.setFont(new Font("HP Simplified Hans", Font.PLAIN, 13));
		covishield.setOpaque(false);
		covishield.setBounds(613, 406, 109, 37);
		frame.getContentPane().add(covishield);
		
		JRadioButton covaxin = new JRadioButton("Covaxin");
		covaxin.setFont(new Font("HP Simplified Hans", Font.PLAIN, 13));
		covaxin.setOpaque(false);
		covaxin.setBounds(739, 406, 109, 37);
		frame.getContentPane().add(covaxin);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Select Center  :");
		lblNewLabel_2_1_1_1_1_1_1.setForeground(new Color(204, 0, 204));
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(472, 592, 129, 29);
		frame.getContentPane().add(lblNewLabel_2_1_1_1_1_1_1);
		
		JComboBox<String> center = new JComboBox<String>();
		center.setForeground(Color.BLACK);
		center.setFont(new Font("HP Simplified Hans", Font.PLAIN, 13));
		center.setBackground(Color.WHITE);
		center.setOpaque(false);
		center.setBorder(null);
		center.setBounds(613, 588, 235, 37);
		frame.getContentPane().add(center);
		
		JButton btnNewButton = new JButton("Book Slot");
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("HP Simplified Hans", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(204, 0, 204));
		btnNewButton.setBounds(664, 658, 135, 31);
		frame.getContentPane().add(btnNewButton);
		
		center.addItem("Choose your Center");
		center.addItem("Government Hospital");
		center.addItem("Private Hospital");
		
		JLabel enterfullname = new JLabel("* Enter full name");
		enterfullname.setForeground(Color.RED);
		enterfullname.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		enterfullname.setVisible(false);
		enterfullname.setBounds(741, 218, 102, 20);
		frame.getContentPane().add(enterfullname);
		
		JLabel invalidMobileNo = new JLabel("* Invalid Mobile no.");
		invalidMobileNo.setForeground(Color.RED);
		invalidMobileNo.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		invalidMobileNo.setVisible(false);
		invalidMobileNo.setBounds(741, 276, 102, 20);
		frame.getContentPane().add(invalidMobileNo);
		
		JLabel enteraddharno = new JLabel("* Enter 12 digit Addhar no.");
		enteraddharno.setForeground(Color.RED);
		enteraddharno.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		enteraddharno.setVisible(false);
		enteraddharno.setBounds(741, 336, 150, 20);
		frame.getContentPane().add(enteraddharno);
		
		JLabel nameRequired = new JLabel("* Required");
		nameRequired.setForeground(Color.RED);
		nameRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		nameRequired.setVisible(false);
		nameRequired.setBounds(852, 235, 102, 20);
		frame.getContentPane().add(nameRequired);
		
		JLabel mobileNoRequired = new JLabel("* Required");
		mobileNoRequired.setForeground(Color.RED);
		mobileNoRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		mobileNoRequired.setVisible(false);
		mobileNoRequired.setBounds(852, 295, 102, 20);
		frame.getContentPane().add(mobileNoRequired);
		
		JLabel addharRequired = new JLabel("* Required");
		addharRequired.setForeground(Color.RED);
		addharRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		addharRequired.setVisible(false);
		addharRequired.setBounds(852, 353, 102, 20);
		frame.getContentPane().add(addharRequired);
		
		JLabel vaccineRequired = new JLabel("* Required");
		vaccineRequired.setForeground(Color.RED);
		vaccineRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		vaccineRequired.setVisible(false);
		vaccineRequired.setBounds(852, 414, 102, 20);
		frame.getContentPane().add(vaccineRequired);
		
		JLabel cityRequired = new JLabel("* Required");
		cityRequired.setForeground(Color.RED);
		cityRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		cityRequired.setVisible(false);
		cityRequired.setBounds(852, 536, 102, 20);
		frame.getContentPane().add(cityRequired);
		
		
		
		JLabel centerRequired = new JLabel("* Required");
		centerRequired.setForeground(Color.RED);
		centerRequired.setFont(new Font("HP Simplified Hans", Font.PLAIN, 12));
		centerRequired.setVisible(false);
		centerRequired.setBounds(852, 597, 102, 20);
		frame.getContentPane().add(centerRequired);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(204, 0, 204));
		separator.setBounds(613, 263, 235, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(204, 0, 204));
		separator_1.setBounds(613, 322, 235, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(204, 0, 204));
		separator_2.setBounds(613, 381, 235, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(RegisterToVaccination.class.getResource("/images/E3oaRhmWQAIHw1l.jpg")));
		lblNewLabel_2.setBounds(21, 204, 400, 500);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(204, 0, 204), new Color(204, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204)));
		panel.setBounds(452, 204, 504, 500);
		panel.setOpaque(false);
		frame.getContentPane().add(panel);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(204, 0, 204));
		separator_3.setBounds(73, 178, 365, 2);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setForeground(new Color(204, 0, 204));
		separator_3_1.setBounds(63, 184, 375, 2);
		frame.getContentPane().add(separator_3_1);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegisterToVaccination.class.getResource("/images/photo-1621947081720-86970823b77a.jpg")));
		lblNewLabel.setBounds(0, 0, 1000, 121);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_11 = new JLabel("View Appointment");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewAppointment vp = new ViewAppointment();
				AccessToDB a = new AccessToDB();
				
				try {
					
					ad = a.getAppointmentDetails((String) ad.get(2));
					System.out.println(ad);
					if(!(Boolean)ad.get(0))
					{
						JOptionPane.showMessageDialog(null, "First book appointment");
					}
					else
					{
						window.frame.dispose();
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
		lblNewLabel_11.setBounds(58, 170, 120, 50);
		lblNewLabel_11.setForeground(new Color(0, 153, 255));
		lblNewLabel_11.setFont(new Font("HP Simplified Hans", Font.PLAIN, 14));
		board.add(lblNewLabel_11);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setIcon(new ImageIcon("C:\\Users\\Prathamesh\\Downloads\\appointment-icon-png-27 (1).png"));
		lblNewLabel_4_1_1.setBounds(10, 96, 50, 50);
		board.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book Appointment");
		
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
		lblNewLabel_1_2.setBounds(72, 605, 59, 25);
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
		panel_1_1.setBounds(0, 157, 200, 78);
		board.add(panel_1_1);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(new Color(0, 102, 255));
		separator1.setBounds(10, 592, 180, 2);
		board.add(separator1);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setBounds(10, 20, 50, 50);
		panel_1_1.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBounds(10, 11, 50, 50);
		panel_1_1.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setIcon(new ImageIcon(DashBoard.class.getResource("/images/istockphoto-1257955384-170667a-r.png")));
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204), new Color(51, 0, 204)));
		panel_1_1_1.setBackground(SystemColor.menu);
		panel_1_1_1.setBounds(0, 81, 200, 78);
		board.add(panel_1_1_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("");
		lblNewLabel_4_2_1.setBounds(10, 20, 50, 50);
		panel_1_1_1.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("");
		lblNewLabel_4_1_2.setBounds(10, 11, 50, 50);
		panel_1_1_1.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(RegisterToVaccination.class.getResource("/images/6390069-removebg-preview (1).png")));
		lblNewLabel_3_1.setBounds(21, 137, 50, 50);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		lblNewLabel_3.setIcon(new ImageIcon(RegisterToVaccination.class.getResource("/images/download (1).jpg")));
		lblNewLabel_3.setBounds(0, 121, 1000, 618);
		frame.getContentPane().add(lblNewLabel_3);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				al = new ArrayList<String>();
				boolean b1;
				boolean b2;
				b2 = true;
				b1 = Pattern.compile("([A-za-z]{1,30})[ ]([A-za-z]{1,30})").matcher(name.getText()).matches();
				if(name.getText().trim().isEmpty()==true)
				{
					nameRequired.setVisible(true);
					enterfullname.setVisible(false);
					b2 = false;
				}
				else if(b1==false)
				{
					enterfullname.setVisible(true);
					nameRequired.setVisible(false);
					b2 = false;
				}
				else
				{
					nameRequired.setVisible(false);
					enterfullname.setVisible(false);
					al.add(name.getText());
				}
				b1 = Pattern.compile("^[6-9]{1}[0-9]{9}$").matcher(mobileNo.getText()).matches(); 
				if(mobileNo.getText().trim().isBlank()==true)
				{
					mobileNoRequired.setVisible(true);
					invalidMobileNo.setVisible(false);
					b2 = false;
				}
				else if(b1==false)
				{
					invalidMobileNo.setVisible(true);
					mobileNoRequired.setVisible(false);
					b2 = false;
				}
				else
				{
					mobileNoRequired.setVisible(false);
					invalidMobileNo.setVisible(false);
					al.add(mobileNo.getText());
				}
				b1 = Pattern.compile("^[0-9]{12}$").matcher(addharNo.getText()).matches(); 
				if(addharNo.getText().trim().isEmpty()==true)
				{
					addharRequired.setVisible(true);
					enteraddharno.setVisible(false);
					b2 = false;
				}
				else if(b1==false)
				{
					enteraddharno.setVisible(true);
					addharRequired.setVisible(false);
					b2 = false;
				}
				else
				{
					enteraddharno.setVisible(false);
					addharRequired.setVisible(false);
					al.add(addharNo.getText());
				}
				
				if(covishield.isSelected()==false&&covaxin.isSelected()==false)
				{
					vaccineRequired.setVisible(true);
					b2 = false;
				}
				else if(covishield.isSelected()==true)
				{
					vaccineRequired.setVisible(false);
					al.add("Covishield");
				}
				else if(covaxin.isSelected()==true)
				{
					vaccineRequired.setVisible(false);
					al.add("Covaxin");
				}
				String date = String.format("%04d",year.getValue())+"-"+String.format("%02d", month.getValue())+ "-"+ String.format("%02d", day.getValue());
				al.add(date);
				if(city.getSelectedIndex()==0||city.getSelectedIndex()==-1)
				{
					cityRequired.setVisible(true);
					b2 = false;
				}
				else if(city.getSelectedIndex()==1)
				{
					cityRequired.setVisible(false);
					al.add("Mumbai");
				}
				else if(city.getSelectedIndex()==2)
				{
					cityRequired.setVisible(false);
					al.add("Pune");
				}	
				else if(city.getSelectedIndex()==3)
				{
					cityRequired.setVisible(false);
					al.add("Solapur");
				}
				if(center.getSelectedIndex()==0||center.getSelectedIndex()==-1)
				{
					centerRequired.setVisible(true);
					b2 = false;
				}
				else if(center.getSelectedIndex()==1)
				{
					centerRequired.setVisible(false);
					al.add("Government Hospital");
				}
				else if(center.getSelectedIndex()==2)
				{
					centerRequired.setVisible(false);
					al.add("Private Hospital");
				}
				
				if(b2)
				{
					AccessToDB in = new AccessToDB();
					try {
						Boolean b = null;
						EmailNotification em = new EmailNotification();
						b = in.checkVaccineAvailability(al);
						if(b == false)
						{
							
							JOptionPane.showMessageDialog(null,"Stock is not available");
						}
						else
						{
							gmail = (String)ad.get(3);
							in.bookAppointment(al);
							al = in.getAppointmentDetails((String)ad.get(2));
							em.sendAppointmentBookedMail(gmail,al);
							
							JOptionPane.showMessageDialog(null, "Appointment Booked successfully!!!");
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		menuBar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				a = 1;
				board.setVisible(false);
				new RegisterToVaccination(null);
				name_1.setText((String) ad.get(1));
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
