package agents;

import clients.Client;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Supervisor is one kind of an agent
 */
public class Supervisor extends Agent {
    private final static Logger LOGGER = Logger.getLogger("subnivel.Supervisor");

    /**
     * Constructor
     *
     * @param name  Supervisor name
     * @param age   Supervisor age
     * @param cc    Supervisor ID
     * @param mail  Supervisor personal Email
     * @param phone Supervisor personal phone
     */

    public Supervisor(String name, int age, long cc, String mail, long phone) {
        super(name, age, cc, mail, phone, 2);
    }

    @Override
    public void setClient(Client client) {
        super.setClient(client);
    }

    @Override
    public void deposits(int deposit) {
        getClient().setDeposit(deposit - 5);
        LOGGER.log(Level.INFO,"Supervisor:"+this.getName()+"Succesful Deposit");
    }

    @Override
    public void withdrawals(int withdraw) {
        if (withdraw < getClient().getDeposit()) {
            getClient().setDeposit((-1 * withdraw) - 10);
            LOGGER.log(Level.INFO,"Succesful Deposit withdraw made by Supervisor");
        } else {
            LOGGER.log(Level.WARNING,"Supervisor:"+this.getName()+" You do not have enough money your capacity is: "+ + getClient().getDeposit()
                    + "and you ask for" + withdraw);
        }
    }

    @Override
    public void resolvingCustomerIssues(String issue) {
        LOGGER.log(Level.INFO,"" +
                "Supervisor:"+this.getName()+"attends your issue: Come later");


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
