class Solution {

    // public static int height(Node root) {
    // if (root == null)
    // return 0;

    // int lh = height(root.left);
    // int rh = height(root.right);

    // return Math.max(lh, rh) + 1;
    // }

    // public static int diameter(Node root) {
    // if (root == null) {
    // return 0;
    // }

    // int getMaxDiaOfLeftSubTree = diameter(root.left);

    // int getMaxDiaOfRightSubTree = diameter(root.right);

    // int lh = height(root.left);
    // int rh = height(root.right);
    // int diaTroughRoot = lh + rh + 1;

    // return Math.max(diaTroughRoot, Math.max(getMaxDiaOfLeftSubTree,
    // getMaxDiaOfRightSubTree));
    // }

    static class Pair {
        int diameter;
        int height;

        Pair() {
            height = 0;
            diameter = 0;
        }

        Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static Pair diameter_(Node root) {
        if (root == null) {
            return new Pair();
        }

        Pair leftSubTree = diameter_(root.left);

        Pair righSubTree = diameter_(root.right);

        int diaThroughRoot = leftSubTree.height + righSubTree.height + 1;

        int myHeight = Math.max(leftSubTree.height, righSubTree.height) + 1;

        int myDiameter = Math.max(diaThroughRoot, Math.max(leftSubTree.diameter, righSubTree.diameter));

        return new Pair(myHeight, myDiameter);
    }

    public static int diameter(Node root) {
        Pair ans = diameter_(root);
        return ans.diameter;
    }
}
