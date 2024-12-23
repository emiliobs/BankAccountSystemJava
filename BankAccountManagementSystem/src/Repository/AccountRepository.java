package Repository;

import Model.Account;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Emilio
 */
public class AccountRepository
{
    private Map<String, Account>  accounts = new HashMap<>();
    
    
    public  void addAccount(Account account)
    {
        accounts.put(account.getAccountNumber(), account);
    }
    
    public  Account getAccount(String accountNumber)
    {
        return accounts.get(accountNumber);
    }
    
    public void deleteAccount(String accountNumber)
    {
        accounts.remove(accountNumber);
    }
    
    public  Map<String, Account> getallAccounts()
    {
        return accounts;
    }
    
}
