package transactions;

import lombok.Data;

@Data
public class Account {
    private String accNumber;
    private long money;

    public Account() {
        this.accNumber = "";
        this.money = 0;
    }

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
    }

    public void incrementMoney(long money) {
        this.money += money;
    }

    public void decrementMoney(long money) {
        this.money -= money;
    }

}
