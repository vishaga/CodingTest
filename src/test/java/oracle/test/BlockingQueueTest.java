package oracle.test;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Test.None;

/**
 * Provides sufficient test coverage for oracle.test.BlockingQueue class.
 */
public class BlockingQueueTest {

	/**
	 * Interactive test that shares Queue with multiple thread in a thread safe
	 * manner.
	 * 
	 * @exception None
	 * 
	 * @passCriteria BlockingQueue constructor doesn't accept null queue.
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void test_null_queue() throws Exception {
		new BlockingQueue<String>(null);
	}

	/**
	 * Interactive test that shares Queue with multiple thread in a thread safe
	 * manner.
	 * 
	 * @exception None
	 * 
	 * @passCriteria When single thread is pushing data and waits for 1000 Milli
	 *               seconds and interrupts the thread.
	 * 
	 */
	@Test
	public void test_with_producer_thread() throws Exception {
		Queue<String> queue = new LinkedList<String>();
		BlockingQueue<String> blockingQueue = new BlockingQueue<String>(queue);
		Thread producer = new Thread(() -> blockingQueue.push(new Date().toString()));
		producer.start();
		Thread.sleep(1500);
		Assert.assertEquals(queue.size(), 5);
		Thread.sleep(1500);
		Assert.assertEquals(queue.size(), 5);
	}

	/**
	 * Interactive test that shares Queue with multiple thread in a thread safe
	 * manner.
	 * 
	 * @exception None
	 * 
	 * @passCriteria When single thread try to pull data from empty queue and waits
	 *               for 1000 Milli seconds and interrupts the thread.
	 * 
	 */
	@Test
	public void test_with_consumer_thread() throws Exception {
		Queue<String> queue = new LinkedList<String>();
		BlockingQueue<String> blockingQueue = new BlockingQueue<String>(queue);
		Thread consumer = new Thread(() -> blockingQueue.pull());
		consumer.start();
		Thread.sleep(1000);
		Assert.assertTrue(queue.isEmpty());
		Thread.sleep(1000);
		Assert.assertTrue(queue.isEmpty());
	}

	/**
	 * Interactive test that shares Queue with multiple thread in a thread safe
	 * manner.
	 * 
	 * @exception None
	 * 
	 * @passCriteria When multiple thread(s) try to pull and push data
	 *               simultaneously to and from the same shared queue.
	 * 
	 */
	@Test
	public void test_producer_and_consumer() throws Exception {
		Queue<String> queue = new LinkedList<String>();
		final BlockingQueue<String> blockingQueue = new BlockingQueue<String>(queue);
		Thread consumer = new Thread(() -> blockingQueue.pull());
		Thread producer = new Thread(() -> blockingQueue.push(new Date().toString()));
		producer.start();
		consumer.start();
		Thread.sleep(3000);
	}
}
