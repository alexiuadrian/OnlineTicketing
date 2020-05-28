package onlineticketing;

import java.sql.*;
import java.util.ArrayList;
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
            connection.createStatement().execute("CREATE TABLE sportevent (id char(36) primary key, name varchar(50), days int, months int, years int, hours int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE, sport varchar(50), team1 varchar(50), team2 varchar(50), block int, row int, seat int)");
            /*
            connection.createStatement().execute("CREATE TABLE movieevent (id char(36) primary key, name varchar(50) , day int, month int, year int, hour int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE PRECISION(8,2), genre varchar(50), agerestriction int, hall int, row int, seat int)");
            connection.createStatement().execute("CREATE TABLE musicevent (id char(36) primary key, name varchar(50) , day int, month int, year int, hour int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE PRECISION(8,2), artists varchar(50), genre varchar(50), foodcourts boolean)");
            connection.createStatement().execute("CREATE TABLE theatreevent (id char(36) primary key, name varchar(50) , day int, month int, year int, hour int," +
                    " minutes int, venue varchar(50), city varchar(50), street varchar(50), number int, zipcode int," +
                    " price DOUBLE PRECISION(8,2), genre varchar(50), agerestriction int, hall int, row int, seat int, groupticket boolean)");
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

}
