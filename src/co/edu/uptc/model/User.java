package co.edu.uptc.model;

public class User {

    private Person person;
    private String userName;
    private String password;
    private double availableMoney;

    public User(String userName, String password, String personName, String personCc) {
        this.userName = userName;
        this.password = password;
        person = new Person(personName, personCc);
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(double availableMoney) {
        this.availableMoney = availableMoney;
    }
}
