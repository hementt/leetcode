class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int res = 0;
        int candy[] = new int[n];
        Arrays.fill(candy, 1);

        for(int i = 1; i<n;i++){

            if(ratings[i] < ratings[i-1]){
                int j = i;
                int k = i-1;
                while(j >= 0 && k >= 0 && ratings[j] < ratings[k]){
                    if(candy[k] > candy[j]){
                        k--;
                        j--;
                        continue;
                    }
                    candy[k]++;
                    k--;
                    j--;
                }
            }else if(ratings[i-1] < ratings[i]){
                candy[i] = candy[i-1] + 1;
            }else{
                candy[i] = 1;
            }
        }

        int sum = 0;
        for(int num : candy) sum+= num;

        return sum;

    }
}