import Model.TicketModel;
import java.util.List;

    public class DifferencePrice {
        private  double averagePrice;
        private  double medianPrice;
        public double difference;
        public DifferencePrice(VvoToTlvTicketsList vvoToTlvTicketsList) {
            calculateDifferencePrice(vvoToTlvTicketsList.vvoToTlvTickets);
        }


    public double calculateDifferencePrice(List<TicketModel> vvoToTlvTicketsList) {
        List<TicketModel> vvoToTlvTickets = vvoToTlvTicketsList.stream().sorted().toList();
        averagePrice = getAveragePrice(vvoToTlvTickets);
            medianPrice = getMedianPrice(vvoToTlvTickets);
            difference = Math.abs(averagePrice - medianPrice);
            return  difference;
        }

        private double getAveragePrice(List<TicketModel> vvoToTlvTickets) {

            averagePrice = vvoToTlvTickets.stream()
                    .mapToDouble(TicketModel::getPrice)
                    .average()
                    .orElse(0);
            return averagePrice;
        }

        private double getMedianPrice(List<TicketModel> vvoToTlvTickets) {
            if( vvoToTlvTickets.size() % 2 == 1 )
            {
                return vvoToTlvTickets.get(vvoToTlvTickets.size() / 2).getPrice();
            }
            else
            {
                medianPrice = (vvoToTlvTickets.get(vvoToTlvTickets.size()/2).getPrice()+vvoToTlvTickets.get(vvoToTlvTickets.size()/2-1).getPrice())/2;
            }
            return medianPrice;
        }
    }


