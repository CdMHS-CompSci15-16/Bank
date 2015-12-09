package liach.bank;

import java.util.HashMap;
import java.util.Map;

public final class BankManager {
	private Map<String, BankAccount> idToAccountMap;

	private static BankManager instance = new BankManager();
	
	private BankManager() {
		this.idToAccountMap = new HashMap<>();
	}
	
	public static BankManager getInstance() {
		return instance;
	}
	
	public BankAccount getAccount(String id) {
		BankAccount account = idToAccountMap.get(id);
		if (account == null) {
			try {
				account = new BankAccount(id);
			} catch (DuplicateAccountException ex) {
				ex.printStackTrace();
			}
		}
		return account;
	}
	
	void addAccount(BankAccount account) throws DuplicateAccountException {
		String id = account.getId();
		if (idToAccountMap.containsKey(id)) {
			throw new DuplicateAccountException(id, account);
		}
		idToAccountMap.put(id, account);
	}
}
