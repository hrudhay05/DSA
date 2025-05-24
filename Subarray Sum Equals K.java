560. Subarray Sum Equals K
Solved
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

Solution 1:Brute Force O(n2)
  class Solution {
    public int subarraySum(int[] a, int k) {

        int n = a.length;
        int c=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=a[j];
                if(sum==k){
                    c++;
                }
            }
        }
        return c;
        
    }
}
Solution 2:HashMap + Prefix Sum
class Solution {
    public int subarraySum(int[] a, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int n = a.length;
        int sum=0;
        int c=0;
        for(int x:a){
            sum+=x;
            if(map.containsKey(sum-k)){
                c+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return c;
        
    }
}
Solution 3:Sliding Window (Only for positive numbers)
class Solution {
    public int subarraySum(int[] nums, int k) {
         int left = 0, sum = 0, count = 0;

    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];
        while (sum > k && left <= right) {
            sum -= nums[left++];
        }
        if (sum == k) count++;
    }

    return count;
        
    }
}
  
