/**
 * 删除排序链表中的重复元素 II
 *
 * @author 此间凉汐
 * @date 2022/4/3 8:29
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(-101);
        /**
         * result与low表示同一块内存空间
         * low在前，fast在后
         * 如果fast当前值与下一个值相等，那么fast不停的表示下一个节点，直到值不再相等，同时更新low（result）所指向的节点
         * 若不等，则low与fast都向后移动一次
         */
        ListNode low = result;
        low.next = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            if (fast.val == fast.next.val) {
                int temp = fast.val;
                while (fast != null && fast.val == temp) {
                    fast = fast.next;
                }
                low.next = fast;
            } else {
                low = fast;
                fast = fast.next;
            }
        }
        return result.next;
    }
}

class ListNode {
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
}
