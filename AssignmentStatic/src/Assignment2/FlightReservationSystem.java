package StudentManagementSystem;
import java.util.*;
import java.time.LocalDate;
;

class Flight {
    private String flightId;
    private String source;
    private String destination;
    private LocalDate date;
    private int capacity;

    public Flight(String flightId, String source, String destination, LocalDate date, int capacity) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.capacity = capacity;
    }

    // Getters
    public String getFlightId() {
    	return flightId; 
    	}
    public String getSource() {
    	return source; 
    	}
    public String getDestination() {
    	return destination; 
    	}
    public LocalDate getDate() {
    	return date;
    	}
    public int getCapacity() {
    	return capacity;
    	}

    // Setter
    public void setDate(LocalDate date) { this.date = date; }

    @Override
    public String toString() {
        return String.format("Flight %s from %s to %s on %s (Capacity: %d)",
                flightId, source, destination, date, capacity);
    }
}

class Booking {
    private int bookingId;
    private String flightId;
    private int passengerId;

    public Booking(int bookingId, String flightId, int passengerId) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.passengerId = passengerId;
    }

    // Getters
    public int getBookingId() {
    	return bookingId;
    	}
    public String getFlightId() {
    	return flightId; 
    	}
    public int getPassengerId() { 
    	return passengerId; 
    	}
}

class Passenger {
    private int passengerId;
    private String name;

    public Passenger(int passengerId, String name) {
        this.passengerId = passengerId;
        this.name = name;
    }

    // Getters
    public int getPassengerId() {
    	return passengerId;
    	}
    public String getName() { 
    	return name;
    	}

    @Override
    public String toString() {
        return String.format("Passenger %s (ID: %d)", name, passengerId);
    }
}

public class FlightReservationSystem {

    public static void main(String[] args) {

        LocalDate today = LocalDate.of(2025, 9, 17);

        List<Flight> flights = Arrays.asList(
            new Flight("AI-202", "Delhi", "Mumbai", today.plusDays(3), 2),
            new Flight("6E-501", "Delhi", "Mumbai", today.plusDays(5), 150),
            new Flight("UK-810", "Bengaluru", "Delhi", today.plusDays(10), 180),
            new Flight("SG-816", "Mumbai", "Chennai", today.plusDays(20), 100),
            new Flight("AI-303", "Delhi", "Kolkata", today.plusDays(1), 3)
        );

        List<Passenger> passengers = Arrays.asList(
            new Passenger(1, "Aarav"),
            new Passenger(2, "Vivaan"),
            new Passenger(3, "Aditya"),
            new Passenger(4, "Diya")
        );

        List<Booking> bookings = Arrays.asList(
            new Booking(101, "AI-202", 1),
            new Booking(102, "AI-202", 2),
            new Booking(103, "AI-202", 3),
            new Booking(104, "6E-501", 4),
            new Booking(105, "AI-303", 1),
            new Booking(106, "AI-303", 4),
            new Booking(107, "AI-303", 2)
        );

        System.out.println(" Main Question: Find Flights that are Overbooked ");
        overbookedFlights(bookings, flights);



        System.out.println("1. List Flights with Number of Passengers Booked ");
        passengerCountsWithFlight(bookings, flights);

        System.out.println(" 2. Show Flights with Zero Bookings ");
        zeroBookings(bookings, flights);

        System.out.println(" 3. Find Passengers who Booked More Than One Flight on the Same Day ");
        List<Booking> bookingsWithConflict = new ArrayList<>(bookings);
        bookingsWithConflict.add(new Booking(108, "6E-501", 1));
        flights.get(4).setDate(flights.get(1).getDate()); // Now AI-303 and 6E-501 same day
       

    }

    // Main Question
    public static void overbookedFlights(List<Booking> bookings, List<Flight> flights) {
        Map<String, Integer> bookingCounts = new HashMap<>();
        for (Booking b : bookings) {
            bookingCounts.put(b.getFlightId(), bookingCounts.getOrDefault(b.getFlightId(), 0) + 1);
        }

        boolean anyOverbooked = false;
        for (Flight f : flights) {
            int booked = bookingCounts.getOrDefault(f.getFlightId(), 0);
            if (booked > f.getCapacity()) {
                System.out.printf("  - %s is OVERBOOKED. (Booked: %d, Capacity: %d)%n",
                        f, booked, f.getCapacity());
                anyOverbooked = true;
            }
        }

        if (!anyOverbooked) {
            System.out.println("No flights are currently overbooked.");
        }
    }

    // Use Case 1
    public static void passengerCountsWithFlight(List<Booking> bookings, List<Flight> flights) {
        Map<String, Integer> bookingCounts = new HashMap<>();
        for (Booking b : bookings) {
            bookingCounts.put(b.getFlightId(), bookingCounts.getOrDefault(b.getFlightId(), 0) + 1);
        }

        for (Flight f : flights) {
            int booked = bookingCounts.getOrDefault(f.getFlightId(), 0);
            System.out.printf("  - %s, Booked Seats: %d%n", f, booked);
        }
    }

    // Use Case 2
    public static void zeroBookings(List<Booking> bookings, List<Flight> flights) {
        Set<String> bookedFlightIds = new HashSet<>();
        for (Booking b : bookings) {
            bookedFlightIds.add(b.getFlightId());
        }

        List<Flight> zeroBookingFlights = new ArrayList<>();
        for (Flight f : flights) {
            if (!bookedFlightIds.contains(f.getFlightId())) {
                zeroBookingFlights.add(f);
            }
        }

        System.out.println("The following flights have zero bookings:");
        if (zeroBookingFlights.isEmpty()) {
            System.out.println("  - None");
        } else {
            for (Flight f : zeroBookingFlights) {
                System.out.println("  - " + f);
            }
        }
    }
}
