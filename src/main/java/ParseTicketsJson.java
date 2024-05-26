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

public class ParseTicketsJson {
    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    List<TicketModel> tickets = new ArrayList<>();
    public ParseTicketsJson() {
        // Чтение JSON-файла
    }

    public List<TicketModel> ReadJson(TicketsModel ticketsModel) {
        try {
            module.addDeserializer(Date.class, new CustomDateDeserializer());
            mapper.registerModule(module);
            String filePath = "tickets.json";
            ticketsModel = mapper.readValue(new File(filePath), TicketsModel.class);
            tickets.addAll(ticketsModel.getTickets());

        } catch ( FileNotFoundException e) {
            e.printStackTrace();
        }
         catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}



