/*
* ****************************************************************************************************************************
*
* DATABASE ACCESS LAYER
* Fev-2018
* By Caiuby Freitas
*
* Implements USER data model.
*
* ****************************************************************************************************************************
*/

package PrimeIT.Models;

import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import PrimeIT.Database.MySQLDBCommand;

public class User {
	
	// Atributos do modelo
	protected int id;
	protected String name;
	protected String password;
	protected String fullName;
	protected String email;
	
	// Setters & Getters
	public void setId(int newValue) {
		this.id = newValue;
	}
	
	public int getID() {
		return this.id;
	}	
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setEmail(String newValue) {
		this.email = newValue;
	}
	
	public void setPassword(String newValue) {
		// Qualquer rotina para encriptar a senha deverá ser incluída aqui
		this.password = newValue;
	}
	
	// Insere registro
	public void add() {
		
	}
	
	// Remove registro
	public void remove() {
		
	}
	
	public boolean exists() throws JSONException {
		
		boolean result = false;
		
		// Define o SQL associado ao método
		String stmt = "SELECT 1 FROM USER WHERE EMAIL = ? AND PASSWORD = ?";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("email", this.getEmail()));
		params.put(new JSONObject().put("password", this.getPassword()));
		
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
		String stmt = "SELECT ID, NAME, PASSWORD FROM USER WHERE ID = ?";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("id", this.getID()));
		
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
