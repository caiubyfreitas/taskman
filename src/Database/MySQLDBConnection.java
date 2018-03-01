/*
* ****************************************************************************************************************************
*
* DATABASE ACCESS LAYER
* Fev-2018
* By Caiuby Freitas
*
* Implements connection handshake to a particular mySQL database and transaction control
*
* ****************************************************************************************************************************
*/

package Database;

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
    	this.dbName = "mydb";
    	this.url = "jdbc:mysql://";
    	this.userName = "root";
    	this.password = "admin";
    	this.port = "3306";    	
    }
    
	@Override
	public void finalize() throws SQLException{
		this.instance.setAutoCommit(true);
	}


	public void open() throws SQLException{
        try {
			this.url += this.hostName + ":" + this.port + "/" + this.dbName;
			this.instance = DriverManager.getConnection(this.url, this.userName, this.password);
			this.instance.setAutoCommit(false);
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
	
	public void commitTransaction() throws SQLException {
		this.instance.commit();
	}
	
	public void rollbackTransaction() throws SQLException{
		this.instance.rollback();
	}
	
}
