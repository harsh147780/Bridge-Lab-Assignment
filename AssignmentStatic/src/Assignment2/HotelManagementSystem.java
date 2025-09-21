package StudentManagementSystem;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
class Room{
	private int roomId ;
	private String type;
	private double roomPrice ;
	
	public Room(int roomId ,String type , int roomPrice) {
		this.roomId = roomId;
		this.type = type;
		this.roomPrice = roomPrice;
		
	}
	
	// getter 
	public int getRoomId() {
		return roomId;
	}
	public String getType() {
		return type;
	}
	public double getRoomPrice() {
		return roomPrice;
	}
	
	 @Override
	    public String toString() {
	        return "Room [id=" + roomId + ", type=" + type + ", price=" + roomPrice + "]";
	    }
}


class Bookings {
	private int bookingId;
	private int roomId;
	private int guestId;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Bookings (int bookingId ,int roomId , int guestId,LocalDate checkIn , LocalDate checkOut) {
		this.bookingId = bookingId;
		this.checkIn = checkIn ; 
		this.checkOut = checkOut;
		this.guestId = guestId ;
		this.roomId = roomId;
	}
	
	//getter
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public int bookingId() {
		return bookingId;
	}
	public int getGuestId() {
		return guestId;
	}
	public int getRoomId() {
		return roomId;
	}
	
}

class Guest{
	private int guestId ;
	private String name;
	
	public Guest(int guestId ,String name) {
		this.guestId = guestId ;
		this.name = name;
	}
	
	//getter
	public int getGuestId() {
		return guestId;
	}
	public String getName() {
		return name;
	}
	 @Override
	    public String toString() {
	        return "Guest{" + "id=" + guestId + ", name='" + name + '\'' + '}';
	    }
	
}

public class HotelManagementSystem {

    public static void main(String[] args) {
        
         List<Room> rooms = Arrays.asList(
                    new Room(101, "Single", 1500),
                    new Room(102, "Single", 1600),
                    new Room(201, "Double", 2500),
                    new Room(202, "Double", 2600),
                    new Room(301, "Suite", 5000)
                );
         List<Guest> guests = Arrays.asList(
                    new Guest(1, "Alice"),
                    new Guest(2, "Bob"),
                    new Guest(3, "Charlie"),
                    new Guest(4, "David")
                );

                List<Bookings> bookings = Arrays.asList(
                   
                    new Bookings(1, 201, 1, LocalDate.now().minusMonths(1), LocalDate.now().minusMonths(1).plusDays(3)),
                    new Bookings(2, 201, 2, LocalDate.now().minusMonths(2), LocalDate.now().minusMonths(2).plusDays(5)),
                    new Bookings(3, 201, 3, LocalDate.now().minusMonths(3), LocalDate.now().minusMonths(3).plusDays(2)),
                    
                    
                    new Bookings(4, 101, 4, LocalDate.now().minusMonths(4), LocalDate.now().minusMonths(4).plusDays(7)),
                    new Bookings(5, 102, 1, LocalDate.now().minusMonths(5), LocalDate.now().minusMonths(5).plusDays(4)),
                    
                    
                    new Bookings(6, 202, 2, LocalDate.now().minusMonths(7), LocalDate.now().minusMonths(7).plusDays(2)),
                    new Bookings(7, 301, 3, LocalDate.now().minusMonths(8), LocalDate.now().minusMonths(8).plusDays(1)),
                    new Bookings(8, 101, 1, LocalDate.now().minusMonths(13), LocalDate.now().minusMonths(13).plusDays(10))
                );

                
                System.out.println("## Main Question: Most Frequently Booked Room in Last 6 Months ##");
                findMostFrequentRoom(bookings, rooms);
                
                System.out.println("\n--- Other Use Cases ---");

                System.out.println("\n## 1. Number of Times Each Room Was Booked ##");
                showBookingCounts(bookings);

                System.out.println("\n## 2. Rooms Never Booked in Last 12 Months ##");
                listNeverBookedRooms(bookings, rooms);

                System.out.println("\n## 3. Average Stay Duration Per Guest ##");
                findAverageStay(bookings, guests);

                System.out.println("\n## 4. Total Revenue by Room Type ##");
                getRevenueByRoomType(bookings, rooms);

                System.out.println("\n## 5. Top 3 Guests by Number of Stays ##");
                showTopGuests(bookings, guests);
    }

    // Main Question
 
