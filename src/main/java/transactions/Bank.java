package transactions;

import java.util.*;


public class Bank {
    private Map<String, Client> clients = new HashMap<>();
    private final Random random = new Random();

    /* Fraud decision-making procedure */
    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }


    /* TODO: Add new account into bank accounts storage */
    public void addNewClient(String accNumber, Client client) {
        clients.put(accNumber, client);
    }

    /* TODO: Return Account entity with particular account number */
    public List<Client> getClientsByAccountNumber(String number) {
        List<Client> foundClients = new ArrayList<>();
        if ((clients.containsKey(number)) == true) {
            foundClients.add(clients.get(number));
        }
        return foundClients;
    }


    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public boolean transfer(String fromAccountNum, String toAccountNum, long amount) {
        boolean transferResult = true;
        Client from = new Client();
        Client to = new Client();

        List<Client> fromClients = getClientsByAccountNumber(fromAccountNum);
        if (fromClients.size() > 0) {
            from = fromClients.get(0);
        }
        else {
            transferResult = false;
        }

        List<Client> toClients = getClientsByAccountNumber(fromAccountNum);
        if (toClients.size() > 0) {
            to = toClients.get(0);
        }
        else {
            transferResult = false;
        }

        if (transferResult) {
            from.sendMoney(to, 1000);
        }
        return transferResult;
    }


    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        List<Client> clients = getClientsByAccountNumber(accountNum);
        if (clients.size() == 0) return -1;

        long money = clients.get(0).getAccount().getMoney();
        return money;
    }

    public long getSumAllAccounts() {
        long totalMoney = 0;

        Set<String> accNumbers = clients.keySet();
        for (String number: accNumbers) {
            Client c = clients.get(number);
            totalMoney += c.getRestMoney();
        }
        return totalMoney;
    }
}

