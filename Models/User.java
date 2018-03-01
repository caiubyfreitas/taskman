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
	
	public int getId() {
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
	
	public void setName(String newValue) {
		this.name = newValue;
		this.fullName = newValue;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getFullName() {
		return this.fullName;
	}
	
	// Insere registro
	public void add() throws JSONException {

		// Define o SQL associado ao método
		String stmt = "INSERT INTO USER (ID, NAME, FULLNAME, EMAIL, PASSWORD, PICTURE) VALUES (NULL, ?, ?, ?, ?, 'TEMP')";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("name", this.getName()));
		params.put(new JSONObject().put("fullname", this.getFullName()));
		params.put(new JSONObject().put("email", this.getEmail()));
		params.put(new JSONObject().put("password", this.getPassword()));
		
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
		String stmt = "DELETE FROM USER WHERE ID = ?";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("id", this.getId()));
		
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
		params.put(new JSONObject().put("id", this.getId()));
		
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
