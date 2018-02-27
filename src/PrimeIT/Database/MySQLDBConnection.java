package PrimeIT.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBConnection {

    protected Connection instance;
	private String hostName;
	private String dbName;
    private String url;
    private String userName;
    private String password;
    private String port;

    public MySQLDBConnection() {
    	this.hostName = "localhost";
    	this.dbName = "lab";
    	this.url = "jdbc:mysql://";
    	this.userName = "tester";
    	this.password = "oPuXqpKDJyuEv4cn";
    	this.port = "3306";    	
    }

	public void open() throws SQLException{
        try {
			this.url += this.hostName + ":" + this.port + "/" + this.dbName;
			this.instance = DriverManager.getConnection(this.url, this.userName, this.password);		
        } 
		catch (Exception e) {
            System.out.println("Database Connection Creation Failed : " + e.getMessage());
        }
	}
	
	public void close(){
		if (this.instance != null){
			try {
				this.instance.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.instance = null;
	}
	
}
