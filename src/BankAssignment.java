
import java.io.*;
import java.util.Scanner;
public class BankAssignment {
    public static void main(String[] args) throws IOException {
        double balance = 1000.00;
        double withdraw;
        int transactionNum = 1;
        int activity;
        double deposit;
        System.out.println("Welcome to CIS-2348 Banking System!\n");
        File infile = new File("bankFile.txt");
        FileWriter fwriter = new FileWriter("bankFile.txt");
        PrintWriter outfile = new PrintWriter(fwriter);
        Scanner input = new Scanner(System.in);
        Scanner inp = new Scanner(infile);
        String choice = "yes";
        while (!(choice.equals("exit"))) {
            System.out.println("Enter your option as a number:\n\n1. Display balance\n" +
                    "2. Deposit\n3. Withdraw amount\n4. Exit");
            activity = input.nextInt();


            //Display Balance
            if (activity == 1) {
                System.out.printf("Your account balance is $%.2f.%n", balance);
                System.out.println("Would you like to make another transaction?\n");
                choice = input.nextLine();

                //Deposit into account
            } else if (activity == 2) {

                System.out.println("How much would you like to deposit today?");
                deposit = input.nextDouble();
                balance = deposit + balance;
                outfile.printf("%.2s    Deposit  +$%.2f   $%.2f.%n",transactionNum, deposit, balance);
                transactionNum++;
                System.out.println("Would you like to make another transaction?");
                choice = input.nextLine();

                //Withdraw from account
            } else if (activity == 3) {
                System.out.println("How much would you like to withdraw today?");
                withdraw = input.nextDouble();
                if (balance - withdraw < 0) { //will not allow funds to be withdrawn if lower than balance
                    System.out.println("Not enough funds for this withdrawal. Maximum withdrawal is " + "$" + balance + "\n");
                } else { //withdraws the amount from the balance
                    balance -= withdraw;
                    outfile.printf("%.2s    Withdraw +$%.2f   $%.2f.%n",transactionNum, withdraw, balance);
                    transactionNum++;

                }
                System.out.println("Would you like to make another transaction?");
                choice = input.nextLine();

            } else { //Exit Program
                System.out.println("\nGoodbye.\n");
                outfile.close();
                break;
            }

        }

        while (inp.hasNextLine()) {
            System.out.println(inp.nextLine());
        }
        inp.close();
    }
}