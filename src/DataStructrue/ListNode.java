package DataStructrue;

import java.util.List;

public class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
        next =null;
    }

    public static ListNode fromArray(int[] nums) {
        // 处理空数组情况
        if (nums == null || nums.length == 0) {
            return null;
        }

        // 创建头节点
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;

        // 遍历数组中剩余的元素，创建对应的节点并链接
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        return head;
    }


    public static ListNode fromList(List<Integer> list) {
        // 处理空列表情况
        if (list == null || list.isEmpty()) {
            return null;
        }

        // 创建头节点
        ListNode head = new ListNode(list.get(0));
        ListNode current = head;

        // 遍历列表中剩余的元素，创建对应的节点并链接
        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }

        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;

        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.toString();
    }
}