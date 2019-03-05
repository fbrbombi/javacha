import agents.Cashier;
import clients.Client;

public class Bank {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        Cashier agent = new Cashier("Fabio", 22, 105012105, "mail@.com", "1204540", 1);
        Cashier agent2 = new Cashier("Fabio2", 22, 105012105, "mail@.com", "1204540", 1);

        Client client = new Client("Fabio", 22, 105012105, "mail@.com", "1204540", 1, "");
        dispatcher.setAgents(agent.getCode(),1,agent);
        dispatcher.attend(client);

    }
}
