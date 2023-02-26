import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
	public static void encode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");

        encode(root.left, sb);
        encode(root.right, sb);
    }
    public static String serialize(TreeNode root) {
        //Write code here
		StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
	static int idx = 0;

    public static TreeNode decode(String[] input) {
        String data = input[idx];
        idx++;

        if (idx == input.length) {
            return null;
        }

        if (data.equals("null") == true) {
            return null;
        }

        int val = Integer.parseInt(data);
        TreeNode root = new TreeNode(val);

        root.left = decode(input);
        root.right = decode(input);

        return root;
    }
    public static TreeNode deserialize(String data) {
        //Write code here
		String[] input = data.split(",");
        return decode(input);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}
