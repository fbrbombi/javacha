import agents.Cashier;

public class Bank {

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();

        Cashier agent = new Cashier("Fabio", 22, 105012105, "mail@.com", 121245, 1);
        Cashier agent2 = new Cashier("Fabio2", 22, 105012105, "mail@.com", 145454, 1);

        //Client client = new Client("Fabio", 22, 105012105, "mail@.com", "1204540", 1, "");
        //Client client2 = new Client("Fabio", 22, 105012105, "mail@.com", "1204540", 1, "");

        dispatcher.setAgents(agent.getCode(), 1, agent);

        dispatcher.setAgents(agent2.getCode(), 2, agent2);

        //dispatcher.attend(client);
        //dispatcher.attend(client2);


    }
}
