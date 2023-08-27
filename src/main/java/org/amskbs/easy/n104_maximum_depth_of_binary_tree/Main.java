package org.amskbs.easy.n104_maximum_depth_of_binary_tree;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, node9, node20);
        System.out.println(main.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxDepth(root, 1);
    }

    public int maxDepth(TreeNode node, int level) {
        return Math.max(
                node.left == null ? level : maxDepth(node.left, level + 1),
                node.right == null ? level : maxDepth(node.right, level + 1)
        );
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
