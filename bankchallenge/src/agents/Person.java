package agents;

/**
 * This is the class for a Person
 */
public abstract class Person {
    private String name;
    private int age;
    private long cc;
    private String mail;
    private long phone;

    /**
     * Constructor
     *
     * @param name  Name of a person
     * @param age   Age of a person
     * @param cc    ID
     * @param mail  Personal Email
     * @param phone Personal phone
     */
    public Person(String name, int age, long cc, String mail, long phone) {
        this.name = name;
        this.age = age;
        this.cc = cc;
        this.mail = mail;
        this.phone = phone;

    }

    /**
     * Getter
     *
     * @return Name: Get the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param name: The new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     *
     * @return age: Returns the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter
     *
     * @param age: The new age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public long getCc() {
        return cc;
    }

    public void setCc(long cc) {
        this.cc = cc;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
