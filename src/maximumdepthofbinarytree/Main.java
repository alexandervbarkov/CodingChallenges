package maximumdepthofbinarytree;

import common.TreeNode;

public class Main {
    public int maxDepth;

    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        maxDepth(root, 0);
        return maxDepth;
    }

    private void maxDepth(TreeNode root, int currentDepth) {
        if(root == null) return;
        if(++currentDepth > maxDepth) maxDepth = currentDepth;
        maxDepth(root.left, currentDepth);
        maxDepth(root.right, currentDepth);
    }
}
