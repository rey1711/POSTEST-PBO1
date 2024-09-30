package model;

import java.util.ArrayList;

public class sistem_penjualan_tiket {
    private final ArrayList<tiket> tickets = new ArrayList<>();

    public void addtiket(tiket tiket) {
        tickets.add(tiket);
    }

    public void viewtickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
        } else {
            for (tiket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }

    public tiket getTicketById(int id) {
        for (tiket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null; // Ticket not found
    }

    public void updatetiket(int id, tiket updatedTicket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId() == id) {
                tickets.set(i, updatedTicket);
                return;
            }
        }
    }

    public boolean deleteTicket(int id) {
        return tickets.removeIf(ticket -> ticket.getId() == id);
    }
}
