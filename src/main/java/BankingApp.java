import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Bank myBank = new Bank();

		myBank.addAccount("1111", new BankAccount("1111", "Checking", 17.38));
		myBank.addAccount("2222", new BankAccount("2222", "Savings", 350.00));

		System.out.println("Here are your current accounts at our bank: ");
		for (BankAccount current : myBank.accountsDisplay()) {
			System.out.println(current.getType() + " " + current.getBalance());
		}
		menu();
		int selection = input.nextInt();
		while (selection < -1 || selection > 4 || selection == 0) {
			System.out.println("You have entered an invalid choice.");
			menu();
			selection = input.nextInt();
		}
		double amount = 0;
		while ((selection >= 1 && selection <= 4) || selection == -1) {
			if (selection == 1) {
				System.out.println("You want to deposit");
				showAccounts(myBank);
				System.out.println("Select the account by (acct num) to perform this transaction.");
				String enteredAccount = accountMatch(input, myBank);
				System.out.println("You have selected " + enteredAccount);
				System.out.println("Please enter a deposit amount: ");
				amount = input.nextDouble();
				myBank.accounts.get(enteredAccount).deposit(amount);
				;
				System.out.println("Your updated balance is " + myBank.accounts.get(enteredAccount).getBalance());
			}

			if (selection == 2) {
				System.out.println("You would like to withdraw.");
				showAccounts(myBank);
				System.out.println("Select the account by (acct num) to perform this transaction.");
				String enteredAccount = accountMatch(input, myBank);
				System.out.println("You have selected " + enteredAccount);
				System.out.println("Please enter a withdraw amount: ");
				amount = input.nextDouble();
				while (amount > myBank.accounts.get(enteredAccount).getBalance()) {
					System.out.println("You do not have the funds available.");
					System.out.println("Your balance is " + myBank.accounts.get(enteredAccount).getBalance());
					System.out.println("How much would you like to withdraw?");
					amount = input.nextDouble();
				}
				myBank.accounts.get(enteredAccount).withdraw(amount);
				;
				System.out.println("Your updated balance is " + myBank.accounts.get(enteredAccount).getBalance());
			}
			if (selection == 3) {
				System.out.println("You want to check your balance.");
				showAccounts(myBank);
			}
			if (selection == 4) {
				System.out.println("You want to close an account.");
				showAccounts(myBank);
				System.out.println("Enter the account number of the account you would like to close: ");
				String enteredAccount = accountMatch(input, myBank);
				System.out.println("You want to close account # " + enteredAccount);
				myBank.closeAccount(enteredAccount);
				showAccounts(myBank);
			}

			if (selection == -1) {
				System.out.println("Thanks for banking with us. Have a nice day!");
				System.exit(0);
			}
			menu();
			selection = input.nextInt();
		}
	}

	public static String accountMatch(Scanner input, Bank myBank) {
		String enteredAccount = input.next();
		input.nextLine();
		while (!myBank.allowAccess(enteredAccount)) {
			System.out.println("You have selected an invalid account");
			showAccounts(myBank);
			System.out.println("Select the account by (acct num) to perform this transaction.");
			enteredAccount = input.next();
			input.nextLine();
		}
		return enteredAccount;
	}

	public static void showAccounts(Bank myBank) {
		System.out.println("Here are your accounts:");
		for (BankAccount current : myBank.accountsDisplay()) {
			System.out.println("(" + current.getAccountNum() + ") " + current.getType() + " " + current.getBalance());
		}
	}

	public static void menu() {
		System.out.println("\nWhat would you like to do? " + "\nPress 1 to deposit" + "\nPress 2 to withdraw"
				+ "\nPress 3 to check balance" + "\nPress 4 to close an account" + "\nPress -1 to exit");
	}
}
