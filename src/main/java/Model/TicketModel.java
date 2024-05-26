package Model;

import java.util.Date;

public class TicketModel {
    private String origin;
    private  String origin_name;
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
        this.arrival_time = arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getOrigin() {
            return origin;
        }

        public String getOrigin_name() {
            return origin_name;
        }

        public String getDestination() {
            return destination;
        }

        public String getDestination_name() {
            return destination_name;
        }

        public String getDeparture_date() {
            return departure_date;
        }

        public Date getDeparture_time() {
            return departure_time;
        }

        public String getArrival_date() {
            return arrival_date;
        }

        public Date getArrival_time() {
            return arrival_time;
        }

        public String getCarrier() {
            return carrier;
        }

        public int getStops() {
            return stops;
        }

        public int getPrice() {
            return price;
        }
    }

