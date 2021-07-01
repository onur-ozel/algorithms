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
}
