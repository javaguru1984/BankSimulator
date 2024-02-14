package transactions;

import lombok.Data;

@Data
public class Client {
    private final String firstName;
    private final String lastName;
    private final Account account;

    private void incrementMoney(long money) {
        this.account.incrementMoney(money);
    }

    private void decrementMoney(long money) {
        this.account.decrementMoney(money);
    }

    public Client() {
        this.firstName = "";
        this.lastName = "";
        this.account = new Account();
    }

    public Client(String firstName, String lastName, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }

    public long getRestMoney() {
        return account.getMoney();
    }

    public boolean sendMoney(Client toClient, long money) {
        boolean flagOperation = false;

        if (getRestMoney() >= money) {
            decrementMoney(money);
            toClient.incrementMoney(money);
            flagOperation = true;
        }
        return flagOperation;
    }
}
