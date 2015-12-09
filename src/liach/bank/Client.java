package liach.bank;

public final class Client {

	public static void main(String[] args) {
		BankAccount tiger = BankManager.getInstance().getAccount("tiger");
		BankAccount zebra = BankManager.getInstance().getAccount("zebra");
		tiger.save(500D);
		zebra.save(500D);
		tiger.transferTo(zebra, 499);
		System.out.println(tiger);
		System.out.println(zebra);
	}
	
	private Client() {
	}

}
