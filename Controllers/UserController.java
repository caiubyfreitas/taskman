package PrimeIT.Controllers;

import org.json.JSONException;

import PrimeIT.Models.User;

public class UserController {

	public boolean authenticate(String email, String password) throws JSONException {
		User us = new User();
		us.setEmail(email);
		us.setPassword(password);
		if (us.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
}
