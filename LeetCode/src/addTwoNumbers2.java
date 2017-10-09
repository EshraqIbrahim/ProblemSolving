
public class addTwoNumbers2 {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		class Solution {
			public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
				ListNode head = null;
				int carry = 0;
				String finalAnswer = "";
				ListNode firstList = l1;
				ListNode secondList = l2;
				while (firstList != null) {
					int first = firstList.val;
					int second = 0;
					if (secondList != null) {
						second = secondList.val;
					}
					int answer = first + second + carry;
					if (answer < 10) {
						finalAnswer += answer;
						carry = 0;
					} else {
						String temp = Integer.toString(answer);
						String cary = "";
						for (int i = 0; i < temp.length(); i++) {
							if (i == (temp.length() - 1)) {
								finalAnswer += temp.charAt(i);
							} else {
								cary += temp.charAt(i);
							}
						}
						carry = Integer.parseInt(cary);
					}
					firstList = firstList.next;
					if (secondList != null) {
						secondList = secondList.next;
					}
				}
				while (secondList != null) {
					int second = secondList.val;
					int answer = second + carry;
					if (answer < 10) {
						finalAnswer += answer;
						carry = 0;
					} else {
						String temp = Integer.toString(answer);
						String cary = "";
						for (int i = 0; i < temp.length(); i++) {
							if (i == (temp.length() - 1)) {
								finalAnswer += temp.charAt(i);
							} else {
								cary += temp.charAt(i);
							}
						}
						carry = Integer.parseInt(cary);
					}
					secondList = secondList.next;
				}
				if (carry != 0) {
					finalAnswer += carry;
				}
				for (int i = 0; i < finalAnswer.length(); i++) {
					ListNode current = head;
					String temp = "" + finalAnswer.charAt(i);
					ListNode node = new ListNode(Integer.parseInt(temp));
					if (head == null) {
						head = node;
						head.next = null;
					} else {
						while (current.next != null) {
							current = current.next;
						}
						node.next = null;
						current.next = node;
					}
				}
				return head;
			}
		}
	}
}
