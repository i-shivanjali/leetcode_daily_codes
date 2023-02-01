/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/

class Solution {
    private void backtrack(List<List<Integer>> result, List<Integer> selected, int[] nums, int pos) {
        if(pos == nums.length) {
            result.add(new ArrayList<Integer>(selected));
            return;
        }
        for(int i = 0; i < nums.length; ++i) {
            if(selected.contains(nums[i])) continue;
            selected.add(nums[i]);
            backtrack(result, selected, nums, pos+1);
            selected.remove(selected.size()-1);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
}
