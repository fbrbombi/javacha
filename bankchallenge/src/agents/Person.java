package agents;

public abstract class Person {
    private String name;
    private int age;
    private long cc;
    private String mail;
    private long phone;


    public Person(String name, int age, long cc, String mail, long phone) {
        this.name = name;
        this.age = age;
        this.cc = cc;
        this.mail = mail;
        this.phone = phone;

    }
}
