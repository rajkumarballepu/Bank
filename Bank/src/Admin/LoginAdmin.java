package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class LoginAdmin {

	private JFrame frame;
	private JPasswordField passwordField;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 445, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(71, 32, 288, 50);
		frame.getContentPane().add(panel);
		
		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(loginLabel, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(loginLabel, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(71, 105, 288, 264);
		frame.getContentPane().add(panel_1);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignup.setFont(new Font("Verdana", Font.BOLD, 12));
		
		JTextArea textArea = new JTextArea();
		
		passwordField = new JPasswordField();
		
		JRadioButton adminRadioButton = new JRadioButton("Admin");
		
		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addGap(31)
							.addComponent(loginBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))))
					.addGap(16)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSignup, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
								.addComponent(textArea, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
							.addGap(20))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(adminRadioButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnCustomer)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(adminRadioButton)
							.addComponent(rdbtnCustomer)))
					.addGap(56)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSignup, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		Button loginButton = new Button("Login");
		loginButton.setBounds(111, 293, 113, 32);
		frame.getContentPane().add(loginButton);
	}
}
