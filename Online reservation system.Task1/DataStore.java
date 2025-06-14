import models.ReservationRecord;
import java.util.*;

public class DataStore {
    public static Map<String, ReservationRecord> reservations = new HashMap<>();

    public static void addReservation(ReservationRecord r) {
        reservations.put(r.pnr, r);
    }

    public static ReservationRecord getReservation(String pnr) {
        return reservations.get(pnr);
    }

    public static void cancelReservation(String pnr) {
        reservations.remove(pnr);
    }
}
