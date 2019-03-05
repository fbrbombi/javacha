package agents;


import clients.Client;

public class Director extends Agent {

    public Director(String name, int age, long cc, String mail, String phone, int code) {
        super(name, age, cc, mail, phone, 3);
    }

    @Override
    public void setClient(Client client) {
        super.setClient(client);
    }

    @Override
    public void deposits(int deposit) {
        getClient().setDeposit(deposit + 10);

    }

    @Override
    public void withdrawals(int withdraw) {
        getClient().setDeposit((-1 * withdraw) - 100);

    }

    @Override
    public void resolvingCustomerIssues(String issue) {
        getClient().getIssue();
    }

    @Override
    public boolean isStatus() {
        return super.isStatus();
    }

    @Override
    public void setStatus(boolean status) {
        super.setStatus(status);
    }
}
