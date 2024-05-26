import Model.TicketModel;
import Model.TicketsModel;

public class FlightAnalyzer {

    public static void main(String[] args) {
        TicketModel ticketModel = new TicketModel();
        TicketsModel ticketsModel = new TicketsModel();
        /*ParseTicketsJson fj = new ParseTicketsJson();
        fj.ReadJson(ticketsModel);*/
        MinFly minFly = new MinFly(new ParseTicketsJson());
        OutMinFly.out(minFly);


        //List<TicketModel> tickets = fj.ticketsModel.getTickets();
        /*MinFly fj = new MinFly();
        System.out.println("Минимальное время полета между городами Владивосток и Тель-Авив:");
        System.out.println(fj.toString());
        System.out.println("Разницу между средней ценой  и медианой");
        differenceFly df = new differenceFly();
        System.out.println(df.toString());*/
    }
}
