package agents;


import clients.Client;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Director is one kind of an agent
 */
public class Director extends Agent {
    private final static Logger LOGGER = Logger.getLogger("subnivel.Director");

    /**
     * Constructor
     *
     * @param name  Director name
     * @param age   Director age
     * @param cc    Director ID
     * @param mail  Director personal mail
     * @param phone Director  personal phone
     */
    public Director(String name, int age, long cc, String mail, long phone) {
        super(name, age, cc, mail, phone, 3);
    }

    @Override
    public void setClient(Client client) {
        super.setClient(client);
    }

    @Override
    public void deposits(int deposit) {
        getClient().setDeposit(deposit + 10);
        LOGGER.log(Level.INFO, "Director " + this.getName() + " :Succesful Deposit");
    }

    @Override
    public void withdrawals(int withdraw) {
        if (withdraw < getClient().getDeposit()) {
            getClient().setDeposit((-1 * withdraw) - 100);
            LOGGER.log(Level.INFO, "Succesful Deposit withdraw made by Director " + this.getName());

        } else {
            LOGGER.log(Level.WARNING, "Director " + this.getName() + ": You do not have enough money your capacity is: "
                    + +getClient().getDeposit()
                    + "and you ask for" + withdraw);
        }
    }

    @Override
    public void resolvingCustomerIssues(String issue) {
        LOGGER.log(Level.INFO, "Director: " + this.getName() + "  attends your issue: Come later");

    }

    @Override
    public boolean isAvailable() {
        return super.isAvailable();
    }

    @Override
    public void setAvalability(boolean status) {
        super.setAvalability(status);
    }
}
