package bankaccountapp;

public class Savings extends Account {
	public Savings(String name,String SSN,double deposit)
	{
		super(name,SSN,deposit);
		accountnumber = "2"+accountnumber;
		
	}
	public void setinterest()
	{
		rate=baserate() * .15;
	}
	public void showinfo()
	{
		super.showinfo();
		setinterest();
		System.out.println("This is saving account");
	}

}
