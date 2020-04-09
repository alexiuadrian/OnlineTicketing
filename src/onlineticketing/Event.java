package onlineticketing;

import java.sql.Time;
import java.util.Comparator;
import java.util.Date;

public class Event {



    protected String name;
    protected int day;
    protected int month;
    protected int year;
    protected int hour;
    protected int minutes;
    protected Location location;
    protected double price;

    class sortByDate implements Comparator<Event>
    {
        public int compare(Event a, Event b)
        {
            if(a.getYear() - b.getYear() != 0) {
                return a.getYear() - b.getYear();
            }
            else if(a.getMonth() - b.getMonth() != 0) {
                return a.getMonth() - b.getMonth();
            }
            else if(a.getDay() - b.getDay() != 0) {
                return a.getDay() - b.getDay();
            }
            else if(a.getHour() - b.getHour() != 0) {
                return a.getHour() - b.getHour();
            }
            else if(a.getMinutes() - b.getMinutes() != 0) {
                return a.getMinutes() - b.getMinutes();
            }
            return a.getMinutes() - b.getMinutes();
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if(!((Event) obj).getName().equals(this.name)) {
            return false;
        }

        if(((Event) obj).getDay() != this.day) {
            return false;
        }

        if(((Event) obj).getMonth() != this.month) {
            return false;
        }

        if(((Event) obj).getYear() != this.year) {
            return false;
        }

        if(((Event) obj).getHour() != this.hour) {
            return false;
        }

        if(((Event) obj).getMinutes() != this.minutes) {
            return false;
        }

        return true;
    }

    public Event() {

    }

    public Event(String name, int day, int month, int year, int hour, int minutes, Location location, double price) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minutes = minutes;
        this.location = location;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void showEvent() {
        System.out.println("Event name: " + this.name);
        System.out.println("Date: " + this.day + "." + this.month + "." + this.year);
        if(this.minutes < 10) {
            System.out.println("Time: " + this.hour + ":0" + this.minutes);
        }
        else {
            System.out.println("Time: " + this.hour + ":" + this.minutes);
        }
        this.location.showLocation();
        System.out.println("Price: " + this.price);
    }

}