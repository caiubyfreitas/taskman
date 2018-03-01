package Models;

import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;

public class ObjectUser {
	protected int Object_ID;
	protected int User_ID;
	
	//insere registo
	public void add() throws JSONException {

		// Define o SQL associado ao método
		String stmt = "INSERT INTO OBJECT_USER (OBJECT_ID, USER_ID) VALUES (NULL, NULL)";
		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("Object_ID", this.Object_ID));
		params.put(new JSONObject().put("User_ID", this.User_ID));
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
			String stmt = "DELETE FROM OBJECT_USER WHERE USER_ID = ?";

			// Insere o(s) parâmetro(s) em uma matriz JSON 		
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("User_ID", this.User_ID));
			
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
			
		//Recupera registro
		public JSONArray fetch() throws JSONException {
			
			JSONArray result = null;
			
			// Define o SQL associado ao método
			String stmt = "SELECT OBJECT_ID FROM OBJECT_USER WHERE USER_ID = ?";

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
