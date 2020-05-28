package onlineticketing;

import java.sql.Time;
import java.util.Date;

public class TheatreEvent extends Event {

    private String genre;
    private int ageRestriction;
    private int hall;
    private int row;
    private int seat;
    private boolean groupTicket;

    public TheatreEvent(String name, int day, int month, int year, int hour, int minutes, Location location,
                        double price, String genre, int ageRestriction, int hall, int row, int seat, boolean groupTicket) {
        super(name, day, month, year, hour, minutes, location, price);
        this.genre = genre;
        this.ageRestriction = ageRestriction;
        this.hall = hall;
        this.row = row;
        this.seat = seat;
        this.groupTicket = groupTicket;
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

    public boolean isGroupTicket() {
        return groupTicket;
    }

    public void setGroupTicket(boolean groupTicket) {
        this.groupTicket = groupTicket;
    }

    @Override
    public void showEvent() {
        super.showEvent();
        System.out.println("Genre: " + this.genre);
        System.out.println("Age restriction: " + this.ageRestriction);
        System.out.println("Hall: " + this.hall);
        System.out.println("Row: " + this.row);
        System.out.println("Seat: " + this.seat);

        if(this.groupTicket == true) {
            System.out.println("Group ticket: YES");
        }
        else {
            System.out.println("Group ticket: NO");
        }
    }

    @Override
    public String toString() {
        /*
        return "TheatreEvent{" +
                "genre='" + genre + '\'' +
                ", ageRestriction=" + ageRestriction +
                ", hall=" + hall +
                ", row=" + row +
                ", seat=" + seat +
                ", groupTicket=" + groupTicket +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hour=" + hour +
                ", minutes=" + minutes +
                ", location=" + location +
                ", price=" + price +
                '}';

        return (location.toString() + ", " + name + ", " + Integer.toString(day) + ", " + Integer.toString(month) + ", " + Integer.toString(year) + ", " +
                Integer.toString(hour) + ", " + Integer.toString(minutes) + ", " + Double.toString(price) + ", " +
                genre + ", " + Integer.toString(ageRestriction) + ", " + Integer.toString(hall) + ", " + Integer.toString(row) + ", " +
                Integer.toString(seat) + ", " + Boolean.toString(groupTicket));

         */

        return (super.toString() + "," + genre + "," + Integer.toString(ageRestriction) + ","
                + Integer.toString(hall) + "," + Integer.toString(row) + "," + Integer.toString(seat) + "," + Boolean.toString(groupTicket));

    }
}
