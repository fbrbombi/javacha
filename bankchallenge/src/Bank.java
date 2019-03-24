import agents.Agent;
import clients.Client;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static utils.PeopleGenerator.*;

/**
 * Java Challenge Bank
 *
 * @author Fabio A. Bombiela Ramirez
 * @Version 1.0
 */


public class Bank {


    public static void main(String[] args) {

        Dispatcher dispatcher = new Dispatcher("" + 0);
        List<Client> clients = clientGen();
        List<Agent> cashiers = cashierGen();
        List<Agent> supervisors = supervisorsGen();
        List<Agent> directors = directorGen();
        dispatcher.obtainListAgents(cashiers, 1);
        dispatcher.obtainListAgents(supervisors, 2);
        dispatcher.obtainListAgents(directors, 3);
        int directorSize = directors.size();
        int cashierSize = cashiers.size();
        int superSize = supervisors.size();
        System.out.println(directorSize + cashierSize + superSize + " Agents");
        ExecutorService executor = Executors.newFixedThreadPool(directorSize + cashierSize + superSize);
        System.out.println(clients.size() + " clients");

        int i = 1;
        for (Client client : clients) {
            Runnable worker = new Dispatcher("" + i);
            ((Dispatcher) worker).setClient(client);
            executor.execute(worker);
            i++;
        }
        executor.shutdown();
        while (!executor.isTerminated()) ;
    }


}
