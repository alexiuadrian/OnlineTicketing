package onlineticketing;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyService implements MyContract, AutoCloseable {
    private Connection connection;

    public MyService() throws SQLException {
        //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        this.connection = DriverManager.getConnection("jdbc:derby:eventsDB;create=true");
        boolean notFound = true;
        ResultSet results = connection.getMetaData().getTables(null, null, null, new String[]{"TABLE"});
        while(results.next()){
            if("sportevent".equalsIgnoreCase(results.getString("TABLE_NAME")) || "movieevent".equalsIgnoreCase(results.getString("TABLE_NAME")) ||
                    "musicevent".equalsIgnoreCase(results.getString("TABLE_NAME")) || "theatreevent".equalsIgnoreCase(results.getString("TABLE_NAME"))){
                notFound = false;
                break;
            }
        }
        if(notFound){

            Statement statement = connection.createStatement();

            connection.setAutoCommit(false);

            statement.addBatch("CREATE TABLE sportevent (id char(36) primary key, name varchar(50), days int, months int, years int, hours int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE, sport varchar(50), team1 varchar(50), team2 varchar(50), block int, row int, seat int)");

            statement.addBatch("CREATE TABLE movieevent (id char(36) primary key, name varchar(50) , days int, months int, years int, hours int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE, genre varchar(50), agerestriction int, hall int, row int, seat int)");

            statement.addBatch("CREATE TABLE musicevent (id char(36) primary key, name varchar(50) , days int, months int, years int, hours int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE, artists varchar(50), genre varchar(50), foodcourts boolean)");

            statement.addBatch("CREATE TABLE theatreevent (id char(36) primary key, name varchar(50) , days int, months int, years int, hours int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE, genre varchar(50), agerestriction int, hall int, row int, seat int, groupticket boolean)");

            statement.executeBatch();
            connection.commit();
            /*
            statement.execute("CREATE TABLE sportevent (id char(36) primary key, name varchar(50), days int, months int, years int, hours int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE, sport varchar(50), team1 varchar(50), team2 varchar(50), block int, row int, seat int)");


            statement.execute("CREATE TABLE movieevent (id char(36) primary key, name varchar(50) , days int, months int, years int, hours int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE, genre varchar(50), agerestriction int, hall int, row int, seat int)");


            connection.createStatement().execute("CREATE TABLE movieevent (id char(36) primary key, name varchar(50) , days int, months int, years int, hours int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE, genre varchar(50), agerestriction int, hall int, row int, seat int)");

            connection.createStatement().execute("CREATE TABLE musicevent (id char(36) primary key, name varchar(50) , day int, month int, year int, hour int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE, artists varchar(50), genre varchar(50), foodcourts boolean)");

            connection.createStatement().execute("CREATE TABLE theatreevent (id char(36) primary key, name varchar(50) , day int, month int, year int, hour int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE, genre varchar(50), agerestriction int, hall int, row int, seat int, groupticket boolean)");
             */
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
/*
    @Override
    public Player createPlayer(String name, String score) throws Exception {
        Player player = new Player().name(name).score(score);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO player (id, name, score) VALUES (?, ?, ?)");
        statement.setString(1, player.getId());
        statement.setString(2 , player.getName());
        statement.setString(3, player.getScore());

        if(statement.executeUpdate() == 1){
            return player;
        }
        return null;
    }

    @Override
    public List<Player> readPlayer() throws Exception {
      List<Player> players = new ArrayList<>();
      ResultSet results = connection.createStatement().executeQuery("SELECT id, name, score FROM player");
      while(results.next()){
          players.add(new Player().id(results.getString(1))
                  .name(results.getString(2)).score(results.getString(3)));
      }
      return players;
    }

    @Override
    public boolean updatePlayer(Player player) throws Exception {
        PreparedStatement statement = connection.prepareStatement("UPDATE player SET name = ?, score = ? WHERE id = ?");
        statement.setString(1, player.getName());
        statement.setString(2, player.getScore());
        statement.setString(3, player.getId());
        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean deletePlayer(String id) throws Exception {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM player WHERE id = ?");
        statement.setString(1, id);
        return statement.executeUpdate() == 1;
    }
*/
    @Override
    public SportEvent createSportEvent(String name, int day, int month, int year, int hour, int minutes, Location location,
                                double price, String sport, String team1, String team2, int block, int row, int seat) throws Exception {
        SportEvent sportEvent = new SportEvent(name, day, month, year, hour, minutes, location, price, sport, team1, team2, block, row, seat);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO sportevent (id, name, days, months, years, hours, minutes, venue, city, street, number, zipcode, " +
                "price, sport, team1, team2, block, row, seat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, sportEvent.getId());
        statement.setString(2 , sportEvent.getName());
        statement.setInt(3, sportEvent.getDay());
        statement.setInt(4, sportEvent.getMonth());
        statement.setInt(5, sportEvent.getYear());
        statement.setInt(6, sportEvent.getHour());
        statement.setInt(7, sportEvent.getMinutes());
        statement.setString(8, sportEvent.getLocation().getVenue());
        statement.setString(9, sportEvent.getLocation().getCity());
        statement.setString(10, sportEvent.getLocation().getStreet());
        statement.setInt(11, sportEvent.getLocation().getNumber());
        statement.setInt(12, sportEvent.getLocation().getZipCode());
        statement.setDouble(13, sportEvent.getPrice());
        statement.setString(14, sportEvent.getSport());
        statement.setString(15, sportEvent.getTeam1());
        statement.setString(16, sportEvent.getTeam2());
        statement.setInt(17, sportEvent.getBlock());
        statement.setInt(18, sportEvent.getRow());
        statement.setInt(19, sportEvent.getSeat());
        if(statement.executeUpdate() == 1){
            return sportEvent;
        }
        return null;

    }

    @Override
    public List<SportEvent> readSportEvent() throws Exception {
        List<SportEvent> sportEvents = new ArrayList<SportEvent>();
        ResultSet results = connection.createStatement().executeQuery("SELECT id, name, days, months, years, hours, minutes, venue, city, street, number, zipcode, price, sport, team1, team2, block, row, seat FROM sportevent");
        while(results.next()){

            sportEvents.add(new SportEvent(results.getString(1), results.getString(2), results.getInt(3), results.getInt(4),
                    results.getInt(5), results.getInt(6), results.getInt(7),
                    new Location(results.getString(8), results.getString(9), results.getString(10),
                            results.getInt(11), results.getInt(12)), results.getDouble(13), results.getString(14),
                    results.getString(15), results.getString(16), results.getInt(17), results.getInt(18),
                    results.getInt(19)));
        }

        return sportEvents;
    }

    @Override
    public boolean updateSportEvent(SportEvent sportEvent) throws Exception {
        PreparedStatement statement = connection.prepareStatement("UPDATE sportevent SET name = ?, days = ?, months = ?, years = ?, hours = ?, minutes = ?, venue = ?, city = ?, street = ?, number = ?, zipcode = ?, price = ?, sport = ?, team1 = ?, team2 = ?, block = ?, row = ?, seat = ? WHERE id = ?");
        statement.setString(1 , sportEvent.getName());
        statement.setInt(2, sportEvent.getDay());
        statement.setInt(3, sportEvent.getMonth());
        statement.setInt(4, sportEvent.getYear());
        statement.setInt(5, sportEvent.getHour());
        statement.setInt(6, sportEvent.getMinutes());
        statement.setString(7, sportEvent.getLocation().getVenue());
        statement.setString(8, sportEvent.getLocation().getCity());
        statement.setString(9, sportEvent.getLocation().getStreet());
        statement.setInt(10, sportEvent.getLocation().getNumber());
        statement.setInt(11, sportEvent.getLocation().getZipCode());
        statement.setDouble(12, sportEvent.getPrice());
        statement.setString(13, sportEvent.getSport());
        statement.setString(14, sportEvent.getTeam1());
        statement.setString(15, sportEvent.getTeam2());
        statement.setInt(16, sportEvent.getBlock());
        statement.setInt(17, sportEvent.getRow());
        statement.setInt(18, sportEvent.getSeat());
        statement.setString(19, sportEvent.getId());
        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean deleteSportEvent(String id) throws Exception {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM sportevent WHERE id = ?");
        statement.setString(1, id);
        return statement.executeUpdate() == 1;
    }

    @Override
    public MovieEvent createMovieEvent(String name, int day, int month, int year, int hour, int minutes, Location location,
                                       double price, String genre, int ageRestriction, int hall, int row, int seat) throws Exception {
        MovieEvent movieEvent = new MovieEvent(name, day, month, year, hour, minutes, location, price, genre, ageRestriction, hall, row, seat);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO movieevent (id, name, days, months, years, hours, minutes, venue, city, street, number, zipcode, " +
                "price, genre, agerestriction, hall, row, seat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, movieEvent.getId());
        statement.setString(2 , movieEvent.getName());
        statement.setInt(3, movieEvent.getDay());
        statement.setInt(4, movieEvent.getMonth());
        statement.setInt(5, movieEvent.getYear());
        statement.setInt(6, movieEvent.getHour());
        statement.setInt(7, movieEvent.getMinutes());
        statement.setString(8, movieEvent.getLocation().getVenue());
        statement.setString(9, movieEvent.getLocation().getCity());
        statement.setString(10, movieEvent.getLocation().getStreet());
        statement.setInt(11, movieEvent.getLocation().getNumber());
        statement.setInt(12, movieEvent.getLocation().getZipCode());
        statement.setDouble(13, movieEvent.getPrice());
        statement.setString(14, movieEvent.getGenre());
        statement.setInt(15, movieEvent.getAgeRestriction());
        statement.setInt(16, movieEvent.getHall());
        statement.setInt(17, movieEvent.getRow());
        statement.setInt(18, movieEvent.getSeat());
        if(statement.executeUpdate() == 1){
            return movieEvent;
        }
        return null;

    }

    @Override
    public List<MovieEvent> readMovieEvent() throws Exception {
        List<MovieEvent> movieEvents = new ArrayList<>();
        ResultSet results = connection.createStatement().executeQuery("SELECT id, name, days, months, years, hours, minutes, venue, city, street, number, zipcode, price, genre, agerestriction, hall, row, seat FROM movieevent");
        while(results.next()){

            movieEvents.add(new MovieEvent(results.getString(1), results.getString(2), results.getInt(3), results.getInt(4),
                    results.getInt(5), results.getInt(6), results.getInt(7),
                    new Location(results.getString(8), results.getString(9), results.getString(10),
                            results.getInt(11), results.getInt(12)), results.getDouble(13), results.getString(14),
                    results.getInt(15), results.getInt(16), results.getInt(17), results.getInt(18)));
        }

        return movieEvents;
    }

    @Override
    public boolean updateMovieEvent(MovieEvent movieEvent) throws Exception {
        PreparedStatement statement = connection.prepareStatement("UPDATE movieevent SET name = ?, days = ?, months = ?, years = ?, hours = ?, minutes = ?, venue = ?, city = ?, street = ?, number = ?, zipcode = ?, price = ?, genre = ?, agerestriction = ?, hall = ?, row = ?, seat = ? WHERE id = ?");
        statement.setString(1 , movieEvent.getName());
        statement.setInt(2, movieEvent.getDay());
        statement.setInt(3, movieEvent.getMonth());
        statement.setInt(4, movieEvent.getYear());
        statement.setInt(5, movieEvent.getHour());
        statement.setInt(6, movieEvent.getMinutes());
        statement.setString(7, movieEvent.getLocation().getVenue());
        statement.setString(8, movieEvent.getLocation().getCity());
        statement.setString(9, movieEvent.getLocation().getStreet());
        statement.setInt(10, movieEvent.getLocation().getNumber());
        statement.setInt(11, movieEvent.getLocation().getZipCode());
        statement.setDouble(12, movieEvent.getPrice());
        statement.setString(13, movieEvent.getGenre());
        statement.setInt(14, movieEvent.getAgeRestriction());
        statement.setInt(15, movieEvent.getHall());
        statement.setInt(16, movieEvent.getRow());
        statement.setInt(17, movieEvent.getSeat());
        statement.setString(18, movieEvent.getId());
        System.out.println("Hello");
        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean deleteMovieEvent(String id) throws Exception {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM movieevent WHERE id = ?");
        statement.setString(1, id);
        return statement.executeUpdate() == 1;
    }

    @Override
    public MusicEvent createMusicEvent(String name, int day, int month, int year, int hour, int minutes, Location location,
                                       double price, List<String> artists, String genre, boolean foodCourts) throws Exception {
        MusicEvent musicEvent = new MusicEvent(name, day, month, year, hour, minutes, location, price, artists, genre, foodCourts);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO musicevent (id, name, days, months, years, hours, minutes, venue, city, street, number, zipcode, " +
                "price, artists, genre, foodcourts) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        Boolean ok = false;
        String artists1 = "";
        for(String s : musicEvent.getArtists()) {
            artists1 += s + ", ";
            ok = true;
        }

        if(ok == true) {
            artists1 = artists1.substring(0, artists1.length() - 2);
        }

        statement.setString(1, musicEvent.getId());
        statement.setString(2 , musicEvent.getName());
        statement.setInt(3, musicEvent.getDay());
        statement.setInt(4, musicEvent.getMonth());
        statement.setInt(5, musicEvent.getYear());
        statement.setInt(6, musicEvent.getHour());
        statement.setInt(7, musicEvent.getMinutes());
        statement.setString(8, musicEvent.getLocation().getVenue());
        statement.setString(9, musicEvent.getLocation().getCity());
        statement.setString(10, musicEvent.getLocation().getStreet());
        statement.setInt(11, musicEvent.getLocation().getNumber());
        statement.setInt(12, musicEvent.getLocation().getZipCode());
        statement.setDouble(13, musicEvent.getPrice());
        statement.setString(14, artists1);
        statement.setString(15, musicEvent.getGenre());
        statement.setBoolean(16, musicEvent.isFoodCourts());
        if(statement.executeUpdate() == 1){
            return musicEvent;
        }
        return null;
    }

    @Override
    public List<MusicEvent> readMusicEvent() throws Exception {
        List<MusicEvent> musicEvents = new ArrayList<>();
        ResultSet results = connection.createStatement().executeQuery("SELECT id, name, days, months, years, hours, minutes, venue, city, street, number, zipcode, price, artists, genre, foodcourts FROM musicevent");
        while(results.next()){

            musicEvents.add(new MusicEvent(results.getString(1), results.getString(2), results.getInt(3), results.getInt(4),
                    results.getInt(5), results.getInt(6), results.getInt(7),
                    new Location(results.getString(8), results.getString(9), results.getString(10),
                            results.getInt(11), results.getInt(12)), results.getDouble(13), Arrays.asList(results.getString(14).split(",")),
                    results.getString(15), results.getBoolean(16)));
        }

        return musicEvents;
    }

    @Override
    public boolean updateMusicEvent(MusicEvent musicEvent) throws Exception {
        PreparedStatement statement = connection.prepareStatement("UPDATE musicevent SET name = ?, days = ?, months = ?, years = ?, hours = ?, minutes = ?, venue = ?, city = ?, street = ?, number = ?, zipcode = ?, price = ?, artist = ?, genre = ?, foodcourts = ? WHERE id = ?");
        Boolean ok = false;
        String artists1 = "";
        for(String s : musicEvent.getArtists()) {
            artists1 += s + ", ";
            ok = true;
        }

        if(ok == true) {
            artists1 = artists1.substring(0, artists1.length() - 2);
        }

        statement.setString(1 , musicEvent.getName());
        statement.setInt(2, musicEvent.getDay());
        statement.setInt(3, musicEvent.getMonth());
        statement.setInt(4, musicEvent.getYear());
        statement.setInt(5, musicEvent.getHour());
        statement.setInt(6, musicEvent.getMinutes());
        statement.setString(7, musicEvent.getLocation().getVenue());
        statement.setString(8, musicEvent.getLocation().getCity());
        statement.setString(9, musicEvent.getLocation().getStreet());
        statement.setInt(10, musicEvent.getLocation().getNumber());
        statement.setInt(11, musicEvent.getLocation().getZipCode());
        statement.setDouble(12, musicEvent.getPrice());
        statement.setString(13, artists1);
        statement.setString(14, musicEvent.getGenre());
        statement.setBoolean(15, musicEvent.isFoodCourts());
        statement.setString(16, musicEvent.getId());
        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean deleteMusicEvent(String id) throws Exception {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM musicevent WHERE id = ?");
        statement.setString(1, id);
        return statement.executeUpdate() == 1;
    }

    @Override
    public TheatreEvent createTheatreEvent(String name, int day, int month, int year, int hour, int minutes, Location location,
                                       double price, String genre, int ageRestriction, int hall, int row, int seat, boolean groupTicket) throws Exception {
        TheatreEvent theatreEvent = new TheatreEvent(name, day, month, year, hour, minutes, location, price, genre, ageRestriction, hall, row, seat, groupTicket);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO theatreevent (id, name, days, months, years, hours, minutes, venue, city, street, number, zipcode, " +
                "price, genre, agerestriction, hall, row, seat, groupticket) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, theatreEvent.getId());
        statement.setString(2 , theatreEvent.getName());
        statement.setInt(3, theatreEvent.getDay());
        statement.setInt(4, theatreEvent.getMonth());
        statement.setInt(5, theatreEvent.getYear());
        statement.setInt(6, theatreEvent.getHour());
        statement.setInt(7, theatreEvent.getMinutes());
        statement.setString(8, theatreEvent.getLocation().getVenue());
        statement.setString(9, theatreEvent.getLocation().getCity());
        statement.setString(10, theatreEvent.getLocation().getStreet());
        statement.setInt(11, theatreEvent.getLocation().getNumber());
        statement.setInt(12, theatreEvent.getLocation().getZipCode());
        statement.setDouble(13, theatreEvent.getPrice());
        statement.setString(14, theatreEvent.getGenre());
        statement.setInt(15, theatreEvent.getAgeRestriction());
        statement.setInt(16, theatreEvent.getHall());
        statement.setInt(17, theatreEvent.getRow());
        statement.setInt(18, theatreEvent.getSeat());
        statement.setBoolean(19, theatreEvent.isGroupTicket());
        if(statement.executeUpdate() == 1){
            return theatreEvent;
        }
        return null;
    }

    @Override
    public List<TheatreEvent> readTheatreEvent() throws Exception {
        List<TheatreEvent> theatreEvents = new ArrayList<>();
        ResultSet results = connection.createStatement().executeQuery("SELECT id, name, days, months, years, hours, minutes, venue, city, street, number, zipcode, price, genre, agerestriction, hall, row, seat, groupticket FROM theatreevent");
        while(results.next()){

            theatreEvents.add(new TheatreEvent(results.getString(1), results.getString(2), results.getInt(3), results.getInt(4),
                    results.getInt(5), results.getInt(6), results.getInt(7),
                    new Location(results.getString(8), results.getString(9), results.getString(10),
                            results.getInt(11), results.getInt(12)), results.getDouble(13), results.getString(14),
                    results.getInt(15), results.getInt(16), results.getInt(17), results.getInt(18), results.getBoolean(19)));
        }

        return theatreEvents;
    }

    @Override
    public boolean updateTheatreEvent(TheatreEvent theatreEvent) throws Exception {
        PreparedStatement statement = connection.prepareStatement("UPDATE theatreevent SET name = ?, days = ?, months = ?, years = ?, hours = ?, minutes = ?, venue = ?, city = ?, street = ?, number = ?, zipcode = ?, price = ?, genre = ?, agerestriction = ?, hall = ?, row = ?, seat = ?, groupticket = ? WHERE id = ?");
        statement.setString(1, theatreEvent.getName());
        statement.setInt(2, theatreEvent.getDay());
        statement.setInt(3, theatreEvent.getMonth());
        statement.setInt(4, theatreEvent.getYear());
        statement.setInt(5, theatreEvent.getHour());
        statement.setInt(6, theatreEvent.getMinutes());
        statement.setString(7, theatreEvent.getLocation().getVenue());
        statement.setString(8, theatreEvent.getLocation().getCity());
        statement.setString(9, theatreEvent.getLocation().getStreet());
        statement.setInt(10, theatreEvent.getLocation().getNumber());
        statement.setInt(11, theatreEvent.getLocation().getZipCode());
        statement.setDouble(12, theatreEvent.getPrice());
        statement.setString(13, theatreEvent.getGenre());
        statement.setInt(14, theatreEvent.getAgeRestriction());
        statement.setInt(15, theatreEvent.getHall());
        statement.setInt(16, theatreEvent.getRow());
        statement.setInt(17, theatreEvent.getSeat());
        statement.setBoolean(18, theatreEvent.isGroupTicket());
        statement.setString(19, theatreEvent.getId());
        return statement.executeUpdate() == 1;
    }

    @Override
    public boolean deleteTheatreEvent(String id) throws Exception {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM theatreevent WHERE id = ?");
        statement.setString(1, id);
        return statement.executeUpdate() == 1;
    }

}
