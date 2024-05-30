import Model.TicketModel;
import Model.TicketsModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class MinFly {
    private Date dateDeparture;
    private Date dateArrival;

    Map<String, Integer> minFlightTimeByCarrier;

    public MinFly(VvoToTlvTicketsList vvoToTlvTicketsList) {
        minFlightTimeByCarrier = getMinFlightTimeByCarrier( vvoToTlvTicketsList);
    }

    private Map<String, Integer> getMinFlightTimeByCarrier(VvoToTlvTicketsList vvoToTlvTicketsList) {
        minFlightTimeByCarrier = new HashMap<>();
        minFlightTimeByCarrier = vvoToTlvTicketsList.vvoToTlvTickets.stream()
                .collect(Collectors.toMap(
                        TicketModel::getCarrier,
                        this::calculateFlightTimeInHoursNew,
                        (currentFlightTime, currentFlightTime2) -> Math.min(currentFlightTime, currentFlightTime2),
                        LinkedHashMap::new
                ));
        return minFlightTimeByCarrier;
    }

    private int calculateFlightTimeInHours(TicketModel ticket) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy HH:mm", Locale.ENGLISH);
        try {
            dateDeparture = sdf.parse(ticket.getDeparture_date()+ " " +ticket.getDeparture_time());
            dateArrival = sdf.parse(ticket.getArrival_date()+" "+ticket.getArrival_time());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ((int)(dateArrival.getTime() - dateDeparture.getTime()) / (60*1000));
    }

    private int calculateFlightTimeInHoursNew(TicketModel ticket) {
        StringBuilder departureStringBuilder = new StringBuilder();
        departureStringBuilder.append(ticket.getDeparture_date()).append(" ").append(ticket.getDeparture_time());
        StringBuilder arrivalStringBuilder = new StringBuilder();
        arrivalStringBuilder.append(ticket.getArrival_date()).append(" ").append(ticket.getArrival_time());

        Date departureDate = null;
        Date arrivalDate = null;
        try {
            departureDate = new SimpleDateFormat("dd.MM.yy HH:mm", Locale.ENGLISH).parse(departureStringBuilder.toString());
            arrivalDate = new SimpleDateFormat("dd.MM.yy HH:mm", Locale.ENGLISH).parse(arrivalStringBuilder.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        return (int) ((arrivalDate.getTime() - departureDate.getTime()) / (60 * 1000));
    }
}
