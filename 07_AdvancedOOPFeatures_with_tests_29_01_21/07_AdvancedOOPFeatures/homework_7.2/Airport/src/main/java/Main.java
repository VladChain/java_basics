import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.util.*;
import java.util.stream.Collectors;

import static com.skillbox.airport.Flight.Type.DEPARTURE;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Flight> flightList = findPlanesLeavingInTheNextTwoHours(airport);
        System.out.println(flightList);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        List<Flight> flightList = new ArrayList<>();
        List<Terminal> terminalList = airport.getTerminals();
        for (Terminal terminal : terminalList) {
            flightList.addAll(terminal.getFlights());
        }

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.HOUR, 2);

        return flightList.stream()
                .filter(t -> t.getType().equals(DEPARTURE))
                .filter(f1 -> f1.getDate().after(calendar1.getTime()))
                .filter(f2 -> f2.getDate().before(calendar2.getTime()))
                .collect(Collectors.toList());
    }
}