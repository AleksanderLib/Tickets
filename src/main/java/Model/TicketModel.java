package Model;

import java.util.Date;

public class TicketModel implements Comparable<TicketModel> {
    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private String departure_date;
    private Date departure_time;
    private String arrival_date;
    private Date arrival_time;
    private String carrier;
    private int stops;
    private int price;

    public TicketModel() {

    }

    public String getOrigin_name() {
        return origin_name;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public int getStops() {
        return stops;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public String getCarrier() {
        return carrier;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(TicketModel ticketModel) {
        return Integer.compare(ticketModel.price, this.price);
    }
}

