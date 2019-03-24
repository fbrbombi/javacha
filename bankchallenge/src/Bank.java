import agents.Agent;
import clients.Client;

import java.util.List;

import static variablesGenerator.PeopleGenerator.*;

/**
 * Java Challenge Bank
 *
 * @author Fabio A. Bombiela Ramirez
 * @Version 1.0
 */


public class Bank {


    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        List<Client> clients = clientGen();
        List<Agent> cashiers = cashierGen();
        List<Agent> supervisors = supervisorsGen();
        List<Agent> directors = directorGen();
        dispatcher.obtainListAgents(cashiers, 1);
        dispatcher.obtainListAgents(supervisors, 2);
        dispatcher.obtainListAgents(directors, 3);


        for (int i = 0; i < clients.size(); i++) {
            dispatcher.attend(clients.get(i));
        }

    }


}
