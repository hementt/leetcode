class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int size = 0;

        for(int i =0; i<nums.length; i++){
            if(list.size() == 0 || nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            }else{
                int idx = binarySearch(list, nums[i]);
                list.set(idx, nums[i]);
                
            }
            size = Math.max(size, list.size());
        }
        return size;

    }
    public int binarySearch(List<Integer> list, int target){
        int left = 0;
        int right = list.size()-1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(list.get(mid) == target) return mid;
            else if(list.get(mid) > target) right = mid -1;
            else left = mid + 1;
        }
        return left;
    }
}