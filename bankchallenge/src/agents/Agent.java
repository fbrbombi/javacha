package agents;

import clients.Client;

public abstract class Agent extends Person implements iBankOperation {
    private Client client;
    private boolean status = true;
    private int code;

    public Agent(String name, int age, long cc, String mail, String phone, int code) {
        super(name, age, cc, mail, phone);
        this.code = code;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }
}