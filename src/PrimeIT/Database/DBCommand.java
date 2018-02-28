package PrimeIT.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONException;

import PrimeIT.Helpers.Helper;

public class DBCommand extends MySQLDBConnection{
	
	public DBCommand() throws SQLException{
		this.open();
	}

	@Override
	public void finalize(){
		this.close();
	}
	
	public JSONArray query(String stmt, JSONArray params) throws SQLException, JSONException {
		PreparedStatement st = null;
		ResultSet rs = null;
		JSONArray result = null;
		try {
			st = this.instance.prepareStatement(stmt, ResultSet.CONCUR_READ_ONLY);
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
	
	public int execute(String stmt, JSONArray params) throws SQLException, JSONException{
		int recordsAffected = 0;
		PreparedStatement st = null;
		try {
			this.instance.setAutoCommit(false);
			st = this.instance.prepareStatement(stmt);
			for (int i = 0, tot = params.length(); i < tot; i++) {
				String fieldName = params.getJSONObject(i).keys().next().toString();
				st.setObject((i+1), params.getJSONObject(i).get(fieldName));	
			}
			recordsAffected = st.executeUpdate();
			this.instance.commit();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			this.instance.rollback();
		}
		finally {
			this.instance.setAutoCommit(true);
			st.close();
		}
		return recordsAffected;
	}
	
}
