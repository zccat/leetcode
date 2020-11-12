package zx.learn.leetcode.btree;


import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: huzhixin
 * Date: 2020/11/11
 * Description: No Description
 */
public class TreeOrder {

    public static void main(String[] args) {
        InitTree initTree = new InitTree();
        Integer[] list = {1, 2, 3, 4, null, 6, 7, null, null, null, null, null, null, null, 9};
//        Integer[] list = {1, 2, 3, null, null, 6, 7};
        TreeNode treeNode = initTree.initTree(list);
        TreeOrder treeOrder = new TreeOrder();
        treeOrder.preOrder(treeNode);
        System.out.println();
        treeOrder.preOrderN(treeNode);

    }

    /**
     * 先序便利 递归
     *
     * @param node 二叉树根节点
     */
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 先访问根再访问左右
        doSomething(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 先序便利 非递归
     *
     * @param node 二叉树根节点
     */
    public void preOrderN(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            doSomething(pop);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    void doSomething(TreeNode node) {
        System.out.print(node.val + "  ");
    }

}
