
287. Find the Duplicate Number
Solved
Medium
Topics
Companies
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3

Solution 1:Sorting 
  class Solution {
    public int findDuplicate(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        for(int i=1;i<n;i++){
            if(a[i]==a[i-1]) return a[i];
        }
        return -1;
        
    }
}
Solution 2:Binary Search on Value
  class Solution {
    public int findDuplicate(int[] a) {
        int l = 1;
        int r = a.length-1;
        
       while(l<r){
        int c=0;
        int mid = (l+r)/2;
        for(int x:a){
            if(x<=mid){
                c++;
            }
            
        }
        if(c>mid){
            r = mid;
        }
        else{
            l =mid+1;
        }
       }
       return l;
        
    }
}
Solution 3: Floyd’s Tortoise and Hare (Cycle Detection) 
class Solution {
    public int findDuplicate(int[] a) {

        int slow = a[0];
        int fast = a[0];
        do{
            slow = a[slow];
            fast = a[a[fast]];
        }while(slow!=fast);
        
        slow = a[0];
        while(slow!=fast){
            slow = a[slow];
            fast = a[fast];
        }
        return slow;
    }
}
