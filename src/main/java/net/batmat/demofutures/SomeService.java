package net.batmat.demofutures;
public class SomeService
{
	public int countApples()
	{
		try {Thread.sleep(5000);}catch(InterruptedException e){throw new RuntimeException(e);}
		return 5;
	}

	public int countBananas()
	{
		try {Thread.sleep(15000);}catch(InterruptedException e){throw new RuntimeException(e);}
		return 15;
	}

	public int countCarWheels()
	{
		try {Thread.sleep(10000);}catch(InterruptedException e){throw new RuntimeException(e);}
		return 10;
	}
}
