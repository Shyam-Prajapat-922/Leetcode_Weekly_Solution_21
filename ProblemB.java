class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Integer.MIN_VALUE ; 
        long min = Integer.MAX_VALUE ; 
        long res = 0 ; 
        for(int i = 0;i < nums.length ; i++){
            min= Math.min(min, nums[i]) ;
            max = Math.max(max , nums[i]) ; 
        }
        res = (max - min) * (long)k ; 
        return res ; 
    }
}
