/*
* ****************************************************************************************************************************
*
* DATABASE ACCESS LAYER
* Fev-2018
* By Caiuby Freitas
*
* Implements low level functions for data access and data manipulation in any mySQL database.
*
* ****************************************************************************************************************************
*/

package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONException;

import Helpers.Helper;

public class MySQLDBCommand extends DBCommand {
		
	private MySQLDBConnection connection = null;
	
	public MySQLDBCommand() throws SQLException {
		this.connection = new MySQLDBConnection();
		this.connection.open();
	}

	/*
	 * Execute a configurable query w/ parameters
	 * Result is given in a JSONArray format to make data transfer to front-end easier via ajax 
	 */
	@Override
	public JSONArray query(String stmt, JSONArray params) throws JSONException, SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		JSONArray result = null;
		try {
			st = this.connection.instance.prepareStatement(stmt, ResultSet.CONCUR_READ_ONLY);
			for (int i = 0, tot = params.length(); i < tot; i++) {
				String fieldName = params.getJSONObject(i).keys().next().toString();
				st.setObject((i+1), params.getJSONObject(i).get(fieldName));	
			}
			rs = st.executeQuery();
    		result = Helper.JSONEncode(rs);
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (rs != null) {
	    		rs.close();
			}
			if (st != null) {
				st.close();
			}
		}
		return result;
	}
	
	/*
	 * Execute a configurable SQL command.
	 * Returns the total number of records affected by the operation.
	 */
	@Override
	public int execute(String stmt, JSONArray params) throws SQLException, JSONException{
		int recordsAffected = 0;
		PreparedStatement st = null;
		try {
			st = this.connection.instance.prepareStatement(stmt);
			for (int i = 0, tot = params.length(); i < tot; i++) {
				String fieldName = params.getJSONObject(i).keys().next().toString();
				st.setObject((i+1), params.getJSONObject(i).get(fieldName));	
			}
			recordsAffected = st.executeUpdate();
			this.connection.commitTransaction();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			this.connection.rollbackTransaction();
		}
		finally {
			st.close();
		}
		return recordsAffected;
	}
	
}
