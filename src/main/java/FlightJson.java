import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.List;

public class FlightJson {
    ObjectMapper mapper = new ObjectMapper();
    Tickets tickets;

    public FlightJson() {
        // Чтение JSON-файла
        try {
            File file = new File("tickets.json");
            long fileSize = file.length();
            long blockSize = 1024;
            long numBlocks = (fileSize + blockSize - 1) / blockSize;

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            for (long i = 0; i < numBlocks; i++) {
                byte[] buffer = new byte[(int) Math.min(blockSize, fileSize - i * blockSize)];
                bis.read(buffer);
                tickets = mapper.readValue(new String(buffer), Tickets.class);
            }
            bis.close();
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

    }

    public static class Flight {
        public String origin;
        public String destination;
        public String carrier;
        public int duration;
        public int price;

        public String getCarrier() {
            return carrier;
        }

        public int getDuration() {
            return duration;
        }

        public int getPrice() {
            return price;
        }
    }
    public static class Tickets {
        public List<Flight> flights;

        public List<Flight> getFlights() {
            return flights;
        }
    }


}



