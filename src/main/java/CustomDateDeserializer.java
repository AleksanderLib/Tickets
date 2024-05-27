import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

    private final DateFormat df = new SimpleDateFormat("HH:mm");

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dateStr = null;
        try {
            dateStr = p.getText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Timestamp timestamp = new Timestamp(df.parse(dateStr).getTime());
            return new Date(timestamp.getTime());
        } catch (ParseException e) {
            throw new IOException(e);
        }
    }
}
