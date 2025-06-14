public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Online Reservation System");

        if (!Login.authenticate()) {
            System.out.println("Login Failed. Exiting...");
            return;
        }

        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:\n1. Make Reservation\n2. Cancel Reservation\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    Reservation.bookTicket();
                    break;
                case 2:
                    Cancellation.cancelTicket();
                    break;
                case 3:
                    System.out.println("Thank you for using the system.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
