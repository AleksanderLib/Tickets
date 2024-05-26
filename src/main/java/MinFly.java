import Model.TicketModel;

import java.util.*;
import java.util.stream.Collectors;

public class MinFly {
    Map<String, Integer> minFlightTimeByCarrier;

    public MinFly(ParseTicketsJson parseTicketsJson, VvoToTlvTicketsList vvoToTlvTicketsList) {
        minFlightTimeByCarrier = getMinFlightTimeByCarrier(parseTicketsJson, vvoToTlvTicketsList);
    }

    private Map<String, Integer> getMinFlightTimeByCarrier(ParseTicketsJson parseTicketsJson, VvoToTlvTicketsList vvoToTlvTicketsList) {
        minFlightTimeByCarrier = new HashMap<>();
        minFlightTimeByCarrier = vvoToTlvTicketsList.getVvoToTlvTickets(parseTicketsJson).stream()
                .collect(Collectors.toMap(
                        TicketModel::getCarrier,
                        this::calculateFlightTimeInHours,
                        (currentFlightTime, currentFlightTime2) -> Math.min(currentFlightTime, currentFlightTime2),
                        LinkedHashMap::new
                ));
        return minFlightTimeByCarrier;

    }

    private int calculateFlightTimeInHours(TicketModel ticket) {
        return (int) ((ticket.getArrival_time().getTime() - ticket.getDeparture_time().getTime()) / (60 * 60 * 1000));
    }
}
