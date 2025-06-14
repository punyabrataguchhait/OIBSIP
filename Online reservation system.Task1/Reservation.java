import models.ReservationRecord;
import java.util.Scanner;
import java.util.UUID;

public class Reservation {
    public static void bookTicket() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Train Number: ");
        String trainNo = sc.nextLine();
        String trainName = getTrainName(trainNo);
        System.out.print("Enter Class Type (e.g., Sleeper/AC): ");
        String classType = sc.nextLine();
        System.out.print("Enter Date of Journey (dd-mm-yyyy): ");
        String doj = sc.nextLine();
        System.out.print("From: ");
        String from = sc.nextLine();
        System.out.print("To: ");
        String to = sc.nextLine();

        String pnr = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        ReservationRecord r = new ReservationRecord(pnr, name, trainNo, trainName, classType, doj, from, to);
        DataStore.addReservation(r);
        System.out.println("Reservation successful! Your PNR: " + pnr);
    }

    private static String getTrainName(String trainNo) {
        switch (trainNo) {
            case "12345": return "Rajdhani Express";
            case "54321": return "Shatabdi Express";
            default: return "Generic Express";
        }
    }
}
