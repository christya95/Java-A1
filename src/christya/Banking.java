/*
    Name:  Josua Christyanton
    Assignment:  Assignment 1
    Program: PROG24178 Java 2
    Date:  January 19th 2020
   
    Description:
    The following program, retrieves user input for Account Number, Customer
    name, Initial Balance, Deposit and Withdraw Amounts. The program then 
    validates the users input to make sure it is entered in correctly. Then
    the program outputs the values in a formatted way on the console. The
    Balance amount is adjusted based on how much the user deposits or
    withdraws.
 */
package christya;
import java.util.*;

/**
 *
 * @author Josua Christyanton
 */
public class Banking {

    private Account account;

    /**
     Default constructor creates the account object from the Account class.
     */
    public Banking() {
        account = new Account();
    }

    /**
     Retrieves the user Inputs for Account Number, Customer Name, Initial Balance,
     Deposit amount and the Withdraw amount. Validation is done to make sure the 
     expected numeric values entered are numbers and nothing else.
     @throws InputMismatchException if the expected numeric value entered by 
     the user is anything else but a number
     @param input the scanner input from the user
     @return the account object with updated data fields for Account Number,
     Customer name, and balance value
     */
    public Account getUserInput(Scanner input) {

        String accountNum;
        boolean valid = false;
        do {
            try {
                System.out.print("Enter Account Number: ");
                accountNum = input.nextLine();
                account.setAccountNo(accountNum);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!valid);

        String customerName;
        valid = false;
        do {
            try {
                System.out.print("Enter Customer Name: ");
                customerName = input.nextLine();
                account.setCustomerName(customerName);
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!valid);

        double newBalance;
        valid = false;
        do {
            try {
                System.out.print("Enter initial balance: ");
                newBalance = input.nextDouble();
                account.setBalance(newBalance);
                valid = true;
            } catch (InputMismatchException e2) {
                System.out.println("Error: The value entered must be a number.");
                input.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        } while (!valid);

        double depositAmount;
        valid = false;
        do {
            try {
                System.out.print("Enter deposit amount: ");
                depositAmount = input.nextDouble();
                account.deposit(depositAmount);
                valid = true;
            } catch (InputMismatchException e2) {
                System.out.println("Error: The value entered must be a number.");
                input.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        } while (!valid);

        double withdrawAmount;
        valid = false;
        do {
            try {
                System.out.print("Enter withdraw amount: ");
                withdrawAmount = input.nextDouble();
                account.withdraw(withdrawAmount);
                valid = true;
            } catch (InputMismatchException e2) {
                System.out.println("Error: The value entered must be a number.");
                input.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        } while (!valid);

        System.out.println();
        return account;
    }

    /**
     Formats the account object to the desired String format.
     @return Account classes toString() method
     */
    public String toString() {
        return account.toString();
    }

    /**
     Invokes method/constructor calls, also creates the scanner object here to 
     obtain user inputs and creates the Banking object.
     @param args general arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Banking inventory = new Banking();

        inventory.account = inventory.getUserInput(input);
        System.out.println(inventory.toString());

        input.close();

    }
}
