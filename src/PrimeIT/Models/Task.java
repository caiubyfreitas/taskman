package PrimeIT.Models;

import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import PrimeIT.Database.DBCommand;

public class Task {

	protected int id;
	protected String title;
	protected String description;
	protected int state;

	//Insere registro
	public void add() throws JSONException {
		String stmt = "INSERT INTO TASK (ID, TITLE, DESCRIPTION, STATE) VALUES (NULL, ?, ?, ?)";
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("title", this.title));
		params.put(new JSONObject().put("description", this.description));
		params.put(new JSONObject().put("state", this.state));
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
		String stmt = "DELETE FROM TASK WHERE ID = ?";
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("id", this.id));
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
		String stmt = "UPDATE TASK SET TITLE = ?, DESCRIPTION = ?, STATE = ? WHERE ID = ?";
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("title", this.title));
		params.put(new JSONObject().put("description", this.description));
		params.put(new JSONObject().put("state", this.state));
		params.put(new JSONObject().put("id", this.id));
    	try {
    		DBCommand cmd = new DBCommand();
    		rowsAffected = cmd.execute(stmt, params);
    	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
		}    
    	return rowsAffected;
	}
		
	//Recupera registro
	public JSONArray fetch() throws JSONException {
		JSONArray result = null;
		String stmt = "SELECT ID, TITLE, DESCRIPTION, STATE FROM TASK WHERE ID = ?";
		params.put(new JSONObject().put("id", this.id));
    	try {
    		DBCommand cmd = new DBCommand();
    		result = cmd.query(stmt);
    	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
		}    	
    	return result;
	}
	
}
