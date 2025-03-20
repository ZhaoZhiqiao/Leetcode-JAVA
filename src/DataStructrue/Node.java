package DataStructrue;

import java.util.HashMap;
import java.util.Map;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node createLinkedList(Integer[][] nodesInfo) {
        if (nodesInfo == null || nodesInfo.length == 0) {
            return null;
        }

        int n = nodesInfo.length;
        // 创建所有节点
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nodesInfo[i][0]);
        }

        // 连接next指针
        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // 设置random指针
        for (int i = 0; i < n; i++) {
            if (nodesInfo[i][1] != null) {
                nodes[i].random = nodes[nodesInfo[i][1]];
            }
        }

        return nodes[0]; // 返回头节点
    }

    @Override
    public String toString() {
        // 存储节点到索引的映射
        Map<Node, Integer> nodeToIndex = new HashMap<>();

        // 第一步：找到链表头节点
        Node head = this;
        Node temp = this;
        while (temp.next != null && !nodeToIndex.containsKey(temp)) {
            nodeToIndex.put(temp, nodeToIndex.size());
            temp = temp.next;
        }
        nodeToIndex.put(temp, nodeToIndex.size());

        // 重置映射，因为我们可能没有从真正的头节点开始
        nodeToIndex.clear();

        // 第二步：从头节点开始，记录每个节点的索引
        Node current = head;
        int index = 0;
        while (current != null) {
            nodeToIndex.put(current, index++);
            current = current.next;
        }

        // 第三步：再次遍历，生成字符串表示
        StringBuilder result = new StringBuilder("[");
        current = head;
        while (current != null) {
            result.append("[").append(current.val).append(",");

            // 处理random指针
            if (current.random != null) {
                result.append(nodeToIndex.get(current.random));
            } else {
                result.append("null");
            }

            result.append("]");

            // 如果还有下一个节点，添加逗号
            if (current.next != null) {
                result.append(",");
            }

            current = current.next;
        }
        result.append("]");

        return result.toString();
    }
}