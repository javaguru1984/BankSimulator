import transactions.Account;
import transactions.Bank;
import transactions.Client;
import tools.ColorOutput;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        String[] accountNumbers = {"123", "456", "789", "000"};

        for (int i=0; i < 4; i++) {
            Account account = new Account(accountNumbers[i], 1000000 * (i+1));
            Client client = new Client("Ivan", "Petrov", account);
            bank.addNewClient(accountNumbers[i], client);
        }

        ColorOutput output = new ColorOutput();

        long accountMoney = bank.getBalance("789");
        String message = output.greenMessage("Account money: " + accountMoney);
        System.out.println(message);

        long allAccountsMoney = bank.getSumAllAccounts();
        message = output.redMessage("All accounts money: " + allAccountsMoney);
        System.out.println(message);

        message = output.yellowMessage("\nThis is end for today !");
        System.out.println(message);
    }
}
