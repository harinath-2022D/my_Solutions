class Solution {

    // public boolean find(Node root, int tar) {
    // if (root == null) {
    // return false;
    // }

    // if (root.data == tar) {
    // return true;
    // }

    // // find in left child
    // boolean filc = find(root.left, tar);
    // if (filc == true) {
    // return true;
    // }

    // // find in right child
    // boolean firc = find(root.right, tar);
    // if (firc == true) {
    // return true;
    // }

    // // I was not the target, not found in left child niether in right child
    // return false;
    // }

    ArrayList<Integer> path;

    public boolean NodeToRootPath(Node root, int tar) {
        if (root == null) {
            return false;
        }

        if (root.data == tar) {
            path.add(root.data);
            return true;
        }

        // find in left child
        boolean filc = NodeToRootPath(root.left, tar);
        if (filc == true) {
            path.add(root.data);
            return true;
        }

        // find in right child
        boolean firc = NodeToRootPath(root.right, tar);
        if (firc == true) {
            path.add(root.data);
            return true;
        }

        // I was not the target, not found in left child niether in right child
        return false;
    }

    public ArrayList<Integer> solve(Node root, int b) {
        // your code here
        path = new ArrayList<>();
        boolean ans = NodeToRootPath(root, b);

        // root to node path
        Collections.reverse(path);
        return path;
    }
}
