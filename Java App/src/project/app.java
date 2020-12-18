package project;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


/**
 * 
 * @author Lucas Onwuchekwa
 *
 */
public class app {
	
	/**
	 * Dialog box requesting for login credentials
	 * @return String[]
	 */
	public static String[] loginDialog() {
		String result[] = new String[2];
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbUsername = new JLabel("Username: ");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbUsername, cs);

		JTextField tfUsername = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfUsername, cs);

		JLabel lbPassword = new JLabel("Password: ");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbPassword, cs);

		JPasswordField pfPassword = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(pfPassword, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		String[] options = new String[] { "OK", "Cancel" };
		int ioption = JOptionPane.showOptionDialog(null, panel, "Login", JOptionPane.OK_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if (ioption == 0) // pressing OK button
		{
			result[0] = tfUsername.getText();
			result[1] = new String(pfPassword.getPassword());
		}
		return result;
	}
	

	private static void question3(Connection conn, int k, int year) {
		
		//Null check
		if(conn == null) throw new NullPointerException();
		
		try{
			conn.setAutoCommit(false);
			//Create procedure call statement
			String procedStr = "{ call question3(?, ?) }";
			CallableStatement proced = conn.prepareCall(procedStr);
			
			//Holds the result
			ResultSet rs;
			ResultSetMetaData rsMetaData;
			
			//Register and set arguments then execute
			proced.setInt(1, k);
			proced.setInt(2, year);
			rs = proced.executeQuery();
			rsMetaData = rs.getMetaData();
			
			String output = "StateNum | States | Name \n";
			output += "----------------------------------------\n";
			while(rs.next()) {
				for(int i = 0; i < rsMetaData.getColumnCount(); i++) {
					output += rs.getString(i + 1);
					if(i != rsMetaData.getColumnCount() - 1) {output += " | ";}
				}
				output += "\n";
			}
				
			//Display output
			JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.PLAIN_MESSAGE);
			
			//Close and commit
			proced.close();
			conn.commit();
			
			
		}
		catch(SQLException e) {}
	}
	
	private static void question7(Connection conn, int k, String givenHashTag, String givenState, int givenMonth, int givenYear) {
		
		//Null check
		if(conn == null || givenHashTag == null || givenState == null) throw new NullPointerException();
		
		try{
			conn.setAutoCommit(false);
			//Create procedure call statement
			String procedStr = "{ call question7(?, ?, ?, ?, ?) }";
			CallableStatement proced = conn.prepareCall(procedStr);
			
			//Holds the result
			ResultSet rs;
			ResultSetMetaData rsMetaData;
			
			//Register and set arguments then execute
			proced.setInt(1, k);
			proced.setString(2, givenHashTag);
			proced.setString(3, givenState);
			proced.setInt(4, givenMonth);
			proced.setInt(5, givenYear);
			rs = proced.executeQuery();
			rsMetaData = rs.getMetaData();
			
			String output = "Tweet Count | Screen Name | Category \n";
			output += "-----------------------------------------------------\n";
			while(rs.next()) {
				for(int i = 0; i < rsMetaData.getColumnCount(); i++) {
					output += rs.getString(i + 1);
					if(i != rsMetaData.getColumnCount() - 1) {output += " | ";}
				}
				output += "\n";
			}
			
			//Display output
			JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.PLAIN_MESSAGE);
			
			//Close and commit
			proced.close();
			conn.commit();
			
		}
		catch(SQLException e) {}
	}
	
	private static void question9(Connection conn, int k, String givenParty) {
		
		//Null check
		if(conn == null || givenParty == null) throw new NullPointerException();
		
		try{
			conn.setAutoCommit(false);
			//Create procedure call statement
			String procedStr = "{ call question9(?, ?) }";
			CallableStatement proced = conn.prepareCall(procedStr);
			
			//Holds the result
			ResultSet rs;
			ResultSetMetaData rsMetaData;
			
			//Register and set arguments then execute
			proced.setInt(1, k);
			proced.setString(2, givenParty);
			rs = proced.executeQuery();
			rsMetaData = rs.getMetaData();
			
			String output = "Screen Name | Sub Category | Number Of Followers \n";
			output += "----------------------------------------------------------------\n";
			while(rs.next()) {
				for(int i = 0; i < rsMetaData.getColumnCount(); i++) {
					output += rs.getString(i + 1);
					if(i != rsMetaData.getColumnCount() - 1) {output += " | ";}
				}
				output += "\n";
			}
			
			//Display output
			JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.PLAIN_MESSAGE);
			
			//Close and commit
			proced.close();
			conn.commit();
			
		}
		catch(SQLException e) {}
	}
	

	
	private static void question16(Connection conn, int k, int givenMonth, int givenYear) {
		
		//Null check
		if(conn == null) throw new NullPointerException();
		
		try{
			conn.setAutoCommit(false);
			//Create procedure call statement
			String procedStr = "{ call question16(?, ?, ?) }";
			CallableStatement proced = conn.prepareCall(procedStr);
			
			//Holds the result
			ResultSet rs;
			ResultSetMetaData rsMetaData;
			
			//Register and set arguments then execute
			proced.setInt(1, k);
			proced.setInt(2, givenMonth);
			proced.setInt(3, givenYear);
			rs = proced.executeQuery();
			rsMetaData = rs.getMetaData();
			
			String output = "User Name | Category | Tweet | Number Of Retweet | Url \n";
			output += "-----------------------------------------------------------------------\n";
			while(rs.next()) {
				for(int i = 0; i < rsMetaData.getColumnCount(); i++) {
					output += rs.getString(i + 1);
					if(i != rsMetaData.getColumnCount() - 1) {output += " | ";}
				}
				output += "\n";
			}
			
			//Display output
			JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.PLAIN_MESSAGE);
		
			//Close and commit
			proced.close();
			conn.commit();
			
			
		}
		catch(SQLException e) {}
	}
	
	private static void question18(Connection conn, int k, String givenParty,  int givenMonth, int givenYear) {
		
		//Null check
		if(conn == null || givenParty == null) throw new NullPointerException();
		
		try{
			conn.setAutoCommit(false);
			//Create procedure call statement
			String procedStr = "{ call question18(?, ?, ?, ?) }";
			CallableStatement proced = conn.prepareCall(procedStr);
			
			//Holds the result
			ResultSet rs;
			ResultSetMetaData rsMetaData;
			
			//Register and set arguments then execute
			proced.setInt(1, k);
			proced.setString(2, givenParty);
			proced.setInt(3, givenMonth);
			proced.setInt(4, givenYear);
			rs = proced.executeQuery();
			rsMetaData = rs.getMetaData();
			
			String output = "Mentioned User | Mentioned User State | Posting User \n";
			output += "---------------------------------------------------------------------\n";
			while(rs.next()) {
				for(int i = 0; i < rsMetaData.getColumnCount(); i++) {
					output += rs.getString(i + 1);
					if(i != rsMetaData.getColumnCount() - 1) {output += " | ";}
				}
				output += "\n";
			}
			
			//Display output
			JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.PLAIN_MESSAGE);
			
			//Close and commit
			proced.close();
			conn.commit();
			
			
		}
		catch(SQLException e) {}
	}
	
	private static void question23(Connection conn, int k, String givenParty, String givenMonth, int givenYear) {
		
		//Null check
		if(conn == null || givenParty == null || givenMonth == null) throw new NullPointerException();
		
		try{
			conn.setAutoCommit(false);
			//Create procedure call statement
			String procedStr = "{ call question23(?, ?, ?, ?) }";
			CallableStatement proced = conn.prepareCall(procedStr);
			
			//Holds the result
			ResultSet rs;
			ResultSetMetaData rsMetaData;
			
			//Register and set arguments then execute
			proced.setInt(1, k);
			proced.setString(2, givenParty);
			proced.setString(3, givenMonth);
			proced.setInt(4, givenYear);
			rs = proced.executeQuery();
			rsMetaData = rs.getMetaData();
			
			String output = "Name | Number Of Uses \n";
			output += "-------------------------------------\n";
			while(rs.next()) {
				for(int i = 0; i < rsMetaData.getColumnCount(); i++) {
					output += rs.getString(i + 1);
					if(i != rsMetaData.getColumnCount() - 1) {output += " | ";}
				}
				output += "\n";
			}
			
			
			
			//Display output
			JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.PLAIN_MESSAGE);
			
//			System.out.println(output);
			
			
			//Close and commit
			proced.close();
			conn.commit();
			
			
		}
		catch(SQLException e) {}
	}
	

	/**
	 * Used to insert a new actor in the table
	 * @param conn
	 * @param fname
	 */
	private static void insert(Connection conn, String screen_name, String user_name, String party, String category, String state, String numFollowers, String numFollowing){
		
		//Null check
		if(conn == null || screen_name == null) throw new NullPointerException();
		
		int followers = 0;
		int following = 0;
		
		if(!numFollowers.equals("")) {
			followers = Integer.parseInt(numFollowers);
		}
		if(!numFollowing.equals("")) {
			following = Integer.parseInt(numFollowing);
		}
		
		try{
			conn.setAutoCommit(false);
			String prepStr = "insert into users values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement prepSt = conn.prepareStatement(prepStr);
			
			//Clean then set parameters
			prepSt.clearParameters();
			prepSt.setString(1, screen_name);
			prepSt.setString(2, user_name);
			prepSt.setString(3, party);
			prepSt.setString(4, category);
			prepSt.setString(5, state);
			prepSt.setInt(6, followers);
			prepSt.setInt(7, following);
			//Get output from query
			int rowcount = prepSt.executeUpdate();
			
			//Print message
			String output = "Number of rows updated:" + rowcount;
			if(rowcount > 0) {
				output += "\n Successfully inserted "+screen_name;
			}
			else {
				output += "\n Insert Unsuccessful";
			}
			
			
			JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.PLAIN_MESSAGE);
//			System.out.println("Number of rows updated:" + rowcount);
			
			//Close and commit
			prepSt.close();
			conn.commit();
			
		}
		catch (SQLException e) {}
		
	}
	
	/**
	 * Deletes a customer from CUSTOMER relation given a customer_id
	 * @param conn
	 * @param cid
	 */
	private static void delete(Connection conn, String screen_name) {
		//Null check
		if(conn == null || screen_name == null) throw new NullPointerException();
		
		//Confrim deletion
		if(JOptionPane.showInputDialog(null, "All the information related to this user will be deleted\n"
										+ "Enter “y” or “n” ","Warning", JOptionPane.WARNING_MESSAGE).equalsIgnoreCase("n")){
			return;
		}
		
		
		try{
			conn.setAutoCommit(false);
			Statement st = conn.createStatement();
			
			//Create query strings for each table
			String delFromUsers = "delete from users where screen_name = ?";
			
			PreparedStatement usersSt = conn.prepareStatement(delFromUsers);
			usersSt.setString(1, screen_name);
			
			//Execute queries and get rows affected
			int usersRowCount = usersSt.executeUpdate();
			
			//Show output
			String output = "Number of rows updated in USERS table : " + usersRowCount;
			
			if(usersRowCount == 0) {
				output += "\n Could not find user. Delete unsuccessful!";
			}
			
			JOptionPane.showMessageDialog(null, output, "Output", JOptionPane.PLAIN_MESSAGE);
			//Close and commit
			usersSt.close();
			st.close();
			
			conn.commit();
			
		}catch(SQLException e) {}
		
	}
	

	public static void main(String[] args) {
		String dbServer = "jdbc:mysql://localhost:3306/group78?useSSL=false";
		// For compliance with existing applications not using SSL the verifyServerCertificate property is set to ‘false’,
		String userName = "";
		String password = "";

		//Get login credentials
		String result[] = loginDialog();
		userName = result[0];
		password = result[1];
//		userName = "cs363";
//		password = "#project78";

		Connection conn;
		Statement stmt;
		if (result[0]==null || result[1]==null) {
			System.out.println("Terminating: No username or password is given");
			return;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbServer, userName, password);
			stmt = conn.createStatement();

			String option = "";
			String instruction = 
					  "Enter 3: Find k hashtags that are used across the most number of states." + "\n"
					+ "Enter 7: Find the users who used a given hashtag most often in a given state."+ "\n" 
					+ "Enter 9: Find the most influential users measured by the number of followers." + "\n"
					+ "Enter 16: Find the most influential tweets along with the user who posted and the urls used by the user."+ "\n" 
					+ "Enter 18: Find k users who were mentioned the most in tweets of users of a given party in a given month of a given year"+ "\n" 
					+ "Enter 23: Find k most used hashtags with the count of tweets it appeared posted by a given sub-category of users in a list of months."+ "\n" 
					+ "Enter i: Insert information of a new user into the database."+ "\n" 
					+ "Enter d: Delete a given user and all the tweets the user has tweeted, relevant hashtags, and users mentioned."+ "\n" 
					+ "Enter q: Quit program";
			

			//Executes a query depending on the option selected
			while (true) {
				option = JOptionPane.showInputDialog(instruction);
				if (option.equals("3")) {
					int k = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of rows to view (k):"));
					int givenYear = Integer.parseInt(JOptionPane.showInputDialog("Enter year:"));
					question3(conn, k, givenYear);
				} 
				else if (option.equals("7")) {
					int k = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of rows to view (k):"));
					String givenHashTag = JOptionPane.showInputDialog("Enter hashTag:");
					String givenState = JOptionPane.showInputDialog("Enter state:");
					int givenMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter month:"));
					int givenYear = Integer.parseInt(JOptionPane.showInputDialog("Enter year:"));
					question7(conn, k, givenHashTag, givenState, givenMonth, givenYear);
				} 
				else if (option.equals("9")) {
					int k = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of rows to view (k):"));
					String givenParty = JOptionPane.showInputDialog("Enter Party:");
					question9(conn, k, givenParty);
				}
				else if (option.equals("16")) {
					int k = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of rows to view (k):"));
					int givenMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter month:"));
					int givenYear = Integer.parseInt(JOptionPane.showInputDialog("Enter year:"));
					question16(conn, k, givenMonth, givenYear);
				}
				else if (option.equals("18")) {
					int k = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of rows to view (k):"));
					String givenParty = JOptionPane.showInputDialog("Enter Party:");
					int givenMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter month:"));
					int givenYear = Integer.parseInt(JOptionPane.showInputDialog("Enter year:"));
					question18(conn, k, givenParty,  givenMonth, givenYear);
				}
				else if (option.equals("23")) {
					int k = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of rows to view (k):"));
					String givenParty = JOptionPane.showInputDialog("Enter Party:");
					String givenMonth = JOptionPane.showInputDialog("Enter month numbers seperated by a comma ',' :");
					int givenYear = Integer.parseInt(JOptionPane.showInputDialog("Enter year:"));
					question23(conn, k, givenParty,  givenMonth, givenYear);
				}
				else if (option.equalsIgnoreCase("i")) {
					String screen_name= JOptionPane.showInputDialog("Enter Screen Name to insert:");
					String user_name = JOptionPane.showInputDialog("Enter User Name:");
					String party = JOptionPane.showInputDialog("Enter Party:");
					String category = JOptionPane.showInputDialog("Enter Category:");
					String state = JOptionPane.showInputDialog("Enter State:");
					String numFollowers = JOptionPane.showInputDialog("Enter Number Of Followers:");
					String numFollowing = JOptionPane.showInputDialog("Enter Number Of Following:");
					insert(conn, screen_name, user_name, party, category, state, numFollowers, numFollowing);
				}
				else if (option.equalsIgnoreCase("d")) {
					String screen_name = JOptionPane.showInputDialog("Enter Screen Name to delete:");
					delete(conn, screen_name);
				}
				else if (option.equalsIgnoreCase("q")) {
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Entry try again", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Program terminates due to errors");
			e.printStackTrace(); // for debugging
		}
	}


	



	
}

