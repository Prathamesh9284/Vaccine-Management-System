package com.vms.services;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Font;

public class LoadingPage implements Runnable {

	private  JFrame frame;
	static LoadingPage window;
	JProgressBar progressBar;
	private JLabel load;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new LoadingPage();
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
	 * @throws InterruptedException 
	 */
	public LoadingPage() throws InterruptedException {
		initialize();
		Thread t = new Thread(this);
		t.start();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 */
	private void initialize() throws InterruptedException {
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 608, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 608, 454);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(new Color(0, 0, 204));
		progressBar.setBounds(41, 438, 525, 5);
		panel.add(progressBar);
		
		load = new JLabel("New label");
		load.setFont(new Font("HP Simplified Hans", Font.BOLD, 14));
		load.setForeground(new Color(51, 0, 204));
		load.setBounds(483, 405, 98, 38);
		load.setVisible(false);
		panel.add(load);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoadingPage.class.getResource("/images/mvdlb-removebg-preview.png")));
		lblNewLabel.setBounds(21, 0, 608, 454);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoadingPage.class.getResource("/images/photo-1621947081720-86970823b77a.jpg")));
		lblNewLabel_1.setBounds(0, 0, 608, 454);
		panel.add(lblNewLabel_1);
		ImageIcon i = new ImageIcon(this.getClass().getResource("/images/yeet-loading.gif"));
		
		
	}
	String loading;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	@Override
	public void run()
	{
		for(int x = 0;x<=100;x++)
		{
			try {
				loading = "Loading "+x+"%";
				load.setText(loading);
				Thread.sleep(20);
				if(x==100)
				{
					Thread.sleep(1000);
					window.frame.dispose();
					SignUpPage s = new SignUpPage();
					s.main(null);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progressBar.setValue(x);
		}
	}
}
