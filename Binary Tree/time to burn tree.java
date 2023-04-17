private static BinaryTreeNode<Integer> bfsToMapParents(BinaryTreeNode<Integer> root,
                                                       HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp, int start) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);
        while(!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.poll();
            if(node.data == start) res = node;
            if(node.left != null) {
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null) {
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }
    private static int findMaxDistance(HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp, BinaryTreeNode<Integer> target) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(target);
        HashMap<BinaryTreeNode<Integer>,Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;
        
        while(!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;
            
            for(int i = 0;i<sz;i++) {
                BinaryTreeNode<Integer> node = q.poll();
                if(node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if(node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }

                if(mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            if(fl == 1) maxi++;
        }
        return maxi;
    }
  public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
    // your code here
	  HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> mpp = new HashMap<>();
        BinaryTreeNode<Integer> target = bfsToMapParents(root, mpp, start);
        int maxi = findMaxDistance(mpp, target);
        return maxi;
  }



//.......................................
//.......................................

import java.util.*;

class Solution {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void getParent(Node root, HashMap<Node, Node> parent) {
        if (root == null)
            return;

        if (root.left != null) {
            parent.put(root.left, root);
        }

        if (root.right != null) {
            parent.put(root.right, root);
        }

        getParent(root.left, parent);
        getParent(root.right, parent);
    }

    public static Node findTarget(Node root, int target) {
        if (root == null) {
            return null;
        }

        if (root.data == target) {
            return root;
        }

        Node filc = findTarget(root.left, target);
        if (filc != null) {
            return filc;
        }

        Node firc = findTarget(root.right, target);
        if (firc != null) {
            return firc;
        }

        return null;
    }

    public static int minTime(Node root, int target) {
        // Your code goes here
        HashMap<Node, Node> parent = new HashMap<>();
        getParent(root, parent);

        Node targetNode = findTarget(root, target);

        Queue<Node> que = new ArrayDeque<>();
        que.add(targetNode);

        HashSet<Node> burned = new HashSet<>();
        burned.add(targetNode);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size > 0) {
                Node rnode = que.remove();

                if (rnode.left != null && burned.contains(rnode.left) == false) {
                    burned.add(rnode.left);
                    que.add(rnode.left);
                }

                if (rnode.right != null && burned.contains(rnode.right) == false) {
                    burned.add(rnode.right);
                    que.add(rnode.right);
                }

                if (parent.getOrDefault(rnode, null) != null && burned.contains(parent.get(rnode)) == false) {
                    burned.add(parent.get(rnode));
                    que.add(parent.get(rnode));
                }

                size--;
            }
            level++;
        }

        return level - 1;
    }
}
