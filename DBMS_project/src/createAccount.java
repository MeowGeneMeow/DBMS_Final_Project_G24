import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class createAccount {
	private int userID;
	private int password;
	private String userName;
	private String phone_number_User;
	private String gender;
	private String restName;
	private int seats;
	private String phone_Numeber_Rest;
	private String Location;

	public createAccount(int userID,int password,String 
			userName, String phone_number_User,String gender) {

		this.userID=userID;
		this.password=password;
		this.password=password;
		this.password=password;
		this.password=password;
		
		
	}
	
	public void createUserAccount () throws Exception{
		try{
			Connection conn=getConnection();
			PreparedStatement user=conn.prepareStatement("INSERT INTO `user`"
					+ "(`userID` ,`password`,`userName`, `phone_number`,`gender`)"
					+ "VALUES("+userID+","+password+","+userName+","
					+phone_number_User+","+gender+");");
			user.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("success" );
		}
	}
	public void createRestAccount (String restName,int seats,String phone_Numeber_Rest,String Location) throws Exception{
		this.restName=restName;
		this.seats=seats;
		this.phone_Numeber_Rest=phone_Numeber_Rest;
		this.Location=Location;
		
		try{
			Connection conn=getConnection();
			PreparedStatement rest=conn.prepareStatement("INSERT INTO `restaurant` "
					+ "( `userID`,`restName` ,`seats`,`phone_Numeber`, `location`)"
					+ "VALUES('12345678','八方雲集','50','0986587459','台北市文山區');");
			rest.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("success" );
		}
	}
	public void createRestTime () throws Exception{
	
		try{
			Connection conn=getConnection();
			PreparedStatement time=conn.prepareStatement("INSERT INTO `restaurant` "
					+ "( `userID`,`restName` ,`seats`,`phone_Numeber`, `location`)"
					+ "VALUES('12345678','八方雲集','50','0986587459','台北市文山區');");
			time.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("success" );
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
}
