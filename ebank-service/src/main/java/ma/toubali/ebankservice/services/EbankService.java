package ma.toubali.ebankservice.services;

import ma.toubali.ebankservice.entities.BankAccount;
import ma.toubali.ebankservice.feign.CustomerRestClient;
import ma.toubali.ebankservice.model.Customer;
import ma.toubali.ebankservice.repository.BankAccountRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {
    private BankAccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public EbankService(BankAccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    @McpTool(description = "Get all Bank accounts")
    public List<BankAccount> getAllBankAccounts(){
        return accountRepository.findAll();
    }

    @McpTool(description = "Get a bank account by id")
    public BankAccount getBankAccountById(@McpToolParam(description = "The bank account id ") String id){
        BankAccount bankAccount= accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }

    @McpTool(description = "The bank account to save (balance, type, customerId)")
    public BankAccount save(BankAccount bankAccount){
        try {
            Customer customer=customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            return accountRepository.save(bankAccount);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
