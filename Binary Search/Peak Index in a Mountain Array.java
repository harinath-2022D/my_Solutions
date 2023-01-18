class Solution {
    public int peakIndexInMountainArray(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while(start < end){
        int mid = start + (end - start) / 2;
        if(arr[mid] > arr[mid+1]){
            // in decreasing part, so mid can be our peak index so 
            end = mid;
        }
        else{
            // means arr[mid] < arr[mid+1]
            // in increasing part, so mid can not be our peak index so just start from mid+1
            start = mid + 1;
        }
    }
    // in the end start and end will point to same value which is peak index so return start or end 
    return start;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}
