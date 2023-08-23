package co.edu.uptc.model;

public class Person {

    private String name;
    private String cc;

    public Person(String name, String cc){
        this.name = name;
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
