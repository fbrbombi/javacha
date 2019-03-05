import agents.Agent;
import clients.Client;

import java.util.HashMap;
import java.util.Map;

public class Dispatcher {

    private Map<Integer, Map<Integer, Agent>> agents;
    private Agent availableAgent;

    public Dispatcher() {
        this.agents = new HashMap<>();
    }

    public void attend(Client client) {
        if (findAvailableAgent() != null) {
            this.availableAgent = findAvailableAgent();
        }
        else{
            System.out.println("Toca esperar");
        }
    }

    public Agent findAvailableAgent() {
        System.out.println(agents.get(1));
        System.out.println(agents.get(1).size());
        System.out.println(agents.get(1).get(1).isStatus());

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < agents.get(i).size()+1; j++) {
                if (agents.get(i).get(j).isStatus()) {
                    return agents.get(i).get(j);
                }
            }
        }
        return null;
    }

    public void setAgents(int codeAgent, int code, Agent agent) {
        Map<Integer, Agent> agentsPerType = new HashMap<>();
        agentsPerType.put(code, agent);
        if (this.agents.containsKey(codeAgent)) {
            this.agents.get(codeAgent).put(code, agent);
        } else {
            this.agents.put(codeAgent, agentsPerType);
        }
    }
}
