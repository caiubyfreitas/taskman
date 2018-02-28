package PrimeIT.Helpers;

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
