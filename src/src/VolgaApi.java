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
}
