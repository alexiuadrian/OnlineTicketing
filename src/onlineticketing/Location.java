package onlineticketing;

public class Location {
    private String venue;
    private String city;
    private String street;
    private int number;
    private int zipCode;

    public Location(String venue, String city, String street, int number, int zipCode) {
        this.venue = venue;
        this.city = city;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void showLocation() {
        System.out.println("Venue: " + this.venue);
        System.out.println("City: " + this.city);
        System.out.println("Street: " + this.street);
        System.out.println("Street Number: " + this.number);
        System.out.println("Zip Code: " + this.zipCode);
    }

}
