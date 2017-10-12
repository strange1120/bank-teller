import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {

	Map<String, BankAccount> accounts = new HashMap<String, BankAccount>();

	public void addAccount(String accountNum, BankAccount account) {
		accounts.put(accountNum, account);
	}

	public Collection<BankAccount> accountsDisplay() {
		return accounts.values();
	}

	public boolean allowAccess(String enteredAccount) {
		return accounts.containsKey(enteredAccount);
	}

	public void closeAccount(String accountNum) {
		accounts.remove(accountNum);
	}
}
