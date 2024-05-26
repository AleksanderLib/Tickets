import Model.TicketModel;
import Model.TicketsModel;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

//Класс для минимального время полета
public class MinFly {
    HashMap<String, Integer> minFlightTimeByCarrier;
    public MinFly(ParseTicketsJson parseTicketsJson) {
        minFlightTimeByCarrier = getMinFlightTimeByCarrier(parseTicketsJson);
    }
    private HashMap<String, Integer> getMinFlightTimeByCarrier(ParseTicketsJson parseTicketsJson) {
        minFlightTimeByCarrier = new HashMap<>();

        List<TicketModel> vvoToTlvTickets = parseTicketsJson.ReadJson(new TicketsModel())
                .stream()
                .filter(t -> t.getOrigin().equals("VVO") && t.getDestination().equals("TLV"))
                .collect(Collectors.toList());
        for (TicketModel ticket : vvoToTlvTickets) {
            if (!minFlightTimeByCarrier.containsKey(ticket.getCarrier())) {
                minFlightTimeByCarrier.put(ticket.getCarrier(), calculateFlightTimeInHours(ticket));
            } else {
                int currentFlightTime = calculateFlightTimeInHours(ticket);
                if (currentFlightTime < minFlightTimeByCarrier.get(ticket.getCarrier())) {
                    minFlightTimeByCarrier.put(ticket.getCarrier(), currentFlightTime);
                }
            }
        }
        return minFlightTimeByCarrier;
    }

    private static int calculateFlightTimeInHours(TicketModel ticket) {
        return (int) ((ticket.getArrival_time().getTime() - ticket.getDeparture_time().getTime()) / (60 * 60 * 1000));
    }
}