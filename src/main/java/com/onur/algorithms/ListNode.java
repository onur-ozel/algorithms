package com.onur.algorithms;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	ListNode(int[] vals) {
		ListNode curr = this;
		this.val = vals[0];
		for (int i = 1; i < vals.length; i++) {
			curr.next = new ListNode(vals[i]);
			curr = curr.next;
		}
	}

	int[] toArray() {
		List<Integer> result = new ArrayList<>();

		ListNode curr = this;

		while (curr != null) {
			result.add(curr.val);
			curr = curr.next;
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
}