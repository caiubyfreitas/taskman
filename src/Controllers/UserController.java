/*
* ****************************************************************************************************************************
*
* CONTROLLER LAYER
* Fev-2018
* By Caiuby Freitas
*
* Defines a controller to interact with the USER data model.
* All functionalities need in the presentation layer should be implemented here, specially business rules.
*
* ****************************************************************************************************************************
*/

package Controllers;

import org.json.JSONException;

import Models.User;

public class UserController {
	
	public void add(String nome, String username, String password) throws JSONException{
		User us = new User();
		us.setHumanName(nome);
		us.setUsername(username);
		us.setPassword(password);
		us.add();
	}
	
	public void remove(int id) throws JSONException {
		User us = new User();
		us.setUser_ID(id);
		us.remove();
	}

	public boolean authenticate(String username, String password) throws JSONException {
		User us = new User();
		us.setUsername(username);
		us.setPassword(password);
		if (us.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
}
