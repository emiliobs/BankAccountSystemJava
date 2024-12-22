package Model;

import java.util.Date;

/**
 *
 * @author Emilio
 */
class Transaction
{

    private String typeTransaction; // Deposit or Withdrawal
    private double amount;
    private Date date;

    public Transaction()
    {
    }

    public Transaction(String typeTransaction, double amount, Date date)
    {
        this.typeTransaction = typeTransaction;
        this.amount = amount;
        this.date = date;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getTypeTransaction()
    {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction)
    {
        this.typeTransaction = typeTransaction;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "Transaction: "
                + "Type Transaction: " + typeTransaction
                + "Amount                : " + amount
                + "Date                     : " + date;
                
    }

}
