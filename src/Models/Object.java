package Models;
import java.sql.SQLException;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;

public class Object {
	
	protected int Object_ID;
	protected int ObjectType_ID;
	protected Date CreationDate;
	protected Date LastUpdatedDate;
	protected Date DeletionDate;
	protected int IsDeleted;
	
	//insere registo
	public void add() throws JSONException {

		// Define o SQL associado ao método
		String stmt = "INSERT INTO OBJECT (OBJECT_ID, OBJECTTYPE_ID, CREATIONDATE, LASTUPDATEDDATE, DELETIONDATE, ISDELETED) VALUES (NULL, NULL, ?, ?, ?, ?)";
		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		
		params.put(new JSONObject().put("Object_ID", this.Object_ID));
		params.put(new JSONObject().put("ObjectType_ID", this.ObjectType_ID));
		params.put(new JSONObject().put("CreationDate", this.CreationDate));
		params.put(new JSONObject().put("LastUpdtatedDate", this.LastUpdatedDate));
		params.put(new JSONObject().put("DeletionDate", this.DeletionDate));
		params.put(new JSONObject().put("IsDeleted", this.IsDeleted));
	
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
			String stmt = "DELETE FROM OBJECT WHERE OBJECT_ID = ?";

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
			String stmt = "UPDATE OBJECT SET CREATIONDATE = ?, LASTUPDATEDDATE = ? , DELETIONDATE = ? , ISDELETED = ? WHERE OBJECT_ID = ?";

			// Insere todos os atributos em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("CreationDate", this.CreationDate));
			params.put(new JSONObject().put("LastUpdtatedDate", this.LastUpdatedDate));
			params.put(new JSONObject().put("DeletionDate", this.DeletionDate));
			params.put(new JSONObject().put("IsDeleted", this.IsDeleted));							
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
			String stmt = "SELECT OBJECT_ID FROM OBJECT WHERE OBJECT_ID = ?";

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
