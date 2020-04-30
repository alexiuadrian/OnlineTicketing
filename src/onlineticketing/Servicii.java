package onlineticketing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Servicii {

    List<Ticket> Tickets;
    List<Event> Events;
    List<Ticket> sportTickets;
    List<Ticket> movieTickets;
    List<Ticket> musicTickets;
    List<Ticket> theatreTickets;
    List<Log> logs;
    private static int nrOfTickets = 0;
    private static int choice = 0;
    private static int choiceSort = 0;
    private static boolean exit = false;

    public Servicii() {
        Tickets = new ArrayList<>();
        Events = new ArrayList<>();
        sportTickets = new ArrayList<>();
        movieTickets = new ArrayList<>();
        musicTickets = new ArrayList<>();
        theatreTickets = new ArrayList<>();
    }

    public void setTicket(Client client, Event event, int typeOfEvent) {
        try {
            Ticket t = new Ticket(event, client, typeOfEvent);
            this.nrOfTickets++;
            t.setTicketId(this.nrOfTickets);
            String logText = "A fost adaugat un eveniment de tip: ";
            switch (typeOfEvent) {
                case 1: {
                    sportTickets.add(t);
                    logText += "Sport";
                    break;
                }
                case 2: {
                    movieTickets.add(t);
                    logText += "Film";
                    break;
                }
                case 3: {
                    musicTickets.add(t);
                    logText += "Muzica/Concert";
                    break;
                }
                case 4: {
                    theatreTickets.add(t);
                    logText += "Teatru";
                    break;
                }
            }

            Log log = new Log();
            log.setText(logText);
            logs.add(log);
            concatLists();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showTickets() {

        for(Ticket ticket : Tickets) {
            ticket.showTicket();
            System.out.println("-----------------------------------");
        }

    }

    public static int getChoice() {
        return choice;
    }

    public static void setChoice(int choice) {
        Servicii.choice = choice;
    }

    public void concatLists() {
        Tickets = Stream.concat(sportTickets.stream(), movieTickets.stream())
                .collect(Collectors.toList());

        Tickets = Stream.concat(Tickets.stream(), musicTickets.stream())
                .collect(Collectors.toList());

        Tickets = Stream.concat(Tickets.stream(), theatreTickets.stream())
                .collect(Collectors.toList());
    }

    public void showMenu() {
        System.out.println("Alegeti o optiune: ");
        System.out.println("1. Adaugati un bilet");
        System.out.println("2. Afisati toate biletele");
        System.out.println("3. Afisati biletele asociate unui client");
        System.out.println("4. Afisati evenimentele");
        System.out.println("0. Iesire");

        Scanner input = new Scanner(System.in);
        this.choice = input.nextInt();
    }

    public void executeOption() {
        switch(this.choice) {
            case 0: {
                this.exit = true;
                break;
            }
            case 1: {
                addTicket();
                break;
            }
            case 2: {
                showTickets();
                break;
            }
            case 3: {
                showTicketsForClient();
                break;
            }
            case 4: {
                System.out.println("Sortati dupa:");
                System.out.println("1. Nume");
                System.out.println("2. Data");
                System.out.println("3. Pret");

                Scanner input = new Scanner(System.in);
                this.choiceSort = input.nextInt();

                switch (this.choiceSort) {
                    case 1: {
                        Collections.sort(Events, new Event.sortByName());
                        showAllEvents();
                        break;
                    }
                    case 2: {
                        Collections.sort(Events, new Event.sortByDate());
                        showAllEvents();
                        break;
                    }
                    case 3: {
                        Collections.sort(Events, new Event.sortByPrice());
                        showAllEvents();
                        break;
                    }
                    default: {
                        System.out.println("Optiune invalida! Incercati din nou!");
                        break;
                    }
                }
                break;
            }
            default: {
                System.out.println("Optiune invalida! Incercati din nou!");
                break;
            }
        }
    }

    public void showAllEvents() {
        for(Event event : Events) {
            System.out.println(event.getName());
        }
    }

    public void addTicket() {
        System.out.println("Ce fel de eveniment?");
        System.out.println("1. Eveniment sportiv");
        System.out.println("2. Film");
        System.out.println("3. Concert/Eveniment Muzical");
        System.out.println("4. Spectacol de teatru");
        Scanner input = new Scanner(System.in);

        int kindOfEvent = input.nextInt();
        switch(kindOfEvent) {
            case 1: {
                String name, sport, team1, team2;
                String locationName, city, street;
                String firstName, lastName, gender;
                int age;
                int day, month, year, hour, minutes, number, zipcode;
                int block, row, seat;
                double price;
                System.out.println("Informatiile evenimentului:");

                Scanner input2 = new Scanner(System.in);
                System.out.println("Numele evenimentului: ");
                name = input2.nextLine();

                System.out.println("Sportul: ");
                sport = input2.nextLine();

                System.out.println("Ziua evenimentului: ");
                day = input.nextInt();

                System.out.println("Luna evenimentului: ");
                month = input.nextInt();

                System.out.println("Anul evenimentului: ");
                year = input.nextInt();

                System.out.println("Ora evenimentului (ora spatiu minute): ");
                hour = input.nextInt();
                minutes = input.nextInt();

                System.out.println("Echipa gazda: ");
                team1 = input2.nextLine();

                System.out.println("Echipa oaspete: ");
                team2 = input2.nextLine();

                Scanner input3 = new Scanner(System.in);

                System.out.println("Pretul: ");
                price = input3.nextDouble();

                System.out.println("Informatii privind locatia: ");

                System.out.println("Numele locatiei: ");
                locationName = input2.nextLine();

                System.out.println("Numele orasului: ");
                city = input2.nextLine();

                System.out.println("Numele strazii: ");
                street = input2.nextLine();

                System.out.println("Numarul: ");
                number = input.nextInt();

                System.out.println("Codul postal: ");
                zipcode = input.nextInt();

                System.out.println("Informatii despre bilet: ");

                System.out.println("Bloc/Sector: ");
                block = input.nextInt();

                System.out.println("Rand: ");
                row = input.nextInt();

                System.out.println("Loc: ");
                seat = input.nextInt();

                System.out.println("Informatii despre client: ");

                System.out.println("Prenume: ");
                firstName = input2.nextLine();

                System.out.println("Nume de familie: ");
                lastName = input2.nextLine();

                System.out.println("Sex: ");
                gender = input2.nextLine();

                System.out.println("Varsta: ");
                age = input.nextInt();

                Client client = new Client(firstName, lastName, gender, age);
                Location location = new Location(locationName, city, street, number, zipcode);
                Event event = new SportEvent(name, day, month, year, hour, minutes, location, price, sport, team1, team2, block, row, seat);

                Events.add(event);

                setTicket(client, event, kindOfEvent);

                break;
            }
            case 2: {
                String name, genre;
                String locationName, city, street;
                String firstName, lastName, gender;
                int age, ageRestriction;
                int day, month, year, hour, minutes, number, zipcode;
                int hall, row, seat;
                double price;
                System.out.println("Informatiile evenimentului:");

                Scanner input2 = new Scanner(System.in);
                System.out.println("Numele evenimentului: ");
                name = input2.nextLine();

                System.out.println("Genul filmului: ");
                genre = input2.nextLine();

                System.out.println("Restrictia de varsta: ");
                ageRestriction = input.nextInt();

                System.out.println("Ziua evenimentului: ");
                day = input.nextInt();

                System.out.println("Luna evenimentului: ");
                month = input.nextInt();

                System.out.println("Anul evenimentului: ");
                year = input.nextInt();

                System.out.println("Ora evenimentului (ora spatiu minute): ");
                hour = input.nextInt();
                minutes = input.nextInt();

                Scanner input3 = new Scanner(System.in);

                System.out.println("Pretul: ");
                price = input3.nextDouble();

                System.out.println("Informatii privind locatia: ");

                System.out.println("Numele locatiei: ");
                locationName = input2.nextLine();

                System.out.println("Numele orasului: ");
                city = input2.nextLine();

                System.out.println("Numele strazii: ");
                street = input2.nextLine();

                System.out.println("Numarul: ");
                number = input.nextInt();

                System.out.println("Codul postal: ");
                zipcode = input.nextInt();

                System.out.println("Informatii despre bilet: ");

                System.out.println("Sala: ");
                hall = input.nextInt();

                System.out.println("Rand: ");
                row = input.nextInt();

                System.out.println("Loc: ");
                seat = input.nextInt();

                System.out.println("Informatii despre client: ");

                System.out.println("Prenume: ");
                firstName = input2.nextLine();

                System.out.println("Nume de familie: ");
                lastName = input2.nextLine();

                System.out.println("Sex: ");
                gender = input2.nextLine();

                System.out.println("Varsta: ");
                age = input.nextInt();

                Client client = new Client(firstName, lastName, gender, age);
                Location location = new Location(locationName, city, street, number, zipcode);
                Event event = new MovieEvent(name, day, month, year, hour, minutes, location, price, genre, ageRestriction, hall, row, seat);

                Events.add(event);

                setTicket(client, event, kindOfEvent);

                break;
            }
            case 3: {
                String name, genre;
                List<String> artists = new ArrayList<>();
                String locationName, city, street;
                String firstName, lastName, gender;
                int age;
                int day, month, year, hour, minutes, number, zipcode;
                double price;
                boolean foodCourts;
                System.out.println("Informatiile evenimentului:");

                Scanner input2 = new Scanner(System.in);
                System.out.println("Numele evenimentului: ");
                name = input2.nextLine();

                System.out.println("Genul de muzica: ");
                genre = input2.nextLine();

                System.out.println("Tonete de mancare: ");
                String gT = input2.nextLine();
                if(gT.toLowerCase().equals("da")) {
                    foodCourts = true;
                }
                else {
                    foodCourts = false;
                }

                boolean done = false;
                System.out.println("Artisti: ");
                do {
                    String ar = input2.nextLine();
                    artists.add(ar);

                    System.out.println("Mai adaugati un artist?");
                    String x = input2.nextLine();
                    if(x.toLowerCase().equals("nu")) {
                        done = true;
                    }
                }while(done == false);

                System.out.println("Ziua evenimentului: ");
                day = input.nextInt();

                System.out.println("Luna evenimentului: ");
                month = input.nextInt();

                System.out.println("Anul evenimentului: ");
                year = input.nextInt();

                System.out.println("Ora evenimentului (ora spatiu minute): ");
                hour = input.nextInt();
                minutes = input.nextInt();

                Scanner input3 = new Scanner(System.in);

                System.out.println("Pretul: ");
                price = input3.nextDouble();

                System.out.println("Informatii privind locatia: ");

                System.out.println("Numele locatiei: ");
                locationName = input2.nextLine();

                System.out.println("Numele orasului: ");
                city = input2.nextLine();

                System.out.println("Numele strazii: ");
                street = input2.nextLine();

                System.out.println("Numarul: ");
                number = input.nextInt();

                System.out.println("Codul postal: ");
                zipcode = input.nextInt();

                System.out.println("Informatii despre client: ");

                System.out.println("Prenume: ");
                firstName = input2.nextLine();

                System.out.println("Nume de familie: ");
                lastName = input2.nextLine();

                System.out.println("Sex: ");
                gender = input2.nextLine();

                System.out.println("Varsta: ");
                age = input.nextInt();

                Client client = new Client(firstName, lastName, gender, age);
                Location location = new Location(locationName, city, street, number, zipcode);
                Event event = new MusicEvent(name, day, month, year, hour, minutes, location, price, artists, genre, foodCourts);

                Events.add(event);

                setTicket(client, event, kindOfEvent);

                break;
            }
            case 4: {
                String name, genre;
                String locationName, city, street;
                String firstName, lastName, gender;
                int age, ageRestriction;
                int day, month, year, hour, minutes, number, zipcode;
                int hall, row, seat;
                double price;
                boolean groupTicket;
                System.out.println("Informatiile evenimentului:");

                Scanner input2 = new Scanner(System.in);
                System.out.println("Numele evenimentului: ");
                name = input2.nextLine();

                System.out.println("Genul piesei de teatru: ");
                genre = input2.nextLine();

                System.out.println("Restrictia de varsta: ");
                ageRestriction = input.nextInt();

                System.out.println("Bilet de grup: ");
                String gT = input2.nextLine();
                if(gT.toLowerCase().equals("da")) {
                    groupTicket = true;
                }
                else {
                    groupTicket = false;
                }

                System.out.println("Ziua evenimentului: ");
                day = input.nextInt();

                System.out.println("Luna evenimentului: ");
                month = input.nextInt();

                System.out.println("Anul evenimentului: ");
                year = input.nextInt();

                System.out.println("Ora evenimentului (ora spatiu minute): ");
                hour = input.nextInt();
                minutes = input.nextInt();

                Scanner input3 = new Scanner(System.in);

                System.out.println("Pretul: ");
                price = input3.nextDouble();

                System.out.println("Informatii privind locatia: ");

                System.out.println("Numele locatiei: ");
                locationName = input2.nextLine();

                System.out.println("Numele orasului: ");
                city = input2.nextLine();

                System.out.println("Numele strazii: ");
                street = input2.nextLine();

                System.out.println("Numarul: ");
                number = input.nextInt();

                System.out.println("Codul postal: ");
                zipcode = input.nextInt();

                System.out.println("Informatii despre bilet: ");

                System.out.println("Sala: ");
                hall = input.nextInt();

                System.out.println("Rand: ");
                row = input.nextInt();

                System.out.println("Loc: ");
                seat = input.nextInt();

                System.out.println("Informatii despre client: ");

                System.out.println("Prenume: ");
                firstName = input2.nextLine();

                System.out.println("Nume de familie: ");
                lastName = input2.nextLine();

                System.out.println("Sex: ");
                gender = input2.nextLine();

                System.out.println("Varsta: ");
                age = input.nextInt();

                Client client = new Client(firstName, lastName, gender, age);
                Location location = new Location(locationName, city, street, number, zipcode);
                Event event = new TheatreEvent(name, day, month, year, hour, minutes, location, price, genre, ageRestriction, hall, row, seat, groupTicket);

                Events.add(event);

                setTicket(client, event, kindOfEvent);

                break;
            }
        }

    }

    public static boolean isExit() {
        return exit;
    }

    public static void setExit(boolean exit) {
        Servicii.exit = exit;
    }

    public void showTicketsForClient() {
        String firstName, lastName;

        Scanner input = new Scanner(System.in);
        System.out.println("Prenume: ");
        firstName = input.nextLine();

        System.out.println("Nume: ");
        lastName = input.nextLine();

        for(Ticket ticket : Tickets) {
            if(ticket.getClient().getFirstName().equals(firstName) && ticket.getClient().getLastName().equals(lastName)) {
                ticket.showTicket();
                System.out.println("-----------------------------------");
            }
        }
    }

    public List<Ticket> getTickets() {
        return Tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        Tickets = tickets;
    }

    public List<Event> getEvents() {
        return Events;
    }

    public void setEvents(List<Event> events) {
        Events = events;
    }

    public List<Ticket> getSportTickets() {
        return sportTickets;
    }

    public void setSportTickets(List<Ticket> sportTickets) {
        this.sportTickets = sportTickets;
    }

    public List<Ticket> getMovieTickets() {
        return movieTickets;
    }

    public void setMovieTickets(List<Ticket> movieTickets) {
        this.movieTickets = movieTickets;
    }

    public List<Ticket> getMusicTickets() {
        return musicTickets;
    }

    public void setMusicTickets(List<Ticket> musicTickets) {
        this.musicTickets = musicTickets;
    }

    public List<Ticket> getTheatreTickets() {
        return theatreTickets;
    }

    public void setTheatreTickets(List<Ticket> theatreTickets) {
        this.theatreTickets = theatreTickets;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public void addLog(Log log) {
        logs.add(log);
    }
}
