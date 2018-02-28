package PrimeIT.Models;

import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.DBCommand;

public class Task {

	// Atributos do modelo
	protected int id;
	protected String title;
	protected String description;
	protected int state;

	//Insere registro
	public void add() throws JSONException {

		// Define o SQL associado ao método
		String stmt = "INSERT INTO TASK (ID, TITLE, DESCRIPTION, STATE) VALUES (NULL, ?, ?, ?)";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("title", this.title));
		params.put(new JSONObject().put("description", this.description));
		params.put(new JSONObject().put("state", this.state));
		
		// Execute o SQL
    	try {
    		DBCommand cmd = new DBCommand();
    		cmd.execute(stmt, params);
    	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
		}    	
	}
	
	//Remove registro
	public void remove() throws JSONException {
		
		// Define o SQL associado ao método
		String stmt = "DELETE FROM TASK WHERE ID = ?";

		// Insere o(s) parâmetro(s) em uma matriz JSON 		
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("id", this.id));
		
		// Execute o SQL
    	try {
    		DBCommand cmd = new DBCommand();
    		cmd.execute(stmt, params);
    	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
		}    	
	}
	
	//Altera registro
	public int update() throws JSONException {
		
		int rowsAffected = 0;

		// Define o SQL associado ao método
		String stmt = "UPDATE TASK SET TITLE = ?, DESCRIPTION = ?, STATE = ? WHERE ID = ?";

		// Insere todos os atributos em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("title", this.title));
		params.put(new JSONObject().put("description", this.description));
		params.put(new JSONObject().put("state", this.state));
		params.put(new JSONObject().put("id", this.id));
		
		//Executa o SQL
    	try {
    		DBCommand cmd = new DBCommand();
    		rowsAffected = cmd.execute(stmt, params);
    	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
		}    
    	
    	// Retorna a quantidade de registros afetados.
    	return rowsAffected;
	}
		
	//Recupera registro
	public JSONArray fetch() throws JSONException {
		
		JSONArray result = null;
		
		// Define o SQL associado ao método
		String stmt = "SELECT ID, TITLE, DESCRIPTION, STATE FROM TASK WHERE ID = ?";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("id", this.id));
		
		// Execute o SQL
    	try {
    		DBCommand cmd = new DBCommand();
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
