import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        VolgaApi volga = new VolgaApi();
        try {
            List<RouteInfo> routes = volga.getRoutes();
            System.out.println("All routes: " + routes.toString());

            RouteInfo route = routes.get(0);
            RouteInfo got_route = volga.getRoute(route.route_id);
            System.out.println("First route: " + got_route.name);

            List<Station> stations = volga.getStations();
            System.out.println("All stations: " + stations.toString());

            Station first_station = stations.get(0);
            System.out.println("First station: " + first_station.name);

            List<Route> route_list = volga.getStationRoutes(first_station.station_id);
            System.out.println("All routes of this station: " + route_list.toString());

            Route route1 = route_list.get(0);
            System.out.println("First route: " + route1.station.name);

            List<Location> locations = volga.getLocations();
            int location_length = locations.toArray().length;
            System.out.println("Total locations (cities): " + Integer.toString(location_length));

            Location location = locations.get(0);
            System.out.println("First location: " + location.name);




    } catch (Exception e) {
        System.out.println("Error: " + e);
        }
    }
}
