package controllers;
 
import models.*;
 
public class Security extends Secure.Security {
	
    static boolean authenticate(String username, String password) {
        return true;
    }
    
    static void onAuthenticated() {
    	if (Security.connected() != null) {
    		if (UserList.getUserByName(Security.connected()) == null) {
    			User newUser = new User(Security.connected());
    		}
    	}
    } 
}
