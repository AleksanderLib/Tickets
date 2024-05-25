import java.util.HashMap;
//Класс для минимального время полета
public class MinFly {
    HashMap<String, Integer> minDurations;

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        for (String carrier : minDurations.keySet()) {
            result.append(carrier).append(": ").append(minDurations.get(carrier)).append(" часов\n");
        }
        return result.toString();
    }

    public MinFly() {
        HashMap<String, Integer> minDurations = getMinDurations();
    }

    private HashMap<String, Integer> getMinDurations() {
        minDurations = new HashMap<>();
        FlightJson flightJson = new FlightJson();
        for (FlightJson.Flight flight : flightJson.tickets.getFlights()) {
            if (!minDurations.containsKey(flight.getCarrier())) {
                minDurations.put(flight.getCarrier(), flight.getDuration());
            } else {
                int currentMin = minDurations.get(flight.getCarrier());
                minDurations.put(flight.getCarrier(), Math.min(currentMin, flight.getDuration()));
            }
        }
        return minDurations;
    }
}