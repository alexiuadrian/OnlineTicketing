package onlineticketing;

public class Main {
    public static void main(String[] args) {
    Servicii servicii = new Servicii();

    while(!servicii.isExit()) {
        servicii.showMenu();
        servicii.executeOption();
    }

    }
}
