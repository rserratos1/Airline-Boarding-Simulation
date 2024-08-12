package A9_2;
import java.util.*;
import java.io.*;

public class Flight {
    
    private String flightName;
    private int seats;
    private int seatsSold;
    private Random randy;
    LinkedList<Passenger> passBooked = new LinkedList<>();//contains Passengers
    PriorityQueue<Passenger> boardingQueue = new PriorityQueue<>(new PassengerComparator()); // orders based on the PassengerComparator
    
    public Flight(String flightName, int seed){
        setFlightName(flightName);
        randy = new Random(seed);
        setSeats();
    }
    
    public void setFlightName(String flightName){
        this.flightName = flightName;
    }
    
    public void setSeats(){
        this.seats = randy.nextInt(75, 151);
    }
    
    public void sellSeats(){
        this.seatsSold = randy.nextInt(0, 1 + (seats/2)) + (seats/2);
        
        for(int i = 0; i < this.seatsSold; i++){
            int num = randy.nextInt(0, 5);
            
            if(num == 0){
                passBooked.add(new FirstClassPassenger());
            }
            else{
                passBooked.add(new CoachPassenger());
            }
        }
    }
    
    public void lineUpCall(){
        //Use an iterator to add each Passenger in passBooked to boardingQueue
        
        Collections.sort(passBooked, new PassengerComparator());
        
        Iterator<Passenger> iterPassengers = passBooked.iterator();
        
        while(iterPassengers.hasNext()){
            boardingQueue.offer(iterPassengers.next());
        }
    }
    
    public void boarding(PrintWriter outputWriter) throws IOException{
        
        outputWriter.printf("The boarding order for Flight %s with %d seats and %d seats sold is:\n", flightName, seats, seatsSold);
        
        Iterator<Passenger> iterPassenger = boardingQueue.iterator();
        
        while(iterPassenger.hasNext()){
            outputWriter.printf("%15s", iterPassenger.next().toString());
            if(iterPassenger.hasNext()){
                outputWriter.printf("%15s", iterPassenger.next().toString());
            }
            if(iterPassenger.hasNext()){
                outputWriter.printf("%15s\n", iterPassenger.next().toString());
            }
        }
    }
}