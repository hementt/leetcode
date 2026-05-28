class Solution {
    class Pair{
        int freq;
        char c;
        Pair(int freq, char c){
            this.freq = freq;
            this.c = c;
        }
    }
    public String frequencySort(String s) {
        int capital[] = new int[26];
        int lower[] = new int[26];
        int digit[] = new int[10];

        for(char c : s.toCharArray()){
            if(Character.isUpperCase(c)){
                capital[c - 'A']++;
            }else if(Character.isLowerCase(c)){
                lower[c - 'a']++;
            }else{
                digit[c - '0']++;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for(int i =0; i<26 ;i++){
            if(capital[i] != 0){
                pq.add(new Pair(capital[i], (char)(i + 'A')));
            }
            if(lower[i] != 0){
                pq.add(new Pair(lower[i], (char)(i + 'a')));
            }
            if( i < 10 && digit[i] != 0){
                pq.add(new Pair(digit[i], (char)(i + '0')));
            }

        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            int i = curr.freq;
            char c = curr.c;

            while(i-- >0){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}