package bankaccountapp;
import java.sql.*;
import java.util.*;

public class BankApplication {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter Your ID\n");
		int id = s.nextInt();
		String url = "jdbc:mysql://localhost:3306/users?useSSL=false";
		String uname = "root";
		String pass = "password";
		String query  = "SELECT * FROM user where ID=?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1,id);
		ResultSet rs = st.executeQuery();
		
		rs.next();
		String name = rs.getString("fullname");
		String ssn = rs.getString("ssn");
		double deposit = rs.getDouble("deposit");
		
		System.out.println("\nChose The Account Type \n"
				+ "1.Press 1 For The Saving Type\n"
				+"2.Press 2 For The Checking Type\n"
				);
		int choice = s.nextInt();
		if(choice == 1)
		{
			Savings sv = new Savings(name,ssn,deposit);
			System.out.println("\n1.Press 1 To Check The Information\n"
					+"2.Press 2 For Transfer Money\n");
			int choice1 = s.nextInt();
			if(choice1 == 1)
			{
				sv.showinfo();
				sv.compound();
			}
			else if(choice1 == 2)
			{
				System.out.println("\nEnter The Amount You Wanted Transfer\n");
				double amount = s.nextDouble();
				sv.transfer(amount);
			}
		
			
		}
		else  if(choice == 2)
		{

			 Checking ch = new Checking(name,ssn,deposit); 
			 ch.showinfo();
			 ch.compound();
			
		}
		
		
		 
		s.close();
		st.close();
		con.close();
		System.out.println("\n**** Timed Out ****\n");
		
		
		
	}

}
