package oracle.test;

import java.util.Objects;
import java.util.Queue;

/**
 * Provides waiting thread-safe access to a java.util.Queue instance.
 *
 * Requirements: - Usage of API from java.util.concurrent packageis prohibited.
 * - Limit the amount of additional consumed memory to O(1). - The
 * implementation is supposed to be acceptable for usage in a highly
 * multi-thread environment.
 *
 * Useful tips a.k.a. common pitfalls: - Please note that you do not need to
 * implement java.util.Queue. - Readiness to accept or provide elements is
 * solely dependent on the underlying queue. Any additional queue capacity
 * limitations break contract defined in the javadoc.
 */
public class BlockingQueue<E> {

	private Queue<E> queue;

	// Default queue capacity is 5
	private int elements = 5;

	/**
	 * @param queue The underlying "wrapped" queue.
	 */
	public BlockingQueue(Queue<E> queue) {
		// Queue should not be null.
		Objects.requireNonNull(queue);
		this.queue = queue;
	}

	/**
	 * Inserts the specified element into the underlying queue, waiting if necessary
	 * for the underlying queue to be ready to accept new elements.
	 * 
	 * @param e the element to insert.
	 */
	public void push(E e) {
		while (true) {
			// synchronized on queue to ensure queue is shared across multiple threads with
			// thread safety.
			synchronized (queue) {
				// If Queue is full (maximum 5 elements at a time queue can hold.), than wait
				// for dequeue.
				while (queue.size() >= elements) {
					try {
						queue.wait(1000);
					} catch (InterruptedException ex) {
						throw new RuntimeException("Exception occurred while waiting to make room in Queue:", ex);
					}
				}
				System.out.println("Data pushed into queue is: " + e);
				queue.add(e);
				queue.notify();
				sleep(30);
			}
		}
	}

	/**
	 * Retrieves and removes the head of the underlying queue, waiting if necessary
	 * until it is capable of providing an element.
	 * 
	 * @return the retrieved element
	 */
	public E pull() {
		while (true) {
			// synchronized on queue to ensure queue is shared across multiple threads with
			// thread safety.
			synchronized (queue) {
				// If queue is empty than wait for other thread to push data.
				while (queue.size() == 0) {
					try {
						queue.wait(1000);
					} catch (InterruptedException ex) {
						throw new RuntimeException("Exception occurred while waiting to read data from Queue: ", ex);
					}
				}
				System.out.println("Data pulled from queue is: " + queue.remove());
				queue.notify();
				sleep(20);
			}
		}
	}

	private void sleep(int milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException ex) {
			System.out.println("Exception occurred while sleeping: " + ex);
		}
	}
}
