package Assignment_4;

class BankATMException extends Exception{

	
	private static final long serialVersionUID = 1L;
	public BankATMException(String name, String location, Double balance) {
		this("ATM Error: Balance " + balance + " < " + 10000
				+ "\nBank Name: " + name
				+ "\nLocation: " + location);
	}
	public BankATMException(String message) {
		super(message);
	}
	
}
class BankAtm{
	int atmId;
	String bankName;
	String location;
	double balance;
	
	public BankAtm(int atmId, String bankName, String location, double balance) {
		this.atmId = atmId;
		this.bankName = bankName;
		this.location = location;
		this.balance = balance;
	}
	
	void withdraw(double amt) throws BankATMException{
		if (balance < 10000) {
			throw new BankATMException(bankName, location, balance);
		} else if(amt > balance) {
			System.out.println("Insufficient funds.");
		} else if(amt <= 0){
			System.out.println("Withdrawal must be a positive number.");
		} else {
			balance = balance - amt;
			System.out.println("Bank name: " + bankName
					+ "\nLocation: " + location
					+ "\nWithdrawal amount: " + amt
					+ "\nNew Balance: " + balance);
		}
	}
	void deposit(double amt) {
		if (amt > 0) {
			balance += amt;
			System.out.println("Bank name: " + bankName
					+ "\nLocation: " + location
					+ "\nDeposit amt: " + amt
					+ "\nNew Balance: " + balance);
		} else {
			System.out.println("Deposit must be positive.");
		}
	}
}
public class Bank {
	public static void main(String[] args) {
		BankAtm atm1, atm2, atm3;
		atm1 = new BankAtm(1, "Bank1", "Location1", 5000);
		atm2 = new BankAtm(2, "Bank2", "Location2", 10000);
		atm3 = new BankAtm(3, "Bank3", "Location3", 20000);
		System.out.println("atm1 = {atmID:1, bankName:Bank1, location:Location1, balance:5000}");
		System.out.println("atm1 = {atmID:2, bankName:Bank2, location:Location2, balance:10000}");
		System.out.println("atm1 = {atmID:3, bankName:Bank3, location:Location3, balance:20000}");
		try {
			System.out.println("\nDeposit to atm1: 2000");
			atm1.deposit(2000);
			System.out.println("\nWithdrawal from atm2: 15000");
			atm2.withdraw(15000);
			System.out.println("\nWithdrawal from atm2: -1");
			atm2.withdraw(-1);
			System.out.println("\nDeposit to atm3: 500");
			atm3.deposit(500);
			System.out.println("\nWithdrawal from atm3: 20000");
			atm3.withdraw(20000);
			System.out.println("\nWithdrawal from atm1: 200");
			atm1.withdraw(200);
		} catch (BankATMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}