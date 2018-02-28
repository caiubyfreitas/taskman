import PrimeIT.Controllers.UserController;

public class Test {
	
    public static void main(String args[]) {
    	try {

    		UserController usuario = new UserController();
    		if (usuario.authenticate("anapaula@gmail.com", "es9L3jnw.obL.")) {
    			System.out.println("Passar para a view que pode prosseguir.");
    		};

    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	finally {
    	}
    	
	}
    
}

