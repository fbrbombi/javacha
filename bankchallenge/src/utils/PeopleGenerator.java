package utils;

import agents.Agent;
import agents.Cashier;
import agents.Director;
import agents.Supervisor;
import clients.Client;

import java.util.ArrayList;
import java.util.List;

import static utils.Generator.*;

/**
 * Generates random size for each kind of agent, also creates a random size of clients
 */
public class PeopleGenerator {

    public static List<Client> clientGen() {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < ((int) (Math.random() * 40) + 40); i++) {
            clients.add(new Client(randomName(), randomAge(), randomCC(), randomMail(), randomPhone(), randomIssue(), randomComment()));
        }
        return clients;
    }

    public static List<Agent> cashierGen() {
        List<Agent> cashiers = new ArrayList<>();
        for (int i = 0; i < ((int) (Math.random() * 5) + 1); i++) {
            cashiers.add(new Cashier(randomName(), randomAge(), randomCC(), randomMail(), randomPhone()));
        }
        return cashiers;
    }

    public static List<Agent> supervisorsGen() {
        List<Agent> supervisors = new ArrayList<>();
        for (int i = 0; i < ((int) (Math.random() * 5) + 1); i++) {
            supervisors.add(new Supervisor(randomName(), randomAge(), randomCC(), randomMail(), randomPhone()));
        }
        return supervisors;
    }

    public static List<Agent> directorGen() {
        List<Agent> directors = new ArrayList<>();
        for (int i = 0; i < ((int) (Math.random() * 5) + 1); i++) {
            directors.add(new Director(randomName(), randomAge(), randomCC(), randomMail(), randomPhone()));
        }
        return directors;
    }
}
