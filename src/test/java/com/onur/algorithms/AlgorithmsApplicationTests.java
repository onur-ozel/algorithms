package com.onur.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
		assertArrayEquals(algorithmApp.twoSum_BinarySearch(new int[] { 2, 7, 11, 15 }, 9), new int[] { 0, 1 });
		assertArrayEquals(algorithmApp.twoSum_BinarySearch(new int[] { 3, 3 }, 6), new int[] { 0, 1 });
	}
}
