package onlineticketing;

public class Ticket {
    protected Event eventType;
    protected Client client;
    private int ticketId;

    public Ticket(Event eventType, Client client) {
        this.eventType = eventType;
        this.client = client;
        ticketId = 0;
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

}
