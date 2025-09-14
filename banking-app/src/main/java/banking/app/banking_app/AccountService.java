package banking.app.banking_app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    
    private final AccountRepository repo;

    public AccountService(AccountRepository repo) {
        this.repo = repo;
    }

    public Account getAccountById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Account createAccount(String owner, double initialDeposit) {
        return repo.save(new Account(owner, initialDeposit));
    }

    @Transactional
    public void transfer(Long fromId, Long toId, double amount) {
        Account from = repo.findById(fromId).orElseThrow();
        Account to = repo.findById(toId).orElseThrow();
        if (from.getBalance() < amount) throw new RuntimeException("Insufficient funds");

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
    }
}
