package FoodDeliveryApp.Level2;

//4. Movie Ticket Booking System
public class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;

    public MovieTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public void bookTicket(String seat, double ticketPrice) {
        this.seatNumber = seat;
        this.price = ticketPrice;
        System.out.println("Ticket booked successfully!");
    }

    public void displayDetails() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Avengers", "", 0);
        ticket.bookTicket("A12", 250);
        ticket.displayDetails();
    }
}

