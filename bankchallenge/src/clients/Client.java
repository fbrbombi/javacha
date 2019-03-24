package clients;

import agents.Person;

/**
 * Client is a Person
 */
public class Client extends Person {

    private int issue;
    private int deposit;
    private String comment = "";

    /**
     * Constructor
     *
     * @param name    Client name
     * @param age     Client age
     * @param cc      Client personal ID
     * @param mail    Client personal mail
     * @param phone   Client personal phone
     * @param issue   Client code issue (depends on the type of bank's operations the client needs)
     *                ex:
     *                The client wants to deposit (issue=1)
     *                The client wants to withdraw (issue=2)
     *                The client has any personal issue(issue=3)
     * @param comment Client if the client has any personal issue it contais the comment for that
     *                comment=""(default)
     *
     */
    public Client(String name, int age, long cc, String mail, long phone, int issue, String comment) {
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

    public String askIssue() {
        return comment;
    }

}
