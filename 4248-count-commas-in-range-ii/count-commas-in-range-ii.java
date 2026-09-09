class Solution {
    public long countCommas(long n) {
        long res = 0;
        long copy = n;
        while(copy > 999){
            String temp = Long.toString(copy);
            int commas = (temp.length() - 1)/3;
            if(temp.length() > 15){
                long start = 1000000000000000L;
                long curr = copy - start + 1;
                res += curr * commas;
                copy = start - 1;
            }else if(temp.length() > 12){
                long start = 1000000000000L;
                long curr = copy - start + 1;
                res += curr * commas;
                copy = start - 1;
            }else if(temp.length() > 9){
                long start = 1000000000L;
                long curr = copy - start + 1;
                res += curr * commas;
                copy = start - 1;
            }else if(temp.length() > 6){
                long start = 1000000L;
                long curr = copy - start + 1;
                res += curr* commas;
                copy = start - 1;
            }else{
                long start = 1000L;
                long curr = copy - start + 1;
                res += curr * commas;
                copy = start - 1;
            }
            
        }
        return res;
    }
}