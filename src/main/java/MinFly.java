import org.json.simple.JSONObject;
import java.util.HashMap;
//Класс для минимального время полета
public class MinFly extends FlightJson {
    private String origin;
    private  String destination;
    private String carrier;
    private  int duration;
    HashMap<String, Integer> minDurations = new HashMap<>();

    public MinFly() {
        calculateMin();

    }

    private void calculateMin() {
        for (int i = 0; i < flights.size(); i++) {
            JSONObject flight = (JSONObject) flights.get(i);
            origin = (String) flight.get("origin");
            destination = (String) flight.get("destination");
            carrier = (String) flight.get("carrier");
            duration = ((Long) flight.get("duration")).intValue();


            if (origin.equals("Vladivostok") && destination.equals("TelAviv")) {
                if (minDurations.containsKey(carrier)) {
                    minDurations.put(carrier, Math.min(minDurations.get(carrier), duration));
                } else {
                    minDurations.put(carrier, duration);
                }
            }
        }
    }

    public void outMinFly() {
        System.out.println("Минимальное время полета между городами Владивосток и Тель-Авив:");
        for (String carrier : minDurations.keySet()) {
            System.out.println(carrier + ": " + minDurations.get(carrier) + " часов");
        }
    }


}
