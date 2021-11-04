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

    public List<Integer> list = new ArrayList<>();

    /**
     * 思路一：递归
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
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 思路二：非递归方式
     * 利用栈来存储节点
     * <p>
     * Time:O(n)
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {
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
