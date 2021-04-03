package oracle.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Test.None;

public class ArrayListTest {

	/**
	 * {@link ArrayList#subList(int, int)} test case.
	 * 
	 * @exception IndexOutOfBoundsException
	 * 
	 * @passCriteria When {@link ArrayList#subList(int, int)} is called with invalid
	 *               fromIndex parameter.
	 * 
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_arraylist_sublist_exception_case1() {
		ArrayList<String> words = new ArrayList<>(Arrays.asList("My", "Name", "IS", "GAURAV"));
		words.subList(-1, 2);
	}

	/**
	 * {@link ArrayList#subList(int, int)} test case.
	 * 
	 * @exception IndexOutOfBoundsException
	 * 
	 * @passCriteria When {@link ArrayList#subList(int, int)} is called with invalid
	 *               toIndex parameter.
	 * 
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void test_arraylist_sublist_exception_case2() {
		ArrayList<String> words = new ArrayList<>(Arrays.asList("My", "Name", "IS", "GAURAV"));
		words.subList(0, 5);
	}

	/**
	 * {@link ArrayList#subList(int, int)} test case.
	 * 
	 * @exception IllegalArgumentException
	 * 
	 * @passCriteria When {@link ArrayList#subList(int, int)} is called when
	 *               fromIndex is greater than toIndex.
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_arraylist_sublist_exception_case3() {
		ArrayList<String> words = new ArrayList<>(Arrays.asList("My", "Name", "IS", "GAURAV"));
		words.subList(2, 1);
	}

	/**
	 * {@link ArrayList#subList(int, int)} test case.
	 * 
	 * @exception IllegalArgumentException
	 * 
	 * @passCriteria When {@link ArrayList#subList(int, int)} is called when list
	 *               itself is empty.
	 * 
	 */
	@Test
	public void test_arraylist_sublist_exception_case4() {
		ArrayList<String> words = new ArrayList<>();
		Assert.assertTrue(words.subList(0, 0).isEmpty());
	}

	/**
	 * {@link ArrayList#subList(int, int)} test case.
	 * 
	 * @exception None
	 * 
	 * @passCriteria When {@link ArrayList#subList(int, int)} is called when
	 *               {@link List} is not empty.
	 * 
	 */
	@Test
	public void test_arraylist_sublist() {
		ArrayList<String> words = new ArrayList<>(Arrays.asList("My", "Name", "IS", "GAURAV"));
		List<String> subList = words.subList(0, 3);
		Assert.assertFalse(subList.isEmpty());
		ArrayList<String> expectedList = new ArrayList<>(Arrays.asList("My", "Name", "IS"));
		Assert.assertEquals(subList, expectedList);
		subList = words.subList(1, 3);
		Assert.assertFalse(subList.isEmpty());
		expectedList = new ArrayList<>(Arrays.asList("Name", "IS"));
		Assert.assertEquals(subList, expectedList);
	}

	/**
	 * Interactive test that shares Queue with multiple thread in a thread safe
	 * manner.
	 * 
	 * @exception None
	 * 
	 * @passCriteria When {@link Iterator#remove()} is called before calling
	 *               {@link Iterator#next()}
	 * 
	 */
	@Test(expected = IllegalStateException.class)
	public void test_arraylist_iterator() {
		ArrayList<String> words = new ArrayList<>(Arrays.asList("My", "Name", "IS", "GAURAV"));
		Iterator<String> itr = words.iterator();
		while (itr.hasNext()) {
			itr.remove();
		}
	}

}
