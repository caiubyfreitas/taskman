/*
* ****************************************************************************************************************************
*
* HELPER CLASS
* Fev-2018
* By Caiuby Freitas
*
* Implements general purpose static methods.
* 
* JSONEconde: converts a result set in a JSON typed matrix to help sending data back to the presentation layer
*
* ****************************************************************************************************************************
*/

package Helpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Helper {

	public static JSONArray JSONEncode(ResultSet rs) throws JSONException, SQLException {
		JSONArray jsonArray = new JSONArray();		
        int total_cols = rs.getMetaData().getColumnCount();
		while (rs.next()) {
        	for (int i = 0; i < total_cols; i++) {
            	JSONObject obj = new JSONObject();
                obj.put(rs.getMetaData().getColumnLabel(i + 1).toLowerCase(), rs.getObject(i + 1));
                jsonArray.put(obj);
            	obj = null;
            }
		}
		return jsonArray;
	}
	
}
