package agents;

/**
 * Interface for bank's operations
 */
public interface iBankOperation {
    /**
     * Abstract method for deposit
     * @param deposit
     */
    void deposits(int deposit);

    /**
     * Abstract method for withdraw
     * @param withdraw
     */
    void withdrawals(int withdraw);

    /**
     * Abstract method for any personal issue of the client
     * @param issue
     */
    void resolvingCustomerIssues(String issue);

    /**
     * Abstract method for execute the previous bank's operations
     * @param
     */
    void executeOps();
}

