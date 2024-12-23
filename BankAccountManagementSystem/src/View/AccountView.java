package View;

import Model.Account;
import Model.Transaction;
import Repository.AccountRepository;
import Service.AccountService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Emilio
 */
public class AccountView
{

    private AccountService accountService;
    private Scanner scanner;

    public AccountView(AccountService accountService)
    {
        this.accountService = accountService;
        this.scanner =  new Scanner(System.in);
    }

    public void displayMenu()
    {
        while (true)
        {
            System.out.println("\nBANK ACCOUNT MANAGEMENT SYSTEM.");
            System.out.println("1.  Create a New Account.");
            System.out.println("2.  Display All Accounts.");
            System.out.println("3.  Delete an Account.");
            System.out.println("4.  Add a Transaction.");
            System.out.println("5.  Display Last Four Transaction (Sorted).");
            System.out.println("6. Exit.");
            System.out.print("Choose an Option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline
            
            switch (choice)
            {
                case 1:
                    createAccount();
                    break;
                case 2:
                    displayAllAccounts();
                    break;
                case 3: 
                    deleteAccount();
                    break;
                case 4:
                    addTransaction();
                    break;
                case 5:
                    displayLastFourTransactions();
                    break;
                case 6: 
                    System.out.println("Exiting..... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, Try again.");;
            }
        }
    }

    private void createAccount()
    {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
         System.out.print("Enter Holder Name: ");
        String holderName = scanner.nextLine();
        
         System.out.print("Enter Holder Address: ");
        String holderAddress = scanner.nextLine();
        
         System.out.print("Enter Opening Date (DD/MM/YYYY): ");
        String openingDate = scanner.nextLine();
        
         System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();
        
         accountService.createAccount(accountNumber, holderName, holderAddress, openingDate, initialBalance);
         System.out.println("Account created successfully!");
    }

    private void displayAllAccounts()
    {
        List<Account> accounts = accountService.getAllAccounts();
        
        if (accounts.isEmpty())
        {
            System.out.println("No accouts found.");
        }
        else
        {
            accounts.forEach(System.out::println);
        }
    }

    private void deleteAccount()
    {
        System.out.print("Enter Accout Number to Delete: ");
        String accountNumber = scanner.nextLine();
        accountService.deleteAccount(accountNumber);
        System.out.println("Account deleted successfully!");
    }

    private void addTransaction()
    {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
         System.out.print("Enter Transaction Type (deposit/withdrawal): ");
        String type = scanner.nextLine();
        
         System.out.print("Enter Transaction Amount: ");
         double amount = scanner.nextDouble();
         
         if (accountService.addTransaction(accountNumber, type, amount))
        {
            System.out.println("Transaction added successfully!");
        }
         else
         {
             System.out.println("Transaction failed. Check account number or balance.");
         }
        
         
    }

    private void displayLastFourTransactions()
    {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        
        List<Transaction> transactions = accountService.getLastFourtTransactionsSorted(accountNumber);
        if (transactions == null || transactions.isEmpty())
        {
            System.out.println("No transactions found or invalid account number.");
        }
        else
        {
            transactions.forEach(System.out::println);
        }
    }
    
    
//    public static void main(String[] args)
//    {
// AccountRepository repository = new AccountRepository();
// AccountService service = new AccountService(repository);
//  AccountView accountView = new AccountView(service);
//        
//        accountView.displayMenu();
//    }
    
}



