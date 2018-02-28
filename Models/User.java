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
	
	private int getID() {
		return this.id;
	}	
	
	// Insere registro
	public void add() {
		
	}
	
	// Remove registro
	public void remove() {
		
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
