import agents.Agent;
import clients.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Dispatcher handles the communication between agent and client
 */
public class Dispatcher implements Runnable {
    private static Map<Integer, Map<Integer, Agent>> agents = new HashMap<>();
    private final static Logger LOGGER = Logger.getLogger("subnivel.Dispatcher");
    Thread ops;
    private Agent availableAgent;
    private long initialTime;
    private Client client;
    private List<Thread> threads = new ArrayList<Thread>();
    private int i = 0;
    private String order;


    public Dispatcher(String order) {
        super();
        this.order = order;
    }

    /**
     * This method is the bridge between Agent and Client
     * <p>
     * Also search if any agent is avaiable
     *
     * @param client
     */

    public void attend(Client client) {
        this.setClient(client);

    }

    /**
     * Find an available agent to be assigned a client
     *
     * @return
     */

    public Agent findAvailableAgent() {
        for (int i = 1; i < agents.size() + 1; i++) {
            for (int j = 1; j < agents.get(i).size() + 1; j++) {
                if (agents.get(i).get(j).isStatus()) {
                    agents.get(i).get(j).setStatus(false);
                    return agents.get(i).get(j);
                }
            }
        }
        return null;
    }

    /**
     * This method updates all the "list" of the Agents
     *
     * @param codeAgent
     * @param code
     * @param agent
     */
    public void setAgents(int codeAgent, int code, Agent agent) {
        Map<Integer, Agent> agentsPerType = new HashMap<>();
        agentsPerType.put(code, agent);
        if (agents.containsKey(codeAgent)) {
            agents.get(codeAgent).put(code, agent);
        } else {
            agents.put(codeAgent, agentsPerType);
        }
    }


    public void obtainListAgents(List<Agent> agent, int code) {
        for (int i = 0; i < agent.size(); i++) {
            this.setAgents(agent.get(i).getCode(), i + 1, agent.get(i));
        }
    }

    public void setClient(Client client) {
        this.client = client;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Order = " + order);
        this.availableAgent = findAvailableAgent();
        if (this.availableAgent != null) {

            this.availableAgent.setClient(this.client);
            System.out.println("Client: " + client.getName() + " You are being attended by " + availableAgent.getName());
            this.availableAgent.executeOps();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.availableAgent.setStatus(true);
        } else {

            LOGGER.log(Level.WARNING, "Please wait");

        }
    }
}
