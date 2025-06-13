import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User("admin", "1234", "Admin");

        System.out.println("Welcome to Online Examination System");
        System.out.print("Enter username: ");
        String u = sc.nextLine();
        System.out.print("Enter password: ");
        String p = sc.nextLine();

        if (user.getUsername().equals(u) && user.getPassword().equals(p)) {
            System.out.println("Login successful!\n");
            ExamSystem exam = new ExamSystem(user);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Update Profile");
                System.out.println("2. Start Exam");
                System.out.println("3. Logout");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        exam.updateProfile();
                        break;
                    case 2:
                        exam.startExam();
                        break;
                    case 3:
                        System.out.println("Session closed. Logging out...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } else {
            System.out.println("Login failed.");
        }
    }
}