package com.onur.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

////////////////////////////////////////////////////////////////
// array:                    1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
////////////////////////////////////////////////////////////////
// bfs:                      8,4,12,2,6,10,14,1,3,5,7,9,11,13,15
////////////////////////////////////////////////////////////////
// dfs inorder (le,ro,ri):   1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
////////////////////////////////////////////////////////////////
// dfs preorder (ro,le,ri):  8,4,2,1,3,6,5,7,12,10,9,11,14,13,15
////////////////////////////////////////////////////////////////
// dfs postorder (le,ri,ro): 1,3,2,5,7,6,4,9,11,10,13,15,14,12,8
////////////////////////////////////////////////////////////////
//               8        
//             /   \
//            /     \        
//           /       \  
//          /         \ 
//         /           \
//        /             \
//       4               12
//      /\               /\
//     /  \             /  \
//    /    \           /    \
//   2      6         10    14
//   /\     /\        /\     /\
//  /  \   /  \      /  \   /  \
// 1    3 5    7    9   11 13  15

public class TreeAlgorithms {
    public List<Integer> bfsIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.print(node.val + " , ");
            result.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return result;
    }
    public List<Integer> bfsRecursive(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        int height = 4; // getHeight();

        for (int i = 0; i < height; i++) {
            bsfRecursivePrintCurrentLevel(node, i, result);
        }

        return result;
    }
    private void bsfRecursivePrintCurrentLevel(TreeNode node, int level, List<Integer> result) {
        if (node == null) {
            return;
        } else if (level == 0) {
            System.out.print(node.val + " , ");
            result.add(node.val);
        } else if (level >= 0) {
            bsfRecursivePrintCurrentLevel(node.left, level - 1, result);
            bsfRecursivePrintCurrentLevel(node.right, level - 1, result);
        }
    }
    
    public List<Integer> dfsInOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            System.out.print(current.val + " , ");
            result.add(current.val);

            current = current.right;
        }

        return result;
    }
    public List<Integer> dfsInOrderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfsInOrderRecursiveHelper(root, result);

        return result;
    }
    private void dfsInOrderRecursiveHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        dfsInOrderRecursiveHelper(node.left, result);
        System.out.print(node.val + " , ");
        result.add(node.val);
        dfsInOrderRecursiveHelper(node.right, result);
    }

    public List<Integer> dfsPreOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.print(current.val + " , ");
                result.add(current.val);

                stack.push(current.right);

                current = current.left;
            }

            current = stack.pop();
        }

        return result;
    }
    public List<Integer> dfsPreOrderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfsPreOrderRecursiveHelper(root, result);

        return result;
    }
    private void dfsPreOrderRecursiveHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " , ");
        result.add(node.val);

        dfsPreOrderRecursiveHelper(node.left, result);
        dfsPreOrderRecursiveHelper(node.right, result);
    }

    public List<Integer> dfsPostOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            if (!stack.isEmpty() && current == stack.peek()) {
                current = current.right;
            } else {
                System.out.print(current.val + " , ");
                result.add(current.val);
                current = null;
            }
        }

        return result;
    }
    public List<Integer> dfsPostOrderRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfsPostOrderRecursiveHelper(root, result);

        return result;
    }
    private void dfsPostOrderRecursiveHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        dfsPostOrderRecursiveHelper(node.left, result);
        dfsPostOrderRecursiveHelper(node.right, result);

        System.out.print(node.val + " , ");
        result.add(node.val);
    }
}
