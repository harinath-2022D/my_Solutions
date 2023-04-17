class Solution{
	public static int leftcnt=0,rightcnt=0;

	public static int count(Node node,int x){
		if(node == null) return 0;
		int a =count(node.left,x);
		int b = count(node.right,x);
		if(node.data == x){
			leftcnt = a;
			rightcnt = b;
		}
		return 1+a+b;
	}
    public static boolean btreeGameWinningMove(Node root, int n, int x) {
        //write your code here
		int leftright = count(root,x);
		int ans = leftright-leftcnt-rightcnt-1;
		int max = Math.max(ans,Math.max(leftcnt,rightcnt));
		return max>n/2;
    }
    
}
