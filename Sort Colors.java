
Code
Testcase
Test Result
Test Result
75. Sort Colors
Solved
Medium
Topics
Companies
Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

Solution 1: Counting Sort
  class Solution {
    public void sortColors(int[] nums) {

        int one =0;
        int two =0;
        int zero=0;
        for(int x:nums){
            if(x==0) zero++;
            else if(x==1) one++;
            else if(x==2) two++;
        }
        int i=0;
        while(zero-->0) nums[i++]=0;
        while(one-->0) nums[i++]=1;
        while(two-->0) nums[i++]=2;
        
    }
}
Solution 2:Dutch National Flag Algorithm
  class Solution {
    public void sortColors(int[] a) {

        int low=0;
        int high = a.length-1;
        int mid=0;

        while(mid<=high){
            if(a[mid]==0){
              
                swap(a,low,mid);
                low++;
                mid++;
            }
            else if(mid==1){
                mid++;
            }
            else{
                swap(a,mid,high);
               
                high--;
            }
           
        }
        
    }
    public static void swap(int[]a,int i,int j){
        int temp =a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
Solution 3:Built-in Sort 
  import java.util.Arrays;

public void sortColors(int[] nums) {
    Arrays.sort(nums);
}
