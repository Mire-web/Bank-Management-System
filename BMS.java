import java.util.Scanner;
import javax.swing.JOptionPane;

public class BMS{
	public static String FIRST_NAME;
	public static String LAST_NAME;
	public static String COUNTRY_CODE;
	public static String COUNTRY;
	public static int PHONE_NO;
	public static int ACC_NO;
	public static float AMOUNT;
	public static float BALANCE = 0.00F;
	public static long userCount = 0;
	public  static User user;
	public static void main(String[] args){
		JOptionPane.showMessageDialog(null,"*****PayNow*****", "Greeter", JOptionPane.INFORMATION_MESSAGE);
		intro();
		
	}

	public static int intro(){
		Scanner scanner = new Scanner(System.in);
		String RESPONSE;
		System.out.println("\n\n\t\t\t\t**********Welcome to PayNow**********");
		System.out.println("\t\t\t\t*************************************\n");
		System.out.println("\t\t\t1. Create an Account");
		System.out.println("\t\t\t2. Login to Existing Account");
		System.out.println("\t\t\t3. Search Database");
		System.out.print("\t\tWhat would you like to do today?: ");
		RESPONSE = scanner.nextLine();

		while (RESPONSE.matches("[\\D]+") || (Integer.parseInt(RESPONSE) > 3 || Integer.parseInt(RESPONSE) < 1)){
			System.out.println("\t\tSelect from valid options!!");
			System.out.print("\t\tWhat would you like to do today?: ");
			RESPONSE = scanner.next();
		}
		switch (Integer.parseInt(RESPONSE)) {
			case 1:
				open_acc();
				break;
			
			case 2:
				login();
				break;
		
			default:
				System.out.println("Wrong Input Try again!");
				intro();
				break;
		}
		scanner.close();
		return (0);
	}

	public static int open_acc() {
		Scanner scanner = new Scanner(System.in);

		do{
			System.out.print("\t\tEnter FirstName: ");
			FIRST_NAME = scanner.nextLine().toLowerCase();
			if (FIRST_NAME.matches(".*[^a-zA-Z].*"))
			System.out.println("\t\tInput only alphabets, try again!!");
		}while (FIRST_NAME.matches(".*[^a-zA-Z].*"));

		do{
			System.out.print("\t\tEnter LastName: ");
			LAST_NAME = scanner.nextLine().toLowerCase();
			if (LAST_NAME.matches(".*[^a-zA-Z].*"))
			System.out.println("\t\tInput only alphabets, try again!!");
		}while (LAST_NAME.matches(".*[^a-zA-Z].*"));

		do{
			System.out.print("\t\tCountry: ");
			COUNTRY = scanner.nextLine().toLowerCase();
			if (COUNTRY.matches(".*[^a-zA-Z].*"))
			System.out.println("\t\tInput only alphabets, try again!!");
		}while (COUNTRY.matches(".*[^a-zA-Z].*"));
		
		do{
			System.out.print("\t\tCountry Code: +");
			COUNTRY_CODE = scanner.next();
			if (COUNTRY_CODE.matches(".*\\D.*") || Integer.parseInt(COUNTRY_CODE) > 999)
			System.out.println("\t\tInput only 3 digits, try again!!");
		}while (COUNTRY_CODE.matches(".*\\D.*") || Integer.parseInt(COUNTRY_CODE) > 999);

		user = new User(FIRST_NAME, LAST_NAME, COUNTRY, Integer.parseInt(COUNTRY_CODE));
		if(user.getFirstName() != "" && user.getLastName() != ""){
			JOptionPane.showMessageDialog(null, "Account Creation Successful");
			user.setPasswd(createPass());
		}
		else
		{
		JOptionPane.showMessageDialog(null, "Service Timeout, Try again", "ERROR",JOptionPane.ERROR_MESSAGE);
		open_acc();
		}
		scanner.close();
		return(0);
	}

	public static String createPass(){
		Scanner scanner = new Scanner(System.in);
		String pass;
		String Cpass;
		do{
			System.out.print("Create Password (at least 6 characters): ");
			pass = scanner.nextLine();
		}while(pass.length() < 6);

		do{
			System.out.print("Confirm Password (Password must match): ");
			Cpass = scanner.nextLine();
		}while(!(Cpass.equals(pass)));
		scanner.close();
		return (pass);
	}

	public static void login(){
		Scanner scanner = new Scanner(System.in);
		String username;
		String passwd;
		System.out.print("Firstname: ");
		username = scanner.nextLine();
		while(username != user.getFirstName()){
			System.out.println("User does not exist...");
			login();
		}

		System.out.print("Password: ");
		passwd = scanner.nextLine();
		while(passwd != user.getPasswd()){
			System.out.println("Incorrect Password!!");
			System.out.print("Password: ");
			passwd = scanner.nextLine();
		}
		intro();
		scanner.close();
	}
}
