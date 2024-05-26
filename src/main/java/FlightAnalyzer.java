
public class FlightAnalyzer {

    public static void main(String[] args) {
        MinFly minFly = new MinFly(new ParseTicketsJson(), new VvoToTlvTicketsList());
        OutMinFly.out(minFly);
        DifferencePrice differencePrice = new DifferencePrice(new ParseTicketsJson(), new VvoToTlvTicketsList());
        OutDifferencePrice.out(differencePrice);
    }
}
