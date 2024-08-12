package A9_2;

import java.util.Comparator;

public class PassengerComparator implements Comparator<Passenger>{

    public int compare(Passenger a, Passenger b) {
        int classCompare = b.getTicketclass().compareTo(a.getTicketclass());
        int numCompare = a.getTicketNumber() - b.getTicketNumber();
        
        if(classCompare == 0){
            return (numCompare == 0) ? classCompare : numCompare;
        }
        else return classCompare;
    }    
}
