package onlineticketing;

import java.util.List;

public interface MyContract {
    SportEvent createSportEvent(String name, int day, int month, int year, int hour, int minutes, Location location,
                                double price, String sport, String team1, String team2, int block, int row, int seat) throws Exception;
    List<SportEvent> readSportEvent() throws Exception;
    /*
    boolean updateSportEvent (SportEvent sportEvent) throws Exception;
    boolean deleteSportEvent (String id) throws Exception;

    MovieEvent createMovieEvent(String name, int day, int month, int year, int hour, int minutes, Location location,
                                double price, String genre, int ageRestriction, int hall, int row, int seat);
    List<MovieEvent> readMovieEvent() throws Exception;
    boolean updateMovieEvent (MovieEvent movieEvent) throws Exception;
    boolean deleteMovieEvent (String id) throws Exception;

    MusicEvent createMusicEvent(String name, int day, int month, int year, int hour, int minutes, Location location,
                                double price, List<String> artists, String genre, boolean foodCourts);
    List<MusicEvent> readMusicEvent() throws Exception;
    boolean updateMusicEvent (MusicEvent musicEvent) throws Exception;
    boolean deleteMusicEvent (String id) throws Exception;

    TheatreEvent createTheatreEvent(String name, int day, int month, int year, int hour, int minutes, Location location,
                                    double price, String genre, int ageRestriction, int hall, int row, int seat, boolean groupTicket);
    List<TheatreEvent> readTheatreEvent() throws Exception;
    boolean updateTheatreEvent (TheatreEvent theatreEvent) throws Exception;
    boolean deleteTheatreEvent (String id) throws Exception;
     */
}
