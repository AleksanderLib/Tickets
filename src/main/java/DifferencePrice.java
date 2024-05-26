import Model.TicketModel;

import java.util.List;

    public class DifferencePrice {
        private  double averagePrice;
        private  double medianPrice;
        public double difference;
        public DifferencePrice(ParseTicketsJson parseTicketsJson, VvoToTlvTicketsList vvoToTlvTicketsList) {
            calculateDifferencePrice(parseTicketsJson,vvoToTlvTicketsList);
        }


    public double calculateDifferencePrice(ParseTicketsJson parseTicketsJson,VvoToTlvTicketsList vvoToTlvTicketsList) {

            List <TicketModel> vvoToTlvTickets = vvoToTlvTicketsList.getVvoToTlvTickets(parseTicketsJson);
            averagePrice = getAveragePrice(vvoToTlvTickets);
            medianPrice = getMedianPrice(vvoToTlvTickets);
            difference = Math.abs(averagePrice - medianPrice);
            return  difference;
        }

        private double getAveragePrice(List<TicketModel> vvoToTlvTickets) {

            double averagePrice = vvoToTlvTickets.stream()
                    .mapToDouble(TicketModel::getPrice)
                    .average()
                    .orElse(0);
            return averagePrice;
        }

        private double getMedianPrice(List<TicketModel> vvoToTlvTickets) {
            double medianPrice = vvoToTlvTickets.size() % 2 == 0 ?
                    vvoToTlvTickets.get((vvoToTlvTickets.size() / 2) - 1).getPrice() :
                    vvoToTlvTickets.get(vvoToTlvTickets.size() / 2).getPrice();
            return medianPrice;
        }
    }


