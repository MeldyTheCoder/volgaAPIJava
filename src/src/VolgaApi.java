import java.net.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
public class VolgaApi {
    public Gson gson = new Gson();
    public String request(String url) throws Exception {
        URL urlobj = new URL(url);
        URLConnection connection = urlobj.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String output = in.readLine();
        return output;
    }

    public List<RouteInfo> get_routes() throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/routes";
        String output = this.request(url);
        List<RouteInfo> route_list = Arrays.asList(this.gson.fromJson(output, RouteInfo[].class));
        return route_list;

    }

    public RouteInfo get_route(int route_id) throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/routes/" + route_id;
        String output = this.request(url);
        RouteInfo route = this.gson.fromJson(output, RouteInfo.class);
        return route;

    }

    public List<Station> get_stations() throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/stations";
        String output = this.request(url);
        List<Station> station_list = Arrays.asList(this.gson.fromJson(output, Station[].class));
        return station_list;
    }

    public List<Route> get_station_routes(int station_id) throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/stations/" + station_id + "/schedules/nearest";
        String output = this.request(url);
        List<Route> route_list = Arrays.asList(this.gson.fromJson(output, Route[].class));
        return route_list;
    }

    public List<WalletPreset> get_wallet_presets() throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/wallets/presets?wallet_categories=2%2C4%2C5%2C6";
        String output = this.request(url);
        List<WalletPreset> walletpreset_list = Arrays.asList(this.gson.fromJson(output, WalletPreset[].class));
        return walletpreset_list;
    }

    public String get_tickets() throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/tickets";
        String output = this.request(url);
        return output;
    }

    public List<City> get_cities() throws Exception {
        String url = "https://api-gds.odnakassa.ru/city/list/to?query=&agent_id=273";
        String output = this.request(url);
        List<City> city_list = Arrays.asList(this.gson.fromJson(output, City[].class));
        return city_list;
    }

    public List<Location> get_locations() throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/locations";
        String output = this.request(url);
        List<Location> location_list = Arrays.asList(this.gson.fromJson(output, Location[].class));
        return location_list;
    }

    public List<GeneratedRoute> make_route(Station station_from, Station station_to) throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/paths-by-coords?";

        Map<String, String> data = new HashMap<>();
        data.put("start_type_id", "2");
        data.put("end_type_id", "2");
        data.put("save_start", "true");
        data.put("save_end", "true");

        data.put("start_lat", Double.toString(station_from.lat));
        data.put("start_lng", Double.toString(station_from.lng));

        data.put("end_lat", Double.toString(station_to.lat));
        data.put("end_lng", Double.toString(station_to.lng));

        List<String> args = new ArrayList<>();

        for (Map.Entry<String, String> entry: data.entrySet()) {
            args.add(entry.getKey() + '=' + entry.getValue());
        }

        url = url + String.join(",", args);
        String output = this.request(url);
        List<GeneratedRoute> generatedroute_list = Arrays.asList(this.gson.fromJson(output, GeneratedRoute[].class));
        return generatedroute_list;
    }

    public List<TimeTable> get_station_timetable(Station station) throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/stations/" + Integer.toString(station.station_id) + "/schedules";
        String output = this.request(url);
        List<TimeTable> timetable_list = Arrays.asList(this.gson.fromJson(output, TimeTable[].class));
        return timetable_list;
    }

    public Vehicle get_vehicle(String vehicle_id) throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/vehicle/" + vehicle_id;
        String output = this.request(url);
        Vehicle vehicle_data = this.gson.fromJson(output, Vehicle.class);
        return vehicle_data;
    }

    public List<Vehicle> get_vehicles() throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/vehicles?period=180";
        String output = this.request(url);
        List<Vehicle> vehicle_list = Arrays.asList(this.gson.fromJson(output, Vehicle[].class));
        return vehicle_list;
    }

    public List<Station> get_vehicle_estimated_arrivals() throws Exception {
        String url = "https://api.merlin.tvercard.ru/api/client/v1/vehicle/{vehicle_id}/estimated-arrivals";
        String output = this.request(url);
        List<Station> station_list = Arrays.asList(this.gson.fromJson(output, Station[].class));
        return station_list;
    }


}
