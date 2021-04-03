package oracle.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Test.None;

/**
 * Provides sufficient test coverage for oracle.test.IteratorFlattener class.
 */
public class IteratorFlattenerTest {
	// implement code here ...

	/**
	 * Interactive test that Iterator over 2 level nested {@link Iterator}.
	 * 
	 * @exception NullPointerException
	 * 
	 * @passCriteria Should throw NullPointerException when root Iterator passed is
	 *               null.
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void test_null_iterator() {
		new IteratorFlattener<>(null);
	}

	/**
	 * Interactive test that Iterator over 2 level nested {@link Iterator}.
	 * 
	 * @exception None
	 * 
	 * @passCriteria Iterator over nested iterator and print values.
	 * 
	 */
	@Test
	public void test_empty_iterator() {
		List<String> list1 = Arrays.asList();
		List<Iterator<String>> listOfIterator = Arrays.asList(list1.iterator());
		IteratorFlattener<String> flat = new IteratorFlattener<>(listOfIterator.iterator());
		List<String> flattenedList = new ArrayList<String>();
		while (flat.hasNext()) {
			flattenedList.add(flat.next());
		}
		Assert.assertTrue(flattenedList.isEmpty());
	}

	/**
	 * Interactive test that Iterator over 2 level nested {@link Iterator}.
	 * 
	 * @exception None
	 * 
	 * @passCriteria Throws exception if skipped to check whether iterator has next
	 *               element or not.
	 * 
	 */
	@Test(expected = NoSuchElementException.class)
	public void test_empty_iterator_exception() {
		List<String> list1 = Arrays.asList();
		List<Iterator<String>> listOfIterator = Arrays.asList(list1.iterator());
		IteratorFlattener<String> flat = new IteratorFlattener<>(listOfIterator.iterator());
		flat.next();
	}

	/**
	 * Interactive test that Iterator over 2 level nested {@link Iterator}.
	 * 
	 * @exception None
	 * 
	 * @passCriteria Iterator over nested iterator and print values.
	 * 
	 */
	@Test
	public void test_empty_lists_iterator() {
		List<String> list1 = Arrays.asList();
		List<String> list2 = Arrays.asList();
		List<String> list3 = Arrays.asList();
		List<Iterator<String>> listOfIterator = Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator());
		IteratorFlattener<String> flat = new IteratorFlattener<>(listOfIterator.iterator());
		List<String> flattenedList = new ArrayList<String>();
		while (flat.hasNext()) {
			flattenedList.add(flat.next());
		}
		Assert.assertTrue(flattenedList.isEmpty());
	}

	/**
	 * Interactive test that Iterator over 2 level nested {@link Iterator}.
	 * 
	 * @exception None
	 * 
	 * @passCriteria Iterator over nested iterator (skip subIterator if it is empty)
	 *               and print values.
	 * 
	 */
	@Test
	public void test_nested_iterator_case1() {
		List<String> list1 = Arrays.asList();
		List<String> list2 = Arrays.asList("value1");
		List<String> list3 = Arrays.asList("value2", "value3", "value4");
		List<Iterator<String>> listOfIterator = Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator());
		IteratorFlattener<String> flat = new IteratorFlattener<>(listOfIterator.iterator());
		List<String> flattenedList = new ArrayList<String>();
		while (flat.hasNext()) {
			flattenedList.add(flat.next());
		}
		Assert.assertTrue(!flattenedList.isEmpty());
		Assert.assertEquals(flattenedList.size(), 4);
		List<String> expectedList = Arrays.asList("value1", "value2", "value3", "value4");
		Assert.assertEquals(flattenedList, expectedList);
	}

	/**
	 * Interactive test that Iterator over 2 level nested {@link Iterator}.
	 * 
	 * @exception None
	 * 
	 * @passCriteria Iterator over nested iterator (skip subIterator if it is empty)
	 *               and print values.
	 * 
	 */
	@Test
	public void test_nested_iterator_case2() {
		List<String> list1 = Arrays.asList("value1");
		List<String> list2 = Arrays.asList();
		List<String> list3 = Arrays.asList("value2", "value3", "value4");
		List<Iterator<String>> listOfIterator = Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator());
		IteratorFlattener<String> flat = new IteratorFlattener<>(listOfIterator.iterator());
		List<String> flattenedList = new ArrayList<String>();
		while (flat.hasNext()) {
			flattenedList.add(flat.next());
		}
		Assert.assertTrue(!flattenedList.isEmpty());
		Assert.assertEquals(flattenedList.size(), 4);
		List<String> expectedList = Arrays.asList("value1", "value2", "value3", "value4");
		Assert.assertEquals(flattenedList, expectedList);
	}

	/**
	 * Interactive test that Iterator over 2 level nested {@link Iterator}.
	 * 
	 * @exception None
	 * 
	 * @passCriteria Iterator over nested iterator (skip subIterator if it is empty)
	 *               and print values.
	 * 
	 */
	@Test
	public void test_nested_iterator_case3() {
		List<String> list1 = Arrays.asList("value1");
		List<String> list2 = Arrays.asList("value2", "value3", "value4");
		List<String> list3 = Arrays.asList();
		List<Iterator<String>> listOfIterator = Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator());
		IteratorFlattener<String> flat = new IteratorFlattener<>(listOfIterator.iterator());
		List<String> flattenedList = new ArrayList<String>();
		while (flat.hasNext()) {
			flattenedList.add(flat.next());
		}
		Assert.assertTrue(!flattenedList.isEmpty());
		Assert.assertEquals(flattenedList.size(), 4);
		List<String> expectedList = Arrays.asList("value1", "value2", "value3", "value4");
		Assert.assertEquals(flattenedList, expectedList);
	}

	/**
	 * Interactive test that Iterator over 2 level nested {@link Iterator}.
	 * 
	 * @exception IllegalStateException
	 * 
	 * @passCriteria Throws exception if {@link IteratorFlattener#remove()} method
	 *               is invoked before calling {@link IteratorFlattener#next()}
	 * 
	 */
	@Test(expected = IllegalStateException.class)
	public void test_remove_iterator_exception_case1() {
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Iterator<Integer>> listOfIterator = Arrays.asList(list1.iterator());
		IteratorFlattener<Integer> flat = new IteratorFlattener<>(listOfIterator.iterator());
		flat.remove();
	}

	/**
	 * Interactive test that Iterator over 2 level nested {@link Iterator}.
	 * 
	 * @exception IllegalStateException
	 * 
	 * @passCriteria Throws exception if {@link IteratorFlattener#remove()} method
	 *               method has already been called after the last call to the
	 *               {@link IteratorFlattener#next()} method
	 * 
	 */
	@Test(expected = IllegalStateException.class)
	public void test_remove_iterator_exception_case2() {
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		List<Iterator<Integer>> listOfIterator = Arrays.asList(list1.iterator());
		IteratorFlattener<Integer> flat = new IteratorFlattener<>(listOfIterator.iterator());
		while (flat.hasNext()) {
			flat.next();
			flat.remove();
			flat.remove();
		}
	}

	/**
	 * Interactive test that Iterator over 2 level nested {@link Iterator}.
	 * 
	 * @exception UnsupportedOperationException
	 * 
	 * @passCriteria Throws exception if underlying collection is unmodifiable.
	 * 
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void test_remove_iterator_exception_case3() {
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Iterator<Integer>> listOfIterator = Arrays.asList(list1.iterator());
		IteratorFlattener<Integer> flat = new IteratorFlattener<>(listOfIterator.iterator());
		while (flat.hasNext()) {
			flat.next();
			flat.remove();
		}
	}
}
