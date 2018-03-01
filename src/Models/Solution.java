package Models;
import java.sql.SQLException;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Database.MySQLDBCommand;

public class Solution {
	
	protected int Object_ID;
	protected int Opportunity_Object_ID;
	protected String Name;
	protected int YearsOfExperience;
	protected Date AvailableDate;
	
	//insere registo
	public void add() throws JSONException {

		// Define o SQL associado ao método
		String stmt = "INSERT INTO SOLUTION (OBJECT_ID, OPPORTUNITY_OBJECT_ID, NAME, YEAROFEXPERIENCE, AVAILABLEDATE) VALUES (NULL, NULL,?,?,?)";

		// Insere o(s) parâmetro(s) em uma matriz JSON 
		JSONArray params = new JSONArray();
		params.put(new JSONObject().put("Object_ID", this.Object_ID));
		params.put(new JSONObject().put("Opportunity_Object_ID", this.Opportunity_Object_ID));
		params.put(new JSONObject().put("Name", this.Name));
		params.put(new JSONObject().put("YearsOfExperience", this.YearsOfExperience));
		params.put(new JSONObject().put("AvailableDate", this.AvailableDate));
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
			String stmt = "DELETE FROM SOLUTION WHERE OPPORTUNITY_OBJECT_ID = ?";

			// Insere o(s) parâmetro(s) em uma matriz JSON 		
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Opportunity_Object_ID", this.Opportunity_Object_ID));
			
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
			String stmt = "UPDATE STATE SET NAME = ?, YEARSOFEXPERIENCE = ?, AVAILABLEDATE=?, WHERE OPPORTUNITY_OBJECT_ID = ?";

			// Insere todos os atributos em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Name", this.Name));
			params.put(new JSONObject().put("YearsOfExperience", this.YearsOfExperience));
			params.put(new JSONObject().put("AvailableDate", this.AvailableDate));
			params.put(new JSONObject().put("Opportunity_Object_ID", this.Opportunity_Object_ID));
						
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
			String stmt = "SELECT NAME, YEARSOFEXPERIENCE, AVAILABLEDATE FROM SOLUTION WHERE OPPORTUNITY_OBJECT_ID = ?";

			// Insere o(s) parâmetro(s) em uma matriz JSON 
			JSONArray params = new JSONArray();
			params.put(new JSONObject().put("Opportunity_Object_ID", this.Opportunity_Object_ID));
			
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
