class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) ->{
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        List<Integer> list = new ArrayList<>();
        int res = 1;
        for(int i =0; i<n;i++){
            if(list.size() == 0 || list.get(list.size() - 1) < envelopes[i][1]){
                list.add(envelopes[i][1]);
            }else{
                int left = 0;
                int right = list.size() - 1;
                while(left < right){
                    int mid = left + (right - left) /2;

                    if(envelopes[i][1] > list.get(mid)){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }

                list.set(left, envelopes[i][1]);
            }
            res = Math.max(res, list.size());

        }
        return res;
    }
}