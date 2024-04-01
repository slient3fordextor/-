package ListNode;

import java.util.HashMap;
import java.util.Map;

public class leetcode138 {
    Map<Node, Node> cacheNode = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        if(!cacheNode.containsKey(head)){
            Node headNew = new Node(head.val);
            cacheNode.put(head,headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cacheNode.get(head);
    }
}
