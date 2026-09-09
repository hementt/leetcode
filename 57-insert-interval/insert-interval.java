class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int copy [][]= new int[intervals.length + 1][2];
        
        copy[0][0] = newInterval[0];
        copy[0][1] = newInterval[1];

        for(int i =1;i<copy.length;i++){
            copy[i][0] = intervals[i-1][0];
            copy[i][1] = intervals[i-1][1];
        }

        Arrays.sort(copy, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>());

        list.get(0).add(copy[0][0]);
        list.get(0).add(copy[0][1]);

        for(int i = 1; i<copy.length;i++){
            int idx = list.size() - 1;

            if(list.get(idx).get(1) >= copy[i][0]){
                int n = Math.max(list.get(idx).get(1) , copy[i][1]);
                list.get(idx).set(1, n);
            }else{
                idx++;
                list.add(new ArrayList<>());
                
                list.get(idx).add(copy[i][0]);
                list.get(idx).add(copy[i][1]);
            }
        }

        int result[][] = new int[list.size()][2];
        for(int i =0; i<list.size();i++){
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }

        return result;
    }
}