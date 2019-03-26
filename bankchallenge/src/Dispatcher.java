import agents.Agent;
import clients.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Dispatcher handles the communication between agent and client
 */
public class Dispatcher implements Runnable {
    private static Map<Integer, Map<Integer, Agent>> agents = new HashMap<>();
    private Client client;
    private String order;
    private final Logger logger = Logger.getLogger("Dispatcher");
    private Agent agent;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Dispatcher(String order) {
        super();
        this.order = order;
    }

    /**
     * This method is the bridge between Agent and Client
     * <p>
     * Also search if any agent is avaiable
     */

    public Future<String> attendWithFuture() {
        return executor.submit(() -> {
            Agent availableAgent = findAvailableAgent();
            if (availableAgent != null) {
                agent = availableAgent;
                availableAgent.setClient(this.client);
                logger.log(Level.INFO, "Client: " + client.getName() + " You are being attended by " + availableAgent.getName());
                availableAgent.executeOps();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Attended";
            }
            return "Wait please";

        });
    }

    public void attend() {
        Agent availableAgent = findAvailableAgent();
        if (availableAgent != null) {

            availableAgent.setClient(this.client);
            logger.log(Level.INFO, "Client: " + client.getName() + " You are being attended by " + availableAgent.getName());
            availableAgent.executeOps();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Find an available agent to be assigned a client
     *
     * @return
     */

    public Agent findAvailableAgent() {
        for (int i = 1; i < agents.size() + 1; i++) {
            for (int j = 1; j < agents.get(i).size() + 1; j++) {
                if (agents.get(i).get(j).isAvailable()) {
                    agents.get(i).get(j).setAvalability(false);
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


    public void obtainListAgents(List<Agent> agent) {
        for (int i = 0; i < agent.size(); i++) {
            this.setAgents(agent.get(i).getCode(), i + 1, agent.get(i));
        }
    }

    public void setClient(Client client) {
        this.client = client;
    }


    @Override
    public void run() {
        logger.log(Level.INFO, Thread.currentThread().getName() + " Start. Order = " + order);

        Future<String> process = attendWithFuture();
        while (!process.isDone()) ;

        try {
            logger.log(Level.INFO, process.get() + " Order " + order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();

        }
        agent.setAvalability(true);
        executor.shutdown();

    }
}
