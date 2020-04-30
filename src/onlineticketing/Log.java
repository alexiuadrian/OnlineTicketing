package onlineticketing;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private String text;
    private String timestamp;

    public Log(String line) {
        if(line.equals(null)) {
            return;
        }
        String []values = line.split(",");

        if(values.length == 2) {
            text = values[0];
            timestamp = values[1];
        }

    }

    public Log() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("23/09/2007");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();

        timestamp = new Timestamp(time).toString();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
