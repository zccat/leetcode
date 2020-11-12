package zx.learn.leetcode.btree;


import java.util.ArrayList;
import java.util.LinkedList;
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
        /**
         *
         *                   1
         *             2           3
         *        4       n     6      7
         *      n   n   n   n  n  n   n  9
         */
        Integer[] list = {1, 2, 3, 4, null, 6, 7, null, null, null, null, null, null, null, 9};
//        Integer[] list = {1, 2, 3, null, null, 6, 7};
//        TreeNode treeNode = initTree.initTree(list);
        TreeNode treeNode = initTree.initTree("123##45##6##7");
        TreeOrder treeOrder = new TreeOrder();
        System.out.print("先序遍历: ");
        treeOrder.preOrder(treeNode);
        System.out.print("\n先序遍历(非递归): ");
        treeOrder.preOrderN(treeNode);
        System.out.print("\n中序遍历: ");
        treeOrder.midOrder(treeNode);
        System.out.print("\n中序遍历(非递归): ");
        treeOrder.midOrderN(treeNode);
        System.out.print("\n后序遍历: ");
        treeOrder.subOrder(treeNode);
        System.out.print("\n后序遍历(非递归): ");
        treeOrder.subOrderN(treeNode);

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

    /**
     * 中序遍历 => 左 中 右
     *
     * @param node 二叉树根节点
     */
    public void midOrder(TreeNode node) {
        if (node != null) {
            midOrder(node.left);
            doSomething(node);
            midOrder(node.right);
        }
    }

    /**
     * 中序便利 非递归
     *
     * @param node 二叉树根节点
     */
    public void midOrderN(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode backFrom = null;
        while (!stack.empty()) {
            TreeNode m = stack.peek();
            // 如果不是返回回来 并且 栈顶元素的左子树不为空 则一直往左走
            if (backFrom == null && m.left != null) {
                stack.push(m.left);
                continue;
            }
            // 如果左边空了 先出栈自己 做些事情 压栈 自己的右节点
            backFrom = stack.pop();
            doSomething(backFrom);
            if (m.right != null) {
                stack.push(m.right);
                backFrom = null;
            }
        }
    }

    /**
     * 后续遍历 => 左 右 根
     *
     * @param node 二叉树根节点
     */
    public void subOrder(TreeNode node) {
        if (node != null) {
            subOrder(node.left);
            subOrder(node.right);
            doSomething(node);
        }
    }

    /**
     * 后续遍历 非递归
     *
     * @param node 二叉树根节点
     */
    public void subOrderN(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode backFrom = null;
        while (!stack.empty()) {
            TreeNode m = stack.peek();
            // 如果不是返回回来 一直向左走
            if (backFrom == null && m.left != null) {
                stack.push(m.left);
                continue;
            }
            TreeNode pop = stack.peek();
            // 如果是不是从右边返回回来 并且右节点不为空  将右节点压入栈
            if (pop.right != null && backFrom != pop.right) {
                stack.push(pop.right);
                backFrom = null;
                continue;
            }
            // 如果是返回回来 右节点为空 或者 (右节点不为空,但是是从右节点返回回来的)  出栈 做些事情
            stack.pop();
            backFrom = pop;
            doSomething(pop);
        }
    }

    void doSomething(TreeNode node) {
        System.out.print(node.val + "  ");
    }

}
