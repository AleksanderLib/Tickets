import Model.TicketModel;
import Model.TicketsModel;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ParseTicketsJson {
    private ObjectMapper mapper = new ObjectMapper();
    private SimpleModule module = new SimpleModule();
    private List<TicketModel> tickets = new ArrayList<>();

    public ParseTicketsJson() {

    }

    public List<TicketModel> readJson(TicketsModel ticketsModel,FilePathInput filePathInput) {
        try {
            module.addDeserializer(Date.class, new CustomDateDeserializer());
            mapper.registerModule(module);
            ticketsModel = mapper.readValue(filePathInput.getFile(), TicketsModel.class);
            tickets.addAll(ticketsModel.getTickets());

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tickets;
    }

}



