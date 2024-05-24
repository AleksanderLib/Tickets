import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FlightJson {
    JSONParser parser = new JSONParser();
    JSONArray flights = new JSONArray();
    JSONObject json = new JSONObject();
    Object obj = new Object();

    public FlightJson() {
        try {
            obj = parser.parse(new FileReader("tickets.json"));
            json = (JSONObject) obj;
            flights = (JSONArray) json.get("flights");
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }



}



