/*
    Name:  Josua Christyanton
    Assignment:  Assignment 1
    Program: PROG24178 Java 2
    Date:  January 19th 2020
   
    Description:
    The following program, creates an account object with parameters of account
    number, customer name, and balance. Default values are set for each.
    Validation is set to make sure the setters mutate the instance variables
    correctly. A to string method is also created to format the print statement.
 */
package christya;
import java.lang.*;

/**
 *
 * @author Josua Christyanton
 */
public class Account {

    private String accountNo;
    private String customerName;
    private double balance;

    /**
     Default constructor sets the customer name to "Unknown" and accountNo to
     "0000000".
     */
    public Account() {
        accountNo = "0000000";
        customerName = "Unknown";
    }

    /**
     Overloaded constructor with accountNo and customerName passed in as
     parameters.
     @param accountNo the Account number associated with the account object
     @param customerName the Customer name associated with the account object
     */
    public Account(String accountNo, String customerName) {
        this.accountNo = accountNo;
        this.customerName = customerName;
    }

    /**
     Retrieves the accountNo value
     @return the account number
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     Retrieves the customerName value
     @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     Retrieves the balance value
     @return the balance value
     */
    public double getBalance() {
        return balance;
    }

    /**
     Mutates the accountNo value while making sure it is a 7 digit number.
     @param accountNo The accountNo inputted by the user as a string
     @throws IllegalArgumentException if the accountNo is not a 7 digit number
     */
    public void setAccountNo(String accountNo) {
        if (accountNo.matches("^[0-9]{7}")) {
            this.accountNo = accountNo;
        } else {
            throw new IllegalArgumentException("Error: Account number must "
                    + "be a 7 digit number");
        }
    }

    /**
     Mutates the customerName value while making sure the fields inputted are not
     empty.
     @param customerName The name inputted by the user as a string
     @throws IllegalArgumentException if the name is not entered
     */
    public void setCustomerName(String customerName) {
        if (customerName.equals(" ") || customerName.equals("")) {
            throw new IllegalArgumentException("Error: You must enter the "
                    + "customer name.");
        } else {
            this.customerName = customerName;
        }
    }

    /**
     Mutates the balance value while making sure the fields inputted are not
     negative values.
     @param newBalance The balance inputted by the user
     @throws IllegalArgumentException if the value entered is negative
     */
    public void setBalance(double newBalance) {
        if (newBalance < 0) {
            throw new IllegalArgumentException("Error: Deposit amount cannot "
                    + "be a negative number.");
        } else if(newBalance >= 0) {
            balance = newBalance;
        } 
    }

    /**
     Mutates the balance value while making sure the fields inputted are not
     negative values. This will decrease the balance value.
     @param amount The amount inputted by the user to deduct from the balance
     @throws IllegalArgumentException if the value entered is negative
     */
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Error: Withdraw amount cannot "
                    + "be a negative number.");
        } else {
            balance -= amount;
        }
    }

    /**
     Mutates the balance value while making sure the fields inputted are not
     negative values. This will increase the balance value.
     @param amount The amount inputted by the user to add to the balance
     @throws IllegalArgumentException if the value entered is negative
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Error: Deposit amount cannot "
                    + "be a negative number.");
        } else {
            balance += amount;
        }
    }

    /**
     Formats the account object to the desired String format.
     @return the string formatted correctly for viewing on the console
     */
    public String toString() {
        return String.format("%15s%s\n%15s%s\n%16s%.2f\n", "Account no: ",
                accountNo, "Customer name: ", customerName,
                "Balance: $", balance);
    }
}
