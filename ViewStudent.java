package StudentManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStudent extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudent frame = new ViewStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		class DatabaseHandler {
			// JDBC URL, username, and password of MySQL server
			private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mysql";
			private static final String USERNAME = "root";
			private static final String PASSWORD = "sawai";

			public static void main(String[] args) {
				// Example usage: Retrieve and print all records from the student table
				retrieveDataFromStudentTable();
			}

			public static void retrieveDataFromStudentTable() {
				try {
					// Establishing a connection to the database
					Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

					// Creating a statement
					Statement statement = connection.createStatement();

					// Defining the SQL query to retrieve data from the student table
					String sqlQuery = "SELECT * FROM student";

					// Executing the query
					ResultSet resultSet = statement.executeQuery(sqlQuery);

					// Processing the result set
					while (resultSet.next()) {
						// Retrieving data from each row
						String name = resultSet.getString("name");
						String entryNumber = resultSet.getString("entrynumber");
						String email = resultSet.getString("email");
						String contactNum = resultSet.getString("contact_num");
						String homeCity = resultSet.getString("home_city");

						// Printing the retrieved data (you can modify this part as needed)
						System.out.println("Name: " + name);
						System.out.println("Entry Number: " + entryNumber);
						System.out.println("Email: " + email);
						System.out.println("Contact Number: " + contactNum);
						System.out.println("Home City: " + homeCity);
						System.out.println("-----------------------------------");
					}

					// Closing resources
					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ViewStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 753, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(423, Short.MAX_VALUE))
		);

		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(255, 27, 225, 52);
		desktopPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 96, 113, 32);
		desktopPane.add(btnNewButton);
		contentPane.setLayout(gl_contentPane);
	}
}
