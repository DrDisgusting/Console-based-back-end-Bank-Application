package bankaccountapp;

public interface IBaseRate {
	default double baserate()
	{
		return 2.5;
	}
}
