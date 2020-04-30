package onlineticketing;

public class Client {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;

    public Client(String firstName, String lastName, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Client() {

    }

    public Client(String line) {
        String []values = line.split(",");

        if(values.length == 4) {
            this.firstName = values[0];
            this.lastName = values[1];
            this.gender = values[2];
            this.age = Integer.parseInt(values[3]);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void showClient() {
        System.out.println("First Name: " + this.firstName);
        System.out.println("Last Name: " + this.lastName);
        System.out.println("Gender: " + this.gender);
        System.out.println("Age: " + this.age);
    }

    @Override
    public String toString() {
        /*
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
         */

        return (firstName + "," + lastName + "," + gender + "," + age);

    }
}
