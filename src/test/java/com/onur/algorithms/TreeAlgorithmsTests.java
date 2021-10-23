package com.onur.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

@SpringBootTest
public class TreeAlgorithmsTests {
    private static TreeAlgorithms algorithmApp;
    private static TreeNode root;

    private List<Integer> bfsOrderExpectedResult = List.of(8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15);
    private List<Integer> dfsInOrderExpectedResult = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    private List<Integer> dfsPreOrderExpectedResult = List.of(8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15);
    private List<Integer> dfsPostOrderExpectedResult = List.of(1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 14, 12, 8);

    @BeforeAll
    public static void setup() {
        algorithmApp = new TreeAlgorithms();
        initTree();
    }

    private static void initTree() {
        root = new TreeNode(8);

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        // TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);

        root.left = node4;
        root.right = node12;

        node4.left = node2;
        node4.right = node6;

        node2.left = node1;
        node2.right = node3;

        node6.left = node5;
        node6.right = node7;

        node12.left = node10;
        node12.right = node14;

        node10.left = node9;
        node10.right = node11;

        node14.left = node13;
        node14.right = node15;
    }

    @Test
    public void bfsRecursiveTest() {
        List<Integer> result = algorithmApp.bfsRecursive(root);

        assertEquals(result, bfsOrderExpectedResult);
    }

    @Test
    public void bfsIterativeTest() {
        List<Integer> result = algorithmApp.bfsIterative(root);

        assertEquals(result, bfsOrderExpectedResult);
    }

    @Test
    public void dfsInOrderRecursiveTest() {
        List<Integer> result = algorithmApp.dfsInOrderRecursive(root);

        assertEquals(result, dfsInOrderExpectedResult);
    }

    @Test
    public void dfsInOrderIterativeTest() {
        List<Integer> result = algorithmApp.dfsInOrderIterative(root);

        assertEquals(result, dfsInOrderExpectedResult);
    }

    @Test
    public void dfsPreOrderRecursiveTest() {
        List<Integer> result = algorithmApp.dfsPreOrderRecursive(root);

        assertEquals(result, dfsPreOrderExpectedResult);
    }

    @Test
    public void dfsPreOrderIterativeTest() {
        List<Integer> result = algorithmApp.dfsPreOrderIterative(root);

        assertEquals(result, dfsPreOrderExpectedResult);
    }

    @Test
    public void dfsPostOrderRecursiveTest() {
        List<Integer> result = algorithmApp.dfsPostOrderRecursive(root);

        assertEquals(result, dfsPostOrderExpectedResult);
    }

    @Test
    public void dfsPostOrderIterativeTest() {
        List<Integer> result = algorithmApp.dfsPostOrderIterative(root);

        assertEquals(result, dfsPostOrderExpectedResult);
    }
}
