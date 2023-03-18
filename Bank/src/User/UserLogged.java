package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.SwingConstants;

import DataBase.UserDB;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class UserLogged {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogged window = new UserLogged();
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
	String name, balance;
	public UserLogged() {
		initialize();
		LinkedList<String> details = UserDB.getDetails();
		name = details.get(0);
		balance = details.get(1);
		System.out.println(name);
		System.out.println(balance);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Verdana", Font.BOLD, 12));
		
		JLabel lblName = new JLabel("New label");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setForeground(new Color(255, 0, 0));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
//		
		
		JLabel lblBalance = new JLabel("BALANCE");
		lblBalance.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JLabel lblBalanceNumber = new JLabel("");
		lblBalanceNumber.setFont(new Font("Verdana", Font.PLAIN, 12));
//		lblBalance.setText(balance);
		
		JButton btnNewButton = new JButton("DEPOSITE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setText(name);
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JButton btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.setFont(new Font("Verdana", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(138)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(115)
								.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(83)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnNewButton))
								.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnWithdraw)
									.addComponent(lblBalanceNumber, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblWelcome)
					.addGap(10)
					.addComponent(lblName)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBalanceNumber, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnWithdraw, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				lblName.setText(name);
				lblBalanceNumber.setText(balance);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
//		lblName.setText(name);
	}
}