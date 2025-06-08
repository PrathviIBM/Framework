package data;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

	public static Map<String, String> registerPayload(String email, String password) {
        Map<String, String> payload = new HashMap<>();
        payload.put("email", email);
        payload.put("password", password);
        return payload;
    }
	
	public static Map<String, String> createUserPayload(String name, String job) {
        Map<String, String> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("job", job);
        return payload;
    }
}


/*	//First way of declaring payloads
public class Payloads {
    public static String createUserPayload(String name, String job) {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("job", job);
        return obj.toString();
    }

    public static String registerPayload(String email, String password) {
        JSONObject obj = new JSONObject();
        obj.put("email", email);
        obj.put("password", password);
        return obj.toString();
    }
}
*/