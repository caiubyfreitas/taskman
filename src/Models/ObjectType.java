package Models;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;

public class ObjectType {
	
	protected int ObjectType_ID;
	protected String Name;
	
	//insere registo
	public void add() throws JSONException {

		// Define o SQL associado ao método
		String stmt = "INSERT INTO OBJECTTYPE (OBJECTTYPE_ID, NAME) VALUES (NULL,?)";
		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("ObjectType_ID", this.ObjectType_ID));
		params.put(new JSONObject().put("Name", this.Name));
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
			String stmt = "DELETE FROM OBJECTTYPE WHERE OBJECTTYPE_ID = ?";

			// Insere o(s) parâmetro(s) em uma matriz JSON 		
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("ObjectType_ID", this.ObjectType_ID));
			
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
			String stmt = "UPDATE OBJECTTYPE SET NAME = ? WHERE OBJECTTYPE_ID = ?";

			// Insere todos os atributos em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Name", this.Name));							
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
			String stmt = "SELECT NAME FROM OBJECTTYPE WHERE OBJECTTYPE_ID = ?";

			// Insere o(s) parâmetro(s) em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("ObjectType_ID", this.ObjectType_ID));
			
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
