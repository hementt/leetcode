class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            char c = pq.poll();
            boolean flag = false;
            if(sb.isEmpty() || sb.charAt(sb.length() -1) != c){ sb.append(c); flag = true;}
            map.put(c, map.get(c) - 1);
            if(map.get(c) != 0 && pq.isEmpty()) return "";
            if(!pq.isEmpty()){
                char temp = pq.poll();
                map.put(temp, map.get(temp) - 1);
                sb.append(temp);
                if(map.get(temp) != 0){pq.add(temp);}
                else map.remove(temp);
            }
            if(map.get(c) != 0){pq.add(c);}
            else map.remove(c);
            if(!flag) sb.append(c);
            
        }

        return sb.toString();
    }
}