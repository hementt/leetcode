class Solution {
    public String largestNumber(int[] nums) {
        Integer copy[] = new Integer[nums.length];
        for(int i =0; i<nums.length;i++){
            copy[i] = nums[i];
        }

        Arrays.sort(copy, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                String s1 = String.valueOf(a);
                String s2 = String.valueOf(b);

                String order1 = s1+s2;
                String order2 = s2+s1;

                return order2.compareTo(order1);
            }
        });
    

        StringBuilder sb = new StringBuilder();
        for(int num : copy) sb.append(num);

        if(sb.charAt(0) == '0' ) return "0";

        return sb.toString();
    }
}