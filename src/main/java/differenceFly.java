import java.util.Comparator;
import java.util.List;
// Класс для разницы между средней ценой и медианой
public class differenceFly extends FlightJson {
    private double averagePrice;
    private  int medianDuration;
    private double difference;
    public differenceFly() {
        averagePrice = calculateAveragePrice(tickets.getFlights());
        medianDuration = calculateMedianPrice(tickets.getFlights());
        difference = averagePrice - medianDuration;
    }


    private static double calculateAveragePrice(List<Flight> flights) {
        double totalPrice = 0;
        for (Flight flight : flights) {
            totalPrice += flight.getPrice();
        }
        flights.size();
        return totalPrice / flights.size();
    }

    private static int calculateMedianPrice(List<Flight> flights) {
        flights.sort(Comparator.comparingInt(Flight::getPrice));
        if (flights.size() % 2 == 0) {
            int index = flights.size() / 2;
            return (flights.get(index - 1).getPrice() + flights.get(index).getPrice()) / 2;
        } else {
            return flights.get((flights.size() - 1) / 2).getPrice();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(difference);
    }
}
