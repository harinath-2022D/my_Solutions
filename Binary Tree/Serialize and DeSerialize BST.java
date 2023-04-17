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
