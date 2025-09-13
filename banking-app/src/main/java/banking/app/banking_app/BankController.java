package banking.app.banking_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {
    
    private final AccountService service;

    public BankController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/account")
    public Account create(@RequestParam String owner, @RequestParam double deposit) {
        return service.createAccount(owner, deposit);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long from, @RequestParam Long to, @RequestParam double amount) {
        service.transfer(from, to, amount);
        return "Transfer successful";
    }
}
