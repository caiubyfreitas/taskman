package Models;

import java.sql.SQLException;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;

public class Commentary {

	protected int Commentary_ID;
	protected int User_ID;
	protected int Object_ID;
	protected Date create_time;
	protected String Content;
	protected String HumanName;
	//insere registo
		public void add() throws JSONException {

			// Define o SQL associado ao método
			String stmt = "INSERT INTO COMMENTARY (COMMENTARY_ID, USER_ID, OBJECT_ID, CREATE_TIME, CONTENT, HUMANNAME) VALUES (NULL, NULL, NULL, ?, ?, ?)";
			// Insere o(s) parâmetro(s) em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Commentary_ID", this.Commentary_ID));
			params.put(new JSONObject().put("User_ID", this.User_ID));
			params.put(new JSONObject().put("Object_ID", this.Object_ID));
			params.put(new JSONObject().put("create_time", this.create_time));
			params.put(new JSONObject().put("Content", this.Content));
			params.put(new JSONObject().put("HumanName", this.HumanName));
		
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
				String stmt = "DELETE FROM COMMENTARY WHERE COMMENTARY_ID = ?";

				// Insere o(s) parâmetro(s) em uma matriz JSON 		
				JSONArray params = new JSONArray();
				params.put(new JSONObject().put("Commentary_ID", this.Commentary_ID));
				
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
				String stmt = "UPDATE COMMENTARY SET CONTENT = ? WHERE COMMENTARY_ID = ?";

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
				String stmt = "SELECT COMMENTARY_ID FROM COMMENTARY WHERE COMMENTARY_ID = ?";

				// Insere o(s) parâmetro(s) em uma matriz JSON 
				JSONArray params = new JSONArray();
				params.put(new JSONObject().put("Commentary_ID", this.Commentary_ID));
				
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
