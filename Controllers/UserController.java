package PrimeIT.Controllers;

import org.json.JSONException;

import PrimeIT.Models.User;

public class UserController {
	
	public void add(String nome, String email, String password) throws JSONException{
		User us = new User();
		us.setName(nome);
		us.setEmail(email);
		us.setPassword(password);
		us.add();
	}
	
	public void remove(int id) throws JSONException {
		User us = new User();
		us.setId(id);
		us.remove();
	}

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
