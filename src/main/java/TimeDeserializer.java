import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import static java.util.Objects.isNull;

public class TimeDeserializer extends JsonDeserializer<Date> {
    private final DateFormat df = new SimpleDateFormat("HH:mm");
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String dateStr = null;
            dateStr = jsonParser.getText();
        Timestamp timestamp = null;
        try {
            timestamp = new Timestamp(df.parse(dateStr).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new Date(timestamp.getTime());

        }
    }




