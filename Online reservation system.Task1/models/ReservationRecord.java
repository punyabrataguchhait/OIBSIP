package models;

public class ReservationRecord {
    public String pnr;
    public String name;
    public String trainNo;
    public String trainName;
    public String classType;
    public String doj;
    public String from;
    public String to;

    public ReservationRecord(String pnr, String name, String trainNo, String trainName, String classType, String doj, String from, String to) {
        this.pnr = pnr;
        this.name = name;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.classType = classType;
        this.doj = doj;
        this.from = from;
        this.to = to;
    }

    public void print() {
        System.out.println("PNR: " + pnr + ", Name: " + name + ", Train: " + trainNo + " - " + trainName + ", Class: " + classType + ", DOJ: " + doj + ", From: " + from + ", To: " + to);
    }
}
