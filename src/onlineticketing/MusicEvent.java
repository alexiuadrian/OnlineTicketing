package onlineticketing;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MusicEvent extends Event {

    private List<String> artists;
    private String genre;
    private boolean foodCourts;

    public MusicEvent(String name, int day, int month, int year, int hour, int minutes, Location location, double price, List<String> artists, String genre, boolean foodCourts) {
        super(name, day, month, year, hour, minutes, location, price);
        this.artists = artists;
        this.genre = genre;
        this.foodCourts = foodCourts;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isFoodCourts() {
        return foodCourts;
    }

    public void setFoodCourts(boolean foodCourts) {
        this.foodCourts = foodCourts;
    }

    @Override
    public void showEvent() {
        super.showEvent();
        if(this.artists.size() > 1) {
            System.out.print("Artisti: ");
            for(String i : this.artists) {
                System.out.print(i + " ");
            }
        }
        else {
            System.out.print("Artist: " + artists.get(0));
        }
        System.out.println(" ");
        System.out.println("Genre: " + this.genre);

        if(this.foodCourts == true) {
            System.out.println("Food courts: Yes");
        }
        else {
            System.out.println("Food courts: No");
        }
    }

    @Override
    public String toString() {
        /*
        return "MusicEvent{" +
                "artists=" + artists +
                ", genre='" + genre + '\'' +
                ", foodCourts=" + foodCourts +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hour=" + hour +
                ", minutes=" + minutes +
                ", location=" + location +
                ", price=" + price +
                '}';

        String x = (location.toString() + ", " + name + ", " + Integer.toString(day) + ", " + Integer.toString(month) + ", " + Integer.toString(year) + ", " +
                Integer.toString(hour) + ", " + Integer.toString(minutes) + ", " + Double.toString(price) + ", ");

         */

        String x = super.toString() + ", ";

        for(String s : artists) {
            x += s + ", ";
        }

        x += genre + ", " + Boolean.toString(foodCourts);

        return x;

    }
}
