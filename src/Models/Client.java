package Models;

import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;

public class Client {

	protected int Client_ID;
	protected String Name;
	protected String Description;
	//insere registo
		public void add() throws JSONException {

			// Define o SQL associado ao método
			String stmt = "INSERT INTO CLIENT (CLIENT_ID, NAME, DESCRIPTION) VALUES (NULL, ?, ?)";
			// Insere o(s) parâmetro(s) em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Client_ID", this.Client_ID));
			params.put(new JSONObject().put("Name", this.Name));
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
				String stmt = "DELETE FROM CLIENT WHERE CLIENT_ID = ?";

				// Insere o(s) parâmetro(s) em uma matriz JSON 		
				JSONArray params = new JSONArray();
				params.put(new JSONObject().put("Client_ID", this.Client_ID));
				
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
				String stmt = "UPDATE Client SET DESCRIPTION = ? WHERE CLIENT_ID = ?";

				// Insere todos os atributos em uma matriz JSON 
				JSONArray params = new JSONArray();
				params.put(new JSONObject().put("Description", this.Description));
				
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
				String stmt = "SELECT CLIENT_ID FROM CLIENT WHERE CLIENT_ID = ?";

				// Insere o(s) parâmetro(s) em uma matriz JSON 
				JSONArray params = new JSONArray();
				params.put(new JSONObject().put("Client_ID", this.Client_ID));
				
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
