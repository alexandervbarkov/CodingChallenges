package binarytreetilt;

import common.TreeNode;

public class Main {
    private static int tilt;

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(
//                1,
//                new TreeNode(2),
//                null);
        TreeNode root = new TreeNode(
                4,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        new TreeNode(5)),
                new TreeNode(
                        9,
                        null,
                        new TreeNode(7)));

        System.out.println(findTilt(root));
    }

    private static int findTilt(TreeNode root) {
        getSum(root);
        return tilt;
    }

    private static int getSum(TreeNode root) {
        if(root == null) return 0;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
