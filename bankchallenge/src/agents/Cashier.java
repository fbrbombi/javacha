package agents;

import clients.Client;

public class Cashier extends Agent {


    public Cashier(String name, int age, long cc, String mail, String phone, int code) {
        super(name, age, cc, mail, phone, 1);
    }

    @Override
    public void setClient(Client client) {
        super.setClient(client);
    }

    @Override
    public void deposits(int deposit) {
        getClient().setDeposit(deposit);
    }

    @Override
    public void withdrawals(int withdraw) {
        getClient().setDeposit(-1 * withdraw);

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
