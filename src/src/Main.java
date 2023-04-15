import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        VolgaApi volga = new VolgaApi();
        try {
            List<RouteInfo> routes = volga.get_routes();
            System.out.println("Все маршруты: " + routes.toString());

            RouteInfo route = routes.get(0);
            RouteInfo got_route = volga.get_route(route.route_id);
            System.out.println("Получен маршрут из запроса: " + got_route.name);

            List<Station> stations = volga.get_stations();
            System.out.println("Все станции: " + stations.toString());

            Station first_station = stations.get(0);
            System.out.println("Первая станция: " + first_station.name);

            List<Route> route_list = volga.get_station_routes(first_station.station_id);
            System.out.println("Маршруты этой остановки: " + route_list.toString());

            Route route1 = route_list.get(0);
            System.out.println("Первый маршрут: " + route1.station.name);

    } catch (Exception e) {
        System.out.println("Error: " + e);
        }
    }
}
