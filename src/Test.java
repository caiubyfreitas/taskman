import PrimeIT.Models.User;

public class Test {
	
    public static void main(String args[]) {
    	try {

    		User us = new User();
    		us.setId(18);
    		System.out.println(us.fetch());

    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	finally {
    	}
    	
	}
    
}

