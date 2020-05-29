package onlineticketing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        MyContract proxy = Proxy.create("tcp://localhost:1527/events", MyContract.class);
        System.out.println("Enter command help, create, read, update, delete or exit.");

        try(Scanner scanner = new Scanner(System.in)){
            while(true){
                if(scanner.hasNextLine()){
                    String[] arguments = scanner.nextLine().split("\\|");
                    switch (arguments[0]){
                        case "help":
                            System.out.println("types = Sport|Movie|Music|Theatre");
                            System.out.println("create|<type>|information");
                            System.out.println("read|<type>");
                            System.out.println("update|<id>|information");
                            System.out.println("delete|<id>");
                            System.out.println("exit");
                            break;
                        case "create":
                            switch(arguments[1]) {
                                case "Sport": {
                                    Location location = new Location(arguments[8], arguments[9], arguments[10], Integer.parseInt(arguments[11]), Integer.parseInt(arguments[12]));

                                    proxy.createSportEvent(arguments[2],
                                            Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]), Integer.parseInt(arguments[7]),
                                            location,
                                            Double.parseDouble(arguments[13]),    // Double
                                            arguments[14], arguments[15], arguments[16],    // Strings
                                            Integer.parseInt(arguments[17]), Integer.parseInt(arguments[18]), Integer.parseInt(arguments[19]));    //Ints
                                    break;
                                }

                                case "Movie": {
                                    Location location = new Location(arguments[8], arguments[9], arguments[10], Integer.parseInt(arguments[11]), Integer.parseInt(arguments[12]));

                                    System.out.println(proxy.createMovieEvent(arguments[2],
                                            Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]), Integer.parseInt(arguments[7]),
                                            location,
                                            Double.parseDouble(arguments[13]),    // Double
                                            arguments[14],  // Strings
                                            Integer.parseInt(arguments[15]), Integer.parseInt(arguments[16]), Integer.parseInt(arguments[17]), Integer.parseInt(arguments[18])));    //Ints
                                    break;
                                }

                                case "Music": {
                                    //creeaza o lista cu artisti din arguments cu split cu virgula
                                    List<String> artists = Arrays.asList(arguments[14].split(","));

                                    Location location = new Location(arguments[8], arguments[9], arguments[10], Integer.parseInt(arguments[11]), Integer.parseInt(arguments[12]));

                                    System.out.println(proxy.createMusicEvent(arguments[2],
                                            Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]), Integer.parseInt(arguments[7]),
                                            location,
                                            Double.parseDouble(arguments[13]),    // Double
                                            artists,  // Lista de artisti
                                            arguments[15],
                                            Boolean.parseBoolean(arguments[16])));
                                    break;
                                }
                                case "Theatre": {
                                    Location location = new Location(arguments[8], arguments[9], arguments[10], Integer.parseInt(arguments[11]), Integer.parseInt(arguments[12]));

                                    System.out.println(proxy.createTheatreEvent(arguments[2],
                                            Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]), Integer.parseInt(arguments[7]),
                                            location,
                                            Double.parseDouble(arguments[13]),    // Double
                                            arguments[14],  // Strings
                                            Integer.parseInt(arguments[15]), Integer.parseInt(arguments[16]), Integer.parseInt(arguments[17]), Integer.parseInt(arguments[18]),
                                            Boolean.parseBoolean(arguments[19])));    //Ints
                                    break;
                                }

                            }
                            break;
                        case "read":
                            switch(arguments[1]) {
                                case "Sport": {
                                    List<SportEvent> sportEvents = proxy.readSportEvent();

                                    for(SportEvent sportEvent : sportEvents) {
                                        System.out.println(sportEvent.toString());
                                    }
                                    break;
                                }
                                case "Movie": {
                                    List<MovieEvent> movieEvents = proxy.readMovieEvent();

                                    for(MovieEvent movieEvent : movieEvents) {
                                        System.out.println(movieEvent.toString());
                                    }
                                    break;
                                }
                                case "Music": {
                                    List<MusicEvent> musicEvents = proxy.readMusicEvent();

                                    for(MusicEvent musicEvent : musicEvents) {
                                        System.out.println(musicEvent.toString());
                                    }
                                    break;
                                }
                                case "Theatre": {
                                    List<TheatreEvent> theatreEvents = proxy.readTheatreEvent();

                                    for(TheatreEvent theatreEvent : theatreEvents) {
                                        System.out.println(theatreEvent.toString());
                                    }
                                    break;
                                }
                            }

                            break;


                        case "update":

                            switch(arguments[1]) {
                                case "Sport": {
                                    Location location = new Location(arguments[9], arguments[10], arguments[11], Integer.parseInt(arguments[12]), Integer.parseInt(arguments[13]));
                                    System.out.println(proxy.updateSportEvent(new SportEvent(arguments[2], arguments[3],
                                            Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]), Integer.parseInt(arguments[7]), Integer.parseInt(arguments[8]),
                                            location,
                                            Double.parseDouble(arguments[14]),    // Double
                                            arguments[15], arguments[16], arguments[17],    // Strings
                                            Integer.parseInt(arguments[18]), Integer.parseInt(arguments[19]), Integer.parseInt(arguments[20]))) ? "Done" : "Failed");
                                            break;
                                }

                                case "Movie": {
                                    Location location = new Location(arguments[9], arguments[10], arguments[11], Integer.parseInt(arguments[12]), Integer.parseInt(arguments[13]));
                                    System.out.println(proxy.updateMovieEvent(new MovieEvent(arguments[2], arguments[3],
                                            Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]), Integer.parseInt(arguments[7]), Integer.parseInt(arguments[8]),
                                            location,
                                            Double.parseDouble(arguments[14]),    // Double
                                            arguments[15],  // Strings
                                            Integer.parseInt(arguments[16]), Integer.parseInt(arguments[17]), Integer.parseInt(arguments[18]), Integer.parseInt(arguments[19]))) ? "Done" : "Failed");
                                            break;
                                }

                                case "Music": {
                                    List<String> artists = Arrays.asList(arguments[15].split(","));

                                    Location location = new Location(arguments[9], arguments[10], arguments[11], Integer.parseInt(arguments[12]), Integer.parseInt(arguments[13]));
                                    System.out.println(proxy.updateMusicEvent(new MusicEvent(arguments[2], arguments[3],
                                            Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]), Integer.parseInt(arguments[7]), Integer.parseInt(arguments[8]),
                                            location,
                                            Double.parseDouble(arguments[14]),    // Double
                                            artists,  // Lista de artisti
                                            arguments[16],
                                            Boolean.parseBoolean(arguments[17]))) ? "Done" : "Failed");
                                            break;
                                }

                                case "Theatre": {
                                    Location location = new Location(arguments[9], arguments[10], arguments[11], Integer.parseInt(arguments[12]), Integer.parseInt(arguments[13]));
                                    System.out.println(proxy.updateTheatreEvent(new TheatreEvent(arguments[2], arguments[3],
                                            Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]), Integer.parseInt(arguments[7]), Integer.parseInt(arguments[8]),
                                            location,
                                            Double.parseDouble(arguments[14]),    // Double
                                            arguments[15],  // Strings
                                            Integer.parseInt(arguments[16]), Integer.parseInt(arguments[17]), Integer.parseInt(arguments[18]), Integer.parseInt(arguments[19]),
                                            Boolean.parseBoolean(arguments[20]))) ? "Done" : "Failed");
                                            break;
                                }
                            }

                            break;

                        case "delete":
                            switch (arguments[1]) {
                                case "Sport": {
                                    System.out.println(proxy.deleteSportEvent(arguments[2]) ? "Done" : "Failed");
                                    break;
                                }
                                case "Movie": {
                                    System.out.println(proxy.deleteMovieEvent(arguments[2]) ? "Done" : "Failed");
                                    break;
                                }
                                case "Music": {
                                    System.out.println(proxy.deleteMusicEvent(arguments[2]) ? "Done" : "Failed");
                                    break;
                                }
                                case "Theatre": {
                                    System.out.println(proxy.deleteTheatreEvent(arguments[2]) ? "Done" : "Failed");
                                    break;
                                }
                            }

                            break;

                        case "exit":
                            System.exit(0);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
