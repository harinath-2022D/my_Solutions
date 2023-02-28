import java.util.*;

class Solution {

    public int solve(int nums[],int n) {
        // Your code here
		int[] rmax = new int[n];
		rmax[n-1] = nums[n-1];
		for(int i=n-2; i>=0; i--){
			rmax[i]=Math.max(rmax[i+1],nums[i]);
		}

		int l = 0;
		int r = 1;
		int ans = 0;
		while(r < n){
			if(nums[l] <= rmax[r]){
				ans = Math.max(ans,r-l);
				r++;
			}else{
				l++;
			}
		}

		return ans;

    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        nums[i]=sc.nextInt();

        Solution obj=new Solution();
        System.out.println(obj.solve(nums,n));
        sc.close();
    }
}

// aproch 2
class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<nums.length; i++)
            if(stack.isEmpty() || nums[i] < nums[stack.peek()])
                stack.push(i);
       
        int ans = 0;
        
        for(int i=nums.length-1; i>=0; i--)
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()])
                ans = Math.max(ans, i - stack.pop());
        
        return ans;
    }
}
