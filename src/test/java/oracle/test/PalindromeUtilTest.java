package oracle.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Test.None;

/**
 * <p>
 * Provides sufficient test coverage for oracle.test.PalindromeUtil class.
 * 
 * @author gaurav.vishal
 */
public class PalindromeUtilTest {

	/**
	 * Interactive test that checks if a passed string is palindrome or not.
	 * 
	 * @exception None
	 * 
	 * @passCriteria null string can't be a palindrome.
	 * 
	 */
	@Test
	public void test_null_string() {
		Boolean isPalindrome = PalindromeUtil.isPalindrome(null);
		Assert.assertFalse(isPalindrome);
	}

	/**
	 * Interactive test that checks if a passed string is palindrome or not.
	 * 
	 * @exception None
	 * 
	 * @passCriteria Empty string can be treated as palindrome.
	 * 
	 */
	@Test
	public void test_empty_string() {
		Boolean isPalindrome = PalindromeUtil.isPalindrome("");
		Assert.assertTrue(isPalindrome);
		isPalindrome = PalindromeUtil.isPalindrome(" ");
		Assert.assertTrue(isPalindrome);
	}

	/**
	 * Interactive test that checks if a passed string is palindrome or not.
	 * 
	 * @exception None
	 * 
	 * @passCriteria A string containing only special characters can be treated as
	 *               palindrome.
	 * 
	 */
	@Test
	public void test_special_chars_string() {
		Boolean isPalindrome = PalindromeUtil.isPalindrome("!.@*()");
		Assert.assertTrue(isPalindrome);
		isPalindrome = PalindromeUtil.isPalindrome("&*()(&^");
		Assert.assertTrue(isPalindrome);
	}

	/**
	 * Interactive test that checks if a passed string is palindrome or not.
	 * 
	 * @exception None
	 * 
	 * @passCriteria Single char alphabets are always palindrome.
	 * 
	 */
	@Test
	public void test_single_char_string() {
		Assert.assertTrue(PalindromeUtil.isPalindrome("G"));
		Assert.assertTrue(PalindromeUtil.isPalindrome("A"));
		Assert.assertTrue(PalindromeUtil.isPalindrome("U"));
		Assert.assertTrue(PalindromeUtil.isPalindrome("R."));
		Assert.assertTrue(PalindromeUtil.isPalindrome(".V"));
		Assert.assertTrue(PalindromeUtil.isPalindrome("g"));
	}

	/**
	 * Interactive test that checks if a passed string is palindrome or not.
	 * 
	 * @testcase A string from left to right or right to left sounds same (only
	 *           alphabets are considered) than string is called palindrome.
	 *           <p>
	 *           <string>"Dalad"</strong> word from left to right or right to left
	 *           sounds same, hence it is palindrome.
	 *           <p>
	 *           <p>
	 *           <string>"palindrome"</strong> word from left to right or right to
	 *           left doesn't sounds same, hence it is not palindrome.
	 *           <p>
	 *           <p>
	 *           <string>"Madam, I'm Adam."</strong> word(s) from left to right or
	 *           right to left sounds same (ignoring special characters), hence it
	 *           is palindrome.
	 *           <p>
	 *           <string>"Mr. Owl ate my metal worm"</strong> word(s) from left to
	 *           right or right to left sounds same (ignoring special characters),
	 *           hence it is palindrome.
	 *           <p>
	 *           <string>"Was it a cat I saw?"</strong> word(s) from left to right
	 *           or right to left sounds same (ignoring special characters), hence
	 *           it is palindrome.
	 *           <p>
	 *           <string>"&?!@ab123AD*#"</strong> word(s) from left to right or
	 *           right to left doesn't sounds same (ignoring special characters),
	 *           hence it is not palindrome.
	 *           <p>
	 *           <p>
	 *           <string>"&?!123321&$#"</strong> word(s) from left to right or right
	 *           to left are sounds same (ignoring special characters), hence it is
	 *           palindrome.
	 *           <p>
	 * @exception None
	 * 
	 * @passCriteria string can be treated as <strong>palindrome</strong> only when
	 *               reading from left to right or right to left sounds same
	 *               (ignoring special characters).
	 * 
	 */
	@Test
	public void test_null_string__() {
		Assert.assertTrue(PalindromeUtil.isPalindrome("Dalad"));
		Assert.assertFalse(PalindromeUtil.isPalindrome("palindrome"));
		Assert.assertTrue(PalindromeUtil.isPalindrome("Madam, I'm Adam."));
		Assert.assertTrue(PalindromeUtil.isPalindrome("Mr. Owl ate my metal worm"));
		Assert.assertTrue(PalindromeUtil.isPalindrome("Was it a cat I saw?"));
		Assert.assertFalse(PalindromeUtil.isPalindrome("&?!@ab123AD*#"));
		Assert.assertTrue(PalindromeUtil.isPalindrome("&?!123321&$#"));
	}
}
