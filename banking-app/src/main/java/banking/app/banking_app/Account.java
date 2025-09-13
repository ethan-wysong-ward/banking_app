package banking.app.banking_app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id @GeneratedValue

    private Long id;

    private String owner;

    private double balance;

    public Account() {}
    
    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
}
