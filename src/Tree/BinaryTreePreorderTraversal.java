package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * Example:
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,2,3]
 *
 * @author DanielQSL
 * @date 2019/2/26
 */
public class BinaryTreePreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> list = new ArrayList<>();

    /**
     * 思路一：递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return list;
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    /**
     * 思路二：非递归方式
     * 利用栈来存储节点
     *
     * Time:O(n)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalTwo(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tempNode = null;
        while (!stack.isEmpty()) {
            tempNode = stack.pop();
            list.add(tempNode.val);
            if (tempNode.right != null) {
                //先压右边，先压后出
                stack.push(tempNode.right);
            }
            if (tempNode.left != null) {
                //再压左边，后压先出
                stack.push(tempNode.left);
            }
        }
        return list;
    }
}
