package bankaccountapp;

public class Checking extends Account {
	public Checking(String name,String SSN,double deposit)
	{
		super(name,SSN,deposit);
		accountnumber = "1"+accountnumber;
	}
	public void setinterest()
	{
		rate = baserate() - .25;
	}
	public void showinfo()
	{
		super.showinfo();
		setinterest();
		System.out.println("Account is Checking type");
	}

}
