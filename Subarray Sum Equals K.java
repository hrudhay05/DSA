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



/*

Given an integer array, find the maximum length contiguous subarray having a given sum.

Input : nums[] = [5, 6, -5, 5, 3, 5, 3, -2, 0], target = 8
Output: [-5, 5, 3, 5]
Explanation: The subarrays with sum 8 are [[-5, 5, 3, 5], [3, 5], [5, 3]]. The longest subarray is [-5, 5, 3, 5] having length 4.

Note: Since an input can contain several maximum length subarrays with given sum, the solution should return any one of the maximum length subarray.

*/

class Solution
{
	public static List<Integer> findMaxLenSubarray(List<Integer> nums, int tar)
	{
		// Write your code here...
		Map<Integer,Integer> map  = new HashMap<>();
		int n = nums.size();
	
		int start=-1;
		int end=-1;
		int sum=0;
		int max=0;
		map.put(0,-1);
		for(int i=0;i<n;i++){
			sum+=nums.get(i);
			if(map.containsKey(sum-tar)){
				int prev = map.get(sum-tar);
				if(i-prev>max){
					max = i-prev;
					start=prev+1;
					end =i;
				}
			}
			map.putIfAbsent(sum,i);
			
		}
		List<Integer> res = new ArrayList<>();
		if(start!=-1){
		for(int i=start;i<=end;i++){
			res.add(nums.get(i));
		}
		}
		return res;
		
	}
}

  
