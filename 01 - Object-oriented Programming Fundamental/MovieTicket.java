class MovieTicket{
    private String movieName;
    private int seatNumber;
    private double price;
    private boolean isBooked;

    public MovieTicket(String movieName, int seatNumber, double price){
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isBooked = false;
    }

    public void bookTicket(){
        if (!isBooked){
            isBooked = true;
            System.out.println("Ticket booked successfully for " + movieName + " (Seat: " + seatNumber + ", Price: " + price + ")");
        }else{
            System.out.println("Seat " + seatNumber + " is already booked.");
        }
    }

    public void displayTicketDetails(){
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
        System.out.println("Booking Status: " + (isBooked ? "Booked" : "Available"));
    }

    public static void main(String[] args){
        MovieTicket ticket = new MovieTicket("Inception", 12, 250.0);
        ticket.displayTicketDetails();
        ticket.bookTicket();
        ticket.displayTicketDetails();
    }
}
