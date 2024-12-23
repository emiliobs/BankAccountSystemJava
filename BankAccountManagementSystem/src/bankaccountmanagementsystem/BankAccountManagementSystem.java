package bankaccountmanagementsystem;

import Repository.AccountRepository;
import Service.AccountService;
import View.AccountView;

/**
 *
 * @author Emilio
 */
public class BankAccountManagementSystem
{
    public static void main(String[] args)
    {
        AccountRepository repository = new AccountRepository();
        AccountService service = new AccountService(repository);
        AccountView accountView = new AccountView(service);
        
        accountView.displayMenu();
    }
    
}
