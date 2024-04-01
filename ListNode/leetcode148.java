package ListNode;

import java.util.ArrayList;
import java.util.List;

class leetcode148 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tall){
        if(head == null) return head;
        if(head.next == tall){
            head.next = null;
            return head;
        }
        ListNode slow = head , fast = head;
        while (fast != tall){
            slow = slow.next;
            fast = fast.next;
            if(fast != tall) fast = fast.next;
        }
        ListNode mid = slow;
        ListNode listNode1 = sortList(head , mid);
        ListNode listNode2 = sortList(mid , tall);
        ListNode sorted = mergesort(listNode1, listNode2);

        return sorted;
    }

    public ListNode mergesort(ListNode listNode1, ListNode listNode2) {
        ListNode listNode = new ListNode(0);
        ListNode node = listNode, node1 = listNode1 ,node2 = listNode2;
        while (node1 != null && node2 != null){
            if (node1.val <= node2.val) {
                node.next = node1;
                node1 = node1.next;
            }
            else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        if(node1 != null) node.next = node1;
        else if(node2 != null) node.next = node2;
        return listNode.next;
    }
}
