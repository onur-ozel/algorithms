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

	AlgorithmsApplication algorithmApp = null;

	@BeforeAll
	public void setup() {
		algorithmApp = new AlgorithmsApplication();
	}

	@Test
	public void twoSumTest() {
		assertArrayEquals(algorithmApp.twoSum(new int[] { 2, 7, 11, 15 }, 9), new int[] { 0, 1 });
	}
}
