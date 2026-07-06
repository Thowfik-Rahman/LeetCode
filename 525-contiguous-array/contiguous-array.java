class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,-1);
        int prefixSum=0;
        int maxlength =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                prefixSum +=-1;
            }else{
                prefixSum +=1;
            }
            if(map.containsKey(prefixSum)){
                maxlength = Math.max(maxlength,i-map.get(prefixSum));
            }else{
                map.put(prefixSum,i);
            }
        } return maxlength;      
    }
}