package oracle.test;

/**
 * Checks if a string is a palindrome.
 * <p>
 * string can be treated as <strong>palindrome</strong> only when reading from
 * left to right or right to left sounds same (ignoring special characters).
 * <p>
 * Palindrome is a word, phrase or sentence that reads the same backward or
 * forward. For example, the following string is a palindrome: "Madam, I'm
 * Adam."
 */
public class PalindromeUtil {
	/**
	 * Checks whether passed String is a palindrome or not.
	 *
	 * Requirements: - Limit the amount of additional consumed memory to O(1). -
	 * Limit complexity to O(n).
	 *
	 * @return true if passed string is palindrome, false - otherwise
	 */
	public static boolean isPalindrome(String str) {
		// Null STring can't be considered as palindrome.
		if (str == null) {
			return false;
		}

		// Empty string can be treated as palindrome.
		if (str.trim().isEmpty()) {
			return true;
		}
		int startIndex = 0;
		int lastIndex = str.length() - 1;

		// Compares character until they are equal
		while (startIndex <= lastIndex) {
			char leftChar = str.charAt(startIndex);
			char rightChar = str.charAt(lastIndex);

			// Ignore current character, if it is not alphabet.
			if (!(Character.toLowerCase(leftChar) >= 'a' && Character.toLowerCase(leftChar) <= 'z')) {
				startIndex++;
			}
			// Ignore current character, if it is not alphabet.
			else if (!(Character.toLowerCase(rightChar) >= 'a' && Character.toLowerCase(rightChar) <= 'z')) {
				lastIndex--;
			}
			// If both are equal than move forward from left and move backward from right,
			// in order to compare next character, else no need to traverse further, return
			// false because it's not palindrome.
			else if (Character.toLowerCase(leftChar) == Character.toLowerCase(rightChar)) {
				startIndex++;
				lastIndex--;
			} else {
				return false;
			}
		}
		// Returns true if it succeeded all traversal.
		return true;

	}
}
