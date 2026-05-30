class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int j = 0;
        int count = map.size();
        int start = -1;
        int end = -1;
        int min = Integer.MAX_VALUE;

        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            int window = i - j + 1;

            if(map.containsKey(c)){
                // if(map.get(c) > 0){
                    map.put(c, map.get(c) - 1);

                    if(map.get(c) == 0) count--;
                // }
            }
            while(j <= i && count == 0){
                window = i - j + 1;
                if(window < min){
                    min = window;
                    start = j;
                    end = i;
                }
                char ch = s.charAt(j);
                if(map.containsKey(ch)){
                    map.put(ch , map.get(ch) + 1);
                    if(map.get(ch) > 0) count++;
                }
                j++;
            }

        }
        if(start == -1 || end == -1) return "";
        return s.substring(start, end+1);


    }
}