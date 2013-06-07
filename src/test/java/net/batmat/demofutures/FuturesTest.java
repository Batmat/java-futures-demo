package net.batmat.demofutures;

import static org.fest.assertions.Assertions.assertThat;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * This test class has two test.
 * <ul>
 * <li>One does not use future and show synchronous operations that makes overall time long (around
 * 30 seconds).</li>
 * <li>The second one executes each operations in parallel and then sums them all when they're done.
 * So this implementation takes roughly the maximum time of the three computations.</li>
 * </ul>
 * 
 * @author Batmat
 */
public class FuturesTest
{
	private SomeService service = new SomeService();

	@Test
	// Let's test adding meaningful things.
	public void withoutFutures() throws Exception
	{
		long before = System.currentTimeMillis();
		// Without futures, it's gonna take the addition of each operation time
		assertThat(service.countApples() + service.countBananas() + service.countCarWheels())
			.isEqualTo(30);
		long after = System.currentTimeMillis();
		System.out.println("Test without futures took " + (after - before) / 1000 + " seconds");
	}

	ExecutorService executor = Executors.newFixedThreadPool(3);

	@Test
	/**
	 * Here, with Future, a bit more complex and mostly more verbose (lambdas@java8 will help a lot here),
	 * but quicker since it should roughly take the maximum time of the three computations instead 
	 * of theirs addition.
	 */
	public void withFutures() throws Exception
	{
		long before = System.currentTimeMillis();
		Future<Integer> apples = executor.submit(new Callable<Integer>()
		{
			public Integer call() throws Exception
			{
				return service.countApples();
			}
		});
		Future<Integer> bananas = executor.submit(new Callable<Integer>()
		{
			public Integer call() throws Exception
			{
				return service.countBananas();
			}
		});
		Future<Integer> carWheels = executor.submit(new Callable<Integer>()
		{
			public Integer call() throws Exception
			{
				return service.countCarWheels();
			}
		});

		assertThat(apples.get() + bananas.get() + carWheels.get()).isEqualTo(30);
		long after = System.currentTimeMillis();
		System.out.println("Test with futures took " + (after - before) / 1000 + " seconds");
	}

}
