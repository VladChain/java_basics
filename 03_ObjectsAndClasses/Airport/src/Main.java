import com.skillbox.airport.Airport;
import transport.*;   //.Car;
import java.util.TreeMap;
import java.lang.*;

public class Main
{
    public static void main(String[] args) {
/*
        String name = "";
        TreeMap<String, String> map;

        Car car = new Car();
        //  transport.Car car = transport.Car(); // можно написать вот так и не вызывать
        //  import transport.Car; Но чтоб не писать много лишних
        // слов придумали эту библиотеку.
 */
        Airport airport = Airport.getInstance();
        airport.getAllAircrafts();
        System.out.println(airport.getAllAircrafts());
    }
}