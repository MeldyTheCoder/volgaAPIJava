import java.net.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;

public class VolgaApi {
    // final String[] methods = {"POST", "GET", "PUT", "DELETE"};
    public Gson gson = new Gson();

    public String get(String url) throws Exception {
        URL urlobj = new URL(url);
        URLConnection connection = urlobj.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String output = in.readLine();
        return output;
    }
    public List<RouteInfo> getRoutes() throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/routes";
        String output = this.get(url);
        List<RouteInfo> route_list = Arrays.asList(this.gson.fromJson(output, RouteInfo[].class));
        return route_list;

    }
    public RouteInfo getRoute(int route_id) throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/routes/" + route_id;
        String output = this.get(url);
        RouteInfo route = this.gson.fromJson(output, RouteInfo.class);
        return route;

    }

    public List<Station> getStations() throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/stations";
        String output = this.get(url);
        List<Station> station_list = Arrays.asList(this.gson.fromJson(output, Station[].class));
        return station_list;
    }

    public List<Route> getStationRoutes(int station_id) throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/stations/" + Integer.toString(station_id) + "/schedules/nearest";
        String output = this.get(url);
        List<Route> route_list = Arrays.asList(this.gson.fromJson(output, Route[].class));
        return route_list;

    }

    public List<Vehicle> getVehicles() throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/vehicles?period=180";
        String output = this.get(url);
        List<Vehicle> vehicle_list = Arrays.asList(this.gson.fromJson(output, Vehicle[].class));
        return vehicle_list;
    }

    public List<Station> getVehicleEstimatedArrivals(String vehicle_id) throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/vehicle/" + vehicle_id + "/estimated-arrivals";
        String output = this.get(url);
        List<Station> station_list = Arrays.asList(this.gson.fromJson(output, Station[].class));
        return station_list;
    }

    public Vehicle getVehicle(String vehicle_id) throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/vehicle/" + vehicle_id;
        String output = this.get(url);
        Vehicle vehicle = this.gson.fromJson(output, Vehicle.class);
        return vehicle;
    }

    public List<Location> getLocations() throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/locations";
        String output = this.get(url);
        List<Location> location_list = Arrays.asList(this.gson.fromJson(output, Location[].class));
        return location_list;
    }


}
