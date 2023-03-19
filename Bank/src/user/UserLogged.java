package user;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import DataBase.UserDB;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class UserLogged {

	public JFrame frame;

	/**
	 * Launch the application.
	 * 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogged window = new UserLogged(null);
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
	private JFrame lFrame;
	public UserLogged(JFrame lFrame) {
		this.lFrame = lFrame;
		initialize();
		LinkedList<String> details = new UserDB().getDetails();
		name = details.get(0);
		balance = details.get(1);
		System.out.println(name);
		System.out.println(balance);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame();
		frame.setBounds(((int)screenSize.getWidth()-450)/2, ((int)screenSize.getHeight()-300)/2, 450, 300);
		frame = new JFrame();
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
				double deposite = Double.parseDouble(JOptionPane.showInputDialog(frame, "How much..?"));
				if (deposite > 0) {
					double total = deposite + Double.parseDouble(balance);
					UserDB.deposit(total);
					balance = new UserDB().getDetails().get(1);
					if (balance != null) {
						JOptionPane.showMessageDialog(frame, "Deposite successful..");
						lblBalanceNumber.setText(balance);
					} else {
						JOptionPane.showMessageDialog(frame, "Internal connection error...");
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Amount can't be negative..");
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JButton btnWithdraw = new JButton("WITHDRAW");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double withdraw = Double.parseDouble(JOptionPane.showInputDialog(frame, "How much..?"));
				Double balance = Double.parseDouble(new UserDB().getDetails().get(1));
				if (withdraw <= balance) {
					if (withdraw % 100 == 0 || withdraw % 500.0 == 0) {
						balance -= withdraw;
						UserDB.deposit(balance);
						lblBalanceNumber.setText(balance.toString());
						int count500 = (int)withdraw / 500, count100 = (int)(withdraw % 500 / 100);
						JOptionPane.showMessageDialog(frame, "Withdraw successful..\nCollect your cash\n500's : "
								+ count500 +"\n100's : " + count100);	
					} else {
						JOptionPane.showMessageDialog(frame, "Amount should be multiple of 100, 500");
					}
				} else if (withdraw < 0){
					JOptionPane.showMessageDialog(frame, "Amount can't be negative..");
				} else {
					JOptionPane.showMessageDialog(frame, "Insufficient funds....");
				}
			}
		});
		btnWithdraw.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBorder(new RoundedBorder(5));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(frame, "Are you sure...?","Logout", JOptionPane.YES_NO_CANCEL_OPTION);
				if (a==0) {
					frame.dispose();
					lFrame.setVisible(true);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(138)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(115)
								.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(83)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnNewButton))
								.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnWithdraw)
									.addComponent(lblBalanceNumber, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(115, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(341, Short.MAX_VALUE)
					.addComponent(btnLogout)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnLogout)
					.addGap(7)
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
	}
}