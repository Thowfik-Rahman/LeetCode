class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> result = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(result.containsKey(nums[i])){
                if(i - result.get(nums[i]) <= k){
                    return true;
                }
            }
            result.put(nums[i],i);
        }
        return false;
    }
}