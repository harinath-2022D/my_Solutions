class Solution
{
    public static void flatten(Node root){
        //Write code here
		if(root == null){
			return;
		}

		flatten(root.left);
		flatten(root.right);

		Node temp = root.right;
		root.right = root.left;

		root.left = null;

		Node temp2 = root;
		while(temp2.right!=null){
			temp2 = temp2.right;
		}

		temp2.right = temp;
    }
}
