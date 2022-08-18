class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr;
        arr = new int[2];
        for (int i=0; i<nums.length; i++){
            int a = target - nums[i];
            for (int j=i+1; j<nums.length; j++){
                if (nums[j] == a){
                    arr[0] = i;
                    arr[1] = j;
                    return(arr);
                }
            }
        }
        return(arr);
    }
}