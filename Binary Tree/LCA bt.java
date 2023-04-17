class Solution {
    public static Node findLCA(Node node,int n1,int n2) {
		//TC : O(N) SC : O(1)
       // write code here
		if(node == null){
			return null;
		}

		if(node.data == n1 || node.data == n2){
			return node;
		}
		Node findInLeft = findLCA(node.left, n1, n2);
		Node findInRight = findLCA(node.right, n1, n2);

		if(findInLeft!=null && findInRight!=null){
			return node;
		}

		if(findInLeft != null){
			return findInLeft;
		}else if(findInRight != null){
			return findInRight;
		}else{
			return null;
		}
    }
}
