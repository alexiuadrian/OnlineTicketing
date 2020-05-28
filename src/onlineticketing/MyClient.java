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
                            System.out.println("create|<type>|information");
                            System.out.println("read");
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
                                /*
                                case "Movie": {
                                    Location location = new Location(arguments[7], arguments[8], arguments[9], Integer.parseInt(arguments[10]), Integer.parseInt(arguments[11]));

                                    System.out.println(proxy.createMovieEvent(arguments[1],
                                            Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]),
                                            location,
                                            Double.parseDouble(arguments[12]),    // Double
                                            arguments[13],  // Strings
                                            Integer.parseInt(arguments[14]), Integer.parseInt(arguments[15]), Integer.parseInt(arguments[16]), Integer.parseInt(arguments[17])));    //Ints
                                    break;
                                }
                                case "Music": {
                                    //creeaza o lista cu artisti din arguments cu split cu virgula
                                    List<String> artists = Arrays.asList(arguments[13].split(","));

                                    Location location = new Location(arguments[7], arguments[8], arguments[9], Integer.parseInt(arguments[10]), Integer.parseInt(arguments[11]));

                                    System.out.println(proxy.createMusicEvent(arguments[1],
                                            Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]),
                                            location,
                                            Double.parseDouble(arguments[12]),    // Double
                                            artists,  // Lista de artisti
                                            arguments[14],
                                            Boolean.parseBoolean(arguments[15])));
                                    break;
                                }
                                case "Theatre": {
                                    Location location = new Location(arguments[7], arguments[8], arguments[9], Integer.parseInt(arguments[10]), Integer.parseInt(arguments[11]));

                                    System.out.println(proxy.createTheatreEvent(arguments[1],
                                            Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]), Integer.parseInt(arguments[5]), Integer.parseInt(arguments[6]),
                                            location,
                                            Double.parseDouble(arguments[12]),    // Double
                                            arguments[13],  // Strings
                                            Integer.parseInt(arguments[14]), Integer.parseInt(arguments[15]), Integer.parseInt(arguments[16]), Integer.parseInt(arguments[17]),
                                            Boolean.parseBoolean(arguments[18])));    //Ints
                                    break;
                                }
                                 */
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
                            }

                            break;

                            /*
                        case "update":
                            System.out.println(proxy.updatePlayer(
                                    new Player().id(arguments[1]).name(arguments[2]).score(arguments[3])) ? "Done" : "Failed");
                            break;
                        case "delete":
                            System.out.println(proxy.deletePlayer(arguments[1]) ? "Done" : "Failed");
                            break;

                             */
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
