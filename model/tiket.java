package model;

public class tiket {
    private final int id;
    private final String passengerName;
    private final String departure;
    private final String destination;

    public tiket(int id, String passengerName, String departure, String destination) {
        this.id = id;
        this.passengerName = passengerName;
        this.departure = departure;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id + ", Passenger: " + passengerName + ", Departure: " + departure + ", Destination: " + destination;
    }
}
