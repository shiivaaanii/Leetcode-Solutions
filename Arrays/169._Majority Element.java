Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
The input is generated such that a majority element will exist in the array.


#Solution 1 : Boyer-Moore Voting Algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {              
            if (count == 0) {
                candidate = num; // choose new candidate
            }
            if (num == candidate) {
                count++; // same as candidate → increase count
            } else {
                count--; // different → decrease count
            }
        }

        return candidate; // guaranteed majority element
    }
}


##this for(int num : nums) ==> for(int i=0; i<nums.length; i++)
                                 int num = nums[i];

#Solution 2 : Hashmap Counting

  class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map  = new HashMap<>();
        int n = nums.length;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.get(num) > n/2) {
                return num;
            }
        }
        return -1;

    }
}


