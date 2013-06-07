package net.batmat.demofutures;
public class SomeService
{
	public int countApples() throws InterruptedException
	{
		Thread.sleep(5000);
		return 5;
	}

	public int countBananas() throws InterruptedException
	{
		Thread.sleep(15000);
		return 15;
	}

	public int countCarWheels() throws InterruptedException
	{
		Thread.sleep(10000);
		return 10;
	}
}
