package database;

public class Test {

	public static void main(String[] args) {
		
		boolean bool = UserAccess.Create("email2", "pass", "Brandon", "Kowalski"); 
		
		if(bool) {
			System.out.println("Account created!");
		}
		else {
			System.err.println("Creation failed.");
		}
		
	}

}
