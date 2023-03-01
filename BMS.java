import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BMS{
	public static String FIRST_NAME;
	public static String LAST_NAME;
	public static int COUNTRY_CODE;
	public static String COUNTRY;
	public static int PHONE_NO;
	public static int ACC_NO;
	public static float AMOUNT;
	public static float BALANCE;
	public static void main(String args[]){
		int RESPONSE;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n\n**********Welcome to PayNow**********");
		System.out.println("*************************************\n");
		System.out.println("1. Create an Account");
		System.out.println("2. Login to Existing Account");
		System.out.println("3. Search Database");
		System.out.print("What would you like to do today?: ");
		RESPONSE = scanner.nextInt();
		System.out.println(RESPONSE);
		while (RESPONSE > 3 || RESPONSE < 1){
			System.out.println("Select from valid options!!");
			System.out.print("What would you like to do today?: ");
			RESPONSE = scanner.nextInt();
		}
		switch (RESPONSE) {
			case 1:
				open_acc();
				break;
		
			default:
				break;
		}
		scanner.close();
	}

	public static int open_acc() {
		Scanner scanner = new Scanner(System.in);
		Pattern pattern = Pattern.compile("[^a-zA-Z]+");
		Matcher matcher;
		do{
			System.out.print("Enter FirstName: ");
			FIRST_NAME = scanner.nextLine().toLowerCase();
			matcher = pattern.matcher(FIRST_NAME);
			if (matcher.find())
			System.out.println("Input only alphabets, try again!!");
		}while (matcher.matches());
		System.out.println(FIRST_NAME.toUpperCase());
		scanner.close();
		return(0);
	}
}
