package liach;

public class DuplicateAccountException extends Exception {
	private String occupiedName;
	private BankAccount newAccount;
	
	public DuplicateAccountException(String occupiedName, BankAccount newAccount) {
		this.occupiedName = occupiedName;
		this.newAccount = newAccount;
	}
	
	public String getOccupiedName() {
		return occupiedName;
	}
	
	public BankAccount getExistingAccount() {
		return BankManager.getInstance().getAccount(occupiedName);
	}
	
	public BankAccount getNewAccount() {
		return newAccount;
	}
}
