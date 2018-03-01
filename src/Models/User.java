/*
* ****************************************************************************************************************************
*
* MODEL LAYER
* Fev-2018
* By Caiuby Freitas
*
* Defines USER data model.
* Only the basic database level check should be implemented here. No business rules, except to keep data integrity.
*
* ****************************************************************************************************************************
*/

package Models;

import java.sql.SQLException;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;

public class User {
	
	// Atributos do modelo
	protected int User_ID;
	protected Date CreationDate;
	protected Date LastUpdatedDate;
	protected Date DeletionDate;
	protected int Is_Deleted;
	protected int Is_Admin;
	protected String HumanName;
	protected String Username;
	protected String password;
	
	// Setters & Getters
	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}

	public Date getLastUpdatedDate() {
		return LastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		LastUpdatedDate = lastUpdatedDate;
	}

	public Date getDeletionDate() {
		return DeletionDate;
	}

	public void setDeletionDate(Date deletionDate) {
		DeletionDate = deletionDate;
	}

	public int getIs_Deleted() {
		return Is_Deleted;
	}

	public void setIs_Deleted(int is_Deleted) {
		Is_Deleted = is_Deleted;
	}

	public int getIs_Admin() {
		return Is_Admin;
	}

	public void setIs_Admin(int is_Admin) {
		Is_Admin = is_Admin;
	}

	public String getHumanName() {
		return HumanName;
	}

	public void setHumanName(String humanName) {
		HumanName = humanName;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	// Insere registro
	public void add() throws JSONException {

		// Define o SQL associado ao método
		String stmt = "INSERT INTO USER (USER_ID, CreationDate, LastUpdatedDate, DeletionDate, Is_Deleted, Is_Admin, HumanName, Username, Password) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("CreationDate", this.getCreationDate()));
		params.put(new JSONObject().put("LastUpdatedDate", this.getLastUpdatedDate()));
		params.put(new JSONObject().put("DeletionDate", this.getDeletionDate()));
		params.put(new JSONObject().put("Is_Deleted", this.getIs_Deleted()));
		params.put(new JSONObject().put("Is_Admin", this.getIs_Admin()));
		params.put(new JSONObject().put("HumanName", this.getHumanName()));
		params.put(new JSONObject().put("Username", this.getUsername()));
		params.put(new JSONObject().put("Password", this.getPassword()));
		
		// Executa o SQL
    	try {
    		MySQLDBCommand cmd = new MySQLDBCommand();
    		cmd.execute(stmt, params);
    	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
		}    	

	}
	
	

	// Remove registro
	public void remove() throws JSONException {

		// Define o SQL associado ao método
		String stmt = "DELETE FROM USER WHERE USER_ID = ?";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("User_ID", this.getUser_ID()));
		
		// Executa o SQL
    	try {
    		MySQLDBCommand cmd = new MySQLDBCommand();
    		cmd.execute(stmt, params);
    	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
		}    	
		
	}
	
	public boolean exists() throws JSONException {
		
		boolean result = false;
		
		// Define o SQL associado ao método
		String stmt = "SELECT 1 FROM USER WHERE USERNAME = ? AND PASSWORD = ?";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("Username", this.getUsername()));
		params.put(new JSONObject().put("Password", this.getPassword()));
		
		// Execute o SQL
    	try {
    		MySQLDBCommand cmd = new MySQLDBCommand();
    		result = (cmd.query(stmt, params).length() > 0) ? true : false;
    	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			params = null;
		}    	
    	
    	// Retorna uma matriz JSON com os dados do registro
    	return result;
    	
	}
	
	// Recupera os campos do registro
	public JSONArray fetch() throws JSONException {
	
		JSONArray result = null;
		
		// Define o SQL associado ao método
		String stmt = "SELECT USER_ID, USERNAME, PASSWORD FROM USER WHERE USER_ID = ?";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("User_ID", this.getUser_ID()));
		
		// Execute o SQL
    	try {
    		MySQLDBCommand cmd = new MySQLDBCommand();
    		result = cmd.query(stmt, params);
    	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
		}    	
    	
    	// Retorna uma matriz JSON com os dados do registro
    	return result;
    	
	}


}
