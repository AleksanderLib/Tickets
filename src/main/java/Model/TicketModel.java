package Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class TicketModel implements Comparable<TicketModel> {

    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy", locale = "ru_RU")
    private LocalDate departure_date;
    private Date departure_time;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy", locale = "ru_RU")
    private LocalDate arrival_date;
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

    public LocalDate getDeparture_date() {
        return departure_date;
    }


    public LocalDate getArrival_date() {
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

