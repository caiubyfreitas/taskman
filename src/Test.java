/*
* ****************************************************************************************************************************
*
* TEST UNIT
* Fev-2018
* By Caiuby Freitas
*
* ****************************************************************************************************************************
*/

import Controllers.UserController;

public class Test {
	
    public static void main(String args[]) {
    	try {

    		UserController usuario = new UserController();
    		if (usuario.authenticate("anapaula@gmail.com", "es9L3jnw.obL.")) {
    			System.out.println("Passar para a view que pode prosseguir.");
    		};
    		usuario.remove(31);
    		usuario.add("fulaninho", "fulaninho@fulaninho.com", "advinha2");

    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	finally {
    	}
    	
	}
    
}

