package Model;

import java.util.Date;

public class TicketModel {
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
}

