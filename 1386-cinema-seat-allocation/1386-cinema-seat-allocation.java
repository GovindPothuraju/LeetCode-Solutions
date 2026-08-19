class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,HashSet<Integer>> hm = new HashMap<>();
        for(int[] temp : reservedSeats){
            int row = temp[0];
            int col = temp[1];
            if(!hm.containsKey(row)){
                hm.put(row,new HashSet<>());
            }
            hm.get(row).add(col);
        }
        int res = 0;
        for(int key : hm.keySet()){
            HashSet<Integer> temp = hm.get(key);
            // 2,3,4,5
            boolean isTrue = false;
            if(!temp.contains(2) && !temp.contains(3) && !temp.contains(4) && !temp.contains(5)){
                res++;
                isTrue = true;
            }
            // 6,7,8,9
            if(!temp.contains(6) && !temp.contains(7) && !temp.contains(8) && !temp.contains(9)){
                res++;
                isTrue = true;
            }
            if(!isTrue){
                // 4 5 6 7
                if(!temp.contains(4) && !temp.contains(5) && !temp.contains(6) && !temp.contains(7)){
                    res++;
                }
            }
            
        }
        int rem = n-hm.size();
        res+=rem*2;
        return res;
    }
}