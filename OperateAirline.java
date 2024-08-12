package A9_2;
import java.util.*;
import java.io.*;

public class OperateAirline {
    public static void main(String[] args) throws IOException{
        ArrayList<Flight> flightList = new ArrayList<>();
        
        Scanner keyboard = new Scanner(System.in);
        String name;
        int seed;
        
        for(int i = 0; i < 3; i++){
            System.out.println("Please enter the Flight Name:");
            name = keyboard.nextLine();
            System.out.println("Please enter an integer seed from 1 to 50:");
            seed = keyboard.nextInt();
            flightList.add(new Flight(name, seed));
            keyboard.nextLine();
        }
        
        System.out.println("Please enter the name of the output file:");
        File outputFile = new File(keyboard.next());
        PrintWriter outputWriter = new PrintWriter(outputFile);
        
        for(Flight container: flightList){
            container.sellSeats();
            container.lineUpCall();
            container.boarding(outputWriter);
            outputWriter.print("\n\n");
        }
        
        outputWriter.close();
    }
}
