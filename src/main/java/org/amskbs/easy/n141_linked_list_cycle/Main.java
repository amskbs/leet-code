package org.amskbs.easy.n141_linked_list_cycle;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        while (node2 != null) {
            if (node1.next == null || node2.next == null) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) {
                return true;
            }
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
