import com.skillbox.airport.Airport;
import transport.*;  // .Car
import java.util.TreeMap;
import java.lang.*;

public class Main
{
    public static void main(String[] args) {
/*
        String name = "";
        TreeMap<String, String> map;

        Car car = new Car();
        // transport.Car car = transport.Car(); // можно написать вот так и не вызывать библиотеку
                                                // import transport.Car
        // import transport.Car; // Но чтоб не писать много лишних слов придумали эту библиотеку.
 */
        Airport airport = Airport.getInstance();
        System.out.println(airport.getAllAircrafts());
        System.out.println(airport.getAllAircrafts().stream().count());
//        System.out.println(airport.getAllAircrafts().size()); // Как вариант вывод количества самолетов

    }
}
