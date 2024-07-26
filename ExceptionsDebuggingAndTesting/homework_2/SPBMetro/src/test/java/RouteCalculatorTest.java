import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    RouteCalculator routeCalculator;
    StationIndex stationIndex;

    protected void setUp() throws Exception{
        route = new ArrayList<>();
        stationIndex=new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1,"Синяя");
        Line line2 = new Line(2,"Зеленая");
        Line line3 = new Line(3,"Красная");

        Station station1 = new Station("Горьковская",line1);
        Station station2 = new Station("Невский проспект",line1);
        Station station3 = new Station("Гостинный двор",line2);
        Station station4 = new Station("Маяковская",line2);
        Station station5 = new Station("Площадь",line3);
        Station station6 = new Station("Чернышевская",line3);

        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);
        route.add(station6);

        stationIndex.addLine(line1);
        stationIndex.addStation(station1);
        stationIndex.addStation(station2);

        stationIndex.addLine(line2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);

        stationIndex.addLine(line3);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);

        stationIndex.getLine(1).addStation(station1);
        stationIndex.getLine(1).addStation(station2);
        stationIndex.getLine(2).addStation(station3);
        stationIndex.getLine(2).addStation(station4);
        stationIndex.getLine(3).addStation(station5);
        stationIndex.getLine(3).addStation(station6);

        stationIndex.addConnection(Arrays.asList(stationIndex.getStation("Невский проспект"),
                stationIndex.getStation("Гостинный двор")));
        stationIndex.addConnection(Arrays.asList(stationIndex.getStation("Маяковская"),
                stationIndex.getStation("Площадь")));

    }

    public void testCalculateDuration(){
        double current = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected,current);
    }


    public  void testGetShortestRoute(){
        List<Station> current = routeCalculator.getShortestRoute(stationIndex.getStation("Горьковская"),
                stationIndex.getStation("Маяковская"));
        List<Station> expected = Arrays.asList(route.get(0),route.get(1),route.get(2),route.get(3));
        assertEquals(expected,current);
    }

    public  void testGetRouteOnTheLine(){
        List<Station> current = routeCalculator.getShortestRoute(stationIndex.getStation("Горьковская"),
                stationIndex.getStation("Невский проспект"));
        List<Station> expected = Arrays.asList(route.get(0),route.get(1));
        assertEquals(expected,current);
    }

    public void testGetRouteWithOneConnection(){
        List<Station> current = routeCalculator.getShortestRoute(stationIndex.getStation("Маяковская"),
                stationIndex.getStation("Площадь"));
        List<Station>  expected = Arrays.asList(route.get(3),route.get(4));
        assertEquals(expected,current);
    }

    public void testGetRouteWithTwoConnection(){
        List<Station> current = routeCalculator.getShortestRoute(stationIndex.getStation("Горьковская")
                ,stationIndex.getStation("Площадь"));
        List<Station> expected = Arrays.asList(stationIndex.getStation("Горьковская"),
                stationIndex.getStation("Невский проспект"),
                stationIndex.getStation("Гостинный двор"),
                stationIndex.getStation("Маяковская"),
                stationIndex.getStation("Площадь"));
        assertEquals(expected,current);
    }

    @Override
    protected  void  tearDown() throws Exception{
        super.tearDown();
    }
}