    public static void findMostFrequentRoom(List<Booking> bookings, List<Room> rooms) {
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        
        Map<Integer, Integer> roomBookingCounts = new HashMap<>();

        for (Booking booking : bookings) {
            if (booking.getCheckIn().isAfter(sixMonthsAgo)) {
                int roomId = booking.getRoomId();
                roomBookingCounts.put(roomId, roomBookingCounts.getOrDefault(roomId, 0) + 1);
            }
        }

        if (roomBookingCounts.isEmpty()) {
            System.out.println("No rooms have been booked in the last 6 months.");
            return;
        }

        int mostFrequentRoomId = -1;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : roomBookingCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentRoomId = entry.getKey();
            }
        }

        int finalRoomId = mostFrequentRoomId;
        Room room = rooms.stream().filter(r -> r.getRoomId() == finalRoomId).findFirst().orElse(null);
        
        String roomType = "N/A";
        if (room != null) {
            roomType = room.getType();
        }

        System.out.printf("The most frequently booked room is %s (ID: %d), booked %d times.%n",
                roomType, mostFrequentRoomId, maxCount);
    }

    // Use Case 1
    public static void showBookingCounts(List<Booking> bookings) {
        Map<Integer, Long> bookingCounts = bookings.stream()
                .collect(Collectors.groupingBy(Booking::getRoomId, Collectors.counting()));
        
        System.out.println("Room Booking Counts (All Time):");
        bookingCounts.forEach((roomId, count) -> 
            System.out.printf("  Room ID %d: %d times%n", roomId, count));
    }

    // Use Case 2
    public static void listNeverBookedRooms(List<Booking> bookings, List<Room> rooms) {
        LocalDate twelveMonthsAgo = LocalDate.now().minusMonths(12);

        Set<Integer> bookedRoomIds = bookings.stream()
                .filter(b -> b.getCheckIn().isAfter(twelveMonthsAgo))
                .map(Booking::getRoomId)
                .collect(Collectors.toSet());

        List<Room> neverBookedRooms = rooms.stream()
                .filter(room -> !bookedRoomIds.contains(room.getRoomId()))
                .collect(Collectors.toList());

        System.out.println("Rooms never booked in the past 12 months:");
        neverBookedRooms.forEach(room -> System.out.println("  - " + room));
    }

    // Use Case 3
    public static void findAverageStay(List<Booking> bookings, List<Guest> guests) {
        Map<Integer, String> guestMap = guests.stream()
                .collect(Collectors.toMap(Guest::getGuestId, Guest::getName));

        Map<Integer, Double> avgStays = bookings.stream()
                .collect(Collectors.groupingBy(Booking::getGuestId,
                        Collectors.averagingLong(b -> ChronoUnit.DAYS.between(b.getCheckIn(), b.getCheckOut()))));

        System.out.println("Average stay duration per guest:");
        avgStays.forEach((guestId, avgDuration) -> {
            String guestName = guestMap.getOrDefault(guestId, "Unknown");
            System.out.printf("  - Guest: %s (ID: %d), Average Stay: %.2f days%n", guestName, guestId, avgDuration);
        });
    }

    // Use Case 4
    public static void getRevenueByRoomType(List<Booking> bookings, List<Room> rooms) {
        Map<Integer, Room> roomMap = rooms.stream()
                .collect(Collectors.toMap(Room::getRoomId, Function.identity()));

        Map<String, Double> revenueByType = bookings.stream()
                .collect(Collectors.groupingBy(
                        booking -> roomMap.get(booking.getRoomId()).getType(),
                        Collectors.summingDouble(booking -> {
                            long duration = ChronoUnit.DAYS.between(booking.getCheckIn(), booking.getCheckOut());
                            // THIS LINE IS NOW CORRECTED
                            double price = roomMap.get(booking.getRoomId()).getRoomPrice();
                            return duration * price;
                        })
                ));

        System.out.println("Total revenue by room type:");
        revenueByType.forEach((type, total) -> System.out.printf("  - %s: ₹%.2f%n", type, total));
    }

    // Use Case 5
   

    public static void showTopGuests(List<Booking> bookings, List<Guest> guests) {
        Map<Integer, String> guestMap = guests.stream()
                .collect(Collectors.toMap(Guest::getGuestId, Guest::getName));

        Map<Integer, Integer> stayCounts = new HashMap<>();
        for (Booking booking : bookings) {
            int guestId = booking.getGuestId();
            stayCounts.put(guestId, stayCounts.getOrDefault(guestId, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedGuests = new ArrayList<>(stayCounts.entrySet());
        
        sortedGuests.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        System.out.println("Top 3 guests by number of stays:");
        int limit = Math.min(3, sortedGuests.size());

        for (int i = 0; i < limit; i++) {
            Map.Entry<Integer, Integer> entry = sortedGuests.get(i);
            int guestId = entry.getKey();
            int count = entry.getValue();
            String guestName = guestMap.getOrDefault(guestId, "Unknown");
            
            System.out.printf("  - %s (ID: %d) with %d stays.%n", guestName, guestId, count);
        }
    }
}