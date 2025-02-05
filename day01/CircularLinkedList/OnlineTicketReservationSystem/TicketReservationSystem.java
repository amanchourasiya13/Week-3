package day1.CircularLinkedList.OnlineTicketReservationSystem;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class CircularTicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    // Add a new ticket reservation at the end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head; // Circular link
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Circular link
        }
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;

        // Handle case where the ticket to remove is the head
        if (temp.ticketId == ticketId) {
            if (head == tail) {
                head = tail = null; // Only one node
            } else {
                prev = tail;
                while (temp.next != head) {
                    prev = temp;
                    temp = temp.next;
                }
                head = head.next;
                prev.next = head; // Update circular link
            }
            return;
        }

        // Traverse the list to find the ticket to remove
        while (temp != null && temp.ticketId != ticketId) {
            prev = temp;
            temp = temp.next;
            if (temp == head) break; // Stop if we loop back to the head
        }

        if (temp != null && temp.ticketId == ticketId) {
            prev.next = temp.next; // Skip the node to remove it
            if (temp == tail) {
                tail = prev; // Update tail if needed
            }
        } else {
            System.out.println("Ticket with ID " + ticketId + " not found.");
        }
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for Customer Name or Movie Name: " + query);
        }
    }

    // Calculate the total number of booked tickets
    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        CircularTicketReservationSystem system = new CircularTicketReservationSystem();

        // Add some ticket reservations
        system.addTicket(1, "John Doe", "Avatar 2", "A1", "2025-01-28 10:00");
        system.addTicket(2, "Jane Smith", "The Matrix 4", "B3", "2025-01-28 12:00");
        system.addTicket(3, "Alice Johnson", "Avatar 2", "C2", "2025-01-28 14:00");

        // Display all tickets
        System.out.println("Current Tickets:");
        system.displayTickets();

        // Search for a ticket by Customer Name
        System.out.println("\nSearching for tickets by Customer Name 'Jane Smith':");
        system.searchTicket("Jane Smith");

        // Search for a ticket by Movie Name
        System.out.println("\nSearching for tickets by Movie Name 'Avatar 2':");
        system.searchTicket("Avatar 2");

        // Count total booked tickets
        System.out.println("\nTotal number of booked tickets: " + system.countTickets());

        // Remove a ticket by Ticket ID
        System.out.println("\nRemoving Ticket ID 2:");
        system.removeTicket(2);

        // Display all tickets after removal
        System.out.println("\nTickets after removal:");
        system.displayTickets();

        // Count total booked tickets again
        System.out.println("\nTotal number of booked tickets after removal: " + system.countTickets());
    }
}

