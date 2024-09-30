package main;

import model.tiket;
import model.sistem_penjualan_tiket;
import java.util.Scanner;

public class Mainapp {
    private static final sistem_penjualan_tiket sistemPenjualanTiket = new sistem_penjualan_tiket();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("=== Ticket Sales Management ===");
            System.out.println("1. Add Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Update Ticket");
            System.out.println("4. Delete Ticket");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTicket();
                    break;
                case 2:
                    viewtikets();
                    break;
                case 3:
                    updateTicket();
                    break;
                case 4:
                    deleteTicket();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addTicket() {
        System.out.print("Enter Ticket ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Passenger Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Departure Location: ");
        String departure = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();

        tiket ticket = new tiket(id, name, departure, destination);
        sistemPenjualanTiket.addtiket(ticket);
        System.out.println("Ticket added successfully!");
    }

    private static void viewtikets() {
        sistemPenjualanTiket.viewtickets();
    }

    private static void updateTicket() {
        System.out.print("Enter Ticket ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        tiket existingTicket = sistemPenjualanTiket.getTicketById(id);
        if (existingTicket != null) {
            System.out.print("Enter new Passenger Name (current: " + existingTicket.getPassengerName() + "): ");
            String name = scanner.nextLine();
            System.out.print("Enter new Departure Location (current: " + existingTicket.getDeparture() + "): ");
            String departure = scanner.nextLine();
            System.out.print("Enter new Destination (current: " + existingTicket.getDestination() + "): ");
            String destination = scanner.nextLine();

            tiket updatedTicket = new tiket(id, name, departure, destination);
            sistemPenjualanTiket.updatetiket(id, updatedTicket);
            System.out.println("Ticket updated successfully!");
        } else {
            System.out.println("Ticket not found.");
        }
    }

    private static void deleteTicket() {
        System.out.print("Enter Ticket ID to delete: ");
        int id = scanner.nextInt();
        if (sistemPenjualanTiket.deleteTicket(id)) {
            System.out.println("Ticket deleted successfully!");
        } else {
            System.out.println("Ticket not found.");
        }
    }
}
