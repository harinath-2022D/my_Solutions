   static class Pair {
        boolean isBalanced;
        int height;

        Pair() {
            isBalanced = true;
            height = 0;
        }

        Pair(int h, boolean iB) {
            isBalanced = iB;
            height = h;
        }
    }

    public static Pair isBalanced_(Node root) {
        // your code here
        if (root == null) {
            return new Pair();
        }

        Pair leftSubTree = isBalanced_(root.left);

        Pair rightSubTree = isBalanced_(root.right);

        int diff = Math.abs(leftSubTree.height - rightSubTree.height);

        if (diff > 1 || leftSubTree.isBalanced == false || rightSubTree.isBalanced == false) {
            return new Pair(Math.max(leftSubTree.height, rightSubTree.height) + 1, false);
        } else {
            return new Pair(Math.max(leftSubTree.height, rightSubTree.height) + 1, true);
        }
    }

    public static boolean isBalanced(Node root) {
        // your code here
        Pair ans = isBalanced_(root);
        return ans.isBalanced;
    }

    // TC: O(N*N)
    // public static boolean isBalanced(Node root) {
    // // your code here
    // if (root == null) {
    // return true;
    // }

    // // is left sub-tree balanced
    // boolean isLeftBalanced = isBalanced(root.left);

    // // is right sub-tree balanced
    // boolean isRightBalanced = isBalanced(root.right);

    // // check am I balanced
    // int lh = height(root.left);
    // int rh = height(root.right);
    // int diff = Math.abs(lh - rh);

    // boolean ImBalanced = false;
    // if (diff <= 1) {
    // ImBalanced = true;
    // }

    // if (isLeftBalanced == false || isRightBalanced == false || ImBalanced ==
    // false) {
    // return false;
    // } else {
    // return true;
    // }
    // }

    // public static int height(Node root) {
    // if (root == null)
    // return 0;

    // int lh = height(root.left);
    // int rh = height(root.right);

    // return Math.max(lh, rh) + 1;
    // }
