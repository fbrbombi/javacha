package clients;

import agents.Person;

public class Client extends Person {

    private int issue;
    private int deposit;
    private String comment = "";

    public Client(String name, int age, long cc, String mail, String phone, int issue, String comment) {
        super(name, age, cc, mail, phone);
        this.issue = issue;
        this.deposit = (int) (Math.random() * 1000) + 1;
        this.comment = comment;
    }

    public int getIssue() {
        return issue;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit += deposit;
    }

}
