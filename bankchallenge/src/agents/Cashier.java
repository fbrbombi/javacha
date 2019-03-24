package agents;

import clients.Client;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cashier is one kind of Agent
 */
public class Cashier extends Agent {
    /**
     * Constructor
     * @param name Cashier name
     * @param age  Cashier age
     * @param cc   Cashier personal ID
     * @param mail Cashier email
     * @param phone Cashier phone
     */

    private final static Logger LOGGER = Logger.getLogger("subnivel.Cashier");

    public Cashier(String name, int age, long cc, String mail, long phone) {
        super(name, age, cc, mail, phone, 1);
    }

    @Override
    public void setClient(Client client) {
        super.setClient(client);
    }

    @Override
    public void deposits(int deposit) {
        getClient().setDeposit(deposit);
        LOGGER.log(Level.INFO,"Cashier:Succesful Deposit");
    }

    @Override
    public void withdrawals(int withdraw) {
        if (withdraw < getClient().getDeposit()) {
            getClient().setDeposit(-1 * withdraw);
            LOGGER.log(Level.INFO,"Succesful Deposit withdraw made by Cashier");

        } else {
            LOGGER.log(Level.WARNING,"Cashier:You do not have enough money your capacity is: "+ + getClient().getDeposit()
                    + "and you ask for" + withdraw);

        }
    }

    @Override
    public void resolvingCustomerIssues(String issue) {
        LOGGER.log(Level.INFO,"Cashier"+this.getName()+" attends your issue: Come later");
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
