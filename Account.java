package bankaccountapp;


public abstract class Account implements IBaseRate {
	private String name;
	private String SSN;
	protected String accountnumber;
	private double balance;
	private double interest;
	protected double rate;
	private static  int index = 10000;
	public Account(String name,String SSN,double deposit)
	{
		this.name = name;
		this.SSN = SSN;
		index++;
		this.accountnumber = Accountnumber1();
		this.balance = deposit;
		setinterest();
	}
	protected abstract void setinterest();
	public String Accountnumber1()
	{
		int unique = index;
		int randomnumber = (int)(Math.random()*Math.pow(10, 3));
		String acc = SSN.substring(SSN.length()-2,SSN.length())+unique+randomnumber;
		return acc;
	}
	protected void compound()
	{
		interest = balance * (rate/100);
		System.out.println("Interest is :"+interest);
	}
	protected void diposit(double amount)
	{
		balance = balance + amount;
		printbalance();
	}
	protected void withdraw(double amount)
	{
		balance = balance - amount;
		printbalance();
	}
	protected void transfer( double amount)
	{
		balance = balance - amount;
		System.out.println("Transfering amount "+amount );
		printbalance();
	}
	protected void printbalance()
	{
	  System.out.println("Your new balance is       : "+balance+" INR");	
	}
	protected void showinfo()
	{
		System.out.println("Name                   : "+name+" "+
	                       "\nSocial Security Number : "+SSN+" "+
				           "\nAccount number         : "+accountnumber+
				           "\nBalance is             : "+balance+" INR"+
				           "\nInterest rate is       : "+rate+"%");
	}
	
  
  
}
