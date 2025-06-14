import models.User;
import java.util.Scanner;

public class Login {
    static User validUser = new User("admin", "1234");

    public static boolean authenticate() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Login ID: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        return validUser.authenticate(user, pass);
    }
}
