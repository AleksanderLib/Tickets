import java.util.Comparator;
import java.util.List;
    // Класс для разницы между средней ценой и медианой
    public class DifferenceFly {
        private double averagePrice;
        private  int medianDuration;
        private double difference;
        public DifferenceFly() {
/*
        FlightJson flightJson = new FlightJson();
        difference = averagePrice - medianDuration;
        averagePrice = calculateAveragePrice(flightJson.tickets.getFlights());
        medianDuration = calculateMedianPrice(flightJson.tickets.getFlights());
*/
        }

/*

    private static double calculateAveragePrice(List<FlightJson.Flight> flights) {
        double totalPrice = 0;
        for (FlightJson.Flight flight : flights) {
            totalPrice += flight.getPrice();
        }
        flights.size();
        return totalPrice / flights.size();
    }

    private static int calculateMedianPrice(List<FlightJson.Flight> flights) {
        flights.sort(Comparator.comparingInt(FlightJson.Flight::getPrice));
        if (flights.size() % 2 == 0) {
            int index = flights.size() / 2;
            return (flights.get(index - 1).getPrice() + flights.get(index).getPrice()) / 2;
        } else {
            return flights.get((flights.size() - 1) / 2).getPrice();
        }
    }
*/

        @Override
        public String toString() {
            return String.valueOf(difference);
        }
    }


