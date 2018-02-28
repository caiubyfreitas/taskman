/*
* ****************************************************************************************************************************
*
* DATABASE ACCESS LAYER
* Fev-2018
* By Caiuby Freitas
*
* Establishes the generic contract for any derived class regarding data access and data manipulation methods.
*
* ****************************************************************************************************************************
*/

package PrimeIT.Database;

import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;

public class DBCommand {
	
	public DBCommand() throws SQLException{
	}

	@Override
	public void finalize(){
		
	}
	
	public JSONArray query(String stmt, JSONArray params) throws SQLException, JSONException{
		return params;
	
	}
	
	public int execute(String stmt, JSONArray params) throws SQLException, JSONException{
		return 0;
	}

}