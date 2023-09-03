package org.amskbs.easy.n21_merge_two_sorted_lists;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode headNode = null;
        ListNode lastNode = null;
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        while (pointer1 != null || pointer2 != null) {
            if (pointer1 != null && pointer2 == null) {
                if (lastNode != null) {
                    lastNode.next = pointer1;
                } else {
                    headNode = pointer1;
                }
                break;
            }

            if (pointer1 == null && pointer2 != null) {
                if (lastNode != null) {
                    lastNode.next = pointer2;
                } else {
                    headNode = pointer2;
                }
                break;
            }

            if (pointer2.val < pointer1.val) {
                if (lastNode != null) {
                    lastNode.next = pointer2;
                } else {
                    headNode = pointer2;
                }
                lastNode = pointer2;
                pointer2 = pointer2.next;
            } else if (pointer2.val > pointer1.val) {
                if (lastNode != null) {
                    lastNode.next = pointer1;
                } else {
                    headNode = pointer1;
                }
                lastNode = pointer1;
                pointer1 = pointer1.next;
            } else {
                if (lastNode != null) {
                    lastNode.next = pointer1;
                } else {
                    headNode = pointer1;
                }
                lastNode = pointer1;
                pointer1 = pointer1.next;
                lastNode.next = pointer2;
                lastNode = pointer2;
                pointer2 = pointer2.next;
            }
        }
        return headNode;
    }

    private void appendNode(ListNode node, ListNode lastNode, ListNode headNode) {

    }

    public static class ListNode {
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
}
