import java.math.BigDecimal;

public class BankAccount {
    int id;
    User user;
    Branch branch;
    int number;
    BigDecimal balance;

    public BankAccount() {

    }

    public BankAccount(int id, User user, Branch branch, int number, BigDecimal balance) {
        this.id = id;
        this.user = user;
        this.branch = branch;
        this.number = number;
        this.balance = balance;
    }

    public void checkBalance() {
        System.out.println("Consultando saldo...");
    }
}