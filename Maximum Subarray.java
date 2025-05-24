
Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Solution 1: Buteforce O(n2)
class Solution {
    public int maxSubArray(int[] a) {
        int  n = a.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=a[j];
                max = Math.max(sum,max);
            }
        }
        return max;
        
    }
}

Solution 2:Divide and Conquer (Merge Technique) O(nlogn) O(logn)
  class Solution {
    public int maxSubArray(int[] a) {

        int n = a.length;
        return helper(a,0,n-1);
        
    }
    public static int helper(int []a,int left,int right){
        if(left==right) return a[left];

        int mid  = (left+right)/2;

        int leftside = helper(a,left,mid);
        int rightside = helper(a,mid+1,right);
        int total = find(a,left,mid,right);
        return Math.max(Math.max(leftside,rightside),total);
    }
    public static int find(int[]a,int left,int mid,int right){

        int leftside = Integer.MIN_VALUE;
        int sum=0;
        for(int i=mid;i>=left;i--){
            sum+=a[i];
            leftside = Math.max(leftside,sum);

        }
        int rightside = Integer.MIN_VALUE;
         sum=0;
        for(int i=mid+1;i<=right;i++){
            sum+=a[i];
            rightside = Math.max(rightside,sum);

        }
        return leftside +rightside;
    }
}
Solution 3:Dynamic Programming (Bottom-Up Tabulation) O(n) O(n)
  class Solution {
    public int maxSubArray(int[] a) {
        int n = a.length;
        int[] dp = new int[a.length];
        dp[0] = a[0];
        int max=a[0];
        for(int i=1;i<n;i++){
            dp[i] = Math.max(a[i],dp[i-1]+a[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
Solution 4: Kadane's Algorithm O(N) O(1)
class Solution {
    public int maxSubArray(int[] a) {

       int sum=0;
       int max=a[0];
       for(int x:a){
        sum+=x;
        max = Math.max(max,sum);
        if(sum<0){
            sum=0;
        }

       }
       return max;
    }
}


