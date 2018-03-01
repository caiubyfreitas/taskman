package Models;

import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;

public class Attachment {
	
	protected int Attachment_ID;
	protected int Object_ID;
	protected String Name;
	protected String Description;
	protected String Content;
	
	public void add() throws JSONException {

		// Define o SQL associado ao método
		String stmt = "INSERT INTO ATTACHMENT (ATTACHMENT_ID, OBJECT_ID, NAME, DESCRIPTION, CONTENT) VALUES (NULL, NULL, ?, ?, ?)";
		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("Attachment_ID", this.Attachment_ID));
		params.put(new JSONObject().put("Object_ID", this.Object_ID));
		params.put(new JSONObject().put("Name", this.Name));
		params.put(new JSONObject().put("Description", this.Description));
		params.put(new JSONObject().put("Content", this.Content));
	
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
	
	//Remove registo
		public void remove() throws JSONException {
			
			// Define o SQL associado ao método
			String stmt = "DELETE FROM ATTACHMENT WHERE ATTACHMENT_ID = ?";

			// Insere o(s) parâmetro(s) em uma matriz JSON 		
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Attachment_ID", this.Attachment_ID));
			
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
		
		//Altera registo
		public int update() throws JSONException {
			
			int rowsAffected = 0;

			// Define o SQL associado ao método
			String stmt = "UPDATE ATTACHMENT SET NAME = ?, DESCRIPTION = ?, CONTENT = ? WHERE ATTACHMENT_ID = ?";

			// Insere todos os atributos em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Name", this.Name));
			params.put(new JSONObject().put("Description", this.Description));
			params.put(new JSONObject().put("Content", this.Content));
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
			String stmt = "SELECT ATTACHMENT_ID FROM ATTACHMENT WHERE ATTACHMENT_ID = ?";

			// Insere o(s) parâmetro(s) em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Atttachment_ID", this.Attachment_ID));
			
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
