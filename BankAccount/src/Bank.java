/* Assignment 4
   Description: Bank Account
   Name: Jessy Martinez
   Student ID: 921887015
   Class: CSC 210-04
   Semester: Spring 2022
 */

//  Import Scanner
import java.util.Scanner;
// Imported everything util. has, including ArrayList
import java.util.*;

public class Bank {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, welcome to Jessy's Bank");

        // Create a scanner object
        Scanner input = new Scanner(System.in);
        // Create an arrayList obj
        ArrayList<String> pws = new ArrayList<>();

        // Start off by making user create a pw 
        System.out.println("The answer to the next question will serve as your password:");
        System.out.println("In what city did you have your first job?");
        // Store answer in a variable
        String ans = input.nextLine();
        // Store pw in pws array because user may change pw if they want to.
        pws.add(ans);

        System.out.println("Thank you");
        // and create a starting balance
        System.out.println("You have nothing in your account, how much would you like to deposit today?");
        // Store balance in a variable
        int firstBalance = input.nextInt();

        System.out.println("Great, thank you");

        // Create a while loop that continues unless flag becomes false
        boolean flag = true;
        while(flag){
            // Give order options
            System.out.println(" ");
            System.out.println("What would you like to do today?");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change Answer of Security Question");
            System.out.println("5. Exit");
            System.out.println("Choose option by its assigned number ('1','2','3','4', or '5')");
            System.out.println(" ");
            // Store answers in variable
            int switchAns = input.nextInt();
            // Use switch statement for options
            switch(switchAns){
                case 1:
                // Make sure it is the right user before sharing private information
                    System.out.println("What is your password?");
                    String checkPw1 = input.next();
                    // Check if the pw is the most current
                    if(pws.get(pws.size()-1).equals(checkPw1)){
                        System.out.println("Your balance is: $" + firstBalance);
                        // Break and re-loop
                        break;
                    }
                    else{
                        // wrong password, start over
                        System.out.println("Passwords do not match, try again.");
                    }
                    break;
                case 2:
                // This one I did not check password because if a person want to deposit for someone else, then they may
                    System.out.println("How much would you like to deposit?");
                    int deposit = input.nextInt();
                    // Update to new balance
                    firstBalance += deposit;
                    System.out.println("Your new balance is: $" + firstBalance);
                    break;
                case 3:
                    System.out.println("What is your password?");
                    String  checkPw3= input.next();
                    // Make sure pw is the most current
                    if(pws.get(pws.size()-1).equals(checkPw3)){
                        System.out.println("How much would you like to withdraw?");
                        int withdraw = input.nextInt();
                        if(firstBalance >= withdraw){
                            firstBalance -= withdraw;
                            System.out.println("Your new balance is: $" + firstBalance);
                        }
                        else{
                            System.out.println("You do not have that much, try again.");
                        }
                    }
                    else{
                        System.out.println("Passwords do not match, try again.");
                    }
                    break;
                case 4:
                
                    System.out.println("What is your password?");
                    String checkPw4 = input.next();
                if(pws.get(pws.size()-1).equals(checkPw4)){
                    // Utilize changepw method
                    pws.add(changeAnsSecurityQuestion());

                }
                else{
                    System.out.println("Passwords do not match, try again.");
                }
                    break;
                case 5:
                    System.out.println("Thank you for coming to Jessy's Bank.");
                    // Cause the while loop to stop 
                    flag = false;
                    break;
                default:
                    System.out.println("That is not answer, try again.");
            }
        }
    input.close();



    }

    // Create balance method
    public static void checkBalance(double balance, String answer, int account){
        System.out.println("Account number is: " + account);
        System.out.println("Password is: " + answer);
        System.out.println("Your balance is: $" + balance);

    }

    // Create deposit method
    public static double depositMoney(double balance){
        System.out.println("Enter the amount to deposit:");
        Scanner input = new Scanner(System.in);
        int deposit = input.nextInt();
        return balance += deposit;
    }

    public static double withdrawMoney(double balance){
        System.out.println("How much would you like to withdraw?");
        Scanner input = new Scanner(System.in);
        double balance1 = input.nextInt();
        return balance1;
    }

    // Create security method
    public static String changeAnsSecurityQuestion(){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like your new password to be?");
                    String newPw = input.next();
                    return newPw;
    }

}
