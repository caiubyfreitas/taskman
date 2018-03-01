package Models;

import java.sql.SQLException;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;
public class Log {
	protected int Log_ID;
	protected int User_ID;
	protected int Object_ID;
	protected int Operation_ID;
	protected Date CreationDate;
	protected String HumanName;
	protected String ObjectName;
	//insere registo
		public void add() throws JSONException {

			// Define o SQL associado ao método
			String stmt = "INSERT INTO LOG (LOG_ID, USER_ID, OBJECT_ID, OPERATION_ID, CREATIONDATE, HUMANNAME, OBJECTNAME) VALUES (NULL, NULL, NULL, NULL, ?, ?, ?)";
			// Insere o(s) parâmetro(s) em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Log_ID", this.Log_ID));
			params.put(new JSONObject().put("User_ID", this.User_ID));
			params.put(new JSONObject().put("Object_ID", this.Object_ID));
			params.put(new JSONObject().put("Operation_ID", this.Operation_ID));
			params.put(new JSONObject().put("CreationDate", this.CreationDate));
			params.put(new JSONObject().put("HumanName", this.HumanName));
			params.put(new JSONObject().put("ObjecttName", this.ObjectName));
		
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
				String stmt = "DELETE FROM LOG WHERE LOG_ID = ?";

				// Insere o(s) parâmetro(s) em uma matriz JSON 		
				JSONArray params = new JSONArray();
				params.put(new JSONObject().put("Log_ID", this.Log_ID));
				
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
				String stmt = "UPDATE LOG SET CREATIONDATE = ?, HUMANNAME = ?, OBJECTNAME = ? WHERE LOG_ID = ?";

				// Insere todos os atributos em uma matriz JSON 
				JSONArray params = new JSONArray();
				params.put(new JSONObject().put("CreationDate", this.CreationDate));
				params.put(new JSONObject().put("HumanName", this.HumanName));	
				params.put(new JSONObject().put("ObjectName", this.ObjectName));	
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
				String stmt = "SELECT LOG_ID FROM LOG WHERE LOG_ID = ?";

				// Insere o(s) parâmetro(s) em uma matriz JSON 
				JSONArray params = new JSONArray();
				params.put(new JSONObject().put("Log_ID", this.Log_ID));
				
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
