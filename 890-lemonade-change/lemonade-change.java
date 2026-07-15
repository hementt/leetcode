class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int i =0; i<bills.length;i++){
            if(bills[i] == 5) five++;

            if(bills[i] == 10){
                if(five == 0) return false;
                else {five -= 1; ten++;}
            }

            if(bills[i] == 20){
                if(ten >= 1 && five >= 1){
                    ten-= 1;
                    five -= 1;
                }else if(ten == 0  && five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}