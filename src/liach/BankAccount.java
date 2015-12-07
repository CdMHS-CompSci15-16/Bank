package liach;

import java.math.BigDecimal;

public class BankAccount {
	
	private String id;
	private BigDecimal value;
	
	BankAccount(String id) throws DuplicateAccountException {
		this(id, BigDecimal.ZERO);
	}
	
	BankAccount(String id, BigDecimal value) throws DuplicateAccountException {
		assert (id != null && !id.isEmpty()) : "cannot have an invalid id";
		assert value.signum() != -1 : "cannot have negative money value";
		this.id = id;
		this.value = value;
		BankManager.getInstance().addAccount(this);
	}
	
	public BigDecimal getMoney() {
		return value;
	}
	
	public void setMoney(BigDecimal amount) {
		this.value = amount;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean draw(double amount) {
		return draw(new BigDecimal(amount));
	}
	
	public boolean save(double amount) {
		return save(new BigDecimal(amount));
	}
	
	public boolean draw(BigDecimal amount) {
		assert amount.signum() != -1 : "cannot have negative money value";
		if (value.compareTo(amount) == -1) {
			return false;
		}
		value = value.subtract(amount);
		return true;
	}
	
	public boolean save(BigDecimal amount) {
		assert amount.signum() != -1 : "cannot have negative money value";
		value = value.add(amount);
		return true;
	}
	
	public boolean transferTo(BankAccount that, double amount) {
		if (!this.draw(amount)) {
			return false;
		}
		if (!that.save(amount)) {
			return false;
		}
		return true;
	}
	
	public boolean transferFrom(BankAccount that, double amount) {
		return that.transferTo(this, amount);
	}
	
	public boolean transferTo(BankAccount that, BigDecimal amount) {
		if (!this.draw(amount)) {
			return false;
		}
		if (!that.save(amount)) {
			return false;
		}
		return true;
	}
	
	public boolean transferFrom(BankAccount that, BigDecimal amount) {
		return that.transferTo(this, amount);
	}
	
	@Override
	public String toString() {
		return "BankAccount(" + "id = " + id + "; money = " + value.toString() + ")";
	}
}
