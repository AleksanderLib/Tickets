import Model.TicketModel;
import Model.TicketsModel;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParseTicketsJson {
    private ObjectMapper mapper = new ObjectMapper();
    private JavaTimeModule module = new JavaTimeModule();
    private List<TicketModel> tickets = new ArrayList<>();

    public ParseTicketsJson() {

    }

    public List<TicketModel> readJson(TicketsModel ticketsModel,FilePathInput filePathInput) {
        try {
            module.addDeserializer(Date.class, new TimeDeserializer());
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