package StudentManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Menu extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 623);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230)); // Light blue background
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(173, 216, 230));

		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(new Color(240, 240, 240));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(desktopPane_1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(36)
								.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(37, Short.MAX_VALUE))
		);

		// Add Add Student button
		JButton btnNewButton = new JButton("Add Student");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 128)); // Blue button
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student studentDetails = new Student();
				studentDetails.show();
				dispose();
			}
		});
		btnNewButton.setBounds(32, 37, 287, 47);
		desktopPane.add(btnNewButton);

		// Add Remove Student button
		JButton btnNewButton_1 = new JButton("Remove Existing Student");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 0, 128)); // Blue button
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveStudent remove = new RemoveStudent();
				remove.show();
				dispose();
			}
		});
		btnNewButton_1.setBounds(32, 113, 287, 52);
		desktopPane.add(btnNewButton_1);

		// Add Update Existing Student button
		JButton btnNewButton_3 = new JButton("Update Existing Student");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(0, 0, 128)); // Blue button
		btnNewButton_3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudent updateStudent = new UpdateStudent();
				updateStudent.show();
				dispose();
			}
		});
		btnNewButton_3.setBounds(32, 193, 287, 52);
		desktopPane.add(btnNewButton_3);

		// Add Logout button
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(0, 0, 128)); // Blue button
		btnNewButton_4.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login logout = new Login();
				logout.show();
				dispose();
				JOptionPane.showMessageDialog(null, "Successfully logged out :)");
			}
		});
		btnNewButton_4.setBounds(32, 273, 287, 47);
		desktopPane.add(btnNewButton_4);

		// Set background color and font for the welcome label
		JLabel lblNewLabel = new JLabel("      WELCOME");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(93, 17, 220, 27);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		desktopPane_1.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	}
}