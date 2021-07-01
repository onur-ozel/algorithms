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
	public int[] twoSum_BinarySearch(int[] nums, int target) {
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
}
