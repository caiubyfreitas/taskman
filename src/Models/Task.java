package Models;

import java.sql.SQLException;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;

public class Task {

	// Atributos do modelo
	protected int Task_ID;
	protected int Object_ID;
	protected int State_ID;	
	protected String Title;
	protected String Description;
	protected int Progress;
	protected Date ConclusionDate;

	//Insere registro
	public void add() throws JSONException {

		// Define o SQL associado ao método
		String stmt = "INSERT INTO TASK (TASK_ID, OBJECT_ID, STATE_ID, TITLE, DESCRIPTION, PROGRESS, CONCLUSION DATE) VALUES (NULL, NULL, NULL, ?, ?, ?, ?)";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("Title", this.Title));
		params.put(new JSONObject().put("Description", this.Description));
		params.put(new JSONObject().put("Progress", this.Progress));
		params.put(new JSONObject().put("ConclusionDate", this.ConclusionDate));
		
		// Execute o SQL
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
	
	//Remove registro
	public void remove() throws JSONException {
		
		// Define o SQL associado ao método
		String stmt = "DELETE FROM TASK WHERE TASK_ID = ?";

		// Insere o(s) parâmetro(s) em uma matriz JSON 		
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("Task_ID", this.Task_ID));
		
		// Execute o SQL
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
	
	//Altera registro
	public int update() throws JSONException {
		
		int rowsAffected = 0;

		// Define o SQL associado ao método
		String stmt = "UPDATE TASK SET TITLE = ?, DESCRIPTION = ?, PROGRESS = ?, CONCLUSIONDATE = ? WHERE TASK_ID = ?";

		// Insere todos os atributos em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("Title", this.Title));
		params.put(new JSONObject().put("Description", this.Description));
		params.put(new JSONObject().put("Progress", this.Progress));
		params.put(new JSONObject().put("ConclusionDate", this.ConclusionDate));
		params.put(new JSONObject().put("Task_ID", this.Task_ID));
		
		//Executa o SQL
    	try {
    		MySQLDBCommand cmd = new MySQLDBCommand();
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
		String stmt = "SELECT TASK_ID, TITLE, DESCRIPTION, PROGRESS FROM TASK WHERE TASK_ID = ?";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("Task_ID", this.Task_ID));
		
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
