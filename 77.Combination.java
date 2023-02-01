/*

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

Constraints:

1 <= n <= 20
1 <= k <= n

*/

class Solution {
public:
    int n, k;
    
    void backtrack(int start, vector<int>& comb, vector<vector<int>>& combs){
        if(comb.size() == k){
            combs.push_back(comb);
        }else{
            for(int i = start; i <= n; ++i){
                comb.push_back(i);
                backtrack(i+1, comb, combs);
                comb.pop_back();
            }
        }
    }
    
    vector<vector<int>> combine(int n, int k) {
        this->n = n;
        this->k = k;
        
        vector<int> comb;
        vector<vector<int>> combs;
        
        backtrack(1, comb, combs);
        
        return combs;
    }
};
