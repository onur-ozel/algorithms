package com.onur.algorithms;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsApplication.class, args);
	}

	// https://leetcode.com/problems/two-sum/
	// 1. Two Sum | Easy
	// #region
	// TimeComplexity O(n) | SpaceComplexity O(n)
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> complements = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (complements.containsKey(nums[i])) {
				result[0] = complements.get(nums[i]);
				result[1] = i;

				return result;
			}

			complements.put(target - nums[i], i);
		}

		return result;
	}

	// TimeComplexity O(nlogn) | SpaceComplexity O(1)
	public int[] twoSumBinarySearch(int[] nums, int target) {
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			int start = i;
			int end = nums.length - 1;
			int complement = target - nums[i];

			while (start < end) {
				int mid = end + start / 2;

				if (nums[mid] == complement) {
					result[0] = i;
					result[1] = mid;

					return result;
				}

				if (complement < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

		}

		return result;
	}
	// #endregion

	// https://leetcode.com/problems/add-two-numbers/
	// 2. Add Two Numbers | Medium
	// #region
	// TimeComplexity O(n,m) | SpaceComplexity O(n,m)
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode curr = head;
		int carry = 0;
		int sum = 0;

		while (l1 != null || l2 != null || carry != 0) {
			sum = carry;

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			carry = sum / 10;

			curr.next = new ListNode(sum % 10);
			curr = curr.next;
		}

		return head.next;
	}

	// TimeComplexity O(n,m) | SpaceComplexity O(1)
	public ListNode addTwoNumbersSolution2(ListNode l1, ListNode l2) {
		ListNode head = l1;
		int carry = 0;
		int sum = 0;

		while (l1 != null) {
			sum = l1.val + (l2 == null ? 0 : l2.val) + carry;
			carry = sum / 10;

			l1.val = sum % 10;

			if (l1.next == null && l2 != null) {
				l1.next = l2.next;
				l2 = null;
			}

			if (l1.next == null && carry != 0) {
				l1.next = new ListNode(carry);
				l1 = l1.next;
			}

			l1 = l1.next;

			if (l2 != null) {
				l2 = l2.next;
			}
		}

		return head;
	}
	// #endregion

	// https://leetcode.com/problems/longest-substring-without-repeating-characters/
	// 3. Longest Substring Without Repeating Characters | Medium
	// TimeComplexity O(n) | SpaceComplexity O(1)
	public int lengthOfLongestSubstring(String s) {
		int longestLength = 0;
		int currentIndex = 0;
		int[] lastIndexOfChar = new int[256];

		Arrays.fill(lastIndexOfChar, -1);

		for (int i = 0; i < s.length(); i++) {
			currentIndex = Math.max(currentIndex, lastIndexOfChar[s.charAt(i)] + 1);
			longestLength = Math.max(longestLength, i - currentIndex + 1);
			lastIndexOfChar[s.charAt(i)] = i;
		}

		return longestLength;
	}

	// https://leetcode.com/problems/longest-palindromic-substring/
	// 5. Longest Palindromic Substring | Medium
	// TimeComplexity O(n2) | SpaceComplexity O(1)
	public String longestPalindrome(String s) {
		int length = 0;
		int startIndex = 0;

		for (int i = 0; i < s.length(); i++) {
			int evenLength = getLengthOfPalindrome(i, i + 1, s); // baab
			int oddLength = getLengthOfPalindrome(i, i, s); // cbabc

			if (length < Math.max(evenLength, oddLength)) {
				length = Math.max(evenLength, oddLength);

				if (evenLength > oddLength) {
					startIndex = i - (evenLength / 2) + 1;
				} else {
					startIndex = i - (oddLength / 2);
				}
			}
		}

		return s.substring(startIndex, startIndex + length);
	}

	private int getLengthOfPalindrome(int i, int j, String s) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}

		i++;
		j--;

		return j - i + 1;
	}

	// https://leetcode.com/problems/zigzag-conversion/
	// 6. ZigZag Conversion | Medium
	// TimeComplexity O(n) | SpaceComplexity O(n)
	public String zigzagConvert(String s, int numRows) {
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder();
		}

		int i = 0;

		while (i < s.length()) {
			for (int j = 0; j < numRows && i < s.length(); j++) {
				sb[j].append(s.charAt(i++));
			}

			for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
				sb[j].append(s.charAt(i++));
			}
		}

		for (int j = 1; j < sb.length; j++) {
			sb[0].append(sb[j]);
		}

		return sb[0].toString();
	}

	// https://leetcode.com/problems/reverse-integer/
	// 7. Reverse Integer | Easy
	// TimeComplexity O(n) | SpaceComplexity O(1)
	public int reverse(int x) {
		int result = 0;
		int sign = 1;

		if (x < 0) {
			sign = -1;
			x = Math.abs(x);
		}

		while (x != 0) {
			int digit = x % 10;

			int newResult = result * 10 + digit;
			
			if ((newResult - digit) / 10 != result)
				return 0;

			result = newResult;

			x /= 10;
		}

		return result * sign;
	}
}