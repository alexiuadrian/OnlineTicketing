package onlineticketing;

import java.sql.Time;
import java.util.Date;

public class SportEvent extends Event {

    private String sport;
    private String team1;
    private String team2;
    private int block;
    private int row;
    private int seat;

    public SportEvent(String name, int day, int month, int year, int hour, int minutes, Location location, double price, String sport, String team1, String team2, int block, int row, int seat) {
        super(name, day, month, year, hour, minutes, location, price);
        this.sport = sport;
        this.team1 = team1;
        this.team2 = team2;
        this.block = block;
        this.row = row;
        this.seat = seat;
        this.name = this.team1 + " vs " + this.team2;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
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
        System.out.println("Meci de " + this.sport);
        //super.setName(this.team1 + " vs " + this.team2);
        super.showEvent();
        System.out.println("Block: " + this.block);
        System.out.println("Row: " + this.row);
        System.out.println("Seat: " + this.seat);
    }
}
