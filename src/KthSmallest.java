//Implement an algorithm to find the K-th smallest element in a Binary Search Tree.
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class KthSmallest {

    // Insert a value into BST
    private static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Find K-th smallest element
    public static int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        int[] result = new int[1];
        inorder(root, count, result, k);
        return result[0];
    }

    // In-order traversal to find K-th smallest
    private static void inorder(TreeNode node, int[] count, int[] result, int k) {
        if (node == null || count[0] >= k) return;

        inorder(node.left, count, result, k);   // left subtree

        count[0]++;                             // visit current node
        if (count[0] == k) {
            result[0] = node.val;
            return;
        }

        inorder(node.right, count, result, k);  // right subtree
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes in BST: ");
        int n = sc.nextInt();

        TreeNode root = null;
        System.out.println("Enter " + n + " values to build BST:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }

        System.out.print("Enter K (1-based): ");
        int k = sc.nextInt();

        if (k < 1 || k > n) {
            System.out.println("Invalid K! K must be between 1 and " + n);
        } else {
            int answer = kthSmallest(root, k);
            System.out.println("The " + k + "-th smallest element is: " + answer);
        }

        sc.close();
    }
}
