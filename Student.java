package StudentManagementSystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JDesktopPane;

public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField sname;
	private JTextField sentry;
	private JTextField semail;
	private JTextField scontact;
	private JTextField shome;

	Connection con = null;
	PreparedStatement pst = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240)); // Light blue background
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel studentDetails = new JLabel("Student Details");
		studentDetails.setForeground(Color.BLACK);
		studentDetails.setFont(new Font("Comic Sans MS", Font.BOLD, 22));

		JLabel studentName = new JLabel("Student Name");
		studentName.setForeground(Color.BLACK);
		studentName.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

		JLabel entryNumber = new JLabel("Entry Number");
		entryNumber.setForeground(Color.BLACK);
		entryNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

		JLabel emailAddress = new JLabel("Email Address");
		emailAddress.setForeground(Color.BLACK);
		emailAddress.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

		JLabel contactNumber = new JLabel("Contact Number");
		contactNumber.setForeground(Color.BLACK);
		contactNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

		sname = new JTextField();
		sname.setColumns(10);

		sentry = new JTextField();
		sentry.setColumns(10);

		semail = new JTextField();
		semail.setColumns(10);

		scontact = new JTextField();
		scontact.setColumns(10);

		JLabel homeCity = new JLabel("Home City");
		homeCity.setForeground(Color.BLACK);
		homeCity.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

		JButton submit = new JButton("Submit");
		submit.setForeground(Color.WHITE);
		submit.setBackground(new Color(0, 0, 128)); // Blue button
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "INSERT INTO `student`(`name`, `entrynumber`, `email`, `contact_num`, `home_city`) VALUES (?, ?, ?, ?, ?)";
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "sawai");
					pst=con.prepareStatement(query);
					pst.setString(1, sname.getText());
					pst.setString(2, sentry.getText());
					pst.setString(3, semail.getText());
					pst.setString(4, scontact.getText());
					pst.setString(5, shome.getText());
					if(sname.getText().equals("") || sentry.getText().equals("") || semail.getText().equals("") || scontact.getText().equals("") || shome.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Fill all the details :(");
					} else {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Student added Successfully :)");
						dispose();
						Menu menu = new Menu();
						menu.show();
					}
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		submit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

		shome = new JTextField();
		shome.setColumns(10);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 128)); // Red button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(43)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(entryNumber)
														.addComponent(studentName, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
														.addComponent(emailAddress)
														.addComponent(contactNumber)
														.addComponent(homeCity))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(scontact, 242, 242, 242)
														.addComponent(shome, 247, 247, 247)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
																.addComponent(semail)
																.addComponent(sname)
																.addComponent(sentry, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
												.addGap(34))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(studentDetails)
												.addGap(137))))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(submit, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(studentDetails)
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(studentName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addComponent(sname, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
								.addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(sentry, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addComponent(entryNumber))
								.addGap(41)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(semail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
										.addComponent(emailAddress))
								.addGap(37)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(contactNumber)
										.addComponent(scontact, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addGap(41)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(shome, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addComponent(homeCity))
								.addGap(43)
								.addComponent(submit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(38, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
