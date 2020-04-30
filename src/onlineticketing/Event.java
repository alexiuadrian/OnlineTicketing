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

    static class sortByDate implements Comparator<Event>
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
            return 0;
        }
    }

    static class sortByName implements Comparator<Event>
    {
        public int compare(Event a, Event b)
        {
            int n1 = a.getName().length();
            int n2 = b.getName().length();
            int min = Math.min(n1, n2);

            for(int i = 0; i < min; i++) {
                int c1 = (int) a.getName().charAt(i);
                int c2 = (int) b.getName().charAt(i);

                if(c1 != c2) {
                    return c1 - c2;
                }
            }

            if(n1 != n2) {
                return n1 - n2;
            }

            return 0;
        }
    }

    static class sortByPrice implements Comparator<Event>
    {
        public int compare(Event a, Event b)
        {
            if((a.getPrice() - b.getPrice()) < 0) {
                return -1;
            }
            else if((a.getPrice() - b.getPrice()) > 0) {
                return 1;
            }
            return 0;
        }
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

    public Event(String line) {
        String []values = line.split(",");

        if(values.length == 12) {
            this.name = values[0];
            this.day = Integer.parseInt(values[1]);
            this.month = Integer.parseInt(values[2]);
            this.year = Integer.parseInt(values[3]);
            this.hour = Integer.parseInt(values[4]);
            this.minutes = Integer.parseInt(values[5]);
            this.location = new Location(values[6], values[7], values[8], Integer.parseInt(values[9]), Integer.parseInt(values[10]));
            this.price = Double.parseDouble(values[11]);
        }
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

    @Override
    public String toString() {
        /*
        return "Event{" +
                "name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hour=" + hour +
                ", minutes=" + minutes +
                ", location=" + location +
                ", price=" + price +
                '}';
        */

        return (location.toString() + name + "," + Integer.toString(day) + "," + Integer.toString(month) + "," + Integer.toString(year) + "," +
                Integer.toString(hour) + "," + Integer.toString(minutes) + "," + Double.toString(price));

    }
}
