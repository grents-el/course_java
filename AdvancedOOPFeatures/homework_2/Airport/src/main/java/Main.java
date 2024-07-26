import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        findPlanesLeavingInTheNextTwoHours(airport);


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        return airport.getTerminals().stream().flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType()==Flight.Type.DEPARTURE)
                .filter(flight -> isTime(flight.getDate())).collect(Collectors.toList());
    }

    public static boolean isTime(Date date){
        LocalDateTime dateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime timeNow = LocalDateTime.now();
        LocalDateTime timeAfter2H =timeNow.plusHours(2);
        return dateTime.getHour() > timeNow.getHour() && dateTime.getHour() < timeAfter2H.getHour();
    }

}