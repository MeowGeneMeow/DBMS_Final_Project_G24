import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) throws Exception {
		getConnection();
		createAccount account=new createAccount(12345678,12345678,"小美","0986587459","女");
		//account.createUserAccount ();
		//account.createRestAccount("八方雲集",50,"0986587459","台北市文山區");
		ArrayList user_Array=login();
		for(int i=0;i<user_Array.size();i++) {
			System.out.println(user_Array.get(i));
		}
			
	}
	
	public static Connection  getConnection() throws Exception {
		try {
			String driver ="com.mysql.jdbc.Driver";
			String URL="jdbc:mysql://localhost:3306/DBMS_PROJECT";
			//127.0.0.1:3306
			String username="root";
			String password="h45660166";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(URL,username,password);
			System.out.println("Connected");
			return conn;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static ArrayList<String> login() throws Exception{
		try {
			Connection conn=getConnection();
			PreparedStatement statement=conn.prepareStatement("Select `userID`,`password`"
					+ "From `user`");
			ResultSet result=statement.executeQuery();
			
			ArrayList user_Array=new ArrayList<String>();
			while(result.next()) {
				System.out.println("userID:"+result.getString("userID"));
				System.out.println("password:"+result.getString("password"));
				user_Array.add(result.getString("userID"));
				user_Array.add(result.getString("password"));
			}
			return user_Array;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
