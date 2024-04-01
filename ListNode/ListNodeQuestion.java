package ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListNodeQuestion {
    
}

//反转链表
class Solution1{
//    解法一：迭代法
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curt = head;
//        //prev.val = Integer.parseInt(null);
//        while (curt != null){
//            ListNode next = curt.next; // 用一个链表记录该节点的后继节点
//            curt.next = prev;  // 将该节点的后继节点指向prev链表
//            prev = curt;       // 将prev链表修改为curt链表
//            curt = next;       // 将curt链表
//        }
//        return prev;
//    }
//    解法二：递归算法
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
//相交链表
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

//leetcode.2.两数相加
class Solution3{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        String s1 = new String();
        String s2 = new String();
        while(l1 != null){

        }

        return listNode;
    }
}
//leetcode.234.回文链表
class Solution4 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }


}
//    leetcode.141.环形链表
class Solution5{
    public boolean hasCycle(ListNode head) {
        Set<ListNode> hashset = new HashSet<>();
        while(head!=null){
            if (!hashset.add(head)) return true;
            head = head.next;
        }
        return false;
    }
}
//环形链表2
class leetcode142{
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode gui = head;
        ListNode rabbit = head;
        while ( rabbit != null) {
            gui = gui.next;
            if(rabbit.next != null) rabbit = rabbit.next.next;
            else return null;

            if(rabbit == gui) {
                ListNode ptr = head;
                while(ptr != gui){
                    ptr = ptr.next;
                    gui = gui.next;
                }
                return ptr;
            }
        }
        return null;
    }
}