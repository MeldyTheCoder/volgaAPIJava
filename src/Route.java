import java.util.List;

public class Route extends BaseObject {
    public RouteInfo route;
    public int route_id;
    public Station station;
    public int station_id;
    public List<VehicleArrive> vehicle_arrival_time;
}
