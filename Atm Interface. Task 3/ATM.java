import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Java ATM Interface");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        UserAccount user = BankSystem.login(userId, pin);
        if (user != null) {
            System.out.println("Login successful.");
            ATMService service = new ATMService(user);
            service.showMenu();
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }

        scanner.close();
    }
}
