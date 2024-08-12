package A9_2;

public class Passenger {
    private String passengerID;
    private String ticketClass;
    private int ticketNumber;
    
    static int ticketCounter = 0;
    
    public Passenger(String ticketClass){
        setTicketNumber();
        setTicketClass(ticketClass);
        setPassengerID();
    }

    private void setTicketNumber() {
        ticketCounter++;
        this.ticketNumber = ticketCounter;
    }

    private void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    private void setPassengerID() {
        this.passengerID = "PID_" + this.ticketClass + this.ticketNumber;
    }
    
    public int getTicketNumber(){
        return this.ticketNumber;
    }
    
    public String getTicketclass(){
        return this.ticketClass;
    }
    
    public String getPassengerID(){
        return this.passengerID;
    }
    
    public String toString(){
        return String.format("%s", passengerID);
    }
}
