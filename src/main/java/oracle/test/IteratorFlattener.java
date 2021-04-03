package oracle.test;

import java.util.Iterator;
import java.util.Objects;

/**
 * "Flattens" nested sub-iterators into an iterator in a depth-first manner.
 *
 * Requirements: - Limit the amount of additional consumed memory to O(1).
 *
 * Example: an iterator {{1,2},{3},{4,5}} which has three sub-iterators with 2,
 * 1 and 2 elements correspondingly, presents values in this order: {1, 2, 3, 4,
 * 5}
 */
public class IteratorFlattener<E> implements Iterator<E> {
	// implement code here ...

	private Iterator<Iterator<E>> rootIterator;
	private Iterator<E> subIterator;
	private boolean isRemoveAllowed = false;

	public IteratorFlattener(Iterator<Iterator<E>> root) {
		Objects.requireNonNull(root);
		this.rootIterator = root;
		// If rootIterator has elements, than make the first inner iterator as
		// subIterator
		if (this.rootIterator.hasNext()) {
			subIterator = rootIterator.next();
		}
	}

	/**
	 * Returns {@code true} if the iteration has more elements.
	 *
	 * @return {@code true} if the iteration has more elements
	 */
	public boolean hasNext() {
		// If current subIterator doesn't have element and rootIterator has element than
		// try iterating next subIterator.
		while (!subIterator.hasNext() && rootIterator.hasNext()) {
			subIterator = rootIterator.next();
		}
		isRemoveAllowed = false;
		return subIterator.hasNext();
	}

	/**
	 * Returns the next element in the iteration.
	 *
	 * @return the next element in the iteration
	 * @throws NoSuchElementException if the iteration has no more elements
	 */
	public E next() {
		isRemoveAllowed = true;
		return subIterator.next();
	}

	/**
	 * Removes from the underlying collection the last element returned by this
	 * iterator (optional operation). This method can be called only once per call
	 * to {@link #next}.
	 *
	 * @throws IllegalStateException if the {@code next} method has not yet been
	 *                               called, or the {@code remove} method has
	 *                               already been called after the last call to the
	 *                               {@code next} method
	 */
	public void remove() {
		// isRemoveAllowed variable ensures that remove should be called only followed
		// by next() method call.
		if (!isRemoveAllowed) {
			throw new IllegalStateException();
		}
		subIterator.remove();
		isRemoveAllowed = false;
	}
}
