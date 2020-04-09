package onlineticketing;

import java.sql.Time;
import java.util.Date;

public class MovieEvent extends Event {

    private String genre;
    private int ageRestriction;
    private int hall;
    private int row;
    private int seat;

    public MovieEvent(String name, int day, int month, int year, int hour, int minutes, Location location, double price, String genre, int ageRestriction, int hall, int row, int seat) {
        super(name, day, month, year, hour, minutes, location, price);
        this.genre = genre;
        this.ageRestriction = ageRestriction;
        this.hall = hall;
        this.row = row;
        this.seat = seat;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public void showEvent() {
        super.showEvent();
        System.out.println("Movie Genre: " + this.genre);
        System.out.println("Age restriction: " + this.ageRestriction);
        System.out.println("Hall: " + this.hall);
        System.out.println("Row: " + this.row);
        System.out.println("Seat: " + this.seat);
    }
}