package org.amskbs.easy.n101_symmetric_tree;

public class Main {

    // TODO add test cases!
    public static void main(String[] args) {
        Main main = new Main();
    }


    public boolean isSymmetric(TreeNode root) {
        return isMirrorTree(root.left, root.right);
    }

    private boolean isMirrorTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.left);
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
