package Admin;



import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import javax.swing.LayoutStyle.ComponentPlacement;

import DataBase.AdminDB;
import DataBase.UserDB;
import user.UserLogged;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class LoginAdmin {

	public JFrame frame;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin window = new LoginAdmin();
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
	public LoginAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame();
		frame.setBounds(((int)screenSize.getWidth()-400)/2, ((int)screenSize.getHeight()-420)/2, 400, 420);
		frame.setIconImage(new Image() {
			
			@Override
			public int getWidth(ImageObserver observer) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public ImageProducer getSource() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getProperty(String name, ImageObserver observer) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getHeight(ImageObserver observer) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Graphics getGraphics() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 128));
		panel.setBounds(45, 32, 288, 50);
		panel.setOpaque(false);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setForeground(new Color(255, 0, 0));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(loginLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(45, 105, 288, 264);
		panel_1.setOpaque(false);
		frame.getContentPane().add(panel_1);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(new Color(255, 128, 64));
		usernameLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 128, 64));
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JLabel lblType = new JLabel("Type");
		lblType.setForeground(new Color(255, 128, 0));
		lblType.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		
		passwordField = new JPasswordField();
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		
		textField = new JTextField();
		textField.setColumns(10);
		

		panel_2.setLayout(null);
		
		JRadioButton adminRadioButton = new JRadioButton("Admin");
		adminRadioButton.setForeground(new Color(255, 128, 0));
		adminRadioButton.setBounds(0, 5, 68, 21);
		adminRadioButton.setOpaque(false);
		panel_2.add(adminRadioButton);
		buttonGroup.add(adminRadioButton);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		
		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		rdbtnCustomer.setForeground(new Color(255, 128, 0));
		rdbtnCustomer.setBounds(64, 5, 81, 21);
		rdbtnCustomer.setOpaque(false);
		panel_2.add(rdbtnCustomer);
		buttonGroup.add(rdbtnCustomer);
		panel_1.setLayout(gl_panel_1);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText(), password = new String(passwordField.getPassword());
				String type = null;
				if (adminRadioButton.isSelected()) {
					type = "Admin";
				} else if (rdbtnCustomer.isSelected()) {
					type = "Customer";
				}
				if (username == null || password == null || type  == null) {
					JOptionPane.showMessageDialog(frame, "Enter all details...");
				} else if (AdminDB.validCredentials(username, password) && type.equals("Admin")) {
					System.out.println("1");
					frame.dispose();
					new LoginAd().frame.setVisible(true);
					
				} else if (UserDB.validCredentials(username, password) && type.equals("Customer")) {
					new UserLogged(frame).frame.setVisible(true);
					textField.setText("");
					passwordField.setText("");
					buttonGroup.clearSelection();
					frame.dispose();
				} else {
					System.out.println(username);
					System.out.println(password);
					System.out.println(type);
					JOptionPane.showMessageDialog(frame, "Invalid Username or password...");
					textField.setText("");
					passwordField.setText("");
					buttonGroup.clearSelection();
				}
				
			}
		});
		loginBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignup.setFont(new Font("Verdana", Font.BOLD, 12));
		
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(31)
							.addComponent(loginBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(btnSignup, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField)
								.addComponent(passwordField, 143, 143, Short.MAX_VALUE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(17))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(7)))
					.addGap(39)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSignup, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		
	}
}
