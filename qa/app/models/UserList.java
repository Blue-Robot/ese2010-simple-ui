package models;

import java.util.ArrayList;

public class UserList {
	
	private static ArrayList<User> allUsers = new ArrayList<User>();
	
	public UserList() {
		
	}
	
	public static int count() {
		return allUsers.size();
	}
	public static void add(User newUser) {
		allUsers.add(newUser);
	}
	
	public static void remove(User oldUser) {
		allUsers.remove(oldUser);
	}
	
	public static User getUserById(String id) {
		User result = null;
		for (User user : allUsers) {
			if (user.getId().equals(id)) {
				result = user;
			}
		}
		if (result == null)
			throw new Error();
		return result;
	}
	
	public static User getUserByName(String name) {
		User result = null;
		for (User user : allUsers) {
			if (user.getName().equals(name)) {
				result = user;
			}
		}
		return result;
	}
	
	public static ArrayList<User> getAllUsers() {
		return allUsers;
	}

	

	
}