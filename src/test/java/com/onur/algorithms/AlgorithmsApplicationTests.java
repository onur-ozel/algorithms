package com.onur.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlgorithmsApplicationTests {

	@Test
	void contextLoads() {
	}

	static AlgorithmsApplication algorithmApp = null;

	@BeforeAll
	public static void setup() {
		algorithmApp = new AlgorithmsApplication();
	}

	@Test
	public void twoSumTest() {
		assertArrayEquals(algorithmApp.twoSum(new int[] { 2, 7, 11, 15 }, 9), new int[] { 0, 1 });
		assertArrayEquals(algorithmApp.twoSum(new int[] { 3, 2, 4 }, 6), new int[] { 1, 2 });
		assertArrayEquals(algorithmApp.twoSum(new int[] { 3, 3 }, 6), new int[] { 0, 1 });
	}

	@Test
	public void twoSum_BinarySearchTest() {
		assertArrayEquals(algorithmApp.twoSumBinarySearch(new int[] { 2, 7, 11, 15 }, 9), new int[] { 0, 1 });
		assertArrayEquals(algorithmApp.twoSumBinarySearch(new int[] { 3, 3 }, 6), new int[] { 0, 1 });
	}

	@Test
	public void addTwoNumbersTest() {
		ListNode result = algorithmApp.addTwoNumbers(new ListNode(new int[] { 2, 4, 3 }),
				new ListNode(new int[] { 5, 6, 4 }));

		assertArrayEquals(result.toArray(), new int[] { 7, 0, 8 });
	}

	@Test
	public void addTwoNumbersSolution2Test() {
		ListNode result = algorithmApp.addTwoNumbersSolution2(new ListNode(new int[] { 9, 9, 9, 9, 9, 9, 9 }),
				new ListNode(new int[] { 9, 9, 9, 9 }));

		assertArrayEquals(result.toArray(), new int[] { 8, 9, 9, 9, 0, 0, 0, 1 });
	}

	@Test
	public void lengthOfLongestSubstringTest() {
		assertEquals(algorithmApp.lengthOfLongestSubstring("abba"), 2);
		assertEquals(algorithmApp.lengthOfLongestSubstring("abcabcbb"), 3);
		assertEquals(algorithmApp.lengthOfLongestSubstring("bbbbb"), 1);
		assertEquals(algorithmApp.lengthOfLongestSubstring("pwwkew"), 3);
		assertEquals(algorithmApp.lengthOfLongestSubstring(""), 0);
	}

	@Test
	public void longestPalindromeTest() {
		assertEquals(algorithmApp.longestPalindrome("cbbd"), "bb");
		assertEquals(algorithmApp.longestPalindrome("baab"), "baab");
		assertEquals(algorithmApp.longestPalindrome("babad"), "bab");
		assertEquals(algorithmApp.longestPalindrome("a"), "a");
		assertEquals(algorithmApp.longestPalindrome("ac"), "a");
	}

	@Test
	public void zigzagConvertTest() {
		assertEquals(algorithmApp.zigzagConvert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
		assertEquals(algorithmApp.zigzagConvert("PAYPALISHIRING", 4), "PINALSIGYAHRPI");
		assertEquals(algorithmApp.zigzagConvert("A", 1), "A");
	}

	@Test
	public void reverseTest() {
		assertEquals(algorithmApp.reverse(2147483647), 0);
		assertEquals(algorithmApp.reverse(123), 321);
		assertEquals(algorithmApp.reverse(-123), -321);
		assertEquals(algorithmApp.reverse(120), 21);
		assertEquals(algorithmApp.reverse(0), 0);
	}

	@Test
	public void myAtoiTest() {
		assertEquals(algorithmApp.myAtoi("2147483648"), 2147483647);
		assertEquals(algorithmApp.myAtoi("42"), 42);
		assertEquals(algorithmApp.myAtoi("   -42"), -42);
		assertEquals(algorithmApp.myAtoi("4193 with words"), 4193);
		assertEquals(algorithmApp.myAtoi("words and 987"), 0);
		assertEquals(algorithmApp.myAtoi("-91283472332"), -2147483648);
	}

	@Test
	public void maxAreaTest() {
		assertEquals(algorithmApp.maxArea(new int[] { 1, 1 }), 1);
		assertEquals(algorithmApp.maxArea(new int[] { 4, 3, 2, 1, 4 }), 16);
		assertEquals(algorithmApp.maxArea(new int[] { 1, 2, 1 }), 2);
	}

	@Test
	public void romanToIntTest() {
		assertEquals(algorithmApp.romanToInt("III"), 3);
		assertEquals(algorithmApp.romanToInt("IV"), 4);
		assertEquals(algorithmApp.romanToInt("IX"), 9);
		assertEquals(algorithmApp.romanToInt("LVIII"), 58);
		assertEquals(algorithmApp.romanToInt("MCMXCIV"), 1994);
	}
}
