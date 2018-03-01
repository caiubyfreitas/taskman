package Models;

import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;

public class LogField {
	
	protected int LogField_ID;
	protected int Log_ID;
	protected int OperationField_ID;
	protected String Content;
	
	//insere registo
		public void add() throws JSONException {

			// Define o SQL associado ao método
			String stmt = "INSERT INTO LOGFIELD (LOGFIELD_ID, LOG_ID, OPERATIONFIELD_ID, CONTENT) VALUES (NULL, NULL, NULL, ?)";
			// Insere o(s) parâmetro(s) em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("LogField_ID", this.LogField_ID));
			params.put(new JSONObject().put("Log_ID", this.Log_ID));
			params.put(new JSONObject().put("OperationField_ID", this.OperationField_ID));
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
				String stmt = "DELETE FROM LOGFIELD WHERE LOGFIELD_ID = ?";

				// Insere o(s) parâmetro(s) em uma matriz JSON 		
				JSONArray params = new JSONArray();
				params.put(new JSONObject().put("LogField_ID", this.LogField_ID));
				
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
				String stmt = "UPDATE LOGFIELD SET CONTENT = ? WHERE LOGFIELD_ID = ?";

				// Insere todos os atributos em uma matriz JSON 
				JSONArray params = new JSONArray();
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
				String stmt = "SELECT LOGFIELD_ID FROM LOGFIELD WHERE LOGFIELD_ID = ?";

				// Insere o(s) parâmetro(s) em uma matriz JSON 
				JSONArray params = new JSONArray();
				params.put(new JSONObject().put("LogField_ID", this.LogField_ID));
				
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
