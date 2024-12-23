package Model;

import java.util.LinkedList;
import javax.management.openmbean.OpenDataException;

/**
 *
 * @author Emilio
 */
public class Account
{

    private String accountNumber;
    private String holderName;
    private String holderAddress;
    private String openingDate;
    private double currentBalance;
    private LinkedList<Transaction> transactions; // Store the last 4 transactions

    public Account()
    {
    }

    public Account(String accountNumber, String holderName, String holderAddress, String openingDate, double currentBalance)
    {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.holderAddress = holderAddress;
        this.openingDate = openingDate;
        this.currentBalance = currentBalance;
        this.transactions =  new LinkedList<>();
    }

    public String getOpeningDate()
    {
        return openingDate;
    }

    public void setOpeningDate(String openingDate)
    {
        this.openingDate = openingDate;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public String getHolderName()
    {
        return holderName;
    }

    public void setHolderName(String holderName)
    {
        this.holderName = holderName;
    }

    public String getHolderAddress()
    {
        return holderAddress;
    }

    public void setHolderAddress(String holderAddress)
    {
        this.holderAddress = holderAddress;
    }

    public double getCurrentBalance()
    {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance)
    {
        this.currentBalance = currentBalance;
    }

    public LinkedList<Transaction> getTransactions()
    {
        return transactions;
    }

    public void setTransactions(LinkedList<Transaction> transactions)
    {
        this.transactions = transactions;
    }
  

    public void addTransaction(Transaction transaction)
    {
        if (transactions.size() == 4)
        {
            transactions.removeFirst(); // Keep only the las 4 transaction.
        }
        
        transactions.add(transaction);
    }

    @Override
    public String toString()
    {
        return "Account: " + "\n"
                + "  Account Number: " + accountNumber + "\n" 
                + "  Holder Address  : " + holderName + "\n" 
                + "  Holder Address  : " + holderAddress + "\n" 
                + "  Opening Date     : " + openingDate + "\n" 
                + "  Current Balance : " + currentBalance ;
    }

    

}
