### Oracle Assignment

There are four tasks and which we expect you to come up with the most optimized and
clean solution for any of the four problem. Each task
should be solved by completing a corresponding java class in src/oracle/test
directory so it compiles and works in accordance to contract defined in javadoc
comments. We also expect you to write sufficient amount of tests for your implementations
in a corresponding java class in test/oracle/test directory. You can implement
tests using JUnit, TestNG framework or without a test framework.

## ArrayList: For the following 3 methods, develop a sufficient amount of unit tests 
using JUnit, TestNG or any other testing framework of choice (or no framework) Suggest two 
different metrics that would define how well the selected methods are tested.

    java.util.ArrayList.subList()
    java.util.ArrayList.iterator()
    and for any one additional method chosen from java.util.ArrayList class.

	 

## PalindromeUtil: 
	Checks if a string is a palindrome. String can be treated as <strong>palindrome</strong> 
	only when reading from left to right or right to left sounds same (ignoring special characters).
	Palindrome is a word, phrase or sentence that reads the same backward or forward.
	For example, the following string is a palindrome: "Madam, I'm Adam."

## IteratorFlattener: 
	"Flattens" nested sub-iterators into an iterator in a depth-first manner.
	Requirements: - Limit the amount of additional consumed memory to O(1).
	Example: an iterator {{1,2},{3},{4,5}} which has three sub-iterators with 2,1 and 2 elements correspondingly, 
	presents values in this order: {1, 2, 3, 4, 5}

## BlockingQueue: 
	Provides waiting thread-safe access to a java.util.Queue instance.
	Requirements: - Usage of API from java.util.concurrent packageis prohibited.
		- Limit the amount of additional consumed memory to O(1).
		- The implementation is supposed to be acceptable for usage in a highly multi-thread environment.
	Useful tips a.k.a. common pitfalls: 
		- Please note that you do not need to implement java.util.Queue.
		- Readiness to accept or provide elements is solely dependent on the underlying queue.
		- Any additional queue capacity limitations break contract defined in the javadoc.
