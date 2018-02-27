import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import PrimeIT.Database.DBCommand;
import PrimeIT.Models.Task;

public class Test {
	
    public static void main(String args[]) throws JSONException {
    	JSONArray output = null;
    	try {
    		
    		Task tarefa = new Task();
    		tarefa.update();
    		
    		// Read data from the database
    		DBCommand cmd = new DBCommand();
    		output = cmd.query("SELECT * FROM USER");
    		
    		//insert a record
    		JSONArray params = new JSONArray();
			params.put(new JSONObject().put("name", "teste"));
			params.put(new JSONObject().put("fullname", "fulnano"));
			params.put(new JSONObject().put("email", "teste@"));
			params.put(new JSONObject().put("password", "teste#"));
    		cmd.execute("INSERT INTO USER (ID, NAME, FULLNAME, EMAIL, PASSWORD, PICTURE) VALUES (null, ?, ?, ?, ?, 'TEMP')", params);

    	}
    	catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	finally {
    		System.out.println(output);
    	}
    	
	}
    
}

