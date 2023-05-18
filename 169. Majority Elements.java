class Solution {
    public int majorityElement(int[] nums) {
        int n =0;
        if(nums.length%2==0){
        n = nums.length/2;
        }
        else{
            n=(nums.length/2)+1;
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j =i;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if (count>=n){
            ans=nums[i];
        }
        }
    return ans;  
    }
}
