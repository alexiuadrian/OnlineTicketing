package onlineticketing;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Servicii servicii = new Servicii();

        try {
            servicii.setSportTickets(DataFromCSV.getInstance().read("data/sportTickets.csv", Ticket.class));
            servicii.setMovieTickets(DataFromCSV.getInstance().read("data/movieTickets.csv", Ticket.class));
            servicii.setMusicTickets(DataFromCSV.getInstance().read("data/musicTickets.csv", Ticket.class));
            servicii.setTheatreTickets(DataFromCSV.getInstance().read("data/theatreTickets.csv", Ticket.class));
            servicii.getLogs();
//            Log log = new Log();
//            log.setText("S-au citit datele");
//            servicii.addLog(log);
            servicii.concatLists();
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(!servicii.isExit()) {
            servicii.showMenu();
            servicii.executeOption();
        }



        try {
            DataFromCSV.getInstance().write(servicii.getSportTickets(), "data/sportTickets.csv");
            DataFromCSV.getInstance().write(servicii.getMovieTickets(), "data/movieTickets.csv");
            DataFromCSV.getInstance().write(servicii.getMusicTickets(), "data/musicTickets.csv");
            DataFromCSV.getInstance().write(servicii.getTheatreTickets(), "data/theatreTickets.csv");

//            Log log = new Log();
//            log.setText("S-au scris datele");
//            servicii.addLog(log);
            DataFromCSV.getInstance().write(servicii.getLogs(), "data/logs.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
