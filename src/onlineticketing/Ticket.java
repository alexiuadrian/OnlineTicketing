package onlineticketing;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private int typeOfEvent;
    protected onlineticketing.Client client = new Client();
    protected Event eventType;
    private int ticketId;

    public Ticket(String line) {
        if(line.equals(null)) {
            return;
        }

        String []values = line.split(",");

        Event event = null;

        // Location Data
        Location location = new Location(values[5], values[6], values[7], Integer.parseInt(values[8]), Integer.parseInt(values[9]));

        // Client Data
        Client client = new Client(values[1], values[2], values[3], Integer.parseInt(values[4]));

        // Event Data relative to the type of event which is stored on the first
        if(Integer.parseInt(values[0]) == 1) {
            event = new SportEvent(values[10], Integer.parseInt(values[11]), Integer.parseInt(values[12]), Integer.parseInt(values[13]),
                    Integer.parseInt(values[14]), Integer.parseInt(values[15]),
                    location,
                    Double.parseDouble(values[16]),
                    values[17],
                    values[18], values[19],
                    Integer.parseInt(values[20]), Integer.parseInt(values[21]), Integer.parseInt(values[22]));
        }
        else if(Integer.parseInt(values[0]) == 2) {
            event = new MovieEvent(values[10], Integer.parseInt(values[11]), Integer.parseInt(values[12]), Integer.parseInt(values[13]),
                    Integer.parseInt(values[14]), Integer.parseInt(values[15]),
                    location,
                    Double.parseDouble(values[16]),
                    values[17],
                    Integer.parseInt(values[18]),
                    Integer.parseInt(values[19]), Integer.parseInt(values[20]), Integer.parseInt(values[21]));
        }
        else if(Integer.parseInt(values[0]) == 3) {

            List<String> Artists = new ArrayList<String>();

            for(int i = 17; i < values.length - 2; i++) {
                Artists.add(values[i]);
            }

            event = new MusicEvent(values[10], Integer.parseInt(values[11]), Integer.parseInt(values[12]), Integer.parseInt(values[13]),
                    Integer.parseInt(values[14]), Integer.parseInt(values[15]),
                    location,
                    Double.parseDouble(values[16]),
                    Artists,
                    values[values.length - 2],
                    Boolean.parseBoolean(values[values.length - 1])
                    );
        }
        else if(Integer.parseInt(values[0]) == 4) {
            event = new TheatreEvent(values[10], Integer.parseInt(values[11]), Integer.parseInt(values[12]), Integer.parseInt(values[13]),
                    Integer.parseInt(values[14]), Integer.parseInt(values[15]),
                    location,
                    Double.parseDouble(values[16]),
                    values[17],
                    Integer.parseInt(values[18]),
                    Integer.parseInt(values[19]), Integer.parseInt(values[20]), Integer.parseInt(values[21]),
                    Boolean.parseBoolean(values[22])
                    );
        }

        this.typeOfEvent = Integer.parseInt(values[0]);
        this.eventType = event;
        this.client = client;
        ticketId = Integer.parseInt(values[values.length - 1]);
    }

    public Ticket() {

    }

    public Ticket(Event eventType, Client client, int typeOfEvent) {
        this.eventType = eventType;
        this.client = client;
        ticketId = 0;
        this.typeOfEvent = typeOfEvent;
    }

    public Event getEventType() {
        return eventType;
    }

    public void setEventType(Event eventType) {
        this.eventType = eventType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void showTicket() {
        eventType.showEvent();
        client.showClient();
        System.out.println("Ticket id: " + this.ticketId);
    }

    @Override
    public String toString() {
        /*
        return "Ticket{" +
                "eventType=" + eventType +
                ", client=" + client +
                ", ticketId=" + ticketId +
                '}';
         */

        return (typeOfEvent + "," + client.toString() + "," + eventType.toString() + "," + Integer.toString(ticketId));

    }

}
