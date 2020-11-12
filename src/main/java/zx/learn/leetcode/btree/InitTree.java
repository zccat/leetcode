package zx.learn.leetcode.btree;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: huzhixin
 * Date: 2020/11/11
 * Description: No Description
 */
public class InitTree {

    public static void main(String[] args) {
        InitTree initTree = new InitTree();
        /**
         * eg  1 2 3 null null 6 7   n表示空
         *
         *                   1
         *             2           3
         *        n       n     6     7
         *       8 9   10 11  12 13  14 15
         */
        Integer[] list = {1, 2, 3, null, null, 6, 7};
        TreeNode treeNode = initTree.initTree(list);
        System.out.println(treeNode);
    }

    TreeNode initTree(String str) {
        String[] list = str.split("");
        Integer[] integers = new Integer[list.length];
        for (int i = 0; i < list.length; i++) {
            if (!"#".equals(list[i])) {
                integers[i] = Integer.parseInt(list[i]);
            }
        }
        return initTree(integers);
    }

    TreeNode initTree(Integer[] list) {

        TreeNode root = new TreeNode();
        init(root, list, 0);
        return root;
    }

    void init(TreeNode node, Integer[] list, int index) {
        if (index >= list.length || list[index] == null) {
            return;
        }
        node.val = list[index];
        int leftIndex = 2 * (index + 1) - 1;
        int rightIndex = 2 * (index + 1);
        if (leftIndex < list.length && list[leftIndex] != null) {
            node.left = new TreeNode();
            init(node.left, list, leftIndex);
        }
        if (rightIndex < list.length && list[rightIndex] != null) {
            node.right = new TreeNode();
            init(node.right, list, rightIndex);
        }
    }

}
