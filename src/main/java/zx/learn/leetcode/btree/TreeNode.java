package zx.learn.leetcode.btree;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: huzhixin
 * Date: 2020/11/11
 * Description: No Description
 */

@Data
public class TreeNode {

    int val;

    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
