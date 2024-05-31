import Model.TicketModel;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;

public class MinFly {
    private LocalDateTime dateDeparture;
    private LocalDateTime dateArrival;

    Map<String, Integer> minFlightTimeByCarrier;

    public MinFly(VvoToTlvTicketsList vvoToTlvTicketsList) {
        minFlightTimeByCarrier = getMinFlightTimeByCarrier( vvoToTlvTicketsList);
    }

    private Map<String, Integer> getMinFlightTimeByCarrier(VvoToTlvTicketsList vvoToTlvTicketsList) {
        minFlightTimeByCarrier = new HashMap<>();
        minFlightTimeByCarrier = vvoToTlvTicketsList.vvoToTlvTickets.stream()
                .collect(Collectors.toMap(
                        TicketModel::getCarrier,
                        this::calculateFlightTime,
                        (currentFlightTime, currentFlightTime2) -> Math.min(currentFlightTime, currentFlightTime2),
                        LinkedHashMap::new
                ));
        return minFlightTimeByCarrier;
    }

    private int calculateFlightTime(TicketModel ticket) {
        dateArrival = LocalDateTime.of(ticket.getArrival_date(),LocalTime.of(ticket.getArrival_time().getHours(),ticket.getArrival_time().getMinutes()));
        dateDeparture = LocalDateTime.of(ticket.getDeparture_date(),LocalTime.of(ticket.getDeparture_time().getHours(),ticket.getDeparture_time().getMinutes()));
        int rez = (int) (ChronoUnit.MINUTES.between(dateArrival,dateDeparture) /-1);
        return rez;
    }
}
