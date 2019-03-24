package agents;


import clients.Client;

/**
 * Abstract class for Agent
 * Also Agent is a Person
 */
public abstract class Agent extends Person implements iBankOperation {
    private Client client;
    private boolean status = true;
    private int code;

    /**
     * Constructor
     *
     * @param name  Agent name
     * @param age   Agent age
     * @param cc    Agent ID
     * @param mail  Agent personal email
     * @param phone Agent personal phone
     * @param code  Agent code (depends of the type of the Agent ex: Cashier=1, Supervisor=2, Director=3)
     */
    public Agent(String name, int age, long cc, String mail, long phone, int code) {
        super(name, age, cc, mail, phone);
        this.code = code;
    }

    /**
     * Setter
     *
     * @param client : Each agent has one client to attend
     */

    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Getter
     *
     * @return client: Returns the current client
     */

    public Client getClient() {
        return client;
    }

    /**
     * @return status: It means if the agent has a client, the agent is busy so it is not available (Ex: Available=true, Not Avaiable=false)
     */

    public boolean isStatus() {
        return status;
    }

    /**
     * Setter
     *
     * @param status : If the agent has assigned a client the status will become not available (statud=false)
     */

    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Getter
     *
     * @return code: Returns the type of the agent
     */

    public int getCode() {
        return code;
    }

    /**
     * This method execute the operations for each Agent, also depends on the code Issue of the client
     * (Code =1--> the client wants to deposit)
     * (Code =2 --> the client wants to withdraw)
     * (Code =3 --> the client has an issue
     * Also each Agent implements in a different way the operation
     */

    public void executeOps() {
        switch (this.client.getIssue()) {
            case 1:
                deposits((int) (Math.random() * 1000) + 1);
                break;
            case 2:
                withdrawals((int) (Math.random() * 200) + 1);
                break;
            case 3:
                resolvingCustomerIssues(this.client.askIssue());
                break;
            default:
                break;
        }
    }
}