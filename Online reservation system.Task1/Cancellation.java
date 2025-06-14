import java.util.Scanner;
import models.ReservationRecord;

public class Cancellation {
    public static void cancelTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PNR to Cancel: ");
        String pnr = sc.nextLine();
        ReservationRecord r = DataStore.getReservation(pnr);

        if (r != null) {
            System.out.println("Reservation Found:");
            r.print();
            System.out.print("Do you want to cancel this reservation? (yes/no): ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("yes")) {
                DataStore.cancelReservation(pnr);
                System.out.println("Ticket cancelled successfully.");
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("No reservation found with PNR: " + pnr);
        }
    }
}
