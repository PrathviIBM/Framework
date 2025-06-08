package utils;

//Second way of declaring Endpoints
public class Endpoints {
    //public static final String REGISTER = "/api/register";
    //public static final String GET_USER = "/api/users/{id}";
	
	public static final String GET_USER = "/users/{id}";
	public static final String REGISTER = "/register";
	public static final String CREAT_USER = "/users";	
}


/* First way of declaring Endpoints
public class Endpoints {
    public static String getUser = "/users/{id}";
    public static String createUser = "/users";
    public static String register = "/register";
    public static String login = "/login";
}
*/
