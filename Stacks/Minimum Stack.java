// Example 1:
// Input:

// push(2)
// push(3)
// pop()
// getMin()
// push(1)
// getMin()
// Output:

// 3 2 1
// Explanation:

// The first two operation pushes 2 and 3 into the stack. The minimum element currently is 2 and top element is 3.

// Next operation pops the top element in the stack which is 3 and return it.

// Next operation returns the minimum element in the stack which is 2.

// Now we push 1 into the stack.

// Next operation returns the minimum element in the stack which is 1.
import java.util.*;

class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			Solution g = new Solution();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
        sc.close();
		
	}
}

class Solution
{
	
	Stack<Integer> s = new Stack<Integer>();;
    
	Solution()
	{
		
	}

	void push(int x){
        s.push(x);		
    }
	
	int pop(){
        if(s.size() == 0){
			return -1;
		}
		return s.pop();
	}

    int getMin(){
        if( s.size() == 0){
			return -1;
		}
		int min = Integer.MAX_VALUE;
		Stack<Integer> temp = new Stack<>();
		while(s.size() != 0){
			int val = s.pop();
			min = Math.min(min, val);
			temp.push(val);
		}

		while(temp.size() != 0){
			int val = temp.pop();
			s.push(val);
		}
		return min;
	}	
}
