
public class FlightAnalyzer {

    public static void main(String[] args) {
        VvoToTlvTicketsList vvoToTlvTicketsList = new VvoToTlvTicketsList();
        MinFly minFly = new MinFly(vvoToTlvTicketsList);
        OutMinFly.out(minFly);
        DifferencePrice differencePrice = new DifferencePrice(vvoToTlvTicketsList);
        OutDifferencePrice.out(differencePrice);
    }
}
