package Models;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;

public class Opportunity {
	
	//Atributos do modelo
	protected int Object_ID;
	protected int State_ID;
	protected int Client_ID;
	protected String Title;
	protected String Description;
	
	//insere registo
	public void add() throws JSONException {

		// Define o SQL associado ao método
		String stmt = "INSERT INTO OPPORTUNITY (OBJECT_ID, STATE_ID, CLIENT_ID, TITLE, DESCRIPTION) VALUES (NULL, NULL, NULL, ?,?)";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("Object_ID", this.Object_ID));
		params.put(new JSONObject().put("State_ID", this.State_ID));
		params.put(new JSONObject().put("Client_ID", this.Client_ID));
		params.put(new JSONObject().put("Title", this.Title));
		params.put(new JSONObject().put("Description", this.Description));
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
			String stmt = "DELETE FROM OPPORTUNITY WHERE OBJECT_ID = ?";

			// Insere o(s) parâmetro(s) em uma matriz JSON 		
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Object_ID", this.Object_ID));
			
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
			String stmt = "UPDATE OPPORTUNITY SET TITLE = ?, DESCRIPTION = ?, STATE_ID = ?, CLIENT_ID = ? WHERE OBJECT_ID = ?";

			// Insere todos os atributos em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Title", this.Title));
			params.put(new JSONObject().put("Description", this.Description));
			params.put(new JSONObject().put("State_ID", this.State_ID));
			params.put(new JSONObject().put("Client_ID", this.Client_ID));
			params.put(new JSONObject().put("Object_ID", this.Object_ID));
						
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
			String stmt = "SELECT OBJECT_ID, TITLE, DESCRIPTION, STATE_ID FROM OPPORTUNITY WHERE OBJECT_ID = ?";

			// Insere o(s) parâmetro(s) em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Object_ID", this.Object_ID));
			
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
