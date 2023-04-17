class Solution {
class Pair{
	Node node;
	int idx;
	Pair(Node node,int idx){
		this.node =node;
		this.idx = idx;
	}
}
    public int solve(Node root) {
        // your code here
		Queue<Pair> que = new ArrayDeque<>();
		que.add(new Pair(root,1));
		int width = 0;
		while(que.size()>0){
			int min_idx = Integer.MAX_VALUE;
			int max_idx = Integer.MIN_VALUE;
			int size = que.size();
			while(size>0){
				Pair rpair = que.remove();
				min_idx = Math.min(min_idx,rpair.idx);
				max_idx = Math.max(max_idx, rpair.idx);

				if(rpair.node.left != null){
					que.add(new Pair(rpair.node.left, rpair.idx*2));
				}

				if(rpair.node.right != null){
					que.add(new Pair(rpair.node.right, rpair.idx*2+1));
				}
				size--;
			}
			int currWidth = max_idx - min_idx +1;
			width = Math.max(currWidth, width);
		}
        return width;
    }
}
