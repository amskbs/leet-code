package org.amskbs.easy.n226_invert_binary_tree;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //swap branches
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
