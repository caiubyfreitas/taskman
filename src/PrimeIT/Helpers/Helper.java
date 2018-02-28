package PrimeIT.Helpers;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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
	
	public static void setParam(PreparedStatement ps, int parameterIndex, Object object) throws SQLException {
		if (object instanceof Timestamp) {
			ps.setTimestamp(parameterIndex, (Timestamp) object);
		} else if (object instanceof Date) {
			ps.setDate(parameterIndex, (Date) object);
		} else if (object instanceof String) {
			ps.setString(parameterIndex, (String) object);
		} else if (object instanceof Integer) {
			ps.setInt(parameterIndex, ((Integer) object).intValue());
		} else if (object instanceof Long) {
			ps.setLong(parameterIndex, ((Long) object).longValue());
		} else if (object instanceof Boolean) {
			ps.setBoolean(parameterIndex, ((Boolean) object).booleanValue());
		} else {
			ps.setObject(parameterIndex, object);
		}
	}
	
	
}
