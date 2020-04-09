package onlineticketing;

public class Main {
    public static void main(String[] args) {
/*
        Client client = new Client("Adrian", "Alexiu", "male", 20);
        Location location = new Location("Ilie Oana", "Ploiesti", "Str. Stadionului", 12, 100304);
        Event event = new SportEvent("Match", 8, 4, 2020, 20, 30, location, 15, "Football", "Petrolul Ploiesti", "Rapid Bucuresti", 206, 10, 13);

        // Set care stocheaza eventurile + sortare crescatoare dupa data
        // Meniu in constructor Servicii cu optiuni de adaugare/stergere/modificare etc
        Servicii servicii = new Servicii();
        servicii.setTicket(client, event);
        servicii.setTicket(client, event);
        servicii.setTicket(client, event);
        servicii.setTicket(client, event);
        servicii.showTickets();

 */

    Servicii servicii = new Servicii();

    while(!servicii.isExit()) {
        servicii.showMenu();
        servicii.executeOption();
    }

    }
}
