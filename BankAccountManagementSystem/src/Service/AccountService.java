package Service;

import Model.Account;
import Model.Transaction;
import Repository.AccountRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Emilio
 */
public class AccountService
{
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }
    
   public  void createAccount(String accountNumber, String holdName, String holdAddress, String openingDate, double initialBalance )
   {
       Account account = new Account(accountNumber, holdName, holdAddress, openingDate, initialBalance);
       accountRepository.addAccount(account);
   }
    
   public List<Account> getAllAccounts()
   {
       return  new ArrayList<>(accountRepository.getallAccounts().values());
   }
   
   public  boolean addTransaction(String accountNumber, String type, double amount)
   {
       Account account = accountRepository.getAccount(accountNumber);
       
       if (account == null)
       {
           return  false;
       }
       
       double newBalance = type.equals("deposit") ?  account.getCurrentBalance() + amount :  account.getCurrentBalance() - amount;
       
       if (newBalance < 0)
       {
           return false; //Prevent negative balance
       }
       account.setCurrentBalance(newBalance);
       account.addTransaction(new Transaction(type, amount));
       
       return  true;
       
   }
   
   public List<Transaction> getLastFourtTransactionsSorted(String accountNumber)
   {
       Account account = accountRepository.getAccount(accountNumber);
       if (account == null)
       {
           return null;
       }
       
       List<Transaction> transactions = new ArrayList<>(account.getTransactions());
       transactions.sort(Comparator.comparingDouble(Transaction::getAmount));// Sort by amount descending
       
       return  transactions;
   }
   
   public void deleteAccount(String accountNumber)
   {
       accountRepository.deleteAccount(accountNumber);
   }
    
}
