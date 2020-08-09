package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = null;
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        l23.next = null;

        ListNode result = Solution.addTwoNumbers(l11,l21);
        System.out.println(result);

    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int A = add(l1);
        int B = add(l2);
        int result = A + B;
        ListNode resultNode = null;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while(result != 0) {
            list.add(result % 10);
            result /= 10;
            i++;
        }
        for(i = i-1;i >= 0;i--) {
            ListNode newNode = new ListNode(list.get(i));
            if(resultNode == null)
                resultNode = newNode;
            else
                resultNode.next = newNode;
            resultNode = resultNode.next;
        }
        return resultNode;
    }
    private static int add(ListNode node) {
        int temp = 0;
        Stack stack = new Stack();
        ListNode tempNode = node;
        while(tempNode != null) {
            System.out.println(tempNode.val);
            stack.push(tempNode.val);
            tempNode = tempNode.next;
            temp++;
        }
        int result = 0;
        for(int i = 0;i < temp;i++) {
            result += (int)stack.pop()*(Math.pow(10,i)) ;
        }
        return result;
    }
}