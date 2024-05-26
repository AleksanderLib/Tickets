import Model.TicketModel;
import Model.TicketsModel;

import java.util.List;
import java.util.stream.Collectors;

public class VvoToTlvTicketsList {

    private static List<TicketModel> vvoToTlvTickets;

    public List<TicketModel> getVvoToTlvTickets(ParseTicketsJson parseTicketsJson) {
        vvoToTlvTickets = parseTicketsJson.readJson(new TicketsModel())
                .stream()
                .filter(t -> t.getOrigin().equals("VVO") && t.getDestination().equals("TLV"))
                .collect(Collectors.toList());
        return vvoToTlvTickets;
    }


}
